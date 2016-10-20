package com.jparzonka.crossandcircle.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

import com.jparzonka.crossandcircle.R;
import com.jparzonka.crossandcircle.data.Symbol;
import com.jparzonka.crossandcircle.util.Executing;
import com.jparzonka.crossandcircle.util.MovesControl;

public class GameActivity extends AppCompatActivity {
    private ImageButton button11, button12, button13, button21, button22, button23, button31, button32, button33;
    private Bundle bundle;
    private MovesControl moves;
    private Executing executing;
    int id, moveNumber;
    private boolean choose;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.id = 0;
        this.moveNumber = 1;
        setContentView(R.layout.activity_game);
        bundle = getIntent().getExtras();
        choose = bundle.getBoolean("Choose");
        executing = new Executing(choose);
        Log.i("Flag", String.valueOf(choose));
        moves = new MovesControl();

        initButtons();
    }

    private void initButtons() {
        button11 = (ImageButton) findViewById(R.id.button11);
        button12 = (ImageButton) findViewById(R.id.button12);
        button13 = (ImageButton) findViewById(R.id.button13);
        button21 = (ImageButton) findViewById(R.id.button21);
        button22 = (ImageButton) findViewById(R.id.button22);
        button23 = (ImageButton) findViewById(R.id.button23);
        button31 = (ImageButton) findViewById(R.id.button31);
        button32 = (ImageButton) findViewById(R.id.button32);
        button33 = (ImageButton) findViewById(R.id.button33);
    }

    public void onClickButton11(View view) {
        id = 11;
        mainMethod(id);
    }

    public void onClickButton12(View view) {
        id = 12;
        mainMethod(id);
    }

    public void onClickButton13(View view) {
        id = 13;
        mainMethod(id);
    }

    public void onClickButton21(View view) {
        id = 21;
        mainMethod(id);
    }

    public void onClickButton22(View view) {
        id = 22;
        mainMethod(id);
    }

    public void onClickButton23(View view) {
        id = 23;
        mainMethod(id);
    }

    public void onClickButton31(View view) {
        id = 31;
        mainMethod(id);
    }

    public void onClickButton32(View view) {
        id = 32;
        mainMethod(id);
    }

    public void onClickButton33(View view) {
        id = 33;
        mainMethod(id);
    }

    private void numberControl() {
        moveNumber++;
        if (moveNumber > 9) moveNumber = 1;
    }

    private void mainMethod(int id) {
        changeImageController();
        moves.addMoves(id);
        executing.check(moveNumber);
        numberControl();
    }

    private void changeImageController() {
        if (choose) {
            changeImage(Symbol.CIRCLE, Symbol.CROSS);
        } else {
            changeImage(Symbol.CROSS, Symbol.CIRCLE);
        }
    }

    private void changeImage(int first, int second) {
        switch (id) {
            case 11:
                if ((moveNumber % 2) == 0) {
                    button11.setImageResource(first);
                } else if ((moveNumber % 2) == 1) {
                    button11.setImageResource(second);
                }
                button11.setClickable(false);
                break;
            case 12:
                if ((moveNumber % 2) == 0) {
                    button12.setImageResource(first);
                } else if ((moveNumber % 2) == 1) {
                    button12.setImageResource(second);
                }
                button12.setClickable(false);
                break;
            case 13:
                if ((moveNumber % 2) == 0) {
                    button13.setImageResource(first);
                } else if ((moveNumber % 2) == 1) {
                    button13.setImageResource(second);
                }
                button13.setClickable(false);
                break;
            case 21:
                if ((moveNumber % 2) == 0) {
                    button21.setImageResource(first);
                } else if ((moveNumber % 2) == 1) {
                    button21.setImageResource(second);
                }
                button21.setClickable(false);
                break;
            case 22:
                if ((moveNumber % 2) == 0) {
                    button22.setImageResource(first);
                } else if ((moveNumber % 2) == 1) {
                    button22.setImageResource(second);
                }
                button22.setClickable(false);
                break;
            case 23:
                if ((moveNumber % 2) == 0) {
                    button23.setImageResource(first);
                } else if ((moveNumber % 2) == 1) {
                    button23.setImageResource(second);
                }
                button23.setClickable(false);
                break;
            case 31:
                if ((moveNumber % 2) == 0) {
                    button31.setImageResource(first);
                } else if ((moveNumber % 2) == 1) {
                    button31.setImageResource(second);
                }
                button31.setClickable(false);
                break;
            case 32:
                if ((moveNumber % 2) == 0) {
                    button32.setImageResource(first);
                } else if ((moveNumber % 2) == 1) {
                    button32.setImageResource(second);
                }
                button32.setClickable(false);
                break;
            case 33:
                if ((moveNumber % 2) == 0) {
                    button33.setImageResource(first);
                } else if ((moveNumber % 2) == 1) {
                    button33.setImageResource(second);
                }
                button33.setClickable(false);
                break;
        }
    }

}
