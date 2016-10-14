package com.jparzonka.crossandcircle.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.jparzonka.crossandcircle.R;

/**
 * Created by Jakub on 2016-10-14.
 */
public class ChooseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose);

    }

    public void chooseCross(View view) {
        Intent startGame = new Intent(this, GameActivity.class);
        startGame.putExtra("Choose", true);
        startActivity(startGame);
    }

    public void chooseCircle(View view) {
        Intent startGame = new Intent(this, GameActivity.class);
        startGame.putExtra("Choose", false);
        startActivity(startGame);
    }
}
