package org.academiadecodigo.frogger.game;

import org.academiadecodigo.frogger.display.Direction;
import org.academiadecodigo.frogger.display.Field;
import org.academiadecodigo.frogger.display.FieldPosition;

/**
 * Created by codecadet on 21/10/16.
 */
public class Player {

    private FieldPosition pos;
    private Direction dir;
    private boolean dead;

    public Player(Field field){
        this.pos = new FieldPosition(7,15,field);
    }

    public boolean isDead() {
        return dead;
    }

    public void setDead() {
        this.dead = true;
    }

    public FieldPosition getPos() {
        return pos;
    }
}
