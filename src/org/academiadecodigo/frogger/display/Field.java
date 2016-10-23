package org.academiadecodigo.frogger.display;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Created by codecadet on 18/10/16.
 */
public class Field {

    public static final int PADDING = 10;
    public static final int CELL_SIZE = 32;
    private int cols;
    private int rows;

    private Picture field;
    private Rectangle background;


    public Field(int cols, int rows){
        this.cols = cols;
        this.rows = rows;

        //BLACK BACKGROUND DRAW
        background = new Rectangle(PADDING, PADDING, cols * CELL_SIZE, rows * CELL_SIZE);
        background.setColor(Color.BLACK);
        background.fill();

        //FIELD DRAW
        field = new Picture(PADDING + CELL_SIZE, PADDING, SpriteTypes.FIELD.getPath());
        field.draw();


    }

    public FieldPosition makeFieldPosition(int col, int row, SpriteTypes spriteType){
        return new FieldPosition(col, row, this, spriteType);
    }


    public int getCols() {
        return cols;
    }

    public int getRows() {
        return rows;
    }


    public int columnToX(int column) {
        return column * CELL_SIZE + PADDING;
    }

    public int rowToY(int row) {
        return row * CELL_SIZE + PADDING;
    }


    public void setField(Picture field) {
        this.field = field;
    }

    public void redraw(){
        field.draw();
    }

}
