package Practica6.services;

import Practica6.models.Usuario;
import org.apache.hc.client5.http.fluent.Form;
import org.apache.hc.client5.http.fluent.Request;

public class UsuarioService {

    private final String urlBase = "";

    public Usuario findUser(String usr, String pass) throws Exception {
        Usuario usuario = null;

        Form form = Form.form();
        form.add("usuario", usr);
        form.add("contrasenia", pass);

        String results = Request.post(
                urlBase + "end_point_usuarios.php?option=login"
        ).bodyForm(form.build()).execute().returnContent().asString();

        System.out.println(results);



        return usuario;
    }


    public boolean addUsr(String usr, String pass) throws Exception {
        Form form = Form.form();
        form.add("usuario", usr);
        form.add("contrasenia", pass);

        String results = Request.post(
                urlBase + "end_point_usuarios.php?option=register"
        ).bodyForm(form.build()).execute().returnContent().asString();

        System.out.println(results);

        return !results.contains("Error");
    }
}
