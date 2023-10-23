package com.ramzi.audio;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import javax.sound.sampled.FloatControl;

import javafx.scene.control.ProgressBar;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Text;
import javafx.util.Duration;

import java.beans.EventHandler;
import java.io.File;

public class Controller {
    File directory = new File("PATH\\Musics");
    FileManager FM = new FileManager(directory);
    String currentMusic = FM.returnCurrentMusic();
    Music music = new Music(currentMusic);
    String currentTitle = FM.getCurrentTitle();



    @FXML
    private ProgressBar progressBar;
    @FXML
    private Text currentsecs = new Text("0");
    @FXML
    private Text fullsecs = new Text("0");
    @FXML
    public Text Titre = new Text(currentTitle);

    private void updateProgressBar() {
        Timeline timeline = new Timeline(
                new KeyFrame(Duration.seconds(1), event -> {
                    double currentPos = music.getCurrentPosition();
                    double duration = music.getDuration();
                    progressBar.setProgress(currentPos / duration);

                    // Update current time and total time in seconds
                    currentsecs.setText(formatTime(currentPos));
                    fullsecs.setText(formatTime(duration));
                })
        );
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    private String formatTime(double seconds) {
        int minutes = (int) seconds / 60;
        int secs = (int) seconds % 60;
        return String.format("%02d:%02d", minutes, secs);
    }


    @FXML
    protected void play(){
        System.out.println(FM.getCurrentTitle());
        Titre.setText(FM.getCurrentTitle());
        music.play();
        updateProgressBar();
    }
    @FXML
    protected void next(){
        music.reset();
        music = new Music(FM.returnNextMusic());
        music.play();
        System.out.println(FM.getCurrentTitle());
        Titre.setText(FM.getCurrentTitle());
    }
    @FXML
    protected void prev(){
        music.reset();
        music = new Music(FM.returnPrevMusic());
        music.play();
        System.out.println(FM.getCurrentTitle());
    }
    @FXML
    protected void random(){
        music.reset();
        music = new Music(FM.returnRandomMusic());
        music.play();
        System.out.println(FM.getCurrentTitle());

    }
    @FXML
    protected void pauseResume(){

        if(music.clip.isRunning())
            music.pause();
        else
            music.resume();
    }
}
