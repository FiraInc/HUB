package com.fira.hub.HUB;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.fira.hub.Install.InstallWelcome;
import com.fira.hub.R;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class MainActivity extends Activity {

    File file;
    StringBuilder text;

    String tempFolder = "Fira/HUB/temp/";
    String personalInformationFolder = "Fira/HUB/PersonalInformation/";
    String favoriteAppsGeneral = "Fira/HUB/FavoriteApps/General/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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


        AlertDialog.Builder dlgAlert  = new AlertDialog.Builder(this);
        dlgAlert.setMessage("Remember that this is just the beta, so please don't judge the app yet! A lot will change...");
        dlgAlert.setTitle("BETA");
        dlgAlert.setPositiveButton("Ok",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        //dismiss the dialog
                    }
                });
        dlgAlert.setCancelable(false);
        dlgAlert.create().show();

    }

    public void Settings(View view) {
        Toast.makeText(this, "Settings is not available yet! This is just the beta!", Toast.LENGTH_LONG).show();
    }

    public void Connections(View view) {
        Toast.makeText(this, "Connections is not available yet! This is just the beta!", Toast.LENGTH_LONG).show();
    }

    public void Information(View view) {
        Intent intent = new Intent(this, Information.class);
        startActivity(intent);
    }

    public void reportBug(View view) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setType("text/plain");
        intent.setData(Uri.parse("mailto:firaosinc@gmail.com"));
        intent.putExtra(Intent.EXTRA_SUBJECT, "Bug In Fira HUB");
        startActivity(Intent.createChooser(intent, "PLEASE DO NOT CHANGE THE SUBJECT OF THIS MAIL! Choose your email client:"));
    }
}
