package com.fira.hub.Music;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.fira.hub.R;

/**
 * Created by johannett321 on 31.10.2016.
 */
public class Genres extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.genres);
    }

    public void sleepGenre (View view) {
        Intent intent = new Intent(this, GenreSleep.class);
        startActivity(intent);
    }

    public void focus(View view) {
        Intent intent = new Intent(this, GenreFocus.class);
        startActivity(intent);
    }

    public void popGenre(View view) {
        Intent intent = new Intent(this, GenrePop.class);
        startActivity(intent);
    }

    public void moodGenre(View view) {
        Intent intent = new Intent(this, GenreMood.class);
        startActivity(intent);
    }

    public void partyGenre(View view) {
        Intent intent = new Intent(this, GenreParty.class);
        startActivity(intent);
    }

    public void chillGenre(View view) {
        Intent intent = new Intent(this, GenreChill.class);
        startActivity(intent);
    }

    public void workoutGenre(View view) {
        Intent intent = new Intent(this, GenreWorkout.class);
        startActivity(intent);
    }

    public void romanceGenre(View view) {
        Intent intent = new Intent(this, GenreRomance.class);
        startActivity(intent);
    }

    public void gamingGenre(View view) {
        Intent intent = new Intent(this, GenreGaming.class);
        startActivity(intent);
    }

    public void backpressed(View view) {
        super.onBackPressed();
    }
}
