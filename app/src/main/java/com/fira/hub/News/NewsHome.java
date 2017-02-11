package com.fira.hub.News;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.fira.hub.Install.InstallWelcome;
import com.fira.hub.R;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Johannett321 on 29.01.2017.
 */

public class NewsHome extends Activity {

    WebView newsWebView;

    File file;
    StringBuilder text;

    Boolean doubleback = false;

    String tempFolder = "Fira/HUB/temp/";
    String personalInformationFolder = "Fira/HUB/PersonalInformation/";
    String personalInformationFolderParrot = "Fira/Parrot/PersonalInformation/";
    String favoriteAppsGeneral = "Fira/HUB/FavoriteApps/General/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news_simple);

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



        file = new File(Environment.getExternalStorageDirectory(), personalInformationFolderParrot + "NewsPages.txt");
        text = new StringBuilder();
        try {
            BufferedReader brBio = new BufferedReader(new FileReader(file));
            String line;

            while ((line = brBio.readLine()) != null) {
                text.append(line);
            }
            brBio.close();
        } catch (IOException e) {
        }

        newsWebView=(WebView) this.findViewById(R.id.newsWebView);

        newsWebView.getSettings().setJavaScriptEnabled(true);
        newsWebView.setWebViewClient(new ShouldOverrideUrl());

        if (!text.toString().isEmpty()) {
            if (text.toString().startsWith("http://www.")) {
                newsWebView.loadUrl(text.toString());
            }else if (text.toString().startsWith("https://www.")) {
                newsWebView.loadUrl(text.toString());
            }else if (text.toString().startsWith("www.")) {
                newsWebView.loadUrl("http://" + text.toString());
            }else if (text.toString().startsWith("http://")) {
                newsWebView.loadUrl("www." + text.toString());
            }else if (text.toString().startsWith("https://")) {
                newsWebView.loadUrl("www." + text.toString());
            }else {
                newsWebView.loadUrl("http://www." + text.toString());
            }
        }else {
            newsWebView.loadUrl("http://www.bbc.com");
        }
        text.setLength(0);
    }


    private class ShouldOverrideUrl extends WebViewClient implements MyBrowser {

        @Override
        public boolean ShouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }

    @Override
    public void onBackPressed() {
        if (!newsWebView.canGoBack()) {
            if (doubleback) {
                finish();
            }else {
                Toast.makeText(this, "Press again to exit", Toast.LENGTH_SHORT).show();
                doubleback = true;

                new Handler().postDelayed(new Runnable() {

                    @Override
                    public void run() {
                        doubleback = false;
                    }
                }, 2000);
            }
        }else {
            newsWebView.goBack();
        }
    }
}
