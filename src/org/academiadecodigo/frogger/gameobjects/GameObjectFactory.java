package org.academiadecodigo.frogger.gameobjects;

import org.academiadecodigo.frogger.display.Direction;
import org.academiadecodigo.frogger.display.Field;
import org.academiadecodigo.frogger.display.SpriteTypes;

/**
 * Created by codecadet on 21/10/16.
 */
public class GameObjectFactory {

    private Moveable[] moveables;
    private Collidable[] collidables;
    private Puff[] puffs;

    public void fieldMapper(Field field) {

        String[][] objectMap = {

                {"  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  "},
                {"  ", "G ", "G ", "G ", "M ", "G ", "G ", "M ", "G ", "G ", "M ", "G ", "G ", "M ", "G ", "G ", "G ", "  "},
                {"  ", "G ", "G ", "PR", "PR", "PR", "PR", "PR", "PR", "PR", "G ", "G ", "G ", "G ", "G ", "G ", "G ", "  "},
                {"  ", "G ", "G ", "PR", "PR", "PR", "PR", "PR", "PR", "PR", "G ", "G ", "G ", "G ", "G ", "G ", "G ", "  "},
                {"  ", "G ", "G ", "PL", "PL", "PL", "PL", "PL", "PL", "PL", "G ", "G ", "G ", "G ", "G ", "G ", "G ", "  "},
                {"  ", "G ", "G ", "PL", "PL", "PL", "PL", "PL", "PL", "PL", "G ", "G ", "G ", "G ", "G ", "G ", "G ", "  "},
                {"  ", "G ", "G ", "PR", "PR", "PR", "PR", "PR", "PR", "PR", "G ", "G ", "G ", "G ", "G ", "G ", "G ", "  "},
                {"  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  "},
                {"  ", "  ", "RL", "  ", "  ", "  ", "  ", "RL", "  ", "  ", "  ", "  ", "RL", "  ", "  ", "  ", "  ", "  "},
                {"  ", "  ", "  ", "RR", "  ", "  ", "  ", "  ", "  ", "RR", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  "},
                {"  ", "  ", "  ", "  ", "  ", "RL", "  ", "  ", "  ", "  ", "RL", "  ", "  ", "  ", "  ", "RL", "  ", "  "},
                {"  ", "RR", "  ", "  ", "  ", "  ", "  ", "  ", "RR", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  "},
                {"  ", "  ", "  ", "  ", "  ", "  ", "  ", "RL", "  ", "  ", "  ", "  ", "RL", "  ", "  ", "  ", "  ", "RL"},
                {"  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  "},
                {"  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "PA", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  "}};

        fieldPopulator(objectMap, field);

    }

    private void createArraysObjects(String[][] objectMap, Field field){

        String[] arrayMoveables = {"RR", "RL", "PR", "PL"};
        String[] arrayCollidables = {"G ", "RR", "RL", "PR", "PL"};
        String[] arrayPoofs = {"PR", "PL"};

        moveables = new Moveable[objectCounter(objectMap,field,arrayMoveables)];
        collidables = new Collidable[objectCounter(objectMap,field,arrayCollidables)];
        puffs = new Puff[objectCounter(objectMap,field,arrayPoofs)];
    }

    private void fieldPopulator(String[][] objectMap, Field field) {

        createArraysObjects(objectMap,field);

        for (int row = 0; row < field.getRows(); row++) {
            for (int col = 0; col < field.getCols(); col++) {

                switch (objectMap[row][col]) {
                    case "RR":
                        Rat r1 = new Rat(field.makeFieldPosition(col, row, SpriteTypes.PATOS), Direction.RIGHT, 0);
                        addMoveable(r1);
                        addCollidable(r1);
                        break;
                    case "RL":
                        Rat r2 = new Rat(field.makeFieldPosition(col, row, SpriteTypes.RATOS), Direction.LEFT, 1);
                        addMoveable(r2);
                        addCollidable(r2);
                        break;
                    case "G ":
                        Grass g1 = new Grass(field.makeFieldPosition(col, row, SpriteTypes.GRASS));
                        addCollidable(g1);
                        break;
                    case "PR":
                        Grass g2 = new Grass(field.makeFieldPosition(col, row, SpriteTypes.GRASS));
                        addCollidable(g2);
                        Puff p1 = new Puff(field.makeFieldPosition(col, row, SpriteTypes.PUFF), Direction.RIGHT,1);
                        addPuff(p1);
                        addMoveable(p1);
                        break;
                    case "PL":
                        Grass g3 = new Grass(field.makeFieldPosition(col, row, SpriteTypes.GRASS));
                        addCollidable(g3);
                        Puff p2 = new Puff(field.makeFieldPosition(col, row, SpriteTypes.PUFF), Direction.LEFT,1);
                        addPuff(p2);
                        addMoveable(p2);
                        break;
                    case "M ":
                        Mac mac = new Mac(field.makeFieldPosition(col,row, SpriteTypes.MAC));
                        break;
                }
            }
        }
    }

    private int objectCounter(String[][] objectMap, Field field, String[] str) {
        int counter = 0;
        for (int row = 0; row < field.getRows(); row++) {
            for (int col = 0; col < field.getCols(); col++) {
                for (int i = 0; i < str.length; i++) {
                    if(objectMap[row][col].equals(str[i])){
                        counter++;
                    }
                }
            }
        }
        return counter;
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

    private void addPuff(Puff puff) {
        for (int i = 0; i < puffs.length; i++) {
            if (puffs[i] == null) {
                puffs[i] = puff;
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

    public Puff[] getPuffs() {
        return puffs;
    }
}
