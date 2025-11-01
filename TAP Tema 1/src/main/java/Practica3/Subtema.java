package Practica3;

import java.io.Serializable;


public class Subtema implements Serializable{

    private String nombre;
    private int numSubtema;

    public Subtema() { //Clase tipo
    }

    public Subtema(String nombre, int numSubtema) {
        this.nombre = nombre;
        this.numSubtema = numSubtema;
    }

    public int getNumSubtema() {
        return numSubtema;
    }

    public void setNumSubtema(int numSubtema) {
        this.numSubtema = numSubtema;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Subtema{" + "nombre=" + nombre + ", numSubtema=" + numSubtema + '}';
    }
    
    
    
    
}
