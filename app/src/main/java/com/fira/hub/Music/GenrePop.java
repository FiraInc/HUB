package com.fira.hub.Music;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.fira.hub.R;

/**
 * Created by johannett321 on 29.12.2016.
 */
public class GenrePop extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.genre_pop);
    }

    public void Link1(View view) {
        String thirdAlbum = "https://open.spotify.com/user/spotifycharts/playlist/37i9dQZEVXbMDoHDwVN2tF";
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(thirdAlbum));
        startActivity(browserIntent);
    }

    public void Link2(View view) {
        String thirdAlbum = "https://open.spotify.com/user/spotifycharts/playlist/37i9dQZEVXbLiRSasKsNU9";
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(thirdAlbum));
        startActivity(browserIntent);
    }

    public void Link3(View view) {
        String thirdAlbum = "https://open.spotify.com/user/spotify_norway_/playlist/7pza7BO41r0pmiMpFpRDL6";
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(thirdAlbum));
        startActivity(browserIntent);
    }

    public void Link4(View view) {
        String thirdAlbum = "https://open.spotify.com/user/spotify/playlist/5FJXhjdILmRA2z5bvz4nzf";
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(thirdAlbum));
        startActivity(browserIntent);
    }

    public void Link5(View view) {
        String thirdAlbum = "https://open.spotify.com/user/spotify/playlist/0ijttIJY7IL2Ez3zoMPxwC";
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(thirdAlbum));
        startActivity(browserIntent);
    }

    public void Link6(View view) {
        String thirdAlbum = "https://open.spotify.com/user/spotify/playlist/3MlpudZs4HT3i0yGPVfmHC";
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(thirdAlbum));
        startActivity(browserIntent);
    }

    public void Link7(View view) {
        String thirdAlbum = "https://open.spotify.com/user/spotify/playlist/3hojaDtnWmBFMGvnMu5Lqj";
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(thirdAlbum));
        startActivity(browserIntent);
    }

    public void Link8(View view) {
        String thirdAlbum = "https://open.spotify.com/user/spotify/playlist/4MNCftvCERT8MreHSpoRPe";
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(thirdAlbum));
        startActivity(browserIntent);
    }

    public void Link9(View view) {
        String thirdAlbum = "https://open.spotify.com/user/spotify/playlist/4MATto5gVBtUNCq2ASrFf4";
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(thirdAlbum));
        startActivity(browserIntent);
    }
}
