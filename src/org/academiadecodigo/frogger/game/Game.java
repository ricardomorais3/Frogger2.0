package org.academiadecodigo.frogger.game;

import org.academiadecodigo.frogger.display.Direction;
import org.academiadecodigo.frogger.display.Field;
import org.academiadecodigo.frogger.display.FieldPosition;
import org.academiadecodigo.frogger.gameobjects.*;

/**
 * Created by codecadet on 21/10/16.
 */
public class Game {

    private Field field;
    private Player player;
    private int delay;
    private Moveable[] moveables;
    private Collidable[] collidables;

    public Game(int delay) {
        this.field = new Field(18, 15);
        this.delay = delay;
    }

    public void init() {

        player = new Player(field);
        moveables = GameObjectFactory.getMoveables(field);
        collidables = GameObjectFactory.getCollidables(moveables);

    }

    public void start() throws InterruptedException {


        while (!player.isDead()) {

            field.blackLimitsRedraw(); // Gives color to the vertical borders of the Field.
            Thread.sleep(delay);

            moveAll();
        }

    }

    private void moveAll() {

        for (int i = 0; i < moveables.length; i++) {
            moveables[i].move();
            checkCollisions();
        }
    }

    private void checkCollisions() {
        for (int i = 0; i < collidables.length; i++) {
            if (player.getPos().equals(collidables[i].getPos())) {
                player.setDead();
                return;
            }
        }
    }

}
