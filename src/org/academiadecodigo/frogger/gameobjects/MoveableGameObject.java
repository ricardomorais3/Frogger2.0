package org.academiadecodigo.frogger.gameobjects;

import org.academiadecodigo.frogger.display.Direction;
import org.academiadecodigo.frogger.display.FieldPosition;

/**
 * Created by codecadet on 21/10/16.
 */
public abstract class MoveableGameObject extends GameObject implements Moveable {

    private Direction direction;

    public MoveableGameObject(FieldPosition pos, Direction dir){
        super(pos);
        this.direction = dir;

    }

    public Direction getDirection() {
        return direction;
    }

    @Override
    public void move() {

        getPos().moveInDirection(getDirection(), 1);

    }
}
