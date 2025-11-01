/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tarea1;

import com.mpatric.mp3agic.Mp3File;

import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.tag.FieldKey;
import org.jaudiotagger.tag.Tag;


import java.io.File;


public class Cancion implements Cloneable{

    private String title, author,path, songLength;
    private Mp3File mp3File;
    private double frameRatePerMilliseconds;

    public Cancion(){
    }
    
    
    public Cancion(String path)
    {
        this.path = path;
        try{
            mp3File = new Mp3File(path);
            frameRatePerMilliseconds = (double) mp3File.getFrameCount() / mp3File.getLengthInMilliseconds();
            songLength = convertToSongLengthFormat();

            AudioFile audioFile = AudioFileIO.read(new File(path));
            Tag tag = audioFile.getTag();

            if (tag != null){
                title = tag.getFirst(FieldKey.TITLE);
                author = tag.getFirst(FieldKey.ARTIST);
            }else {
                title = "";
                author = "";
            }

        }catch ( Exception e ){
            e.printStackTrace();
        }
    }

    public String getPath() {
        return path;
    }

    public Mp3File getMp3File() {
        return mp3File;
    }

    public double getFrameRatePerMilliseconds() {
        return frameRatePerMilliseconds;
    }

    public String getSongLength() {
        return songLength;
    }

    private String convertToSongLengthFormat(){
        long minutes = mp3File.getLengthInSeconds() / 60;
        long seconds = mp3File.getLengthInSeconds() % 60;

        return String.format("%02d:%02d", minutes, seconds);
    }

    @Override
    public Cancion clone() {
        try {
            return (Cancion) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    @Override
    public String toString() {
        return String.format("%s - %s", author, title);
    }
    
    
    
}
