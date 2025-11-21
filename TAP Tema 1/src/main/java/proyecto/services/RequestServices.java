package proyecto.services;

import proyecto.enums.RequestStatus;
import proyecto.models.Record;
import proyecto.models.Request;
import proyecto.utils.DialogHelper;
import proyecto.utils.Other;

import com.google.gson.Gson;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
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

    public static boolean createRequest(Record record) {
        ArrayList<Request> requests = getRequests();
        String msg;

        Request request = new Request(record.getId_author(), record, RequestStatus.WAITING);

        if (! checkForRequest(record)) {
            requests.add(request);
        }
        else {
            for (Request all : requests) {
                if (record.getId_record().equals(all.getRecord().getId_author())
                        && record.getId_author().equals(all.getId_author())
                        && all.getStatus().equals(RequestStatus.WAITING)
                ) {
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

    public static boolean setRequestStatus(Request request, RequestStatus status, String reason) {
        ArrayList<Request> requests = getRequests();

        request.setStatus(status);
        request.setReason(reason);

        for (Request all : requests) {
            if (request.getId_request().equals(all.getId_request())) {
                requests.set(requests.indexOf(all), request);
                break;
            }
        }
        if (writeRequests(requests)) {
            if (status == RequestStatus.APPROVED) {
                Record record = RecordServices.getRecord(request.getRecord().getId_record());
                if (record != null) {
                    record.setIs_public(true);
                    RecordServices.saveRecord(record);
                }
            }
            DialogHelper.infoMessageDialog("La aprobación ha sido revisada y guardada.", "Guardado exitoso." );
            return true;
        }
        DialogHelper.errorMessageDialog("Error al guardar, intente de nuevo", "Error de guardado");
        return false;
    }

    public static void recordDeleted(Record record){
        ArrayList<Request> requests = getRequests();

        for (Request all : requests) {
            if (record.getId_record().equals(all.getRecord().getId_record())
                    && record.getId_author().equals(all.getId_author())
                    && all.getStatus().equals(RequestStatus.WAITING)
            ) {
                all.setStatus(RequestStatus.CANCELED);
                requests.set(requests.indexOf(all), all);
                break;
            }
        }
        writeRequests(requests);
    }

    private static boolean checkForRequest(Record record) {
        ArrayList<Request> requests = getRequests();

        for (Request all : requests) {
            if (record.getId_record().equals(all.getRecord().getId_record())
                    && record.getId_author().equals(all.getId_author())
                    && all.getStatus().equals(RequestStatus.WAITING)
            ) {
                return true;
            }
        }
        return false;
    }

    public static ArrayList<Request> getUserRequests(String userID) {
        ArrayList<Request> requests = getRequests();
        ArrayList<Request> userRequests = new ArrayList<>();

        for (Request request : requests) {
            if (request.getId_author().equals(userID)) {
                userRequests.add(request);
            }
        }
        return userRequests;
    }


}
