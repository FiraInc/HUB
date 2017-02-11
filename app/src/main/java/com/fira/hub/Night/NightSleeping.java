package com.fira.hub.Night;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.support.v4.app.ActivityOptionsCompat;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.fira.hub.Install.InstallWelcome;
import com.fira.hub.R;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;

/**
 * Created by johannett321 on 07.01.2017.
 */

public class NightSleeping extends Activity {

    ImageView yellow;
    TextView goodNightTextSleeping;

    File file;
    StringBuilder text;

    String tempFolder = "Fira/HUB/temp/";
    String tempFolderParrot = "Fira/Parrot/temp/";
    String personalInformationFolder = "Fira/HUB/PersonalInformation/";
    String favoriteAppsGeneral = "Fira/HUB/FavoriteApps/General/";

    Handler handler;

    Boolean NightSleepingActive = false;
    Boolean daytime = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.night_sleeping);

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


        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        yellow = (ImageView) findViewById(R.id.yellow);
        goodNightTextSleeping = (TextView) findViewById(R.id.goodNightTextSleeping);
        yellow.setVisibility(View.INVISIBLE);

        startTimer();

        NightSleepingActive = true;
        fadeIn();
    }

    private void startTimer() {
        Calendar c = Calendar.getInstance();
        int currentHour = c.get(Calendar.HOUR_OF_DAY);
        int currentMinute = c.get(Calendar.MINUTE);
        int currentDay = c.get(Calendar.DAY_OF_YEAR);

        try{
            File fileHour = new File(Environment.getExternalStorageDirectory(),tempFolderParrot + "NightSleepHour.txt");
            fileHour.delete();
            BufferedWriter writerHour = new BufferedWriter(new FileWriter(fileHour,true));
            writerHour.write(String.valueOf(currentHour));
            writerHour.close();
        }
        catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(this, "Failed to start timer", Toast.LENGTH_LONG).show();
        }

        try{
            File fileMinute = new File(Environment.getExternalStorageDirectory(),tempFolderParrot + "NightSleepMinute.txt");
            fileMinute.delete();
            BufferedWriter writerMinute = new BufferedWriter(new FileWriter(fileMinute,true));
            writerMinute.write(String.valueOf(currentMinute));
            writerMinute.close();
        }
        catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(this, "Failed to start timer", Toast.LENGTH_LONG).show();
        }

        try{
            File fileDay = new File(Environment.getExternalStorageDirectory(),tempFolderParrot + "NightSleepDay.txt");
            fileDay.delete();
            BufferedWriter writerDay = new BufferedWriter(new FileWriter(fileDay,true));
            writerDay.write(String.valueOf(currentDay));
            writerDay.close();
        }
        catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(this, "Failed to start timer", Toast.LENGTH_LONG).show();
        }

        try{
            File fileDay = new File(Environment.getExternalStorageDirectory(),tempFolderParrot + "NightSleepOn.txt");
            fileDay.delete();
            BufferedWriter writerDay = new BufferedWriter(new FileWriter(fileDay,true));
            writerDay.write("1");
            writerDay.close();
        }
        catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(this, "Failed to start timer", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        NightSleepingActive = true;
        fadeIn();
    }

    @Override
    protected void onPause() {
        super.onPause();
        NightSleepingActive = false;
    }

    public void fadeIn () {
        if (NightSleepingActive) {
            Calendar c = Calendar.getInstance();
            int currentHour = c.get(Calendar.HOUR_OF_DAY);
            if (currentHour >= 5 && currentHour <= 17){
                daytime = true;
                try {
                    Animation startAnimation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_in_animation);
                    yellow.startAnimation(startAnimation);
                    yellow.setVisibility(View.VISIBLE);
                    goodNightTextSleeping.setText(getResources().getString(R.string.good_morning));
                }catch (Exception e) {}
            }else {
                handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        fadeIn();
                    }
                }, 10000);
            }
        }
    }

    public void wakeUpButton(View view) {
        File fileDay = new File(Environment.getExternalStorageDirectory(),tempFolderParrot + "NightSleepOn.txt");
        fileDay.delete();
        if (daytime) {
            Intent intent = new Intent(this, SleepStatistics.class);

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                ActivityOptionsCompat optionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(NightSleeping.this,findViewById(R.id.yellow), "transitionStatistics");
                startActivity(intent, optionsCompat.toBundle());
                finish();
            }else {
                startActivity(intent);
                finish();
            }
        }else {
            super.onBackPressed();
        }

    }

    @Override
    public void onBackPressed() {
        try {
            handler.removeCallbacks(null);
        }catch (Exception e) {

        }
        super.onBackPressed();
    }
}
