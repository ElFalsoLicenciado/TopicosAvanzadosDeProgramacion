package Practica2.model_layer.models;

import java.io.Serializable;

public class Usuario implements Serializable {
    private int id_usuario;
    private String correo;
    private String contrasenia;
    private String nombre_completo;
    private Boolean es_admin;
    private byte[] foto;

    public Usuario() {
    }

    public Usuario(int id_usuario, String correo, String contrasenia, String nombre_completo, Boolean es_admin, byte[] foto) {
        this.id_usuario = id_usuario;
        this.correo = correo;
        this.contrasenia = contrasenia;
        this.nombre_completo = nombre_completo;
        this.es_admin = es_admin;
        this.foto = foto;
    }

    public Boolean getEs_admin() {
        return es_admin;
    }

    public void setEs_admin(Boolean es_admin) {
        this.es_admin = es_admin;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getNombre_completo() {
        return nombre_completo;
    }

    public void setNombre_completo(String nombre_completo) {
        this.nombre_completo = nombre_completo;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id_usuario=" + id_usuario + ", correo=" + correo + ", contrasenia=" + contrasenia + ", nombre_completo=" + nombre_completo + ", es_admin=" + es_admin + ", foto=" + foto + '}';
    }
}
