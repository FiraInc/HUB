package com.fira.hub.News;

import android.webkit.WebView;

/**
 * Created by Johan on 28.02.2016.
 */
public interface MyBrowser {
    boolean ShouldOverrideUrlLoading(WebView view, String url);
}
