package proyecto.services;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.apache.hc.client5.http.fluent.Form;
import org.apache.hc.client5.http.fluent.Request;
import proyecto.enums.RecordType;
import proyecto.enums.StateNames;
import proyecto.models.Record;
import proyecto.utils.DialogHelper;
import proyecto.utils.Other;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Base64;
import java.util.UUID;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class RecordServicesSQL {

    private static final String url =  "http://localhost/TAP_2025/Proyecto/";


    public static Record getRecord2(String id_record, int record_number) throws Exception {
        Form form = Form.form();
        form.add("operation", "getRecord");
        form.add("id_record", id_record);
        form.add("record_number", String.valueOf(record_number));

        return getRecords(form).getFirst();
    }


    public static Record addRecord2(Record r) throws Exception {
        int record_number = getRecordNumbers2(r.getId_record())+1;
        String id_record = r.getId_record();
        if (id_record.isEmpty()) id_record = UUID.randomUUID().toString().substring(0, 35);

        Form form = Form.form();
        form.add("operation", "addRecord");
        form.add("id_record", id_record);
        form.add("record_number", String.valueOf(record_number));
        form.add("author", r.getId_author());
        form.add("state_name", r.getState_name().toString());
        form.add("record_type", r.getRecord_type().toString());
        form.add("title", r.getTitle());
        form.add("description", r.getDescription());
        form.add("image", r.getImage());
        form.add("image_name", r.getImage_name());
        form.add("is_hidden", String.valueOf(r.is_hidden()));
        form.add("is_public", String.valueOf(r.is_public()));

        String result = Request.post(
                url + "end_point_records.php"
        ).bodyForm(form.build()).execute().returnContent().asString();


        if (! result.contains("error")) {
            DialogHelper.infoMessageDialog("Registro guardado.", "Guardado exitoso.");
            return getRecord2(id_record, record_number);
        }

        DialogHelper.errorMessageDialog("Error al guardar, intente de nuevo.", "Error de guardado.");
        return null;
    }


    public static boolean deleteRecord2(Record r) throws Exception {
        Form form = Form.form();
        form.add("operation", "deleteRecord");
        form.add("id_record", r.getId_record());
        form.add("record_number", String.valueOf(r.getRecord_number()));

        return extracted(form);
    }


    public static boolean setPublic2(Record r) throws Exception {
        Form form = Form.form();
        form.add("operation", "setPublic");
        form.add("id_record", r.getId_record());
        form.add("record_number", String.valueOf(r.getRecord_number()));

        return extracted(form);
    }


    public static ArrayList<Record> getUserRecords2(String id_user) throws Exception {
        Form form = Form.form();
        form.add("operation", "userRecords");
        form.add("id_user", id_user);

        return getRecords(form);
    }


    public static ArrayList<Record> getApprovedRecords2() throws Exception {
        Form form = Form.form();
        form.add("operation", "approvedRecords");

        return getRecords(form);
    }


    public static ArrayList<Record> getStateSpecificRecords2(StateNames state) throws Exception {
        Form form = Form.form();
        form.add("operation", "stateRecords");
        form.add("state_name", state.toString());

        return getRecords(form);
    }


    public static ArrayList<Record> getTypeSpecificRecords2(RecordType type) throws Exception {
        Form form = Form.form();
        form.add("operation", "typeRecords");
        form.add("type_name", type.toString());

        return getRecords(form);
    }


    public static ArrayList<Record> getVerySpecificRecords2(StateNames state ,RecordType type) throws Exception{
        Form form = Form.form();
        form.add("operation", "specificRecords");
        form.add("state_name", state.toString());
        form.add("type_name", type.toString());

        return getRecords(form);
    }


    public static void getPDF(StateNames state) {
        ArrayList<Record> records;
        try{
            records = getStateSpecificRecords2(state);
            if (records.isEmpty()) {
                DialogHelper.errorMessageDialog("No se encontró ningún registro de: " + state, "Error de guardado.");
                return;
            }


            Document document = new Document(PageSize.A4, 50, 50, 40, 40);
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("results/" + Other.getStateNames()[state.ordinal()] + ".pdf"));

            document.open();

            Font pageTitle = new Font(Font.FontFamily.HELVETICA, 20, Font.BOLD);
            Font labelFont = new Font(Font.FontFamily.HELVETICA, 14, Font.BOLD);
            Font valueFont = new Font(Font.FontFamily.HELVETICA, 13);
            Font body = new Font(Font.FontFamily.HELVETICA, 12);

            for (Record record : records) {
                Paragraph mainTitle = new Paragraph(Other.getStateNames()[state.ordinal()], pageTitle);
                mainTitle.setAlignment(Element.ALIGN_CENTER);
                mainTitle.setSpacingAfter(15f);
                document.add(mainTitle);

                Paragraph info = new Paragraph();
                info.add(new Chunk("ID del registro: ", labelFont));
                info.add(new Chunk(record.getId_record() + "\n", valueFont));
                info.setSpacingAfter(5f);
                document.add(info);

                info = new Paragraph();
                info.add(new Chunk("Título: ", labelFont));
                info.add(new Chunk(record.getTitle() + "\n", valueFont));
                info.setSpacingAfter(5f);
                document.add(info);

                info = new Paragraph();
                info.add(new Chunk("Tipo de registro cultural: ", labelFont));
                info.add(new Chunk(Other.getTypes()[record.getRecord_type().ordinal()] + "\n", valueFont));
                info.setSpacingAfter(5f);
                document.add(info);

                info = new Paragraph();
                info.add(new Chunk("Es público: ", labelFont));
                info.add(new Chunk(record.Is_public() ? "sí\n\n" : "no\n\n", valueFont));
                document.add(info);

                Paragraph desc = new Paragraph("Descripción:\n" + record.getDescription(), body);
                desc.setAlignment(Element.ALIGN_JUSTIFIED);
                desc.setLeading(16f);
                desc.setSpacingAfter(10f);
                document.add(desc);

                Image image;

                if (record.getImage() != null){
                    image = Image.getInstance(Base64.getDecoder().decode(record.getImage()));
                } else image = Image.getInstance("src/main/java/proyecto/resources/imgnotfound.png");

                image.scaleAbsolute(150, 150);
                image.setAlignment(Element.ALIGN_CENTER);
                image.setSpacingBefore(10f);
                image.setSpacingAfter(15f);
                document.add(image);

                document.newPage();
            }

            document.close();
            DialogHelper.infoMessageDialog("Archivo guardado en directorio results, con nombre: " + state+ ".pdf", "Archivo guardado.");
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void getExcel(){
        int [] numberOfRecords = getNumberOfRecords();

        try(Workbook wb = new XSSFWorkbook()){
            Sheet sheet = wb.createSheet("Resumen");
            Row header = sheet.createRow(0);
            header.createCell(0).setCellValue("Estado:");
            header.createCell(1).setCellValue("Num. de registros:");

            for (StateNames state : StateNames.values()) {
                Row row = sheet.createRow(sheet.getLastRowNum() + 1);
                row.createCell(0).setCellValue(state.toString().replace("_", " "));
                row.createCell(1).setCellValue(numberOfRecords[state.ordinal()]);
            }

            OutputStream fileOut = new FileOutputStream("results/resumen.xlsx");
            DialogHelper.infoMessageDialog("Archivo guardado en directorio results, con nombre: resumen.xlsx", "Archivo guardado.");
            wb.write(fileOut);
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    public static int getRecordNumbers2(String id_record) throws  Exception{
        int numberOfRecords;

        Form form = Form.form();
        form.add("operation", "amount");
        form.add("id_record", id_record);

        String result = Request.post(
                url + "end_point_records.php"
        ).bodyForm(form.build()).execute().returnContent().asString();


        numberOfRecords = Integer.parseInt(result);

        return numberOfRecords;
    }


    private static int[] getNumberOfRecords() {
        int [] number = new int[32];
        for(StateNames names : StateNames.values()){
            try {
                number[names.ordinal()] = getStateSpecificRecords2(names).size();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return number;
    }


    private static ArrayList<Record> getRecords(Form form) throws Exception {
        ArrayList<Record> records;

        String results = Request.post(
                url + "end_point_records.php"
        ).bodyForm(form.build()).execute().returnContent().asString();


        Type listType = new TypeToken<ArrayList<Record>>(){}.getType();
        records = new Gson().fromJson(results, listType);

        for(Record r : records){
            r.setAuthor(UserServicesSQL.getUser2(r.getId_author()));
        }

        return records;
    }


    private static boolean extracted(Form form) throws IOException {
        String result = Request.post(
                url + "end_point_records.php"
        ).bodyForm(form.build()).execute().returnContent().asString();


        return !result.contains("\"error\"");
    }
}
