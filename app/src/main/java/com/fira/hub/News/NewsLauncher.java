package com.fira.hub.News;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.util.Log;

import com.fira.hub.R;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Johannett321 on 29.01.2017.
 */

public class NewsLauncher extends Activity {

    File file;
    StringBuilder text;

    String tempFolder = "Fira/HUB/temp/";
    String personalInformationFolder = "Fira/HUB/PersonalInformation/";
    String favoriteAppsGeneral = "Fira/HUB/FavoriteApps/General/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news_launcher);


        startHandler();


    }

    private void startHandler() {

        file = new File(Environment.getExternalStorageDirectory(), personalInformationFolder + "enableExperimentalNews.txt");
        text = new StringBuilder();
        text.append("2");
        try {
            BufferedReader brBio = new BufferedReader(new FileReader(file));
            String line;

            while ((line = brBio.readLine()) != null) {
                text.append(line);
            }
            brBio.close();
        } catch (IOException e) {
        }




        if (text.toString().equals("21")) {
            Intent intent = new Intent(this, NewsHomeExperimental.class);
            startActivity(intent);
            finish();
        }else if (text.toString().equals("1")) {
            Intent intent = new Intent(this, NewsHomeExperimental.class);
            startActivity(intent);
            finish();
        } else {
            Intent intent = new Intent(this, NewsHome.class);
            startActivity(intent);
            finish();
        }
        text.setLength(0);
    }
}
