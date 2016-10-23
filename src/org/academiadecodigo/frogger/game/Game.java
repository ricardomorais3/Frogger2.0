package org.academiadecodigo.frogger.game;

import org.academiadecodigo.frogger.display.Field;
import org.academiadecodigo.frogger.gameobjects.*;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by codecadet on 21/10/16.
 */
public class Game {

    public static int os;

    private Field field;
    private Player player;
    private int delay;
    private Moveable[] moveables;
    private Collidable[] collidables;
    private Puff[] puffs;
    private Puff carrierPuff;
    private Clip clip;

    public Game(int delay) {
        this.field = new Field(18, 15);
        this.delay = delay;
    }

    public void init(int os) {

        this.os = os;


        player = new Player(field);
        GameObjectFactory gameObjectFactory = new GameObjectFactory();
        gameObjectFactory.fieldMapper(field);

        moveables = gameObjectFactory.getMoveables();
        collidables = gameObjectFactory.getCollidables();
        puffs = gameObjectFactory.getPuffs();

    }

    public void start() throws InterruptedException {

        startMusic();


        while (!player.isDead()) {

            if (player.getPos().getRow() == 1){
                /* WIN pic field.setField(new Picture( Field.PADDING + Field.CELL_SIZE,Field.PADDING ,Put the image here "));
                field.redraw();*/
                break;
            }

            field.blackLimitsRedraw(); // Gives color to the vertical borders of the Field.
            Thread.sleep(delay);

            moveAll();
        }
        /* LOSE PIC field.setField(new Picture( Field.PADDING + Field.CELL_SIZE,Field.PADDING ,Put the image here "));
                field.redraw();
                break;*/
     clip.stop();
    }

    private void moveAll() {

        if (player.receivedKeyboardInput()) {
            player.move();
            if(playerHasDied()){
                return;
            }
        }

        moveGameObjects();
        if(playerHasDied()){
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

    private void startMusic() {
        AudioInputStream audioInputStream = null;
        try {
            audioInputStream = AudioSystem.getAudioInputStream(new File("/Users/codecadet/Project/Frogger2.0/resources/musics/Axel_F_2F_Crazy_Frog_8_Bit.wav"));
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

}
