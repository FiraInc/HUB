package com.fira.hub.News;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.fira.hub.Install.InstallWelcome;
import com.fira.hub.R;

import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Johannett321 on 29.01.2017.
 */

public class NewsHomeExperimental extends Activity {

    File file;
    StringBuilder text;

    String tempFolder = "Fira/HUB/temp/";
    String personalInformationFolder = "Fira/HUB/PersonalInformation/";
    String favoriteAppsGeneral = "Fira/HUB/FavoriteApps/General/";

    ImageView rowButton11;
    ImageView rowButton12;
    ImageView rowButton13;

    ImageView rowButton21;
    ImageView rowButton22;
    ImageView rowButton23;

    String BoxContent1;
    String BoxContent2;
    String BoxContent3;

    String BoxContent21;
    String BoxContent22;
    String BoxContent23;

    static Boolean BoxFilled1 = false;
    static Boolean BoxFilled2 = false;
    static Boolean BoxFilled3 = false;

    static Boolean BoxFilled21 = false;
    static Boolean BoxFilled22 = false;
    static Boolean BoxFilled23 = false;

    RelativeLayout firstRow;
    RelativeLayout secondRow;

    static int currentNumber = 1;
    static int currentNumberSaves = 1;

    static String selectedBoxContent = "";

    ImageView splashScreenLogo;
    ImageView splashScreenBackground;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news_home);
        splashScreenLogo = (ImageView) findViewById(R.id.splashScreenLogo);
        splashScreenBackground = (ImageView) findViewById(R.id.splashScreenBackground);
        firstRow = (RelativeLayout) findViewById(R.id.firstRow);
        secondRow = (RelativeLayout) findViewById(R.id.secondRow);
        createOn();

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                splashScreenLogo.setVisibility(View.GONE);
                splashScreenBackground.setVisibility(View.GONE);
            }
        }, 3000);

    }

    public void createOn() {


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

        rowButton11 = (ImageView) findViewById(R.id.rowButton11);
        rowButton12 = (ImageView) findViewById(R.id.rowButton12);
        rowButton13 = (ImageView) findViewById(R.id.rowButton13);
        rowButton21 = (ImageView) findViewById(R.id.rowButton21);
        rowButton22 = (ImageView) findViewById(R.id.rowButton22);
        rowButton23 = (ImageView) findViewById(R.id.rowButton23);






        loadSubscriptions();
        loadSaves();
        loadPopular();
    }

    private void loadSaves() {
        file = new File(Environment.getExternalStorageDirectory(),personalInformationFolder + "newsSaves" + Integer.toString(currentNumberSaves) + ".txt");

        if (file.exists()) {
            if (!BoxFilled23) {
                text = new StringBuilder();
                text.setLength(0);
                try {
                    BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
                    String line;
                    while ((line = bufferedReader.readLine()) != null) {
                        text.append(line);
                    }
                    bufferedReader.close();
                }
                catch (IOException e) {}

                if (!text.toString().isEmpty()) {
                    if (!BoxFilled21) {
                        BoxContent21 = text.toString();
                        BoxFilled21 = true;
                        setImages(4);
                    }else if (!BoxFilled22) {
                        BoxContent22 = text.toString();
                        BoxFilled22 = true;
                        setImages(5);
                    }else if (!BoxFilled23) {
                        BoxContent23 = text.toString();
                        BoxFilled23 = true;
                        setImages(6);
                    }
                }
                Log.e("Checked file", "newsSubscription" + Integer.toString(currentNumberSaves) + ".txt");

                text.setLength(0);
                currentNumberSaves = currentNumberSaves + 1;
                loadSaves();
            }else {

            }
        }else {
            if (!BoxFilled21) {
                secondRow.setVisibility(View.GONE);
            }
            if (!BoxFilled23) {
                rowButton23.setVisibility(View.GONE);
            }
            if (!BoxFilled22) {
                rowButton22.setVisibility(View.GONE);
            }
        }
    }

    private void loadPopular() {
        new DownloadImageTask((ImageView) findViewById(R.id.rowButton31)).execute(NewsSites.imageBBC);
        new DownloadImageTask((ImageView) findViewById(R.id.rowButton32)).execute(NewsSites.imageGOOGLE);
        new DownloadImageTask((ImageView) findViewById(R.id.rowButton33)).execute(NewsSites.imageCNN);
    }

    private void loadSubscriptions() {
        file = new File(Environment.getExternalStorageDirectory(),personalInformationFolder + "newsSubscription" + Integer.toString(currentNumber) + ".txt");

        if (file.exists()) {
            if (!BoxFilled3) {
                text = new StringBuilder();
                text.setLength(0);
                try {
                    BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
                    String line;
                    while ((line = bufferedReader.readLine()) != null) {
                        text.append(line);
                    }
                    bufferedReader.close();
                }
                catch (IOException e) {}

                if (!text.toString().isEmpty()) {
                    if (!BoxFilled1) {
                        BoxContent1 = text.toString();
                        BoxFilled1 = true;
                        setImages(1);
                    }else if (!BoxFilled2) {
                        BoxContent2 = text.toString();
                        BoxFilled2 = true;
                        setImages(2);
                    }else if (!BoxFilled3) {
                        BoxContent3 = text.toString();
                        BoxFilled3 = true;
                        setImages(3);
                    }
                }
                Log.e("Checked file", "newsSubscription" + Integer.toString(currentNumber) + ".txt");

                text.setLength(0);
                currentNumber = currentNumber + 1;
                loadSubscriptions();
            }else {

            }
        }else {
            if (!BoxFilled1) {
                firstRow.setVisibility(View.GONE);
            }
            if (!BoxFilled3) {
                rowButton13.setVisibility(View.GONE);
            }
            if (!BoxFilled2) {
                rowButton12.setVisibility(View.GONE);
            }
        }
    }

    public void setImages(int imageNumber) {
        NewsSites.currentWord = text.toString();
        NewsSites.calculate();

        if (imageNumber == 1) {
            new DownloadImageTask((ImageView) findViewById(R.id.rowButton11)).execute(NewsSites.currentImage);
        }else if (imageNumber == 2) {
            new DownloadImageTask((ImageView) findViewById(R.id.rowButton12)).execute(NewsSites.currentImage);
        }else if (imageNumber == 3) {
            new DownloadImageTask((ImageView) findViewById(R.id.rowButton13)).execute(NewsSites.currentImage);
        }else if (imageNumber == 4) {
            new DownloadImageTask((ImageView) findViewById(R.id.rowButton21)).execute(NewsSites.currentImage);
        }else if (imageNumber == 5) {
            new DownloadImageTask((ImageView) findViewById(R.id.rowButton22)).execute(NewsSites.currentImage);
        }else if (imageNumber == 6) {
            new DownloadImageTask((ImageView) findViewById(R.id.rowButton23)).execute(NewsSites.currentImage);
        }
    }

    public void moreSaved(View view) {
        Intent intent = new Intent(this, savedNewsPapers.class);
        startActivity(intent);
    }

    public void boxClick1 (View view) {
        selectedBoxContent = BoxContent1;
        openNews();
    }

    public void boxClick2 (View view) {
        selectedBoxContent = BoxContent2;
        openNews();
    }

    public void boxClick3 (View view) {
        selectedBoxContent = BoxContent3;
        openNews();
    }


    public void boxClickSaves1 (View view) {
        selectedBoxContent = BoxContent21;
        Log.e("selected is", selectedBoxContent);
        openNews();
    }

    public void boxClickSaves2 (View view) {
        selectedBoxContent = BoxContent22;
        Log.e("selected is", selectedBoxContent);
        openNews();
    }

    public void boxClickSaves3 (View view) {
        selectedBoxContent = BoxContent23;
        openNews();
    }


    private void openNews() {
        if (!selectedBoxContent.isEmpty()) {
            Intent intent = new Intent(this, newsWebLoader.class);
            startActivity(intent);
            overridePendingTransition(R.animator.pull_in_right, R.animator.push_out_left);
        }
    }

    public void popularPaper1(View view) {
        selectedBoxContent = "BBC";
        openNews();
    }

    public void popularPaper2(View view) {
        selectedBoxContent = "GOOGLE";
        openNews();
    }

    public void popularPaper3(View view) {
        selectedBoxContent = "CNN";
        openNews();
    }

    public void morePopular(View view) {
        Intent intent = new Intent(this, popularNewsPapers.class);
        startActivity(intent);
    }

    private class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {

        ImageView bmImage;

        public DownloadImageTask(ImageView bmImage) {
            this.bmImage = bmImage;
        }

        protected Bitmap doInBackground(String... urls) {
            String urldisplay = urls[0];
            Bitmap mIcon11 = null;
            try {
                InputStream in = new java.net.URL(urldisplay).openStream();
                mIcon11 = BitmapFactory.decodeStream(in);
            } catch (Exception e) {
                Log.e("Error", e.getMessage());
                e.printStackTrace();
            }
            return mIcon11;
        }

        protected void onPostExecute(Bitmap result) {
            bmImage.setImageBitmap(result);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        firstRow.setVisibility(View.VISIBLE);
        secondRow.setVisibility(View.VISIBLE);
        rowButton11.setVisibility(View.VISIBLE);
        rowButton12.setVisibility(View.VISIBLE);
        rowButton13.setVisibility(View.VISIBLE);
        rowButton21.setVisibility(View.VISIBLE);
        rowButton22.setVisibility(View.VISIBLE);
        rowButton23.setVisibility(View.VISIBLE);
        createOn();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                BoxFilled1 = false;
                BoxFilled2 = false;
                BoxFilled3 = false;
                BoxFilled21 = false;
                BoxFilled22 = false;
                BoxFilled23 = false;
                BoxContent1 = "";
                BoxContent2 = "";
                BoxContent3 = "";
                BoxContent21 = "";
                BoxContent22 = "";
                BoxContent23 = "";
                rowButton11.setImageResource(R.drawable.loading_news);
                rowButton12.setImageResource(R.drawable.loading_news);
                rowButton13.setImageResource(R.drawable.loading_news);
                rowButton21.setImageResource(R.drawable.loading_news);
                rowButton22.setImageResource(R.drawable.loading_news);
                rowButton23.setImageResource(R.drawable.loading_news);
                currentNumber = 1;
                currentNumberSaves = 1;
            }
        },100);

    }
}
