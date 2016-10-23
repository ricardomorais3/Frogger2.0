package org.academiadecodigo.frogger.gameobjects;

import org.academiadecodigo.frogger.display.Direction;
import org.academiadecodigo.frogger.display.FieldPosition;

/**
 * Created by codecadet on 21/10/16.
 */
public abstract class MoveableGameObject extends GameObject implements Moveable {

    private Direction direction;
    private int waitCounter;
    private int maxMoveCount;
    private int moveCounter;

    public MoveableGameObject(FieldPosition pos, Direction dir, int maxMoveCount){
        super(pos);
        this.direction = dir;
        this.maxMoveCount = maxMoveCount;

    }

    public int getMoveCounter() {
        return moveCounter;
    }

    public Direction getDirection() {
        return direction;
    }

    @Override
    public void move() {

        if (moveCounter < maxMoveCount) {
            moveCounter++;
        } else {
            moveCounter = 0;
            if (getPos().isNearRightBoundaryAndGoingRight(getDirection())) {
                if (waitCounter == 2) {
                    getPos().setPos(0, getPos().getRow());
                    waitCounter = 0;
                } else {
                    waitCounter++;
                }

            } else if (getPos().isNearLeftBoundaryAndGoingLeft(getDirection())) {
                if (waitCounter == 2) {
                    getPos().setPos(getPos().getFieldCols() - 1, getPos().getRow());
                    waitCounter = 0;
                } else {
                    waitCounter++;
                }
            } else {
                getPos().moveInDirection(getDirection(), 1);
            }
        }
    }

    public int getMaxMoveCount() {
        return maxMoveCount;
    }

    @Override
    public FieldPosition getPos() {
        return super.getPos();
    }
}
