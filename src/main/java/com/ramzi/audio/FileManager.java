package com.ramzi.audio;

import java.io.File;
import java.util.Random;

public class FileManager {
    public File path;
    public String contents[];

    public int CurrentMusic;
    FileManager(File path){
        this.path = path;
        contents = this.path.list();
    }
    public String getCurrentTitle() {
        String toSplit;
        toSplit = contents[CurrentMusic].substring(0, contents[CurrentMusic].length() - 4);
        return toSplit;

    }

    public void printFiles(){
        for (String content : contents) {
            System.out.println(content);
        }
    }
    public String returnCurrentMusic(){
        if (contents != null && contents.length > 0) {
            return "Musics\\" + contents[CurrentMusic];
        } else {
            return "No music available.";
        }
    }
    public String returnNextMusic(){
        if (contents != null && contents.length > 0) {
            CurrentMusic = (CurrentMusic + 1) % contents.length;
            return "Musics\\" + contents[CurrentMusic];
        } else {
            return "No music available.";
        }
    }

    public String returnPrevMusic(){
        if (contents != null && contents.length > 0) {
            CurrentMusic = (CurrentMusic - 1 + contents.length) % contents.length;
            return "Musics\\" + contents[CurrentMusic];
        } else {
            return "No music available.";
        }
    }
    public String returnRandomMusic(){
        int rnd = new Random().nextInt(contents.length);
        return "Musics\\" + contents[rnd];
    }

}
