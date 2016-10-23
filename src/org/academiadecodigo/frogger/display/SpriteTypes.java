package org.academiadecodigo.frogger.display;

import org.academiadecodigo.frogger.game.Game;

/**
 * Created by codecadet on 21/10/16.
 */

//set paths to images
public enum SpriteTypes {
    FIELD ("/Users/codecadet/Project/Frogger2.0/src/org/academiadecodigo/frogger/display/res/field.gif","C:\\Users\\gmkba\\Documents\\Frogger2.0\\src\\org\\academiadecodigo\\frogger\\display\\res\\field.gif"),
    PLAYER("/Users/codecadet/Project/Frogger2.0/src/org/academiadecodigo/frogger/display/res/rafa.gif","C:\\Users\\gmkba\\Documents\\Frogger2.0\\src\\org\\academiadecodigo\\frogger\\display\\res\\rafa.gif"),
    RAT("/Users/codecadet/Project/Frogger2.0/src/org/academiadecodigo/frogger/display/res/rato.gif","C:\\Users\\gmkba\\Documents\\Frogger2.0\\src\\org\\academiadecodigo\\frogger\\display\\res\\rato.gif"),
    GRASS ("/Users/codecadet/Project/Frogger2.0/src/org/academiadecodigo/frogger/display/res/grass.gif","C:\\Users\\gmkba\\Documents\\Frogger2.0\\src\\org\\academiadecodigo\\frogger\\display\\res\\grass.gif"),
    DUCK("/Users/codecadet/Project/Frogger2.0/src/org/academiadecodigo/frogger/display/res/duck.gif",""),
    PUFF  ("/Users/codecadet/Project/Frogger2.0/src/org/academiadecodigo/frogger/display/res/puff_circular.gif",""),
    MAC   ("/Users/codecadet/Project/Frogger2.0/src/org/academiadecodigo/frogger/display/res/mac.gif","");

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

