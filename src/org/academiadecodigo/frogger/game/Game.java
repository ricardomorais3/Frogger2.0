package org.academiadecodigo.frogger.game;

import org.academiadecodigo.frogger.display.Field;
import org.academiadecodigo.frogger.extras.Sound;
import org.academiadecodigo.frogger.gameobjects.*;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by codecadet on 21/10/16.
 */
public class Game {

    private Field field;
    private Player player;
    private int delay;
    private Moveable[] moveables;
    private Collidable[] collidables;
    private Puff[] puffs;
    private Puff carrierPuff;
    private Sound soundInstance;

    public Game(int delay) {
        this.field = new Field(18, 15);
        this.delay = delay;
        this.soundInstance = new Sound();
    }

    public void init() {

        player = new Player(field);
        GameObjectFactory gameObjectFactory = new GameObjectFactory();
        gameObjectFactory.fieldMapper(field);

        moveables = gameObjectFactory.getMoveables();
        collidables = gameObjectFactory.getCollidables();
        puffs = gameObjectFactory.getPuffs();

    }

    public void start() throws InterruptedException {

        soundInstance.startMusic();


        while (!player.isDead()) {

            if (player.getPos().getRow() == 1) {
                field.setField(new Picture(Field.PADDING + Field.CELL_SIZE, Field.PADDING, "org/academiadecodigo/frogger/display/res/Winner.gif"));
                field.redraw();
                soundInstance.stopClip();
                soundInstance.winSound();
                return;
            }

            Thread.sleep(delay);

            moveAll();
            player.getPos().playerRedraw();
        }

        field.setField(new Picture(Field.PADDING + Field.CELL_SIZE, Field.PADDING, "org/academiadecodigo/frogger/display/res/gameover.gif"));
        field.redraw();
        soundInstance.stopClip();
        soundInstance.diedSound();
    }

    private void moveAll() {

        if (player.receivedKeyboardInput()) {
            player.move();
            soundInstance.hopSound();
            if (playerHasDied()) {
                return;
            }
        }

        moveGameObjects();
        if (playerHasDied()) {
            return;
        }
    }

    private void moveGameObjects() {
        for (Moveable moveable : moveables) {

            if (moveable.equals(carrierPuff)) {

                moveable.move();
                player.move(((Puff) moveable).getDirection(), (1 - carrierPuff.getMoveCounter()));

            } else {
                moveable.move();
            }
        }
    }

    private boolean playerHasDied() {
        if (!playerIsBeingCarried() && playerHasCollided()) {
            player.setDead();
            return true;
        }
        return false;
    }

    private boolean playerHasCollided() {
        for (int i = 0; i < collidables.length; i++) {
            if (player.getPos().equals(collidables[i].getPos())) {
                return true;
            }
        }
        return false;
    }

    private boolean playerIsBeingCarried() {
        for (int i = 0; i < puffs.length; i++) {
            if (player.getPos().equals(puffs[i].getPos())) {
                carrierPuff = puffs[i];
                return true;
            }
        }
        carrierPuff = null;
        return false;
    }

//    private void startMusic() {
//        AudioInputStream audioInputStream = null;
//        try {
//            audioInputStream = AudioSystem.getAudioInputStream(new File("resources/musics/Axel_F_2F_Crazy_Frog_8_Bit.wav"));
//        } catch (UnsupportedAudioFileException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        try {
//            clip = AudioSystem.getClip();
//            clip.open(audioInputStream);
//            clip.start();
//            clip.loop(clip.LOOP_CONTINUOUSLY);
//        } catch (LineUnavailableException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    private void hopSound() {
//        AudioInputStream audioInputStream = null;
//        try {
//            audioInputStream = AudioSystem.getAudioInputStream(new File("resources/musics/qubodup-cfork-ccby3-jump.wav"));
//        } catch (UnsupportedAudioFileException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        try {
//            clipHop = AudioSystem.getClip();
//            clipHop.open(audioInputStream);
//            clipHop.start();
//        } catch (LineUnavailableException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    private void diedSound() {
//        AudioInputStream audioInputStream = null;
//        try {
//            audioInputStream = AudioSystem.getAudioInputStream(new File("resources/musics/Rafa.wav"));
//        } catch (UnsupportedAudioFileException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        try {
//            Clip clipDuh = AudioSystem.getClip();
//            clipDuh.open(audioInputStream);
//            clipDuh.start();
//        } catch (LineUnavailableException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    private void winSound() {
//        AudioInputStream audioInputStream = null;
//        try {
//
//            audioInputStream = AudioSystem.getAudioInputStream(new File("resources/musics/Voz_161024.wav"));
//
//        } catch (UnsupportedAudioFileException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        try {
//            Clip clipDuh = AudioSystem.getClip();
//            clipDuh.open(audioInputStream);
//            clipDuh.start();
//        } catch (LineUnavailableException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
}
