package proyecto.models;

import proyecto.enums.UserType;
import proyecto.services.RecordServices;
import proyecto.services.RequestServices;
import proyecto.services.UserServices;
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
        try {
            User search = UserServicesSQL.getUser(username, password);
            if (search != null) {
                DialogHelper.infoMessageDialog(
                        "Bienvenido: " + username,
                        "Iniciado sesión correctamente."
                );
                user = search;
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean signUp(UserType type, String username, String password) {
        try {
            if (UserServicesSQL.checkUsername(username)) {
                if (UserServicesSQL.addUser(type, username, password)) {
                    user = UserServicesSQL.getUser(username, password);
                    DialogHelper.infoMessageDialog(
                            "Cuenta creada exitosamente.",
                            "Cuenta creada"
                    );
                    return true;
                }
                DialogHelper.errorMessageDialog(
                        "Error al crear la cuenta, vuelva a intentarlo.",
                        "Error"
                );

            } else {
                DialogHelper.errorMessageDialog(
                        "El nombre de usuario ya existe, intenta con otro.",
                        "Error"
                );
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
        }
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
        return RecordServices.getUserRecords(user.getId_user());
    }

    public ArrayList<Request> getUserRequests() {
        return RequestServices.getUserRequests(user.getId_user());
    }


}
