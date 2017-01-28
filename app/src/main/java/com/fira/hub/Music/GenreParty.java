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
public class GenreParty extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.genre_party);
    }

    public void Link1(View view) {
        String thirdAlbum = "https://open.spotify.com/user/spotify_norway_/playlist/4mUBFwyk0vaioHAx7nkIEJ";
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(thirdAlbum));
        startActivity(browserIntent);
    }

    public void Link2(View view) {
        String thirdAlbum = "https://open.spotify.com/user/spotify_norway_/playlist/2FPT17DoFCEpsAyFkhFzlM";
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(thirdAlbum));
        startActivity(browserIntent);
    }

    public void Link3(View view) {
        String thirdAlbum = "https://open.spotify.com/user/sonymusicentertainment/playlist/7rlCwXBPo431YiHj1xWLnP";
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(thirdAlbum));
        startActivity(browserIntent);
    }

    public void Link4(View view) {
        String thirdAlbum = "https://open.spotify.com/user/spotify/playlist/5hv1itwgNPSUvte2YhPVkB";
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(thirdAlbum));
        startActivity(browserIntent);
    }

    public void Link5(View view) {
        String thirdAlbum = "https://open.spotify.com/user/spotify/playlist/7uDoSz5VxK5lbXgj7tBMG9";
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(thirdAlbum));
        startActivity(browserIntent);
    }

    public void Link6(View view) {
        String thirdAlbum = "https://open.spotify.com/user/spotify/playlist/2JkjXscXs35c5wKE5ZeaYK";
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(thirdAlbum));
        startActivity(browserIntent);
    }

    public void Link7(View view) {
        String thirdAlbum = "https://open.spotify.com/user/spotify/playlist/2ruCyy85iUzZcTZbeSVFRY";
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(thirdAlbum));
        startActivity(browserIntent);
    }

    public void Link8(View view) {
        String thirdAlbum = "https://open.spotify.com/user/myplay.com/playlist/3hoI0s5TLdpPMcimSRmQpj";
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(thirdAlbum));
        startActivity(browserIntent);
    }

    public void Link9(View view) {
        String thirdAlbum = "https://open.spotify.com/user/sonymusicentertainment/playlist/1lSdljPk8zcAdXVMUduDia";
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(thirdAlbum));
        startActivity(browserIntent);
    }
}
