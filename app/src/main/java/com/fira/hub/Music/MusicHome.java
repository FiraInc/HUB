package com.fira.hub.Music;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Toast;

import com.fira.hub.R;

public class MusicHome extends Activity {

    Boolean doubleback = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.music_home);
    }

    @Override
    public void onBackPressed() {
        if (doubleback) {
            super.onBackPressed();
        }else {
            Toast.makeText(this, "Press again to exit", Toast.LENGTH_SHORT).show();
            doubleback = true;

            new Handler().postDelayed(new Runnable() {

                @Override
                public void run() {
                    doubleback = false;
                }
            }, 2000);
        }
    }

    public void spotifyButton (View view) {
        Intent launchIntent = getPackageManager().getLaunchIntentForPackage("com.spotify.music");
        if (launchIntent != null) {
            startActivity(launchIntent);
        }else {
            Toast.makeText(this, "Please install spotify", Toast.LENGTH_LONG).show();
        }
    }

    public void soundcloudButton (View view) {
        Intent launchIntent = getPackageManager().getLaunchIntentForPackage("com.soundcloud.android");
        if (launchIntent != null) {
            startActivity(launchIntent);
        }else {
            Toast.makeText(this, "Please install SoundCloud", Toast.LENGTH_LONG).show();
        }
    }

    public void playmusicButton (View view) {
        Intent intent=Intent.makeMainSelectorActivity(Intent.ACTION_MAIN,
                Intent.CATEGORY_APP_MUSIC);
        startActivity(intent);

        //https://open.spotify.com/user/spotify_norway_/playlist/1xiZVSQUHoCfAMr3TIYqPP
    }

    public void firstAlbum (View view) {
        String firstAlbum = "https://open.spotify.com/user/spotify_norway_/playlist/1xiZVSQUHoCfAMr3TIYqPP";
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(firstAlbum));
        startActivity(browserIntent);
    }

    public void secondAlbum (View view) {
        String secondAlbum = "https://open.spotify.com/user/spotify/playlist/63dDpdoVHvx5RkK87g4LKk";
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(secondAlbum));
        startActivity(browserIntent);
    }

    public void thirdAlbum (View view) {
        String thirdAlbum = "https://open.spotify.com/user/spotify_norway_/playlist/2FPT17DoFCEpsAyFkhFzlM";
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(thirdAlbum));
        startActivity(browserIntent);
    }

    public void PopularMusicApps (View view) {
        Intent intent = new Intent(this, MusicApps.class);
        startActivity(intent);
    }

    public void sleepGenre(View view) {
        Intent intent = new Intent(this, GenreSleep.class);
        startActivity(intent);
    }

    public void Genres(View view) {
        Intent intent = new Intent(this, Genres.class);
        startActivity(intent);
    }

    public void tuckMeIn (View view) {
        String thirdAlbum = "https://open.spotify.com/user/spotify_norway_/playlist/1xiZVSQUHoCfAMr3TIYqPP";
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(thirdAlbum));
        startActivity(browserIntent);
    }

    public void peacefulPiano (View view) {
        String thirdAlbum = "https://open.spotify.com/user/spotify/playlist/63dDpdoVHvx5RkK87g4LKk";
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(thirdAlbum));
        startActivity(browserIntent);
    }

    public void lateNightDrinks (View view) {
        String thirdAlbum = "https://open.spotify.com/user/spotify_norway_/playlist/2FPT17DoFCEpsAyFkhFzlM";
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(thirdAlbum));
        startActivity(browserIntent);
    }

    public void popGenre(View view) {
        Intent intent = new Intent(this, GenrePop.class);
        startActivity(intent);
    }

    public void focusGenre (View view) {
        Intent intent = new Intent(this, GenreFocus.class);
        startActivity(intent);
    }

    public void moodGenre(View view) {
        Intent intent =new Intent(this, GenreMood.class);
        startActivity(intent);
    }
}
