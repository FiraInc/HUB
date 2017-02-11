package com.fira.hub.HUB;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.fira.hub.R;

/**
 * Created by johannett321 on 05.02.2017.
 */

public class Upgrade extends Activity {

    Boolean extended = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.upgrade);
    }

    public void buyPRO(View view) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=com.fira.parrotlauncherpro"));
        startActivity(browserIntent);
    }

    public void buyVIP(View view) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("com.fira.firavip"));
        startActivity(browserIntent);
    }

    public void morePRO(View view) {
        extended = true;
        setContentView(R.layout.fullscreen_webbrowser);
        WebView PROView = (WebView) findViewById(R.id.fullscreenBrowser);
        PROView.getSettings().setJavaScriptEnabled(true);
        PROView.setWebViewClient(new ShouldOverrideUrl());
        PROView.loadUrl("https://dl.dropboxusercontent.com/u/72406826/Fira/HUB/AboutPro.html");
    }

    public void MoreVIP(View view) {
        extended = true;
        setContentView(R.layout.fullscreen_webbrowser);
        WebView PROView = (WebView) findViewById(R.id.fullscreenBrowser);
        PROView.getSettings().setJavaScriptEnabled(true);
        PROView.setWebViewClient(new ShouldOverrideUrl());
        PROView.loadUrl("https://dl.dropboxusercontent.com/u/72406826/Fira/HUB/AboutVIP.html");
    }

    @Override
    public void onBackPressed() {
        if (extended) {
            setContentView(R.layout.upgrade);
            extended = false;
        }else {
            super.onBackPressed();
        }
    }

    private class ShouldOverrideUrl extends WebViewClient implements Browser {

        @Override
        public boolean ShouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }
}
