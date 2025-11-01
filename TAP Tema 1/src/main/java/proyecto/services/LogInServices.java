package proyecto.services;

import proyecto.models.User;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import com.google.gson.Gson;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import proyecto.utils.DialogHelper;

import javax.swing.*;


public class LogInServices {

    public static final String FILE = "users.json";

    public static ArrayList<User> getUsers() {
        ArrayList<User> users = new ArrayList<>();

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
                User user = new Gson().fromJson(
                        object.toString(),
                        User.class
                );
                users.add(user);
            }

        }catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }

    public static boolean writeProductos(ArrayList<User> users) {
        try{
            String json = new Gson().toJson(users);

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

    public static User searchForUser(String username, String password) {
        User user = null;

        ArrayList<User> userList = getUsers();

        for (User all : userList) {
            if (all.getUsername().equals(username)) {
                if (all.getPassword().equals(password)) {
                    user = all;
                    return user;
                }
                DialogHelper.errorMessageDialog(
                        "La contraseña que introdujiste no es correcta.",
                        "Contraseña incorrecta."
                );
            }
            DialogHelper.errorMessageDialog(
                    "No existe cuenta alguna con este nombre de usuario.",
                    "Nombre de usuario inexistente."
            );
        }

        return user;
    }

    public static boolean checkUsername(String username) {
        for (User user : getUsers()) {
            if (user.getUsername().equals(username)) {
                return false;
            }
        }
        return true;
    }
}
