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


    /**
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

    private void setMoveList(ArrayList<Move> moveList) {
        this.moveList = moveList;
    }

    public void check(int moveNumber) {
        setMoveList(MovesControl.getMoveList());
        splitMoves(moveNumber);
        //printMoves(crossMoves, "Crosses");
        //printMoves(circleMoves, "Circles");
        if (moveNumber >= 5) {
            boolean cir = getConditionForCircle();
            Log.i("CIR ", String.valueOf(cir));
            boolean cro = getConditionForCross();
            Log.i("CRO ", String.valueOf(cro));
            if (cir)
                Log.i("Wygrały kółka!", String.valueOf(cir));
            else if (cro)
                Log.i("Wygrały krzyże!", String.valueOf(cro));
        }
    }

    private boolean isCircle(int x) {
        boolean b = false;
        for (int i = 0; i < circleMoves.size(); i++) {
            if (x == circleMoves.get(i).getMove()) b = true;
        }
        System.out.println("isCircle boolean: " + String.valueOf(b) + " of x: " + x);

        return b;

    }

    private boolean isCross(int x) {
        boolean a = false;
        for (int i = 0; i < crossMoves.size(); i++) {
            if (x == crossMoves.get(i).getMove()) a = true;
        }
        System.out.println("isCross boolean: " + String.valueOf(a) + " of x: " + x);
        return a;
    }


    private boolean getConditionForCross() {
        System.out.println("******************************");
        Log.i("Sprawdzamy warunek dla ", " krzyży");
        boolean cross[] = new boolean[8];
        cross[0] = isCross(11) && isCross(21) && isCross(31);
        cross[1] = isCross(12) && isCross(22) && isCross(32);

        cross[2] = isCross(13) && isCross(23) && isCross(33);
        cross[3] = isCross(11) && isCross(12) && isCross(13);

        cross[4] = isCross(21) && isCross(22) && isCross(23);
        cross[5] = isCross(31) && isCross(32) && isCross(33);

        cross[6] = isCross(12) && isCross(22) && isCross(33);
        cross[7] = isCross(13) && isCross(22) && isCross(31);

        return (cross[0] || cross[1] || cross[2] || cross[3] || cross[4] || cross[5] || cross[6] || cross[7]);
    }

    private boolean getConditionForCircle() {
        System.out.println("******************************");
        Log.i("Sprawdzamy warunek dla ", " kół");
        boolean circle[] = new boolean[8];
        circle[0] = isCircle(11) && isCircle(21) && isCircle(31);
        circle[1] = isCircle(12) && isCircle(22) && isCircle(32);

        circle[2] = isCircle(13) && isCircle(23) && isCircle(33);
        circle[3] = isCircle(11) && isCircle(12) && isCircle(13);

        circle[4] = isCircle(21) && isCircle(22) && isCircle(23);
        circle[5] = isCircle(31) && isCircle(32) && isCircle(33);

        circle[6] = isCircle(12) && isCircle(22) && isCircle(33);
        circle[7] = isCircle(13) && isCircle(22) && isCircle(31);

        return (circle[0] || circle[1] || circle[2] || circle[3] || circle[4] || circle[5] || circle[6] || circle[7]);
    }
}