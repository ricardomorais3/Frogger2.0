package org.academiadecodigo.frogger.gameobjects;

import org.academiadecodigo.frogger.display.Direction;
import org.academiadecodigo.frogger.display.Field;
import org.academiadecodigo.frogger.display.SpriteTypes;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by codecadet on 21/10/16.
 */
public class GameObjectFactory {

    public static Moveable[] getMoveables(Field field){

        Moveable[] moveables = new Moveable[13];

        moveables[0] = new Rat(field.makeFieldPosition(17,12,SpriteTypes.RATOS), Direction.LEFT,0);
        moveables[1] = new Rat(field.makeFieldPosition(12,12,SpriteTypes.RATOS), Direction.LEFT,0);
        moveables[2] = new Rat(field.makeFieldPosition(7,12,SpriteTypes.RATOS), Direction.LEFT,0);

        moveables[3] = new Rat(field.makeFieldPosition(1,11,SpriteTypes.RATOS), Direction.RIGHT,1);
        moveables[4] = new Rat(field.makeFieldPosition(7,11,SpriteTypes.RATOS), Direction.RIGHT,1);

        moveables[5] = new Rat(field.makeFieldPosition(15,10,SpriteTypes.RATOS), Direction.LEFT,0);
        moveables[6] = new Rat(field.makeFieldPosition(10,10,SpriteTypes.RATOS), Direction.LEFT,0);
        moveables[7] = new Rat(field.makeFieldPosition(5,10,SpriteTypes.RATOS), Direction.LEFT,0);

        moveables[8] = new Rat(field.makeFieldPosition(3,9,SpriteTypes.RATOS), Direction.RIGHT,1);
        moveables[9] = new Rat(field.makeFieldPosition(9,9,SpriteTypes.RATOS), Direction.RIGHT,1);

        moveables[10] = new Rat(field.makeFieldPosition(13,8,SpriteTypes.RATOS), Direction.LEFT,1);
        moveables[11] = new Rat(field.makeFieldPosition(8,8,SpriteTypes.RATOS), Direction.LEFT,1);
        moveables[12] = new Rat(field.makeFieldPosition(3,8,SpriteTypes.RATOS), Direction.LEFT,1);


        return moveables;

    }

    public static Collidable[] getCollidables(Moveable[] moveables){

        Collidable[] collidables = new Collidable[moveables.length];
        for (int i = 0; i < moveables.length; i++) {
            collidables[i] = (Collidable)moveables[i];
        }
        return collidables;
    }

}
