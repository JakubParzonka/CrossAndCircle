package com.jparzonka.crossandcircle.util;

import android.util.Log;

import com.jparzonka.crossandcircle.data.Move;

import java.util.ArrayList;

/**
 * Created by Jakub on 2016-10-15.
 */

public class Executing {

    private boolean flag;
    private ArrayList<Move> moveList, crossMoves, circleMoves;

    public Executing(boolean flag/*, ArrayList<Move> moveList*/) {
        this.flag = flag;
        crossMoves = new ArrayList<>(9);
        circleMoves = new ArrayList<>(9);
        //this.moveList = moveList;
    }

    //true-> crosses

    /**
     * TODO 1. Zautomatyzować algorytm rozdzielania tablic
     * TODO 2. Wyrzuca IndexOutOfBoundException, ponieważ przy dodaniu do tablicy ruchu danego gracza,
     * TODO    w splitMoves(), podczas rozdzielania tablic dochodzi do przekroczenia rozmiaru.
     */
    private void splitMoves() {
        if (!moveList.isEmpty()) {
            if (flag) {
                for (int i = 0; i < moveList.size(); i++) {
                    crossMoves.add(i, moveList.get(i * 2));
                    if (circleMoves.size() > 1)
                        circleMoves.add(i, moveList.get((i * 2) + 1));
                }
            } else {
                for (int i = 0; i < moveList.size(); i++) {
                    circleMoves.add(i, moveList.get(i * 2));
                    if (crossMoves.size() > 1)
                        crossMoves.add(i, moveList.get((i * 2) + 1));
                }
            }
        } else {
            Log.e("Moves array is", "empty");
        }
    }

    //  Log.i("I am a thread!!!", "Cool");

    private void setMoveList(ArrayList<Move> moveList) {
        this.moveList = moveList;
    }

    public void check(int moveNumber) {
        setMoveList(MovesControl.getMoveList());
        //   splitMoves();
        Log.i("Move " + String.valueOf(moveNumber), String.valueOf(moveList.get(moveNumber - 1).getMove()));
        if (moveNumber >= 5) {
            boolean cir = getConditionForCircle();
            boolean cro = getConditionForCross();
            if (cir)
                Log.i("Wygrały kółka!", String.valueOf(cir));
            else if (cro)
                Log.i("Wygrały krzyże!", String.valueOf(cro));
        }
    }

    private boolean isCircle(int x) {
        return circleMoves.contains(x);
    }

    private boolean isCross(int x) {
        return crossMoves.contains(x);
    }

    private boolean getConditionForCross() {
        Log.i("Sprawdzamy warunek dla ", "krzyży");
        return (isCross(11) && isCross(21) && isCross(31)) ||
                (isCross(12) && isCross(22) && isCross(32)) ||
                (isCross(13) && isCross(23) && isCross(33)) ||
                (isCross(11) && isCross(12) && isCross(13)) ||
                (isCross(21) && isCross(22) && isCross(23)) ||
                (isCross(31) && isCross(32) && isCross(33)) ||
                (isCross(12) && isCross(22) && isCross(33)) ||
                (isCross(13) && isCross(22) && isCross(31));
    }

    private boolean getConditionForCircle() {
        Log.i("Sprawdzamy warunek dla ", "kół");
        return (isCircle(11) && isCircle(21) && isCircle(31)) ||
                (isCircle(12) && isCircle(22) && isCircle(32)) ||
                (isCircle(13) && isCircle(23) && isCircle(33)) ||
                (isCircle(11) && isCircle(12) && isCircle(13)) ||
                (isCircle(21) && isCircle(22) && isCircle(23)) ||
                (isCircle(31) && isCircle(32) && isCircle(33)) ||
                (isCircle(12) && isCircle(22) && isCircle(33)) ||
                (isCircle(13) && isCircle(22) && isCircle(31));
    }
}