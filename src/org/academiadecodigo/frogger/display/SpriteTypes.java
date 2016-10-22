package org.academiadecodigo.frogger.display;

import org.academiadecodigo.frogger.game.Game;

/**
 * Created by codecadet on 21/10/16.
 */
public enum SpriteTypes {
    PLAYER("/Users/codecadet/JavaProjects/Frogger2.0/src/org/academiadecodigo/frogger/display/res/rafa.png", "C:\\Users\\gmkba\\Documents\\Frogger2.0\\src\\org\\academiadecodigo\\frogger\\display\\res\\rafa.png"),
    RATOS ("","C:\\Users\\gmkba\\Documents\\Frogger2.0\\src\\org\\academiadecodigo\\frogger\\display\\res\\rato.png"),
    PADAWAN_SERGIO ("",""),
    PADAWAN_JORGE ("",""),
    PADAWAN_ANTONINHO ("","");

    private String macPath;
    private String winPath;

    SpriteTypes(String s, String s1) {
        macPath = s;
        winPath = s1;
    }

    public String getPath() {
        if(Game.os == 0){
            return macPath;
        }
        else {
            return winPath;
        }
    }
}
