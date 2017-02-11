package com.fira.hub.HUB;

import android.webkit.WebView;

/**
 * Created by johannett321 on 04.02.2017.
 */

public interface Browser {
    boolean ShouldOverrideUrlLoading(WebView view, String url);
}
