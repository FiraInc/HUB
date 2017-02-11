package com.fira.hub.Install;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.fira.hub.R;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

/**
 * Created by johannett321 on 04.02.2017.
 */

public class InstallWelcome extends Activity {

    File file;
    StringBuilder text;

    String tempFolder = "Fira/HUB/temp/";
    String personalInformationFolder = "Fira/HUB/PersonalInformation/";
    String favoriteAppsGeneral = "Fira/Parrot/HUB/General/";

    TextView extensionTitle;
    TextView installExtension;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.install_welcome);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        extensionTitle = (TextView) findViewById(R.id.extensionTitle);
        installExtension = (TextView) findViewById(R.id.installExtension);

        Typeface light = Typeface.createFromAsset(getAssets(),"segoelight.ttf");
        extensionTitle.setTypeface(light);
        installExtension.setTypeface(light);

    }

    public void start(View view) {
        Intent intent = new Intent(this, InstallParrot.class);
        startActivity(intent);
        finish();
    }



}
