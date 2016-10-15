package com.jparzonka.crossandcircle.util;

import android.util.Log;

import com.jparzonka.crossandcircle.data.Move;

import java.util.ArrayList;

/**
 * Created by Jakub on 2016-10-15.
 */

public class MovesControl {
    private ArrayList<Move> moveList;
    private final Integer MAX_MOVES = 9;
    private int moveIndex = 0;

    public MovesControl() {
        moveList = new ArrayList<>(MAX_MOVES);
    }

    public ArrayList<Move> getMoveList() {
        return moveList;
    }

    public void addMoves(int move) {
        moveList.add(moveIndex, new Move(move));
        moveIndex++;
        if (moveIndex >= MAX_MOVES + 1) moveIndex = 0;
        Log.i("Move number ", String.valueOf(move));
        Log.i("Move index number: ", String.valueOf(moveIndex));
    }


}
