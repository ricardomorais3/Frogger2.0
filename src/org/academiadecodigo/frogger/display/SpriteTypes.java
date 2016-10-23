package org.academiadecodigo.frogger.display;

import org.academiadecodigo.frogger.game.Game;

/**
 * Created by codecadet on 21/10/16.
 */
public enum SpriteTypes {

    FIELD ("/Users/codecadet/JavaProjects/Frogger2.0/src/org/academiadecodigo/frogger/display/res/field.gif","C:\\Users\\gmkba\\Documents\\Frogger2.0\\src\\org\\academiadecodigo\\frogger\\display\\res\\field.gif"),
    PLAYER("/Users/codecadet/JavaProjects/Frogger2.0/src/org/academiadecodigo/frogger/display/res/rafa.png","C:\\Users\\gmkba\\Documents\\Frogger2.0\\src\\org\\academiadecodigo\\frogger\\display\\res\\rafa.png"),
    RAT   ("/Users/codecadet/JavaProjects/Frogger2.0/src/org/academiadecodigo/frogger/display/res/rato.png","C:\\Users\\gmkba\\Documents\\Frogger2.0\\src\\org\\academiadecodigo\\frogger\\display\\res\\rato.png"),
    GRASS ("/Users/codecadet/JavaProjects/Frogger2.0/src/org/academiadecodigo/frogger/display/res/grass.png","C:\\Users\\gmkba\\Documents\\Frogger2.0\\src\\org\\academiadecodigo\\frogger\\display\\res\\grass.png"),
    DUCK  ("/Users/codecadet/JavaProjects/Frogger2.0/src/org/academiadecodigo/frogger/display/res/duck.png",""),
    PUFF  ("/Users/codecadet/JavaProjects/Frogger2.0/src/org/academiadecodigo/frogger/display/res/puff_circular.png",""),
    MAC   ("/Users/codecadet/JavaProjects/Frogger2.0/src/org/academiadecodigo/frogger/display/res/mac.png","");

    private String macPath;
    private String winPath;

    SpriteTypes(String s, String s1) {
        macPath = s;
        winPath = s1;
    }

    public String getPath() {
        if (Game.os == 0) {
            return macPath;
        } else {
            return winPath;
        }
    }
}

