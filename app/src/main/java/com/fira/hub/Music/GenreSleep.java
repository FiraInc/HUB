package com.fira.hub.Music;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;

import com.fira.hub.Install.InstallWelcome;
import com.fira.hub.R;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by johannett321 on 31.10.2016.
 */
public class GenreSleep extends Activity {

    File file;
    StringBuilder text;

    String tempFolder = "Fira/HUB/temp/";
    String personalInformationFolder = "Fira/Parrot/PersonalInformation/";
    String favoriteAppsGeneral = "Fira/HUB/FavoriteApps/General/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.genre_sleep);

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


    }

    public void tuckMeIn(View view) {
        String thirdAlbum = "https://open.spotify.com/user/spotify_norway_/playlist/1xiZVSQUHoCfAMr3TIYqPP";
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(thirdAlbum));
        startActivity(browserIntent);
    }

    public void peacefulPiano(View view) {
        String thirdAlbum = "https://open.spotify.com/user/spotify/playlist/63dDpdoVHvx5RkK87g4LKk";
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(thirdAlbum));
        startActivity(browserIntent);
    }

    public void lateNightDrinks(View view) {
        String thirdAlbum = "https://open.spotify.com/user/spotify_norway_/playlist/2FPT17DoFCEpsAyFkhFzlM";
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(thirdAlbum));
        startActivity(browserIntent);
    }

    public void sleep(View view) {
        String thirdAlbum = "https://open.spotify.com/user/spotify/playlist/5UMleIsaNDK5LzZRbrbcXr";
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(thirdAlbum));
        startActivity(browserIntent);
    }

    public void peace(View view) {
        String thirdAlbum = "https://open.spotify.com/user/spotify/playlist/2jPqXjczinrHdKh6qzHcoz";
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(thirdAlbum));
        startActivity(browserIntent);
    }

    public void natureNoise(View view) {
        String thirdAlbum = "https://open.spotify.com/user/spotify/playlist/5lyjV1xN0eVz35QXezqebv";
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(thirdAlbum));
        startActivity(browserIntent);
    }

    public void whiteNoise(View view) {
        String thirdAlbum = "https://open.spotify.com/user/spotify/playlist/0SW543u1KoHJZKjjedW095";
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(thirdAlbum));
        startActivity(browserIntent);
    }

    public void rainStorm(View view) {
        String thirdAlbum = "https://open.spotify.com/user/spotify/playlist/5lzEAI33SAzsaHsG1BgdGR";
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(thirdAlbum));
        startActivity(browserIntent);
    }

    public void atmos(View view) {
        String thirdAlbum = "https://open.spotify.com/user/spotify/playlist/3fCn2nqmX6ZnYUe9uoty98";
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(thirdAlbum));
        startActivity(browserIntent);
    }

    public void backpressed(View view) {
        super.onBackPressed();
    }
}
