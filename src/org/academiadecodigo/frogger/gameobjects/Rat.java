package org.academiadecodigo.frogger.gameobjects;

import org.academiadecodigo.frogger.display.Direction;
import org.academiadecodigo.frogger.display.FieldPosition;

/**
 * Created by codecadet on 21/10/16.
 */
public class Rat extends MoveableGameObject implements Collidable {


    public Rat(FieldPosition pos, Direction dir, int maxMoveCount) {
        super(pos, dir, maxMoveCount);
    }

}
