package com.fira.hub.HUB;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.fira.hub.R;

/**
 * Created by johannett321 on 04.02.2017.
 */

public class Information extends Activity {

    WebView fullscreenBrowser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fullscreen_webbrowser);

        fullscreenBrowser = (WebView) findViewById(R.id.fullscreenBrowser);
        fullscreenBrowser.getSettings().setJavaScriptEnabled(true);
        fullscreenBrowser.setWebViewClient(new ShouldOverrideUrl());
        fullscreenBrowser.loadUrl("https://dl.dropboxusercontent.com/u/72406826/Fira/HUB/AboutHUB.html");
    }


    private class ShouldOverrideUrl extends WebViewClient implements Browser {

        @Override
        public boolean ShouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }

}
