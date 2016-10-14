package com.jparzonka.crossandcircle.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.jparzonka.crossandcircle.R;

public class MainMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
    }

    public void startGame(View view) {
        Intent startGame = new Intent(this, ChooseActivity.class);
        startActivity(startGame);
    }
}
