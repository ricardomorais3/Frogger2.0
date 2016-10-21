package org.academiadecodigo.frogger.gameobjects;

import org.academiadecodigo.frogger.display.FieldPosition;


/**
 * Created by codecadet on 17/10/16.
 */
public abstract class GameObject {

    private FieldPosition pos;

    public GameObject(FieldPosition pos){
        this.pos = pos;
    }

    public FieldPosition getPos() {
        return pos;
    }

    @Override
    public String toString() {
        return "GameObject{" +
                "pos=" + pos +
                '}';
    }
}
