package org.academiadecodigo.frogger.gameobjects;

import org.academiadecodigo.frogger.display.Direction;
import org.academiadecodigo.frogger.display.Field;
import org.academiadecodigo.frogger.display.SpriteTypes;

/**
 * Created by codecadet on 21/10/16.
 */
public class GameObjectFactory {


    public static Moveable[] getGameObject(Field field){

        Moveable[] moveables = new Moveable[2];

        moveables[0] = new Rat(field.makeFieldPosition(16,12, SpriteTypes.RATOS), Direction.LEFT);
        moveables[1] = new Rat(field.makeFieldPosition(11,12, SpriteTypes.RATOS), Direction.LEFT);

        return moveables;

    }


}
