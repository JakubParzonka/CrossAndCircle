package com.jparzonka.crossandcircle.data;

import android.widget.ImageButton;

import java.util.HashMap;


/**
 * Created by Jakub on 2016-10-14.
 */

public class Board {
    private HashMap<Integer, ImageButton> board;
    private static final Integer NUMBER_OF_FIELDS = 9;

    public Board() {
        board = new HashMap<>(NUMBER_OF_FIELDS);
    }

    public HashMap<Integer, ImageButton> getBoard() {
        return board;
    }

/*    private void setBoard() {
        board = new HashMap<>();
        String numberOfButton = "";
        for (Integer i = 1; i < NUMBER_OF_FIELDS + 1; i++) {
            numberOfButton = "R.id"
            board.put(i, new);
        }
    }*/
}
