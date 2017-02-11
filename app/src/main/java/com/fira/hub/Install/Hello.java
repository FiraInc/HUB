package com.fira.hub.Install;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.fira.hub.HUB.MainActivity;
import com.fira.hub.R;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by johannett321 on 04.02.2017.
 */

public class Hello extends Activity {

    String tempFolder = "Fira/HUB/temp/";
    String tempFolderParrot = "Fira/Parrot/temp/";
    String personalInformationFolder = "Fira/HUB/PersonalInformation/";
    String favoriteAppsGeneral = "Fira/HUB/FavoriteApps/General/";

    TextView recommendYou;
    TextView extensionTitle;
    TextView installExtension;
    TextView skipButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hello);

        recommendYou = (TextView) findViewById(R.id.recommendYou);
        extensionTitle = (TextView) findViewById(R.id.extensionTitle);
        installExtension = (TextView) findViewById(R.id.installExtension);
        skipButton = (TextView) findViewById(R.id.skipButton);

        Typeface light = Typeface.createFromAsset(getAssets(),"segoelight.ttf");
        recommendYou.setTypeface(light);
        extensionTitle.setTypeface(light);
        installExtension.setTypeface(light);
        skipButton.setTypeface(light);

        File folderTemp = new File(Environment.getExternalStorageDirectory(),"Fira");
        if (!folderTemp.exists()) {
            folderTemp.mkdirs();
        }

        folderTemp = new File(Environment.getExternalStorageDirectory(),"Fira/HUB");
        if (!folderTemp.exists()) {
            folderTemp.mkdirs();
        }

        folderTemp = new File(Environment.getExternalStorageDirectory(),"Fira/HUB/PersonalInformation");
        if (!folderTemp.exists()) {
            folderTemp.mkdirs();
        }

        folderTemp = new File(Environment.getExternalStorageDirectory(),"Fira/HUB/temp");
        if (!folderTemp.exists()) {
            folderTemp.mkdirs();
        }

        try{
            File fileMinute = new File(Environment.getExternalStorageDirectory(),tempFolder + "Installed.txt");
            fileMinute.delete();
            BufferedWriter writerMinute = new BufferedWriter(new FileWriter(fileMinute,true));
            writerMinute.write("1");
            writerMinute.close();
        }
        catch (IOException e) {
            e.printStackTrace();
            Intent intent = new Intent(this, AskForPermissions.class);
            startActivity(intent);
            Toast.makeText(this, "Could not save installation, please allow access to storage", Toast.LENGTH_LONG).show();
        }

    }

    public void closeHUB(View view) {
        finish();
    }

    public void launchHub(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
