
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
    private int i;

    public Executing(boolean flag) {
        this.flag = flag;
        crossMoves = new ArrayList<>();
        circleMoves = new ArrayList<>();
        i = 0;
    }

    //true-> crosses

    /**
     * TODO UPDATE: Obrazki się nie zgadzają. do obu tablic kopiuje to samo. Indeksy się zgadzają.
     * TODO DO obu tablic dodaje się to samo i jeden ruch jest opóźnione dodawanie??
     *
     * @param moveNumber METHOD OF SHAME!!
     */
    private void splitMoves(int moveNumber) {
        if (!moveList.isEmpty()) {
            //MovesControl.printMoves();

//SHAME!!
            if (flag) {
                // CROSSES
                switch (moveNumber) {
                    case 1:
                        crossMoves.add(moveList.get(moveNumber - 1));
                        break;
                    case 3:
                        crossMoves.add(moveList.get(moveNumber - 1));
                        break;
                    case 5:
                        crossMoves.add(moveList.get(moveNumber - 1));
                        break;
                    case 7:
                        crossMoves.add(moveList.get(moveNumber - 1));
                        break;
                    case 9:
                        crossMoves.add(moveList.get(moveNumber - 1));
                        break;
                }
                //SHAME!!
                //CIRCLES
                switch (moveNumber) {
                    case 2:
                        circleMoves.add(moveList.get(moveNumber - 1));
                        break;
                    case 4:
                        circleMoves.add(moveList.get(moveNumber - 1));
                        break;
                    case 6:
                        circleMoves.add(moveList.get(moveNumber - 1));
                        break;
                    case 8:
                        circleMoves.add(moveList.get(moveNumber - 1));
                        break;
                }
            } else {     //SHAME!!
                //CIRCLES
                switch (moveNumber) {
                    case 1:
                        circleMoves.add(moveList.get(moveNumber - 1));
                        break;
                    case 3:
                        circleMoves.add(moveList.get(moveNumber - 1));
                        break;
                    case 5:
                        circleMoves.add(moveList.get(moveNumber - 1));
                        break;
                    case 7://SHAME!!
                        circleMoves.add(moveList.get(moveNumber - 1));
                        break;
                    case 9:
                        circleMoves.add(moveList.get(moveNumber - 1));
                        break;
                }
                // CROSSES
                switch (moveNumber) {
                    case 2:
                        crossMoves.add(moveList.get(moveNumber - 1));
                        break;
                    case 4:
                        crossMoves.add(moveList.get(moveNumber - 1));
                        break;
                    case 6://SHAME!!
                        crossMoves.add(moveList.get(moveNumber - 1));
                        break;
                    case 8:
                        crossMoves.add(moveList.get(moveNumber - 1));
                        break;
                }//SHAME!!
            }
        } else {
            Log.e("Moves array is", "empty");
        }


        // Log.i(TAG, "sizes after method: " + String.valueOf(crossMoves.size()) + "  " + String.valueOf(circleMoves.size()));

    }

    private void printMoves(ArrayList<Move> list, String whichPlayer) {
        System.out.println("\n");
        System.out.println(whichPlayer.toUpperCase() + " array: ");
        for (Move m : list) {
            System.out.println(m.getMove());
        }
        System.out.println("\n");
    }
    //  Log.i("I am a thread!!!", "Cool");

    private void setMoveList(ArrayList<Move> moveList) {
        this.moveList = moveList;
    }

    public void check(int moveNumber) {
        setMoveList(MovesControl.getMoveList());
        splitMoves(moveNumber);
        printMoves(crossMoves, "Crosses");
        printMoves(circleMoves, "Circles");
        //Log.i("Move " + String.valueOf(moveNumber), String.valueOf(moveList.get(moveNumber - 1).getMove()));
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
        //Log.i("Sprawdzamy warunek dla ", "krzyży");
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
        //Log.i("Sprawdzamy warunek dla ", "kół");
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