package proyecto.models;

import proyecto.enums.UserType;
import proyecto.services.UserServicesSQL;
import proyecto.utils.DialogHelper;

import java.util.ArrayList;
import java.util.UUID;

public class Session {
    private static User user;

    public Session() {
    }

    public User getUser() {
        return user;
    }

    public static boolean logIn(String username, String password) {
        boolean result = false;
        try {
            User search = UserServicesSQL.getUser(username, password);
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
            if (UserServicesSQL.checkUsername(username)) {
                user.setUser_type(type);
                user.setUsername(username);
                user.setPassword(password);
                if (UserServicesSQL.addUser(user)) {
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

//    public ArrayList<Record> getUserRecords() {
//        return RecordServices.getUserRecords(user.getId_user());
//    }

//    public ArrayList<Request> getUserRequests() {
//        return RequestServices.getUserRequests(user.getId_user());
//    }


}
