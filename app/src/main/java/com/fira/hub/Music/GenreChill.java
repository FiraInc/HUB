package com.fira.hub.Music;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;

import com.fira.hub.R;
import com.fira.hub.Install.InstallWelcome;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by johannett321 on 31.12.2016.
 */
public class GenreChill extends Activity {

    File file;
    StringBuilder text;

    String tempFolder = "Fira/HUB/temp/";
    String personalInformationFolder = "Fira/HUB/PersonalInformation/";
    String favoriteAppsGeneral = "Fira/HUB/FavoriteApps/General/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.genre_chill);

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

    public void Link1(View view) {
        String thirdAlbum = "https://open.spotify.com/user/spotify/playlist/7b9XqnXw5J47tmn0Y0IZeW";
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(thirdAlbum));
        startActivity(browserIntent);
    }

    public void Link2(View view) {
        String thirdAlbum = "https://open.spotify.com/user/spotify/playlist/7BixMZxL4bhgULJQ5wPbUz";
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(thirdAlbum));
        startActivity(browserIntent);
    }

    public void Link3(View view) {
        String thirdAlbum = "https://open.spotify.com/user/spotify/playlist/67nMZWgcUxNa5uaiyLDR2x";
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(thirdAlbum));
        startActivity(browserIntent);
    }

    public void Link4(View view) {
        String thirdAlbum = "https://open.spotify.com/user/spotify/playlist/2jvJnYj1DfCT1tX0Otp8z7";
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(thirdAlbum));
        startActivity(browserIntent);
    }

    public void Link5(View view) {
        String thirdAlbum = "https://open.spotify.com/user/spotify/playlist/5HEiuySFNy9YKjZTvNn6ox";
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(thirdAlbum));
        startActivity(browserIntent);
    }

    public void Link6(View view) {
        String thirdAlbum = "https://open.spotify.com/user/spotify/playlist/3hpgM1U3bD6kvo7wJubQ8z";
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(thirdAlbum));
        startActivity(browserIntent);
    }

    public void Link7(View view) {
        String thirdAlbum = "https://open.spotify.com/user/spotify/playlist/3jvtjbhswlSuYQSVBQVxva";
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(thirdAlbum));
        startActivity(browserIntent);
    }

    public void Link8(View view) {
        String thirdAlbum = "https://open.spotify.com/user/spotify/playlist/5tnBjatmVR3VtfVMOpS87h";
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(thirdAlbum));
        startActivity(browserIntent);
    }

    public void Link9(View view) {
        String thirdAlbum = "https://open.spotify.com/user/spotify/playlist/0i0KOEPUK7pA1A5A29ulk4";
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(thirdAlbum));
        startActivity(browserIntent);
    }

    public void backpressed(View view) {
        super.onBackPressed();
    }
}
