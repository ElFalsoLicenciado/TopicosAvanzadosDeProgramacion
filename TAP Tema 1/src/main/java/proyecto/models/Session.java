package proyecto.models;

import proyecto.enums.UserType;
import proyecto.services.UserServices;
import proyecto.utils.DialogHelper;

import java.util.ArrayList;
import java.util.UUID;

public class Session {
    public static ArrayList<User> users = new ArrayList<>();
    private static User user;

    public Session() {
        users = UserServices.getUsers();
    }

    public User getUser() {
        return user;
    }

    public static boolean logIn(String username, String password) {
        User search = UserServices.searchForUser(username, password);
        if (search != null) {
            DialogHelper.infoMessageDialog(
                    "Bienvenido: " + username,
                    "Iniciado sesión correctamente."
            );
            user = search;
            return true;
        }
        return false;
    }

    public static boolean signUp(UserType type, String username, String password) {
        users = UserServices.getUsers();
        if (UserServices.checkUsername(username)) {
            User aux = new User(type, username, password);
            users.add(aux);
            if(UserServices.writeProductos(users)) {
                user = aux;
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
            users.remove(aux);
            return false;

        }else {
            DialogHelper.errorMessageDialog(
                    "El nombre de usuario ya existe, intenta con otro.",
                    "Error"
            );
            return false;
        }
    }

    public static void guestMode() {
        user = new User(
                UserType.GUEST,
                "Guest" + UUID.randomUUID().toString().replace("-", "").substring(0,5),
                ""
        );
        DialogHelper.infoMessageDialog(
                "Entraste a modo invitado",
                "Modo invitado"
        );
    }

    public static void logout() {
        user = null;
    }



}
