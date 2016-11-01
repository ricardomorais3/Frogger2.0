package org.academiadecodigo.frogger.extras;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by codecadet on 01/11/16.
 */
public class Sound {

    private Clip clip, clipHop;

    public void startMusic() {
        AudioInputStream audioInputStream = null;
        try {
            audioInputStream = AudioSystem.getAudioInputStream(new File("resources/musics/Axel_F_2F_Crazy_Frog_8_Bit.wav"));
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
            clip.loop(clip.LOOP_CONTINUOUSLY);
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void hopSound() {
        AudioInputStream audioInputStream = null;
        try {
            audioInputStream = AudioSystem.getAudioInputStream(new File("resources/musics/qubodup-cfork-ccby3-jump.wav"));
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            clipHop = AudioSystem.getClip();
            clipHop.open(audioInputStream);
            clipHop.start();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void diedSound() {
        AudioInputStream audioInputStream = null;
        try {
            audioInputStream = AudioSystem.getAudioInputStream(new File("resources/musics/Rafa.wav"));
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            Clip clipDuh = AudioSystem.getClip();
            clipDuh.open(audioInputStream);
            clipDuh.start();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void winSound() {
        AudioInputStream audioInputStream = null;
        try {

            audioInputStream = AudioSystem.getAudioInputStream(new File("resources/musics/Voz_161024.wav"));

        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            Clip clipDuh = AudioSystem.getClip();
            clipDuh.open(audioInputStream);
            clipDuh.start();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void stopClip(){
        clip.stop();
    }

}
