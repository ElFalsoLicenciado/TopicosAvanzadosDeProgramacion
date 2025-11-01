package Tarea1;

import javazoom.jl.player.advanced.AdvancedPlayer;
import javazoom.jl.player.advanced.PlaybackEvent;
import javazoom.jl.player.advanced.PlaybackListener;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

public class Player extends PlaybackListener {
    private static final Object playSignal = new Object();

    private PaginaReproductor reproductor;

    private Cancion currentSong;
    public Cancion getCurrentSong(){
        return currentSong;
    }

    private ArrayList<Cancion> playlist;

    private int currentPlaylistIndex;

    private AdvancedPlayer advancedPlayer;

    private boolean isPaused;

    private boolean songFinished;

    private boolean pressedNext, pressedPrev;

    private int currentFrame;
    public void setCurrentFrame(int frame){
        currentFrame = frame;
    }

    private int currentTimeInMilli;
    public void setCurrentTimeInMilli(int timeInMilli){
        currentTimeInMilli = timeInMilli;
    }

    public Player(PaginaReproductor reproductor){
        this.reproductor = reproductor;
    }

    public void loadPlaylist(Playlist playlistFile){
        playlist = playlistFile.getListado();

        if(!playlist.isEmpty()){
            reproductor.setPlaybackSliderValue(0);
            currentTimeInMilli = 0;

            currentSong = playlist.getFirst();

            currentFrame = 0;

            reproductor.changelabelNombreCancion(currentSong);
            reproductor.updatePlaybackSlider(currentSong);
        }
    }

    public void pauseSong(){
        if(advancedPlayer != null){
            isPaused = true;

            stopSong();
        }
    }

    public void stopSong(){
        if(advancedPlayer != null){
            advancedPlayer.stop();
            advancedPlayer.close();
            advancedPlayer = null;
        }
    }

    public void stopReproduction(){
        if(playlist == null) return;

        if(!songFinished)
            stopSong();

        currentPlaylistIndex = 0;

        currentSong = playlist.get(currentPlaylistIndex);

        currentFrame = 0;

        currentTimeInMilli = 0;

        reproductor.changelabelNombreCancion(currentSong);
        reproductor.updatePlaybackSlider(currentSong);
        reproductor.setPlaybackSliderValue(0);
    }

    public void nextSong(){
        if(playlist == null) return;

        if(currentPlaylistIndex + 1 > playlist.size() - 1)
        {
            JOptionPane.showMessageDialog(null, "No more songs to play", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        pressedNext = true;

        if(!songFinished)
            stopSong();

        currentPlaylistIndex++;

        currentSong = playlist.get(currentPlaylistIndex);

        currentFrame = 0;

        currentTimeInMilli = 0;

        reproductor.changelabelNombreCancion(currentSong);
        reproductor.updatePlaybackSlider(currentSong);
        reproductor.setPlaybackSliderValue(0);

        playCurrentSong();
    }

    public void prevSong(){
        if(playlist == null) return;

        if(currentPlaylistIndex - 1 < 0) return;

        pressedPrev = true;

        if(!songFinished)
            stopSong();

        currentPlaylistIndex--;

        currentSong = playlist.get(currentPlaylistIndex);

        currentFrame = 0;

        currentTimeInMilli = 0;

        reproductor.changelabelNombreCancion(currentSong);
        reproductor.updatePlaybackSlider(currentSong);
        reproductor.setPlaybackSliderValue(0);

        playCurrentSong();
    }

    public void playCurrentSong(){
        if(currentSong == null) return;

        try{
            FileInputStream fileInputStream = new FileInputStream(currentSong.getPath());
            BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);

            advancedPlayer = new AdvancedPlayer(bufferedInputStream);
            advancedPlayer.setPlayBackListener(this);

            startMusicThread();

            startPlaybackSliderThread();

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    private void startMusicThread(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    if(isPaused){
                        synchronized(playSignal){
                            isPaused = false;

                            playSignal.notify();
                        }

                        advancedPlayer.play(currentFrame, Integer.MAX_VALUE);
                    }else{
                        advancedPlayer.play();
                    }
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        }).start();
    }

    private void startPlaybackSliderThread(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                if(isPaused){
                    try{
                        synchronized(playSignal){
                            playSignal.wait();
                        }
                    }catch(Exception e){
                        e.printStackTrace();
                    }
                }

                while(!isPaused && !songFinished && !pressedNext && !pressedPrev){
                    try{
                        currentTimeInMilli++;

                        int calculatedFrame = (int) ((double) currentTimeInMilli * 2.08 * currentSong.getFrameRatePerMilliseconds());

                        reproductor.setPlaybackSliderValue(calculatedFrame);

                        Thread.sleep(1);
                    }catch(Exception e){
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    @Override
    public void playbackStarted(PlaybackEvent evt) {
        System.out.println("Playback Started");
        songFinished = false;
        pressedNext = false;
        pressedPrev = false;
    }

    @Override
    public void playbackFinished(PlaybackEvent evt) {
        System.out.println("Playback Finished");
        if(isPaused){
            currentFrame += (int) ((double) evt.getFrame() * currentSong.getFrameRatePerMilliseconds());
        }else{
            if(pressedNext || pressedPrev) return;

            songFinished = true;

            if(playlist == null){
                //reproductor.enablePlayButtonDisablePauseButton();
            }else{
                if(currentPlaylistIndex == playlist.size() - 1){
                    //musicPlayerGUI.enablePlayButtonDisablePauseButton();
                }else{
                    nextSong();
                }
            }
        }
    }
}



















