package org.academiadecodigo.frogger.gameobjects;

import org.academiadecodigo.frogger.display.Direction;
import org.academiadecodigo.frogger.display.FieldPosition;

/**
 * Created by codecadet on 21/10/16.
 */
public class Rat extends MoveableGameObject implements Collidable {

    private int waitCounter;
    private int maxMoveCount;
    private int moveCounter;

    public Rat(FieldPosition pos, Direction dir, int maxCount) {
        super(pos, dir);
        this.maxMoveCount = maxCount;
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
                super.move();
            }
        }


    }


    //ver se o rat precisa do seu proprio getPosition
}
