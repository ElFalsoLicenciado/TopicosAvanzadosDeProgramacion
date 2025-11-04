package proyecto.services;

import com.google.gson.Gson;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import proyecto.models.Record;
import proyecto.models.Request;
import proyecto.utils.DialogHelper;
import proyecto.utils.Other;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class RequestServices {

    public static final String FILE = "requests.json";


    public static ArrayList<Request> getRequests() {
        ArrayList<Request> requests = new ArrayList<>();

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
                Request request = new Gson().fromJson(
                        object.toString(),
                        proyecto.models.Request.class
                );
                requests.add(request);
            }

        }catch (Exception e) {
            e.printStackTrace();
        }
        return requests;
    }

    public static boolean writeRequests(ArrayList<Request> requests) {
        try{
            String json = new Gson().toJson(requests);

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

    public static boolean saveRequest(Record record) {
        ArrayList<Request> requests = getRequests();
        String msg;

        Request request = new Request(record.getAuthorId(), record.getRecordId());

        if (! checkForRequest(record)) {
            requests.add(request);
        }
        else {
            for (Request all : requests) {
                if (record.getRecordId().equals(all.getRecordId()) && record.getAuthorId().equals(all.getAuthorId()) && all.getReason().isEmpty()) {
                    requests.set(requests.indexOf(all), request);
                    break;
                }
            }
        }
        msg = "Espera a la aprobación de un administrador para que sea público.";

        if (writeRequests(requests)) {
            DialogHelper.infoMessageDialog(msg, "Aprobación guardada.");
            return true;
        }
        DialogHelper.errorMessageDialog("Error al guardar aprobación.", "Error de guardado");
        return false;
    }

    public static boolean checkForRequest(Record record) {
        ArrayList<Request> requests = getRequests();

        for (Request all : requests) {
            if (record.getRecordId().equals(all.getRecordId()) && record.getAuthorId().equals(all.getAuthorId()) && all.getReason().isEmpty()) {
                return true;
            }
        }
        return false;
    }

    public static ArrayList<Request> getUserRequests(String userID) {
        ArrayList<Request> requests = getRequests();
        ArrayList<Request> userRequests = new ArrayList<>();

        for (Request request : requests) {
            if (request.getAuthorId().equals(userID)) {
                userRequests.add(request);
            }
        }
        return userRequests;
    }


}
