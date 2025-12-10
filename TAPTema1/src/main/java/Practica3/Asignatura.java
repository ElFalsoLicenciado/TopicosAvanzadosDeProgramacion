package Practica3;

import java.io.Serializable;
import java.util.ArrayList;

public class Asignatura implements Serializable{

    private String nombreAsignatura;
    private String claveAsignatura;
    private int semestre;
    private Double creditos;
    private ArrayList<Tema> temas;

    public Asignatura() {
    }

    public Asignatura(String nombreAsignatura, String claveAsignatura, int semestre, Double creditos, ArrayList<Tema> temas) {
        this.nombreAsignatura = nombreAsignatura;
        this.claveAsignatura = claveAsignatura;
        this.semestre = semestre;
        this.creditos = creditos;
        this.temas = temas;
    }

    public ArrayList<Tema> getTemas() {
        return temas;
    }

    public void setTemas(ArrayList<Tema> temas) {
        this.temas = temas;
    }

    public String getNombreAsignatura() {
        return nombreAsignatura;
    }

    public void setNombreAsignatura(String nombreAsignatura) {
        this.nombreAsignatura = nombreAsignatura;
    }

    public String getClaveAsignatura() {
        return claveAsignatura;
    }

    public void setClaveAsignatura(String claveAsignatura) {
        this.claveAsignatura = claveAsignatura;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    public Double getCreditos() {
        return creditos;
    }

    public void setCreditos(Double creditos) {
        this.creditos = creditos;
    }

    @Override
    public String toString() {
        return "Asignatura{" + "nombreAsignatura=" + nombreAsignatura + ", claveAsignatura=" + claveAsignatura + ", semestre=" + semestre + ", creditos=" + creditos + ", temas=" + temas + '}';
    }
    
    
}
