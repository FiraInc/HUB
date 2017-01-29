package com.fira.hub.Music;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.fira.hub.R;


/**
 * Created by johannett321 on 31.10.2016.
 */
public class MusicApps extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.music_apps_extended);
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
    }

    public void appleMusicButton(View view) {
        Intent launchIntent = getPackageManager().getLaunchIntentForPackage("com.apple.android.music");
        if (launchIntent != null) {
            startActivity(launchIntent);
        }else {
            Toast.makeText(this, "Please install Apple Music", Toast.LENGTH_LONG).show();
        }
    }

    public void tidalButton(View view) {
        Intent launchIntent = getPackageManager().getLaunchIntentForPackage("com.aspiro.tidal");
        if (launchIntent != null) {
            startActivity(launchIntent);
        }else {
            Toast.makeText(this, "Please install Tidal", Toast.LENGTH_LONG).show();
        }
    }

    public void pandoraButton(View view) {
        Intent launchIntent = getPackageManager().getLaunchIntentForPackage("com.pandora.android");
        if (launchIntent != null) {
            startActivity(launchIntent);
        }else {
            Toast.makeText(this, "Please install Pandora", Toast.LENGTH_LONG).show();
        }
    }

    public void shazamButton(View view) {
        Intent launchIntent = getPackageManager().getLaunchIntentForPackage("com.shazam.android");
        if (launchIntent != null) {
            startActivity(launchIntent);
        }else {
            Toast.makeText(this, "Please install Shazam", Toast.LENGTH_LONG).show();
        }
    }

    public void soundHoundButton(View view) {
        Intent launchIntent = getPackageManager().getLaunchIntentForPackage("com.melodis.midomiMusicIdentifier.freemium");
        if (launchIntent != null) {
            startActivity(launchIntent);
        }else {
            Toast.makeText(this, "Please install SoundHound", Toast.LENGTH_LONG).show();
        }
    }

    public void amazonMusicButton(View view) {
        Intent launchIntent = getPackageManager().getLaunchIntentForPackage("com.amazon.mp3");
        if (launchIntent != null) {
            startActivity(launchIntent);
        }else {
            Toast.makeText(this, "Please install Amazon Music", Toast.LENGTH_LONG).show();
        }
    }

    public void backpressed(View view) {
        super.onBackPressed();
    }
}
