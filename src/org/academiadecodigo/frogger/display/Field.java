package org.academiadecodigo.frogger.display;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

/**
 * Created by codecadet on 18/10/16.
 */
public class Field {

    public static final int PADDING = 10;
    public static final int CELL_SIZE = 32;
    private int cols;
    private int rows;

    private Rectangle field;
    private Rectangle fieldLimit1;
    private Rectangle fieldLimit2;

    public Field(int cols, int rows){
        this.cols = cols;
        this.rows = rows;

        //VISUAL PART
        field = new Rectangle(PADDING, PADDING, cols * CELL_SIZE, rows * CELL_SIZE);
        field.setColor(Color.DARK_GRAY);
        field.fill();

    }

    public FieldPosition makeFieldPosition(int col, int row /*, SpriteTypes sprite */){
        return new FieldPosition(col, row, this /*, sprite */);
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

    public void blackLimitsRedraw(){
        fieldLimit1 = new Rectangle(PADDING, PADDING, CELL_SIZE, rows * CELL_SIZE);
        fieldLimit1.setColor(Color.YELLOW);
        fieldLimit1.draw();
        fieldLimit2 = new Rectangle(columnToX(17),PADDING,CELL_SIZE,CELL_SIZE* rows);
        fieldLimit2.setColor(Color.YELLOW);
        fieldLimit2.draw();
    }



}
