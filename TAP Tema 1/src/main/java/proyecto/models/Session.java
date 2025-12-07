package proyecto.models;

import proyecto.enums.UserType;
import proyecto.services.RequestServicesSQL;
import proyecto.services.UserServicesSQL;
import proyecto.services.RecordServicesSQL;

import proyecto.utils.DialogHelper;

import java.util.ArrayList;

public class Session {
    private static User user;

    public Session() {
        user = new User();
    }

    public User getUser() {
        return user;
    }

    public static boolean logIn(String username, String password) {
        boolean result = false;
        try {
            User search = UserServicesSQL.getUser2(username, password);
            if (search != null) {
                DialogHelper.infoMessageDialog(
                        "Bienvenido: " + username,
                        "Iniciado sesión correctamente."
                );
                user = search;
                result = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static boolean signUp(UserType type, String username, String password) {
        boolean result = false;
        try {
            if (! UserServicesSQL.checkUsername2(username)) {
                user.setUser_type(type);
                user.setUsername(username);
                user.setPassword(password);
                if (UserServicesSQL.addUser2(user)) {
                    user = UserServicesSQL.getUser2(username, password);
                    DialogHelper.infoMessageDialog(
                            "Cuenta creada exitosamente.",
                            "Cuenta creada"
                    );
                    result = true;
                }
                else DialogHelper.errorMessageDialog(
                        "Error al crear la cuenta, vuelva a intentarlo.",
                        "Error"
                );
            } else DialogHelper.errorMessageDialog(
                    "El nombre de usuario ya existe, intenta con otro.",
                    "Error"
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void guestMode() {
        user = new User(
                "Guest"
        );
        DialogHelper.infoMessageDialog(
                "Entraste a modo invitado",
                "Modo invitado"
        );
    }

    public static void logout() {
        user = null;
    }

    public ArrayList<Record> getUserRecords() {
        try {
            return RecordServicesSQL.getUserRecords2(user.getId_user());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<Request> getUserRequests() {
        try {
            return RequestServicesSQL.getUserRequests2(user.getId_user());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


}
