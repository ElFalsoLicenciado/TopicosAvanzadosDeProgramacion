package Practica3.model_layer;

import java.io.Serializable;

/**
 *
 * @author Link
 */
public class Usuario implements Serializable {
    private String id_usuario;
    private String usuario;
    private String contrasenia;
    private boolean es_admin;

    public Usuario() {
    }

    public Usuario(String id_usuario, String usuario, String contrasenia, boolean es_admin) {
        this.id_usuario = id_usuario;
        this.usuario = usuario;
        this.contrasenia = contrasenia;
        this.es_admin = es_admin;
    }

    public boolean isEs_admin() {
        return es_admin;
    }

    public void setEs_admin(boolean es_admin) {
        this.es_admin = es_admin;
    }

    public String getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(String id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id_usuario=" + id_usuario + ", usuario=" + usuario + ", contrasenia=" + contrasenia + ", es_admin=" + es_admin + '}';
    }
    
    
}
