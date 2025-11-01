/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tarea1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.UUID;



public class Playlist implements Cloneable{
    
    private ArrayList<Cancion> listado;
    private String nombrePlaylist;
    private String idP;
    
    public Playlist()
    {
        
    }
    
    
    
    public Playlist(String nombrePlaylist) {
        idP = UUID.randomUUID().toString();
        this.nombrePlaylist = nombrePlaylist;
        listado = new ArrayList<>();
    }

    public Playlist( Playlist playlist) {
        idP = playlist.getidP();
        nombrePlaylist = playlist.getNombrePlaylist();
        listado = playlist.getListado();
    }
    
    public String getidP(){
        return idP;
    }
    
    public ArrayList<Cancion> getListado() {
        return listado;
    }

    public void setListado(ArrayList<Cancion> listado) {
        this.listado = listado;
    }

    public String getNombrePlaylist() {
        return nombrePlaylist;
    }

    public void setNombrePlaylist(String nombrePlaylist) {
        this.nombrePlaylist = nombrePlaylist;
    }
    
    public void addSong(Cancion adicion){
        listado.add(adicion);
    }
    
    public void removeSong(Cancion rem){
        listado.remove(rem);
    }
    
    
    public void switchSong(Cancion subir, Cancion bajar)
    {
        System.out.printf("Subir: %s Bajar: %s%n",
                listado.indexOf(subir),
                listado.indexOf(bajar));
        
        Collections.swap(listado, 
                listado.indexOf(subir), 
                listado.indexOf(bajar));
    }

    public void clearPlaylist()
    {
        listado.clear();
    }

    @Override
    public Playlist clone() {
        try {
            Playlist copy = (Playlist) super.clone();
            // Deep copy of the song list
            copy.listado = new ArrayList<>();
            for (Cancion c : this.listado) {
                copy.listado.add(c.clone()); // requires Cancion.clone()
            }
            return copy;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(); // should never happen
        }
    }

    @Override
    public String toString() {
        return String.format("%s", nombrePlaylist);
    }
        

}
