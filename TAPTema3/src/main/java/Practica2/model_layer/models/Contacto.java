package Practica2.model_layer.models;

import java.io.Serializable;

public class Contacto implements Serializable {
    private int id_contacto;
    private int id_usuario;
    private String nombre_contacto;
    private String telefono;
    private String correo;
    private byte[] foto_contacto;
    private String nombre_foto;
    private Usuario usuario;

    public Contacto() {
    }

    public Contacto(int id_contacto, int id_usuario, String nombre_contacto, String telefono, String correo, byte[] foto_contacto, String nombre_foto) {
        this.id_contacto = id_contacto;
        this.id_usuario = id_usuario;
        this.nombre_contacto = nombre_contacto;
        this.telefono = telefono;
        this.correo = correo;
        this.foto_contacto = foto_contacto;
        this.nombre_foto = nombre_foto;
    }

    public String getNombre_foto() {
        return nombre_foto;
    }

    public void setNombre_foto(String nombre_foto) {
        this.nombre_foto = nombre_foto;
    }

    public int getId_contacto() {
        return id_contacto;
    }

    public void setId_contacto(int id_contacto) {
        this.id_contacto = id_contacto;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombre_contacto() {
        return nombre_contacto;
    }

    public void setNombre_contacto(String nombre_contacto) {
        this.nombre_contacto = nombre_contacto;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public byte[] getFoto_contacto() {
        return foto_contacto;
    }

    public void setFoto_contacto(byte[] foto_contacto) {
        this.foto_contacto = foto_contacto;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "Contacto{" + "id_contacto=" + id_contacto + ", id_usuario=" + id_usuario + ", nombre_contacto=" + nombre_contacto + ", telefono=" + telefono + ", correo=" + correo + ", foto_contacto=" + foto_contacto + ", nombre_foto=" + nombre_foto + ", usuario=" + usuario.toString() + '}';
    }

}
