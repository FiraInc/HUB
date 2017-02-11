package com.fira.hub.Install;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.fira.hub.R;

/**
 * Created by johannett321 on 04.02.2017.
 */

public class InstallParrot extends Activity {

    TextView recommendYou;
    TextView extensionTitle;
    TextView installExtension;
    TextView skipButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.install_install_parrot);

        recommendYou = (TextView) findViewById(R.id.recommendYou);
        extensionTitle = (TextView) findViewById(R.id.extensionTitle);
        installExtension = (TextView) findViewById(R.id.installExtension);
        skipButton = (TextView) findViewById(R.id.skipButton);

        Typeface light = Typeface.createFromAsset(getAssets(),"segoelight.ttf");
        recommendYou.setTypeface(light);
        extensionTitle.setTypeface(light);
        installExtension.setTypeface(light);
        skipButton.setTypeface(light);
    }

    public void InstallParrotButton (View view) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=com.fira.parrot"));
        startActivity(browserIntent);
        skipButton.setText(R.string.done);
    }

    public void skipParrot(View view) {
        DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which){
                    case DialogInterface.BUTTON_POSITIVE:
                        startHello();
                        break;

                    case DialogInterface.BUTTON_NEGATIVE:
                        //No button clicked
                        break;
                }
            }
        };

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(R.string.are_you_sure).setPositiveButton(R.string.yes, dialogClickListener)
                .setNegativeButton(R.string.no, dialogClickListener).show();
    }

    private void startHello() {
        Intent intent = new Intent(this, Hello.class);
        startActivity(intent);
        finish();
    }
}
