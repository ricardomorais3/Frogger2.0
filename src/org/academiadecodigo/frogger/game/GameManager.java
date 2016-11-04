package org.academiadecodigo.frogger.game;

import org.academiadecodigo.frogger.display.Direction;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

/**
 * Created by codecadet on 04/11/16.
 */
public class GameManager implements KeyboardHandler {

    private Game game;
    private boolean keepPlaying;
    private boolean playerWantsNewGame;

    public GameManager() {
        keepPlaying = true;
        playerWantsNewGame = true;
    }

    public void newGame() {

        while(keepPlaying){

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if(playerWantsNewGame){
                playerWantsNewGame = false;

                game = new Game(200);
                game.init();
                try {
                    game.start();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_SPACE:
                playerWantsNewGame = true;
                break;
            case KeyboardEvent.KEY_Q:
                keepPlaying = false;
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

        KeyboardEvent space = new KeyboardEvent();
        space.setKey(KeyboardEvent.KEY_SPACE);
        space.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent quit = new KeyboardEvent();
        quit.setKey(KeyboardEvent.KEY_Q);
        quit.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        k.addEventListener(space);
        k.addEventListener(quit);

    }
}


