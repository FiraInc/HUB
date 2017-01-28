package com.fira.hub.Music;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.fira.hub.R;

/**
 * Created by johannett321 on 31.12.2016.
 */
public class GenreChill extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.genre_chill);
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
}
