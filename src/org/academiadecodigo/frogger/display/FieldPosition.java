package org.academiadecodigo.frogger.display;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Created by codecadet on 18/10/16.
 */
public class FieldPosition {

    private int col;
    private int row;
    private Field field;
    private SpriteTypes spriteType;
    private Picture sprite;

    private boolean outofLimits;

    public FieldPosition(int col, int row, Field field , SpriteTypes spriteType ){
        this.col = col;
        this.row = row;
        this.field = field;
        this.spriteType = spriteType;
        if(!(spriteType == SpriteTypes.GRASS)){
            sprite = new Picture(field.columnToX(col), field.rowToY(row), spriteType.getPath());
            sprite.draw();
        }

    }

    public int getFieldCols(){
        return field.getCols();
    }

    public int getFieldRows(){
        return field.getRows();
    }

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }

    public void setPos(int col, int row){
        int oldCol = this.col;
        int oldRow = this.row;
        this.col = col;
        this.row = row;

        int differentialCol = this.col - oldCol;
        int differentialRow = this.row - oldRow;
        sprite.translate(differentialCol * field.CELL_SIZE, differentialRow * field.CELL_SIZE);

        if(!(spriteType == SpriteTypes.GRASS)){
            if(col == 0 || col == field.getCols() - 1 ){
                sprite.delete();
                outofLimits = true;
            }
            else if(outofLimits){
                sprite = new Picture(field.columnToX(col), field.rowToY(row), spriteType.getPath());
                sprite.draw();
                outofLimits = false;
            }
        }
    }

    public void playerRedraw(){
        sprite.draw();
    }

    public void moveInDirection(Direction direction, int dist){
        switch (direction) {

            case UP:
                moveUp(dist);
                break;
            case DOWN:
                moveDown(dist);
                break;
            case LEFT:
                moveLeft(dist);
                break;
            case RIGHT:
                moveRight(dist);
                break;
        }
    }

    public void moveUp(int dist) {

        int maxRowsUp = dist < getRow() ? dist : getRow();
        setPos(getCol(), getRow() - maxRowsUp);

    }

    public void moveDown(int dist) {

        int maxRowsDown = dist > field.getRows() - (getRow() + 1) ? field.getRows() - (getRow() + 1) : dist;
        setPos(getCol(), getRow() + maxRowsDown);

    }

    public void moveLeft(int dist) {

        int maxRowsLeft = dist < getCol() ? dist : getCol();
        setPos(getCol() - maxRowsLeft, getRow());

    }

    public void moveRight(int dist) {
        int maxRowsRight = dist > field.getCols() - (getCol() + 1) ? field.getCols() - (getCol() + 1) : dist;
        setPos(getCol() + maxRowsRight, getRow());
    }

    public boolean isNearLeftBoundaryAndGoingLeft(Direction direction){
        if(col == 0 && direction == Direction.LEFT){
            return true;
        }
        return false;
    }

    public boolean isNearRightBoundaryAndGoingRight(Direction direction){
        if(col == field.getCols() - 1 && direction == Direction.RIGHT){
            return true;
        }
        return false;
    }

    public boolean equals(FieldPosition pos) {
        return this.col == pos.getCol() && this.row == pos.getRow() ? true : false;
    }


    @Override
    public String toString() {
        return "FieldPosition{" +
                "col=" + col +
                ", row=" + row +
                '}';
    }

}
