package com.fira.hub.Install;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.view.View;
import android.widget.TextView;

import com.fira.hub.R;

/**
 * Created by johannett321 on 04.02.2017.
 */

public class AskForPermissions extends Activity {

    TextView recommendYou;
    TextView extensionTitle;
    TextView installExtension;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ask_for_permissions);

        recommendYou = (TextView) findViewById(R.id.recommendYou);
        extensionTitle = (TextView) findViewById(R.id.extensionTitle);
        installExtension = (TextView) findViewById(R.id.installExtension);

        Typeface light = Typeface.createFromAsset(getAssets(),"segoelight.ttf");
        recommendYou.setTypeface(light);
        extensionTitle.setTypeface(light);
        installExtension.setTypeface(light);
    }

    public void allow(View view) {
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 1);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case 1: {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Intent intent = new Intent(this, Hello.class);
                    startActivity(intent);
                    finish();
                }return;
            }
        }
    }
}
