package org.academiadecodigo.frogger.game;

import org.academiadecodigo.frogger.display.Direction;
import org.academiadecodigo.frogger.display.Field;
import org.academiadecodigo.frogger.display.FieldPosition;
import org.academiadecodigo.frogger.gameobjects.Collidable;
import org.academiadecodigo.frogger.gameobjects.Moveable;
import org.academiadecodigo.frogger.gameobjects.MoveableGameObject;
import org.academiadecodigo.frogger.gameobjects.Rat;

/**
 * Created by codecadet on 21/10/16.
 */
public class Game {

    private Field field;
    private Player player;
    private int delay;
    private Moveable[] moveables;
    private Collidable[] collidables;

    public Game() {
        this.field = new Field(18, 15);
    }

    public void init() {

        player = new Player(field);
        moveables = new Moveable[0];
        collidables = new Collidable[0];
    }

    public void start() throws InterruptedException {


        while (!player.isDead()) { //adicionar condicao de vitoria (player.getPos().getRow() == 0)

            field.blackLimitsRedraw(); // no final de cada turno esta linha tem que correr
            Thread.sleep(400);

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
