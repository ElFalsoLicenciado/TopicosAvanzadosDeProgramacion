package proyecto.services;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.apache.hc.client5.http.fluent.Form;
import org.apache.hc.client5.http.fluent.Request;
import proyecto.models.User;

import java.lang.reflect.Type;
import java.util.ArrayList;


public class UserServicesSQL {

    private static final String url =  "http://localhost/TAP_2025/Proyecto/";

    public static boolean addUser2(User u) throws Exception {
        Form form = Form.form();
        form.add("operation", "add");
        form.add("type", u.getUser_type().toString());
        form.add("username", u.getUsername());
        form.add("password", u.getPassword());

        String result = Request.post(
                url + "end_point_users.php"
        ).bodyForm(form.build()).execute().returnContent().asString();


        return ! result.contains("\"error\"");
    }

    public static ArrayList<User> getUsers2() throws Exception {
        ArrayList<User> users;

        String results = Request.get(
                url + "end_point_users.php?operation=getAll"
        ).execute().returnContent().asString();

        Type listType = new TypeToken<ArrayList<User>>(){}.getType();
        users = new Gson().fromJson(results, listType);

        return users;
    }


    public static User getUser2(String id_user) throws Exception {
        Form form = Form.form();
        form.add("operation", "getById");
        form.add("id_user", id_user);

        return getUser(form);
    }

    public static User getUser2(String username, String password) throws Exception {
        Form form = Form.form();
        form.add("operation", "getByCredentials");
        form.add("username", username );
        form.add("password", password);

        return getUser(form);
    }



    public static boolean checkUsername2(String username) throws Exception {
        Form form = Form.form();
        form.add("operation", "checkUsername");
        form.add("username", username );

        String result = Request.post(
                url + "end_point_users.php"
        ).bodyForm(form.build()).execute().returnContent().asString();

        if (result.contains("\"error\"")) {
            return true;
        }
        else return !result.contains("0");
    }



    public static int numberOfUsers2() throws Exception {
        int numberOfUsers;

        String results = Request.get(
                url + "end_point_users.php?operation=number"
        ).execute().returnContent().asString();


        numberOfUsers = Integer.parseInt(results);

        return numberOfUsers;
    }


    private static User getUser(Form form) throws Exception {
        ArrayList<User> users;

        String results = Request.post(
                url + "end_point_users.php"
        ).bodyForm(form.build()).execute().returnContent().asString();


        Type listType = new TypeToken<ArrayList<User>>(){}.getType();
        users = new Gson().fromJson(results, listType);

        return users.getFirst();
    }
}
