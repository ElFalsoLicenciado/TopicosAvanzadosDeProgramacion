package proyecto.services;

import com.google.gson.Gson;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import proyecto.models.Record;
import proyecto.utils.Other;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class RecordServices {

    public static final String FILE = "request.json";

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

}
