package com.elte;

import java.util.Arrays;
import java.util.List;

public class Board {

    boolean[][] board_;
    int nLines_;
    int nColumns_;

    public int getnLines_() {
        return nLines_;
    }

    @Override
    public String toString() {

        StringBuilder board = new StringBuilder();

        for (int line = 0; line < this.nLines_; line++){
            for (int column = 0; column < this.nColumns_; column++){
                if (!this.board_[line][column]){
                    board.append('.');
                }else{
                    board.append('X');
                }
                board.append('\t');
            }
            board.append('\n');
        }
        return  board.toString();
    }

    public int getnColumns_() {
        return nColumns_;
    }

    public Board(int lines, int columns) {
        this.board_ = new boolean[lines][columns];
        this.nLines_ = lines;
        this.nColumns_ = columns;
    }

    public boolean markHitFields(List<Coordinate> coords){
        boolean returnStatus = true;
        for (Coordinate coord: coords) {
            if (!this.markHitField(coord)){
                returnStatus = false;
            }
        }
        return returnStatus;
    }

    public boolean markHitField(Coordinate a){
        if (((int) a.getX() < 0) || ((int) a.getX() >= this.nLines_) ||
                ((int) a.getY() < 0) || ((int) a.getY() >= this.nColumns_) ||
                this.board_[(int) a.getX()][(int) a.getY()]){
            // Invalid hit
            System.out.println("Invalid hit. Unconsidered.");
            return false;
        }

        this.board_[(int) a.getX()][(int) a.getY()] = true;
        return true;
    }
}
