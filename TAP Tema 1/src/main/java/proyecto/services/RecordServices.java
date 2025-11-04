package proyecto.services;

import com.google.gson.Gson;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import proyecto.enums.RecordType;
import proyecto.enums.StateNames;
import proyecto.models.Record;
import proyecto.utils.DialogHelper;
import proyecto.utils.Other;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class RecordServices {

    public static final String FILE = "record.json";

    public static ArrayList<Record> getRecords() {
        ArrayList<Record> records = new ArrayList<>();

        Other.createJSON(FILE);

        try {
            BufferedReader br = new BufferedReader(new FileReader(FILE));
            String result = "";
            String line = null;

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
        String msg = "";
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
        DialogHelper.infoMessageDialog("Error al guardar, intente de nuevo.", "Error de guardado.");
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
                    records.remove(all);
                    msg = "Tu registro ha sido eliminado.";
                    break;
                }
            }
            if (! writeRecords(records)) {
                msg = "Error al eliminar el registro.";
            }
        }
        DialogHelper.warnMessageDialog(msg, "Advertencia.");
    }

    public static boolean checkForRecord(Record record) {
        ArrayList<Record> records = getRecords();

        for (Record all : records) {
            if (record.getRecordId().equalsIgnoreCase(all.getRecordId())) {
                return true;
            }
        }
        return false;
    }

    public static ArrayList<Record> getUserRecords(String userID) {
        ArrayList<Record> records = getRecords();
        ArrayList<Record> userRecords = new ArrayList<>();

        for (Record record : records) {
            if (record.getAuthorId().equals(userID)) {
                userRecords.add(record);
            }
        }
        return userRecords;
    }

    public static ArrayList<Record> getUnapprovedRecords() {
        ArrayList<Record> records = getRecords();
        ArrayList<Record> unapprovedRecords = new ArrayList<>();

        for (Record record : records) {
            if (! record.isPublic()) {
                unapprovedRecords.add(record);
            }
        }
        return unapprovedRecords;
    }

    public static ArrayList<Record> getApprovedRecords() {
        ArrayList<Record> records = getRecords();
        ArrayList<Record> approvedRecords = new ArrayList<>();

        for (Record record : records) {
            if (record.isPublic()) {
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

}
