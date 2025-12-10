package Practica3;


import java.io.Serializable;
import java.util.ArrayList;

public class Tema implements Serializable{

    private String nombreTema;
    private int numTema;
    private ArrayList<Subtema> subtemas;

    public Tema() {
    }

    public Tema(String nombreTema, int numTema, ArrayList<Subtema> subtemas) {
        this.nombreTema = nombreTema;
        this.numTema = numTema;
        this.subtemas = subtemas;
    }

    public ArrayList<Subtema> getSubtemas() {
        return subtemas;
    }

    public void setSubtemas(ArrayList<Subtema> subtemas) {
        this.subtemas = subtemas;
    }

    public String getNombreTema() {
        return nombreTema;
    }

    public void setNombreTema(String nombreTema) {
        this.nombreTema = nombreTema;
    }

    public int getNumTema() {
        return numTema;
    }

    public void setNumTema(int numTema) {
        this.numTema = numTema;
    }

    @Override
    public String toString() {
        return "Tema{" + "nombreTema=" + nombreTema + ", numTema=" + numTema + ", subtemas=" + subtemas + '}';
    }    
    
    
}
