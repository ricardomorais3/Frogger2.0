package org.academiadecodigo.frogger.display;

import org.academiadecodigo.frogger.game.Game;

/**
 * Created by codecadet on 21/10/16.
 */

//set paths to images
public enum SpriteTypes {

    FIELD ("org/academiadecodigo/frogger/display/res/field.gif"),
    PLAYER("org/academiadecodigo/frogger/display/res/rafa.gif"),
    RAT   ("org/academiadecodigo/frogger/display/res/rato.gif"),
    GRASS ("org/academiadecodigo/frogger/display/res/grass.gif"),
    DUCK  ("org/academiadecodigo/frogger/display/res/duck.gif"),
    PUFF  ("org/academiadecodigo/frogger/display/res/puff_circular.gif"),
    MAC   ("org/academiadecodigo/frogger/display/res/mac.gif");

    private String macPath;

    SpriteTypes(String s) {
        macPath = s;
    }

    public String getPath() {
            return macPath;
    }
}

