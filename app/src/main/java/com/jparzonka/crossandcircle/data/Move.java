package com.jparzonka.crossandcircle.data;

/**
 * Created by Jakub on 2016-10-14.
 */
//TODO DODAĆ WARTOŚCI RUCHÓW JAKO ENUM
public class Move {
    private int move;

    public Move(int move) {
        setMove(move);
    }

    
    public int getMove() {
        return move;
    }

    private void setMove(int move) {
        this.move = move;
    }
}
