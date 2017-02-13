package com.fira.hub.News;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.fira.hub.Install.InstallWelcome;
import com.fira.hub.R;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Johannett321 on 11.02.2017.
 */

public class newsWebLoader extends Activity {

    File file;
    StringBuilder text;

    String tempFolder = "Fira/HUB/temp/";
    String personalInformationFolder = "Fira/HUB/PersonalInformation/";
    String favoriteAppsGeneral = "Fira/HUB/FavoriteApps/General/";

    int currentNumber = 1;
    int currentNumberSaves = 1;

    Boolean subscribed = false;
    Boolean saved = false;

    WebView WebView;
    ProgressBar progressBar;

    boolean settingsEnabled = false;
    RelativeLayout settingsBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news_web_loader);

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


        WebView = (WebView) findViewById(R.id.WebView);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);


        WebView.setWebChromeClient(new webChromeClient());
        WebView.setWebViewClient(new myWebClient());
        WebView.getSettings().setGeolocationEnabled(true);
        WebView.getSettings().setSupportMultipleWindows(true);
        WebView.getSettings().setJavaScriptEnabled(true);
        WebView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        settingsBox = (RelativeLayout) findViewById(R.id.settingsBox);

        settingsBox.setVisibility(View.INVISIBLE);

        loadURL();
        checkSubscription();
        checkArticleSave();

    }

    private void loadURL() {
        TextView WebPageName = (TextView) findViewById(R.id.WebPageName);
        NewsSites.currentWord = NewsHomeExperimental.selectedBoxContent;
        NewsSites.calculate();
        WebView.loadUrl(NewsSites.currentLink);

        String WebName;
        WebName = NewsHomeExperimental.selectedBoxContent;

        if(WebName.contains("http://www.")) {
            WebName = WebName.replace("http://www.", "");
            Log.e("HMM", "SPECIAL");
        }else if (WebName.contains("https://www.")) {
            WebName = WebName.replace("https://www.", "");
            Log.e("HMM", "SPECIAL");
        }else if (WebName.contains("www.")) {
            WebName = WebName.replace("www.", "");
            Log.e("HMM", "SPECIAL");
        }

        if (WebName.contains(".co")) {
            WebName = WebName.split(".co")[0];
        }else if (WebName.contains(".com")) {
            WebName = WebName.split(".com")[0];
        }else if (WebName.contains(".no")) {
            WebName = WebName.split(".no")[0];
        }else if (WebName.contains(".net")) {
            WebName = WebName.split(".net")[0];
        }else if (WebName.contains(".tk")) {
            WebName = WebName.split(".tk")[0];
        }else if (WebName.contains(".dk")) {
            WebName = WebName.split(".dk")[0];
        }else if (WebName.contains(".org")) {
            WebName = WebName.split(".org")[0];
        }else if (WebName.contains(".uk")) {
            WebName = WebName.split(".uk")[0];
        }else if (WebName.contains(".se")) {
            WebName = WebName.split(".se")[0];
        }else if (WebName.contains(".us")) {
            WebName = WebName.split(".us")[0];
        }

        WebName = WebName.toUpperCase();
        WebPageName.setText(WebName);
    }

    public void subscribeClicked(View view) {
        checkSubscription();
        subscribe();
    }

    private void checkSubscription() {
        TextView subscribedText = (TextView) findViewById(R.id.subscribedText);
        file = new File(Environment.getExternalStorageDirectory(),personalInformationFolder + "newsSubscription" + Integer.toString(currentNumber) + ".txt");
        if (file.exists()) {
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

            if (text.toString().equals(NewsHomeExperimental.selectedBoxContent)) {
                subscribed = true;
                subscribedText.setTextColor(getResources().getColor(R.color.yellowVIP));
                subscribedText.setText("Subscribed");
                Log.e("WUTTUT", "Subscribe text set");

            }else {
                currentNumber = currentNumber + 1;
                text.setLength(0);
                Log.e("WUTTUT", "+1 checkSubscription");
                checkSubscription();
            }


            text.setLength(0);
        }else {
            subscribed = false;
            subscribedText.setTextColor(getResources().getColor(R.color.black));
            subscribedText.setText("Subscribe");
            Log.e("WUTTUT", "subscribed = false");
        }
    }

    private void subscribe() {
        file = new File(Environment.getExternalStorageDirectory(),personalInformationFolder + "newsSubscription" + Integer.toString(currentNumber) + ".txt");
        if (!subscribed) {
            Log.e("WUTTUT", "not subscribed");
            if (!file.exists()) {
                Log.e("WUTTUT", "file does not exist subscribevoid");
                try{
                    BufferedWriter writer = new BufferedWriter(new FileWriter(file,true));
                    writer.write(NewsHomeExperimental.selectedBoxContent);
                    writer.close();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
                subscribed = true;
                checkSubscription();
            }else {
                currentNumber = currentNumber + 1;
                subscribe();
                Log.e("WUTTUT", "subscribed exist");
            }
        }else {
            try{
                file.delete();
                BufferedWriter writer = new BufferedWriter(new FileWriter(file,true));
                writer.write("");
                writer.close();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            Log.e("subscriptionNumber", String.valueOf(currentNumber) + "hello");
            subscribed = false;
            checkSubscription();
            Log.e("WUTTUT", "Subscribed, unsubscribing");
        }
    }

    @Override
    public void onBackPressed() {
        if (settingsEnabled) {
            menuCloser();
        }else {
            if (!WebView.canGoBack()) {
                super.onBackPressed();
                overridePendingTransition(R.animator.pull_in_left, R.animator.push_out_right);
            }else {
                WebView.goBack();
            }
        }

    }

    private void menuCloser() {
        settingsBox.setVisibility(View.INVISIBLE);
        settingsEnabled = false;
    }

    public void menuButton(View view) {
        menuChecker();
    }

    private void menuChecker() {
        if (settingsEnabled) {
            settingsBox.setVisibility(View.INVISIBLE);
            settingsEnabled = false;
        }else {
            settingsBox.setVisibility(View.VISIBLE);
            settingsEnabled = true;
        }
    }

    public void openInBrowser(View view) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(WebView.getUrl().toString()));
        startActivity(browserIntent);
    }

    public void saveArticle(View view) {
        articleSave();
    }

    private void articleSave() {
        file = new File(Environment.getExternalStorageDirectory(),personalInformationFolder + "newsSaves" + Integer.toString(currentNumberSaves) + ".txt");
        if (!saved) {
            if (!file.exists()) {
                try{
                    BufferedWriter writer = new BufferedWriter(new FileWriter(file,true));
                    writer.write(WebView.getUrl().toString());
                    writer.close();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
                saved = true;
                checkArticleSave();
            }else {
                currentNumberSaves = currentNumberSaves + 1;
                articleSave();
            }
        }else {
            try{
                file.delete();
                BufferedWriter writer = new BufferedWriter(new FileWriter(file,true));
                writer.write("");
                writer.close();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            saved = false;
            checkArticleSave();
        }
    }

    private void checkArticleSave() {
        TextView savedText = (TextView) findViewById(R.id.savePage);
        file = new File(Environment.getExternalStorageDirectory(),personalInformationFolder + "newsSaves" + Integer.toString(currentNumberSaves) + ".txt");
        if (file.exists()) {
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

            if (text.toString().equals(WebView.getUrl())) {
                saved = true;
                savedText.setTextColor(getResources().getColor(R.color.yellowVIP));
                savedText.setText("Saved");

            }else {
                currentNumberSaves = currentNumberSaves + 1;
                text.setLength(0);
                checkArticleSave();
            }


            text.setLength(0);
        }else {
            saved = false;
            savedText.setTextColor(getResources().getColor(R.color.black));
            savedText.setText("Save");
        }
    }


    public class myWebClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            return super.shouldOverrideUrlLoading(view, url);
        }


        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
            progressBar.setVisibility(View.VISIBLE);
        }


        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            progressBar.setVisibility(View.GONE);
        }
    }


    public class webChromeClient extends WebChromeClient {

    }
}
