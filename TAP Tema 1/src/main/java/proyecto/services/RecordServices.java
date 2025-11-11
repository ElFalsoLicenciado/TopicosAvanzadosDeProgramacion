package proyecto.services;

import proyecto.enums.RecordType;
import proyecto.enums.StateNames;
import proyecto.models.Record;
import proyecto.utils.DialogHelper;
import proyecto.utils.Other;

import com.google.gson.Gson;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


import java.io.*;
import java.util.ArrayList;

public class RecordServices {

    public static final String FILE = "records.json";

    public static ArrayList<Record> getRecords() {
        ArrayList<Record> records = new ArrayList<>();

        Other.createJSON(FILE);

        try {
            BufferedReader br = new BufferedReader(new FileReader(FILE));
            String result = "";
            String line;

            while ((line = br.readLine()) != null) {
                result += line;
            }
            br.close();

            JSONParser parser = new JSONParser();
            JSONArray array = (JSONArray) parser.parse(result);

            for (Object object : array) {
                Record record = new Gson().fromJson(
                        object.toString(),
                        proyecto.models.Record.class
                );
                records.add(record);
            }

        }catch (Exception e) {
            e.printStackTrace();
        }
        return records;
    }

    public static boolean writeRecords(ArrayList<Record> records) {
        try{
            String json = new Gson().toJson(records);

            BufferedWriter bw = new BufferedWriter(
                    new FileWriter(FILE)
            );

            bw.write(json);
            bw.close();

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean saveRecord(Record record) {
        ArrayList<Record> records = getRecords();
        String msg;
        if (! checkForRecord(record)) {
            records.add(record);
            msg = "Tu registro ha sido creado exitosamente.";
        }
        else {
            for (Record all : records) {
                if (record.getRecordId().equalsIgnoreCase(all.getRecordId())) {
                    records.set(records.indexOf(all), record);
                    break;
                }
            }
            msg = "Tu registro ha sido actualizado exitosamente.";
        }
        if(writeRecords(records)){
            DialogHelper.infoMessageDialog(msg, "Guardado exitoso.");
            return true;
        }
        DialogHelper.errorMessageDialog("Error al guardar, intente de nuevo.", "Error de guardado.");
        return false;
    }

    public static void deleteRecord(Record record) {
        ArrayList<Record> records = getRecords();
        String msg = "";
        if (! checkForRecord(record)) {
            msg = "Tu registro no existe.";
        }
        else {
            for (Record all : records) {
                if (record.getRecordId().equalsIgnoreCase(all.getRecordId())) {
                    records.set(records.indexOf(all), record);
                    msg = "Tu registro ha sido eliminado.";
                    break;
                }
            }
            if (! writeRecords(records)) msg = "Error al eliminar el registro.";
            else RequestServices.recordDeleted(record);
        }
        DialogHelper.warnMessageDialog(msg, "Advertencia.");
    }

    public static void getPDF(StateNames state){
        ArrayList<Record> records = getSpecificStateRecords(state);
        if (records.isEmpty()) {
            DialogHelper.errorMessageDialog("No se encontró ningún registro de: " + state.toString(), "Error de guardado.");
            return;
        }

        try {
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
                info.add(new Chunk(record.getRecordId() + "\n", valueFont));
                info.setSpacingAfter(5f);
                document.add(info);

                info = new Paragraph();
                info.add(new Chunk("Título: ", labelFont));
                info.add(new Chunk(record.getTitle() + "\n", valueFont));
                info.setSpacingAfter(5f);
                document.add(info);

                info = new Paragraph();
                info.add(new Chunk("Tipo de registro cultural: ", labelFont));
                info.add(new Chunk(Other.getTypes()[record.getRecordType().ordinal()] + "\n", valueFont));
                info.setSpacingAfter(5f);
                document.add(info);

                info = new Paragraph();
                info.add(new Chunk("Es público: ", labelFont));
                info.add(new Chunk(record.isPublic() ? "sí\n\n" : "no\n\n", valueFont));
                document.add(info);

                Paragraph desc = new Paragraph("Descripción:\n" + record.getDescription(), body);
                desc.setAlignment(Element.ALIGN_JUSTIFIED);
                desc.setLeading(16f);
                desc.setSpacingAfter(10f);
                document.add(desc);

                Image image = Image.getInstance(record.getImageUrl());
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

    /** <h1> WARNING:</h1>
     * <p> Note that sheet name is Excel must not exceed 31 characters
     * and must not contain any of any of the following characters: </p>
     * <ul>
     *      <li> 0x0000 </li>
     *      <li> 0x0003 </li>
     *      <li> colon (:) </li>
     *      <li> backslash (\) </li>
     *      <li> asterisk (*) </li>
     *      <li> question mark (?) </li>
     *      <li> forward slash (/) </li>
     *      <li> opening square bracket ([) </li>
     *      <li> closing square bracket (]) </li>
     * </ul>
     */

    public static void getExcel(){
        //ArrayList<Record> records = getOrderedRecords();
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


    private static boolean checkForRecord(Record record) {
        ArrayList<Record> records = getRecords();

        for (Record all : records) {
            if (record.getRecordId().equalsIgnoreCase(all.getRecordId())) {
                return true;
            }
        }
        return false;
    }

    public static Record getRecord(String recordId) {
        ArrayList<Record> records = getRecords();
        for (Record all : records) {
            if (recordId.equalsIgnoreCase(all.getRecordId())) {
                return all;
            }
        }
        return null;
    }

    public static ArrayList<Record> getUserRecords(String userID) {
        ArrayList<Record> records = getOrderedRecords();
        ArrayList<Record> userRecords = new ArrayList<>();

        for (Record record : records) {
            if (record.getAuthorId().equals(userID) && ! record.isDeleted()) {
                userRecords.add(record);
            }
        }
        return userRecords;
    }

    public static ArrayList<Record> getApprovedRecords() {
        ArrayList<Record> records = getOrderedRecords();
        ArrayList<Record> approvedRecords = new ArrayList<>();

        for (Record record : records) {
            if (record.isPublic() && ! record.isDeleted()) {
                approvedRecords.add(record);
            }
        }
        return approvedRecords;
    }

    public static ArrayList<Record> getSpecificStateRecords(StateNames state){
        ArrayList<Record> records = getApprovedRecords();

        records.removeIf(record -> ! record.getState().equals(state));

        return records;
    }

    public static ArrayList<Record> getSpecificTypeRecords(RecordType type){
        ArrayList<Record> records = getApprovedRecords();

        records.removeIf(record -> ! record.getRecordType().equals(type));

        return records;
    }

    public static ArrayList<Record> getVerySpecificRecords(StateNames state, RecordType type){
        ArrayList<Record> records = getSpecificStateRecords(state);
        records.removeIf(record -> ! record.getRecordType().equals(type));
        return records;
    }

    private static ArrayList<Record> getVerySpecificRecords(StateNames state, RecordType type, ArrayList<Record> records){

        records.removeIf(record -> ! record.getState().equals(state));
        records.removeIf(record -> ! record.getRecordType().equals(type));
        return records;
    }

    public static ArrayList<Record> getOrderedRecords() {
        ArrayList<Record> ordered = new ArrayList<>();
        for(StateNames names : StateNames.values()){
            for (RecordType types : RecordType.values()) {
                ArrayList<Record> unordered = getRecords();
                ordered.addAll(getVerySpecificRecords(names, types, unordered));
            }
        }
        return ordered;
    }

    public static int[] getNumberOfRecords() {
        int [] number = new int[32];
        for(StateNames names : StateNames.values()){
            number[names.ordinal()] = getSpecificStateRecords(names).size();
        }

        return number;
    }
}
