package org.academiadecodigo.frogger.game;

import org.academiadecodigo.frogger.display.Direction;
import org.academiadecodigo.frogger.display.Field;
import org.academiadecodigo.frogger.display.FieldPosition;
import org.academiadecodigo.frogger.display.SpriteTypes;
import org.academiadecodigo.frogger.gameobjects.Moveable;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

/**
 * Created by codecadet on 21/10/16.
 */
public class Player implements Moveable, KeyboardHandler {


    private FieldPosition pos;
    private Direction dir;
    private boolean dead;
    private boolean willMove;

    public Player(Field field) {
        keyboardInit();
        this.pos = new FieldPosition(9, 14, field, SpriteTypes.PLAYER);
    }

    public boolean isDead() {
        return dead;
    }

    public void setDead() {
        this.dead = true;
    }

    public FieldPosition getPos() {
        return pos;
    }

    public void setPos(FieldPosition pos) {
        this.pos = pos;
    }

    public boolean getWillMove() {
        return willMove;
    }

    public void move() {
        willMove = false;
        if (pos.getCol() == 1 && dir == Direction.LEFT ||
                pos.getCol() == pos.getFieldCols()-2 && dir == Direction.RIGHT) {
            return;
        }
        pos.moveInDirection(dir, 1);
    }

    public void keyPressed(KeyboardEvent keyboardEvent) {

        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_UP:
                dir = Direction.UP;
                willMove = true;
                break;
            case KeyboardEvent.KEY_DOWN:
                dir = Direction.DOWN;
                willMove = true;
                break;
            case KeyboardEvent.KEY_RIGHT:
                dir = Direction.RIGHT;
                willMove = true;
                break;
            case KeyboardEvent.KEY_LEFT:
                dir = Direction.LEFT;
                willMove = true;
                break;
            default:
                System.out.println("Something went terribly wrong");
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }


    public void keyboardInit() {

        Keyboard k = new Keyboard(this);

        KeyboardEvent goUp = new KeyboardEvent();
        KeyboardEvent goDown = new KeyboardEvent();
        KeyboardEvent goRight = new KeyboardEvent();
        KeyboardEvent goLeft = new KeyboardEvent();


        goUp.setKey(KeyboardEvent.KEY_UP);
        goUp.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        goDown.setKey(KeyboardEvent.KEY_DOWN);
        goDown.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        goRight.setKey(KeyboardEvent.KEY_RIGHT);
        goRight.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        goLeft.setKey(KeyboardEvent.KEY_LEFT);
        goLeft.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        k.addEventListener(goUp);
        k.addEventListener(goDown);
        k.addEventListener(goRight);
        k.addEventListener(goLeft);

    }
}



