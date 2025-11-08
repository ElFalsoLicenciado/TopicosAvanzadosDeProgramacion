package proyecto.services;

import proyecto.enums.RecordType;
import proyecto.enums.StateNames;
import proyecto.models.Record;
import proyecto.utils.DialogHelper;
import proyecto.utils.Other;

import com.google.gson.Gson;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfDocument;
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
            return;
        }

        try {
            Document document = new Document(PageSize.A4, 40, 40, 20, 20);
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("results/" + Other.getStateNames()[state.ordinal()] + ".pdf") );
            PdfDocument pdfDocument = new PdfDocument();
            Font title = new Font(Font.FontFamily.HELVETICA, 18, Font.BOLD);
            Font body = new Font(Font.FontFamily.HELVETICA, 15, Font.NORMAL);


            pdfDocument.addWriter(writer);

            document.open();

            for (Record record : records) {
                String titleAndAuthor ="ID del registro: " + record.getRecordId()+ "\nTítulo: " + record.getTitle();
                String aux = UserServices.searchForUser(record.getAuthorId());
                if (aux.isEmpty()) titleAndAuthor += " - sin autor";
                else titleAndAuthor += " - " + aux;

                String stateAndType = "Estado: " + record.getState().toString().replace("_", " ");
                stateAndType+= "\nTipo de registro cultural: " + Other.getTypes()[record.getRecordType().ordinal()];

                String isPublic;
                if (record.isPublic()) isPublic = "Es público: si";
                else isPublic = "Es público: no";

                String description = "Descripción:\n" + record.getDescription();
                Image image = Image.getInstance(record.getImageUrl());
                image.scaleAbsolute(150,150);
                image.setAlignment(Element.ALIGN_CENTER);

                Paragraph p1 = new Paragraph(titleAndAuthor, title);
                Paragraph p2 = new Paragraph(stateAndType, title);
                Paragraph p3 = new Paragraph(isPublic, title);
                Paragraph p4 = new Paragraph(description, body);

                p1.setAlignment(Element.ALIGN_JUSTIFIED);
                p2.setAlignment(Element.ALIGN_JUSTIFIED);
                p3.setAlignment(Element.ALIGN_JUSTIFIED);
                p4.setAlignment(Element.ALIGN_JUSTIFIED);

                document.add(p1);
                document.add(p2);
                document.add(p3);
                document.add(p4);

                document.add(image);
                document.newPage();
            }

            document.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /** <h1> WARNING:</h1>
     * <p> Note that sheet name is Excel must not exceed 31 characters
     * and must not contain any of the any of the following characters: </p>
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
        ArrayList<Record> records = getOrderedRecords();

        try(Workbook wb = new XSSFWorkbook()){
            Sheet sheet = wb.createSheet("Resumen");
            Row header = sheet.createRow(0);
            header.createCell(0).setCellValue("recordId");
            header.createCell(1).setCellValue("authorId");
            header.createCell(2).setCellValue("stateName");
            header.createCell(3).setCellValue("recordType");
            header.createCell(4).setCellValue("isPublic");
            header.createCell(5).setCellValue("title");
            header.createCell(6).setCellValue("description");
            header.createCell(7).setCellValue("imageUrl");
            header.createCell(8).setCellValue("deleted");

            for (Record record : records) {
                Row row = sheet.createRow(sheet.getLastRowNum() + 1);
                row.createCell(0).setCellValue(record.getRecordId());
                row.createCell(1).setCellValue(record.getAuthorId());
                row.createCell(2).setCellValue(record.getState().toString().replace("_", " "));
                row.createCell(3).setCellValue(Other.getTypes()[record.getRecordType().ordinal()]);
                row.createCell(4).setCellValue(record.isPublic());
                row.createCell(5).setCellValue(record.getTitle());
                row.createCell(6).setCellValue(record.getDescription());
                row.createCell(7).setCellValue(record.getImageUrl());
                row.createCell(8).setCellValue(record.isDeleted());
            }

            OutputStream fileOut = new FileOutputStream("results/try.xlsx");
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

        System.out.println("STATE");

        records.removeIf(record -> ! record.getState().equals(state));

        return records;
    }

    public static ArrayList<Record> getSpecificTypeRecords(RecordType type){
        ArrayList<Record> records = getApprovedRecords();

        System.out.println("TYPE");

        records.removeIf(record -> ! record.getRecordType().equals(type));

        return records;
    }

    public static ArrayList<Record> getVerySpecificRecords(StateNames state, RecordType type){
        ArrayList<Record> records = getApprovedRecords();

        System.out.println("SPECIFIC");

        records.removeIf(record -> ! record.getState().equals(state));
        records.removeIf(record -> ! record.getRecordType().equals(type));
        return records;
    }

    private static ArrayList<Record> getVerySpecificRecords(StateNames state, RecordType type, ArrayList<Record> records){
        System.out.println("SPECIFIC");

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


}
