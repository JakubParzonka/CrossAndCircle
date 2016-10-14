package com.jparzonka.crossandcircle.data;

import android.util.Log;

import java.util.ArrayList;

/**
 * Created by Jakub on 2016-10-14.
 */

public class Moves {
    private ArrayList<Integer> moveList;
    private final Integer MAX_MOVES = 9;
    private int moveIndex = 0;

    public Moves() {
        moveList = new ArrayList<>(MAX_MOVES);
    }

    public ArrayList<Integer> getMoveList() {
        return moveList;
    }

    public void addMoves(int move) {
        moveList.add(moveIndex, move);
        Log.i("Move number ", String.valueOf(move));
        moveIndex++;
    }

    public void setMoveList(ArrayList<Integer> moveList) {
        this.moveList = moveList;
    }
}
