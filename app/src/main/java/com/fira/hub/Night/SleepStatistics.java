package com.fira.hub.Night;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Environment;
import android.renderscript.Sampler;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

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

public class SleepStatistics extends Activity {

    String tempFolder = "Fira/Parrot/temp/";
    String personalInformationFolder = "Fira/Parrot/PersonalInformation/";
    String favoriteAppsGeneral = "Fira/Parrot/FavoriteApps/General/";

    String SavedHour = "";
    String SavedMinute = "";
    String SavedDay = "";

    int savedHour;
    int savedMinute;
    int savedDay;

    int hoursTillTwelve;
    int hoursAfterTwelve;

    int hoursSlept;
    int minutesSlept;

    File file;
    StringBuilder text;
    BufferedReader brBio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sleep_statistics);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        try{
            File fileDay = new File(Environment.getExternalStorageDirectory(),tempFolder + "NightSleepOn.txt");
            fileDay.delete();
            BufferedWriter writerDay = new BufferedWriter(new FileWriter(fileDay,true));
            writerDay.write("0");
            writerDay.close();
        }
        catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(this, "Failed to start timer", Toast.LENGTH_LONG).show();
        }

        calculateTime();
    }

    private void calculateTime() {
        file = new File(Environment.getExternalStorageDirectory(),tempFolder + "NightSleepHour.txt");
        text = new StringBuilder();
        try {
            brBio = new BufferedReader(new FileReader(file));
            String line;

            while ((line = brBio.readLine()) != null) {
                text.append(line);
            }
            brBio.close();
        }
        catch (IOException e) {

        }
        SavedHour = text.toString();
        text.setLength(0);



        file = new File(Environment.getExternalStorageDirectory(),tempFolder + "NightSleepMinute.txt");
        text = new StringBuilder();
        try {
            brBio = new BufferedReader(new FileReader(file));
            String line;

            while ((line = brBio.readLine()) != null) {
                text.append(line);
            }
            brBio.close();
        }
        catch (IOException e) {

        }
        SavedMinute = text.toString();
        text.setLength(0);


        file = new File(Environment.getExternalStorageDirectory(),tempFolder + "NightSleepDay.txt");
        text = new StringBuilder();
        try {
            brBio = new BufferedReader(new FileReader(file));
            String line;

            while ((line = brBio.readLine()) != null) {
                text.append(line);
            }
            brBio.close();
        }
        catch (IOException e) {

        }


        SavedDay = text.toString();
        text.setLength(0);


        if (!SavedDay.isEmpty()) {
            savedDay = Integer.parseInt(SavedDay);
        }else {
            savedDay = 0;
        }
        if (!SavedHour.isEmpty()) {
            savedHour = Integer.parseInt(SavedHour);
        }else {
            savedHour = 0;
        }
        if (!SavedMinute.isEmpty()) {
            savedMinute = Integer.parseInt(SavedMinute);
        }else {
            savedMinute = 0;
        }






        Calendar c = Calendar.getInstance();
        int currentHour = c.get(Calendar.HOUR_OF_DAY);
        int currentMinute = c.get(Calendar.MINUTE);
        int currentDay = c.get(Calendar.DAY_OF_YEAR);


        if (savedHour > currentHour) {
            hoursTillTwelve = 24-currentHour;
            hoursAfterTwelve = currentHour;
            hoursSlept = hoursTillTwelve + hoursAfterTwelve;
        }else if (savedHour < currentHour) {
            hoursSlept = currentHour - savedHour;
        }


        if (currentMinute < savedMinute) {
            minutesSlept = 60 - savedMinute + currentMinute;
        }else {
            minutesSlept = currentMinute - savedMinute;
            Log.e("WHUT", String.valueOf(savedMinute) + 1);
        }

        try{
            file = new File(Environment.getExternalStorageDirectory(),tempFolder + "NightSleepDay.txt");
            file.delete();
        }
        catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(this, "Failed to start timer", Toast.LENGTH_LONG).show();
        }

        setTime();
    }

    private void setTime() {
        TextView hours;
        hours = (TextView) findViewById(R.id.hours);
        hours.setText(String.valueOf(hoursSlept));

        TextView minutes;
        minutes = (TextView) findViewById(R.id.minutes);
        minutes.setText(String.valueOf(minutesSlept));
    }

    @Override
    public void onBackPressed() {

    }
}
