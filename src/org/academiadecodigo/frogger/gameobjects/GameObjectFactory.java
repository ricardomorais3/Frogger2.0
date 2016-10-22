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

    private Moveable[] moveables;
    private Collidable[] collidables;
    private Padawan[] padawans;

    public void fieldMapper(Field field) {

        String[][] objectMap = {

                {"  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  "},
                {"  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  "},
                {"  ", "G ", "G ", "G ", "G ", "G ", "G ", "G ", "P ", "P ", "G ", "G ", "G ", "G ", "G ", "G ", "G ", "  "},
                {"  ", "G ", "G ", "G ", "G ", "G ", "G ", "G ", "P ", "P ", "G ", "G ", "G ", "G ", "G ", "G ", "G ", "  "},
                {"  ", "G ", "G ", "G ", "G ", "G ", "G ", "G ", "P ", "P ", "G ", "G ", "G ", "G ", "G ", "G ", "G ", "  "},
                {"  ", "G ", "G ", "G ", "G ", "G ", "G ", "G ", "P ", "P ", "G ", "G ", "G ", "G ", "G ", "G ", "G ", "  "},
                {"  ", "G ", "G ", "G ", "G ", "G ", "G ", "G ", "P ", "P ", "G ", "G ", "G ", "G ", "G ", "G ", "G ", "  "},
                {"  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  "},
                {"  ", "  ", "RL", "  ", "  ", "  ", "  ", "RL", "  ", "  ", "  ", "  ", "RL", "  ", "  ", "  ", "  ", "  "},
                {"  ", "  ", "  ", "RR", "  ", "  ", "  ", "  ", "  ", "RR", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  "},
                {"  ", "  ", "  ", "  ", "  ", "RL", "  ", "  ", "  ", "  ", "RL", "  ", "  ", "  ", "  ", "RL", "  ", "  "},
                {"  ", "RR", "  ", "  ", "  ", "  ", "  ", "  ", "RR", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  "},
                {"  ", "  ", "  ", "  ", "  ", "  ", "  ", "RL", "  ", "  ", "  ", "  ", "RL", "  ", "  ", "  ", "  ", "RL"},
                {"  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  "},
                {"  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "PL", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  "}};

        fieldPopulator(objectMap, field);

    }

    private void fieldPopulator(String[][] objectMap, Field field) {

        moveables = new Moveable[13/*+10*/];
        collidables = new Collidable[13+80];
        padawans = new Padawan[10];

        for (int row = 0; row < field.getRows(); row++) {
            for (int col = 0; col < field.getCols(); col++) {

                switch (objectMap[row][col]) {
                    case "RR":
                        Rat r1 = new Rat(field.makeFieldPosition(col, row, SpriteTypes.RATOS), Direction.RIGHT, 0);
                        addMoveable(r1);
                        addCollidable(r1);
                        break;
                    case "RL":
                        Rat r2 = new Rat(field.makeFieldPosition(col, row, SpriteTypes.RATOS), Direction.LEFT, 1);
                        addMoveable(r2);
                        addCollidable(r2);
                        break;
                    case "G ":
                        Grass g1 = new Grass(field.makeFieldPosition(col, row, SpriteTypes.PLAYER));
                        addCollidable(g1);
                        break;
                    case "P ":
                        Grass g2 = new Grass(field.makeFieldPosition(col, row, SpriteTypes.PLAYER));
                        addCollidable(g2);
                        Padawan p = new Padawan(field.makeFieldPosition(col, row, SpriteTypes.RATOS), Direction.LEFT);
                        addPadawan(p);
                        //addMoveable(p);
                        break;
                }
            }
        }
    }

    private void addMoveable(Moveable moveable) {
        for (int i = 0; i < moveables.length; i++) {
            if (moveables[i] == null) {
                moveables[i] = moveable;
                return;
            }
        }
    }

    private void addCollidable(Collidable collidable) {
        for (int i = 0; i < collidables.length; i++) {
            if (collidables[i] == null) {
                collidables[i] = collidable;
                return;
            }
        }
    }

    private void addPadawan(Padawan padawan) {
        for (int i = 0; i < padawans.length; i++) {
            if (padawans[i] == null) {
                padawans[i] = padawan;
                return;
            }
        }
    }


    public Moveable[] getMoveables() {
        return moveables;
    }

    public Collidable[] getCollidables() {
        return collidables;
    }

    public Padawan[] getPadawans() {
        return padawans;
    }
}


