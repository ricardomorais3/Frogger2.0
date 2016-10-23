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


    //GameObject Matrix where we define the specific position of every game object
    public void fieldMapper(Field field) {

        String[][] objectMap = {

                {"  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  "},
                {"  ", "G ", "G ", "G ", "M ", "G ", "G ", "M ", "G ", "G ", "M ", "G ", "G ", "M ", "G ", "G ", "G ", "  "},
                {"  ", "G ", "G ", "G ", "G ", "PR", "PR", "PR", "G ", "G ", "G ", "G ", "G ", "G ", "PR", "PR", "PR", "  "},
                {"  ", "PL", "PL", "G ", "G ", "G ", "PL", "PL", "G ", "G ", "G ", "PL", "PL", "G ", "G ", "G ", "G ", "  "},
                {"  ", "G ", "G ", "PR", "PR", "PR", "PR", "PR", "G ", "G ", "PR", "PR", "PR", "PR", "PR", "G ", "G ", "  "},
                {"  ", "PR", "PR", "PR", "G ", "G ", "G ", "PR", "PR", "PR", "G ", "G ", "G ", "PR", "PR", "PR", "G ", "  "},
                {"  ", "G ", "G ", "G ", "PL", "PL", "G ", "G ", "PL", "PL", "G ", "G ", "PL", "PL", "G ", "G ", "G ", "  "},
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


    //Creates the arrays for the different types of game objects
    private void createArraysObjects(String[][] objectMap, Field field){

        String[] arrayMoveables = {"RR", "RL", "PR", "PL"};
        String[] arrayCollidables = {"G ", "RR", "RL", "PR", "PL"};
        String[] arrayPuffs = {"PR", "PL"};

        moveables = new Moveable[objectCounter(objectMap,field,arrayMoveables)];
        collidables = new Collidable[objectCounter(objectMap,field,arrayCollidables)];
        puffs = new Puff[objectCounter(objectMap,field,arrayPuffs)];
    }


    //Populates the game objects arrays
    private void fieldPopulator(String[][] objectMap, Field field) {

        createArraysObjects(objectMap,field);

        for (int row = 0; row < field.getRows(); row++) {
            for (int col = 0; col < field.getCols(); col++) {

                switch (objectMap[row][col]) {
                    case "RR":
                        Rat r1 = new Rat(field.makeFieldPosition(col, row, SpriteTypes.DUCK), Direction.RIGHT, 0);
                        addMoveable(r1);
                        addCollidable(r1);
                        break;
                    case "RL":
                        Rat r2 = new Rat(field.makeFieldPosition(col, row, SpriteTypes.RAT), Direction.LEFT, 1);
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
                        Puff p2 = new Puff(field.makeFieldPosition(col, row, SpriteTypes.PUFF), Direction.LEFT,0);
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

    //Counts and returns the number of different objects in the object map for each array type.
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


    //Adds movable objects to the moveables array
    private void addMoveable(Moveable moveable) {
        for (int i = 0; i < moveables.length; i++) {
            if (moveables[i] == null) {
                moveables[i] = moveable;
                return;
            }
        }
    }


    //Adds collidable objects to the collidables array
    private void addCollidable(Collidable collidable) {
        for (int i = 0; i < collidables.length; i++) {
            if (collidables[i] == null) {
                collidables[i] = collidable;
                return;
            }
        }
    }


    //Adds puffs to the puffs array
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
