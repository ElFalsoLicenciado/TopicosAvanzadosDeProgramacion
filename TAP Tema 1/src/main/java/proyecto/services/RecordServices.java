package proyecto.services;

import com.google.gson.Gson;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfDocument;
import com.itextpdf.text.pdf.PdfWriter;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import proyecto.enums.RecordType;
import proyecto.enums.StateNames;
import proyecto.models.Record;
import proyecto.utils.DialogHelper;
import proyecto.utils.Other;

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
        ArrayList<Record> records = getRecords();
        ArrayList<Record> userRecords = new ArrayList<>();

        for (Record record : records) {
            if (record.getAuthorId().equals(userID) && ! record.isDeleted()) {
                userRecords.add(record);
            }
        }
        return userRecords;
    }

    public static ArrayList<Record> getApprovedRecords() {
        ArrayList<Record> records = getRecords();
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
}
