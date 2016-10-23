package org.academiadecodigo.frogger.game;

import org.academiadecodigo.frogger.display.Field;
import org.academiadecodigo.frogger.gameobjects.*;

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
    private Padawan[] padawans;
    private Padawan carrierPadawan;

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
        padawans = gameObjectFactory.getPadawans();

    }

    public void start() throws InterruptedException {


        while (!player.isDead()) {

            //if (player.getPos().getRow() == 0){
            //    field = new Picture(PADDING + CELL_SIZE, PADDING, "/Users/codecadet/Project/Frogger2.0/src/org/academiadecodigo/frogger/display/res/field.gif");
            //}

            field.blackLimitsRedraw(); // Gives color to the vertical borders of the Field.
            Thread.sleep(delay);

            moveAll();
        }

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

            if (moveable.equals(carrierPadawan)) {

                moveable.move();
                player.move(((Padawan) moveable).getDirection(), (1 - carrierPadawan.getMoveCounter()));

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
        for (int i = 0; i < padawans.length; i++) {
            if (player.getPos().equals(padawans[i].getPos())) {
                carrierPadawan = padawans[i];
                return true;
            }
        }
        carrierPadawan = null;
        return false;
    }

}
