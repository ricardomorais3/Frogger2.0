package org.academiadecodigo.frogger.game;

import org.academiadecodigo.frogger.display.Field;
import org.academiadecodigo.frogger.gameobjects.GameObjectFactory;

/**
 * Created by codecadet on 21/10/16.
 */
public class Main {

    public static void main(String[] args) {

        GameManager gameManager = new GameManager();
        gameManager.keyboardInit();
        gameManager.newGame();

    }
}
