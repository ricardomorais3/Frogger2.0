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
    private Rectangle fieldLimit1;
    private Rectangle fieldLimit2;

    //picture array (one per object)

    public Field(int cols, int rows){
        this.cols = cols;
        this.rows = rows;

        //VISUAL PART
        field = new Picture(PADDING + CELL_SIZE, PADDING, "/Users/codecadet/Project/Frogger2.0/src/org/academiadecodigo/frogger/display/res/field.gif");
        field.draw();

        //preload function

    }

    public FieldPosition makeFieldPosition(int col, int row, SpriteTypes spriteType){
        return new FieldPosition(col, row, this, spriteType);
    }

    //preload all pictures in X = PADDING Y = PADDING

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

    public void blackLimitsRedraw(){
        fieldLimit1 = new Rectangle(PADDING, PADDING, CELL_SIZE, rows * CELL_SIZE);
        fieldLimit1.setColor(Color.BLACK);
        fieldLimit1.fill();
        fieldLimit2 = new Rectangle(columnToX(17),PADDING,CELL_SIZE,CELL_SIZE* rows);
        fieldLimit2.setColor(Color.BLACK);
        fieldLimit2.fill();
    }

    public void setField(Picture field) {
        this.field = field;
    }

    public void redraw(){
        field.draw();
    }
}
