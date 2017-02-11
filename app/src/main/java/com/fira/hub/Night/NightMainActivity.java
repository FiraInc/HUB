package com.fira.hub.Night;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.hardware.Camera;
import android.media.AudioManager;
import android.media.Image;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.provider.Settings;
import android.support.v4.app.ActivityOptionsCompat;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
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

/**
 * Created by johannett321 on 07.01.2017.
 */

public class NightMainActivity extends Activity {

    File file;
    StringBuilder text;

    Boolean activeCam = false;

    ImageView flashlightButton;
    ImageView volumeButton;
    ImageView lightbulb;

    EditText NotesEditText;

    String tempFolder = "Fira/HUB/temp/";
    String tempFolderParrot = "Fira/Parrot/temp/";
    String personalInformationFolder = "Fira/HUB/PersonalInformation/";
    String personalInformationFolderParrot = "Fira/Parrot/PersonalInformation/";
    String favoriteAppsGeneral = "Fira/HUB/FavoriteApps/General/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.night_main_activity);

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

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().getDecorView().setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }

        flashlightButton = (ImageView) findViewById(R.id.flashlightButton);
        volumeButton = (ImageView) findViewById(R.id.volumeButton);
        lightbulb = (ImageView) findViewById(R.id.lightbulb);

        NotesEditText = (EditText) findViewById(R.id.NotesHome2);


        AudioManager am = (AudioManager)getSystemService(Context.AUDIO_SERVICE);
        switch (am.getRingerMode()) {
            case AudioManager.RINGER_MODE_SILENT:
                volumeButton.setImageDrawable(getResources().getDrawable(R.drawable.volume_off));
                break;
            case AudioManager.RINGER_MODE_VIBRATE:
                volumeButton.setImageDrawable(getResources().getDrawable(R.drawable.volume_off));
                break;
            case AudioManager.RINGER_MODE_NORMAL:
                volumeButton.setImageDrawable(getResources().getDrawable(R.drawable.volume_on));
                break;
        }

        file = new File(Environment.getExternalStorageDirectory(), personalInformationFolderParrot + "WhatLights.txt");
        text = new StringBuilder();
        try {
            BufferedReader brBio = new BufferedReader(new FileReader(file));
            String line;

            while ((line = brBio.readLine()) != null) {
                text.append(line);
            }
            brBio.close();
        } catch (IOException e) {
        }

        if (text.toString().isEmpty()) {
            lightbulb.setVisibility(View.GONE);
        }
        text.setLength(0);





        file = new File(Environment.getExternalStorageDirectory(),personalInformationFolderParrot + "QuickNotes.txt");
        text = new StringBuilder();
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;

            while ((line = br.readLine()) != null) {
                text.append(line);
            }
            br.close();
        }
        catch (IOException e) {
        }
        NotesEditText.setText(text.toString());
        text.setLength(0);

    }

    public void gotoSleep(View view) {
        Intent intent = new Intent(this, NightSleeping.class);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            ActivityOptionsCompat optionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(NightMainActivity.this,findViewById(R.id.headerNight), "transitionSleep");
            startActivity(intent, optionsCompat.toBundle());
            finish();
        }else {
            startActivity(intent);
            finish();
        }
    }

    public void flashlightButton(View view) {
        final Camera cam = Camera.open();
        if (activeCam) {
            flashlightButton.setImageDrawable(getResources().getDrawable(R.drawable.flashlight_unlit));
            cam.stopPreview();
            cam.release();
            activeCam = false;
        }else {
            flashlightButton.setImageDrawable(getResources().getDrawable(R.drawable.flashlight_lit));
            Camera.Parameters p = cam.getParameters();
            p.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
            cam.setParameters(p);
            cam.startPreview();
            activeCam = true;
        }


    }

    public void volumeToggle(View view) {
        AudioManager am = (AudioManager)getSystemService(Context.AUDIO_SERVICE);
        switch (am.getRingerMode()) {
            case AudioManager.RINGER_MODE_SILENT:
                volumeButton.setImageDrawable(getResources().getDrawable(R.drawable.volume_on));
                am.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
                break;
            case AudioManager.RINGER_MODE_VIBRATE:
                volumeButton.setImageDrawable(getResources().getDrawable(R.drawable.volume_on));
                am.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
                break;
            case AudioManager.RINGER_MODE_NORMAL:
                volumeButton.setImageDrawable(getResources().getDrawable(R.drawable.volume_off));
                am.setRingerMode(AudioManager.RINGER_MODE_SILENT);
                break;
        }
    }

    public void smartLightsButton(View view) {
        file = new File(Environment.getExternalStorageDirectory(), personalInformationFolderParrot + "WhatLights.txt");
        text = new StringBuilder();
        try {
            BufferedReader brBio = new BufferedReader(new FileReader(file));
            String line;

            while ((line = brBio.readLine()) != null) {
                text.append(line);
            }
            brBio.close();
        } catch (IOException e) {
        }


        if (text.toString().isEmpty()) {
            Toast.makeText(this, "Please choose your smart light bulbs in Parrot Launcher settings", Toast.LENGTH_LONG).show();

        }else {
            Intent intent = getPackageManager().getLaunchIntentForPackage(text.toString());
            startActivity(intent);
        }

        text.setLength(0);
    }

    public void saveNotes(View view) {
        NotesEditText.setCursorVisible(false);
        String input = NotesEditText.getText().toString();
        try {
            File file = new File(Environment.getExternalStorageDirectory(), personalInformationFolderParrot + "QuickNotes.txt");
            file.delete();
            BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
            writer.write(input);
            writer.close();
            Toast.makeText(this, R.string.saved, Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(this, "FAILED TO SAVE!", Toast.LENGTH_LONG).show();
        }
    }


    public void clearNotes(View view) {
        NotesEditText.setText("");
    }

    public void loadNotes(View view) {
        file = new File(Environment.getExternalStorageDirectory(),personalInformationFolderParrot + "QuickNotes.txt");
        text = new StringBuilder();
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;

            while ((line = br.readLine()) != null) {
                text.append(line);
            }
            br.close();
        }
        catch (IOException e) {
        }
        NotesEditText.setText(text.toString());
        text.setLength(0);
    }
}
