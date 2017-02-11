package com.fira.hub.Music;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.fira.hub.HUB.Upgrade;
import com.fira.hub.Install.InstallWelcome;
import com.fira.hub.R;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by johannett321 on 31.10.2016.
 */
public class Genres extends Activity {

    File file;
    StringBuilder text;

    String tempFolder = "Fira/HUB/temp/";
    String personalInformationFolder = "Fira/HUB/PersonalInformation/";
    String favoriteAppsGeneral = "Fira/HUB/FavoriteApps/General/";

    boolean isInstalled;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.genres);

        file = new File(Environment.getExternalStorageDirectory(),tempFolder + "Installed.txt");
        text = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                text.append(line);
            }
            bufferedReader.close();
        }
        catch (IOException e) {

        }

        if (!text.toString().equals("1")) {
            Intent intent = new Intent(this, InstallWelcome.class);
            startActivity(intent);
            finish();
        }
        text.setLength(0);


       checkPro();



    }

    public void checkPro() {
        Context context = this;
        PackageManager pm = context.getPackageManager();
        isInstalled = isPackageInstalled("com.fira.firavip", pm);

        if (isInstalled) {
            ImageView moodGenre = (ImageView) findViewById(R.id.moodGenre);
            ImageView chillGenre = (ImageView) findViewById(R.id.chillGenre);
            ImageView workoutGenre = (ImageView) findViewById(R.id.workoutGenre);
            ImageView romanceGenre = (ImageView) findViewById(R.id.romanceGenre);
            ImageView gamingGenre = (ImageView) findViewById(R.id.gamingGenre);

            moodGenre.setImageDrawable(getResources().getDrawable(R.drawable.mood_genre_normal));
            chillGenre.setImageDrawable(getResources().getDrawable(R.drawable.chill_genre_normal));
            workoutGenre.setImageDrawable(getResources().getDrawable(R.drawable.workout_genre_normal));
            romanceGenre.setImageDrawable(getResources().getDrawable(R.drawable.romance_genre_normal));
            gamingGenre.setImageDrawable(getResources().getDrawable(R.drawable.gaming_genre_normal));
        }else {

        }
    }


    private boolean isPackageInstalled(String packagename, PackageManager packageManager) {
        try {
            packageManager.getPackageInfo(packagename, PackageManager.GET_ACTIVITIES);
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
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
        if (isInstalled) {
            Intent intent = new Intent(this, GenreMood.class);
            startActivity(intent);
        }else {
            Intent intent = new Intent(this, Upgrade.class);
            startActivity(intent);
        }
    }

    public void partyGenre(View view) {
        Intent intent = new Intent(this, GenreParty.class);
        startActivity(intent);
    }

    public void chillGenre(View view) {
        if (isInstalled) {
            Intent intent = new Intent(this, GenreChill.class);
            startActivity(intent);
        }else {
            Intent intent = new Intent(this, Upgrade.class);
            startActivity(intent);
        }
    }

    public void workoutGenre(View view) {
        if (isInstalled) {
            Intent intent = new Intent(this, GenreWorkout.class);
            startActivity(intent);
        }else {
            Intent intent = new Intent(this, Upgrade.class);
            startActivity(intent);
        }
    }

    public void romanceGenre(View view) {
        if (isInstalled) {
            Intent intent = new Intent(this, GenreRomance.class);
            startActivity(intent);
        }else {
            Intent intent = new Intent(this, Upgrade.class);
            startActivity(intent);
        }
    }

    public void gamingGenre(View view) {
        if (isInstalled) {
            Intent intent = new Intent(this, GenreGaming.class);
            startActivity(intent);
        }else {
            Intent intent = new Intent(this, Upgrade.class);
            startActivity(intent);
        }
    }

    public void backpressed(View view) {
        super.onBackPressed();
    }
}
