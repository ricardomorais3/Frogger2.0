package org.academiadecodigo.frogger.game;

/**
 * Created by codecadet on 21/10/16.
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {

        Game g1 = new Game(200);
        g1.init(1); // 0 = mac, 1 = windows
        g1.start();

    }

}
