package proyecto.models;

import proyecto.enums.UserType;
import proyecto.services.LogInServices;
import proyecto.utils.DialogHelper;

import java.util.ArrayList;

public class Session {
    public ArrayList<User> users = new ArrayList<>();
    private User user;

    public Session() {
        users = LogInServices.getUsers();
    }


    public User getUser() {
        return user;
    }

    public void logIn(String username, String password) {
        User user = LogInServices.searchForUser(username, password);
        if (user != null) {
            DialogHelper.infoMessageDialog(
                    "Bienvenido: " + username,
                    "Iniciado sesión correctamente."
                    );
            this.user = user;
        }
    }

    public void signUp(UserType type, String username, String password) {
        if (LogInServices.checkUsername(username)) {
            User aux = new User(type, username, password);
            users.add(aux);
            if(LogInServices.writeProductos(users)) {
                user = aux;
                DialogHelper.infoMessageDialog(
                        "Cuenta creada exitosamente.",
                        "Cuenta creada"
                );
            }

        }else {
            DialogHelper.errorMessageDialog(
                    "El nombre de usuario ya existe, intenta con otro.",
                    "Error"
            );
        }
    }

}
