package com.jparzonka.crossandcircle.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

import com.jparzonka.crossandcircle.R;
import com.jparzonka.crossandcircle.data.Moves;

public class GameActivity extends AppCompatActivity {
    private ImageButton button11, button12, button13, button21, button22, button23, button31, button32, button33;
    private Bundle bundle;
    private Moves moves;
    int id = 0, i = 0, circle = 0, cross = 0;
    private boolean choose;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        bundle = getIntent().getExtras();
        choose = bundle.getBoolean("Choose");
        circle = R.drawable.kolko;
        cross = R.drawable.krzyzyk;
        moves = new Moves();
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
        moves.addMoves(id);
    }

    public void onClickButton12(View view) {
        id = 12;
        moves.addMoves(id);
    }

    public void onClickButton13(View view) {
        id = 13;
        moves.addMoves(id);
    }

    public void onClickButton21(View view) {
        id = 21;
        moves.addMoves(id);
    }

    public void onClickButton22(View view) {
        id = 22;
        moves.addMoves(id);
    }

    public void onClickButton23(View view) {
        id = 23;
        moves.addMoves(id);
    }

    public void onClickButton31(View view) {
        id = 31;
        moves.addMoves(id);
    }

    public void onClickButton32(View view) {
        id = 32;
        moves.addMoves(id);
    }

    public void onClickButton33(View view) {
        id = 33;
        moves.addMoves(id);
    }
}
