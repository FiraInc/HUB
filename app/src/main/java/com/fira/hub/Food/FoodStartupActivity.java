package com.fira.hub.Food;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.fira.hub.R;

import java.util.Calendar;

/**
 * Created by johannett321 on 30.12.2016.
 */
public class FoodStartupActivity extends Activity {

    public int currentHour;
    public int currentMinute;
    public int currentSecond;
    public int currentDay;

    public String CurrentDay;
    public String CurrentHour;
    public String CurrentMinute;
    public String CurrentSecond;

    WebView webViewFood;

    Boolean doubleExit = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.food_startup);

        webViewFood = (WebView) findViewById(R.id.webViewFood);
        webViewFood.setWebChromeClient(new WebChromeClient());
        webViewFood.setWebViewClient(new WebViewClient());
        webViewFood.clearCache(true);
        webViewFood.clearHistory();
        webViewFood.getSettings().setJavaScriptEnabled(true);
        webViewFood.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);


        checkTime();
    }

    @Override
    public void onBackPressed() {
        if (doubleExit.equals(true)) {
            super.onBackPressed();
        }
        if (!webViewFood.canGoBack()) {
            Toast.makeText(this, "Press again to exit", Toast.LENGTH_SHORT).show();
            doubleExit = true;
        }
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                doubleExit = false;
            }
        }, 2000);
    }

    public void checkTime() {
        Calendar c = Calendar.getInstance();
        currentHour = c.get(Calendar.HOUR_OF_DAY);
        currentMinute = c.get(Calendar.MINUTE);
        currentSecond = c.get(Calendar.SECOND);
        currentDay = c.get(Calendar.DAY_OF_WEEK);

        CurrentDay = String.valueOf(currentDay);
        CurrentHour = String.valueOf(currentHour);
        CurrentMinute = String.valueOf(currentMinute);
        CurrentSecond = String.valueOf(currentSecond);

        Log.e("Current is", String.valueOf(currentDay) + ":" + String.valueOf(currentHour) + ":" + String.valueOf(currentMinute) + ":" + String.valueOf(currentSecond));

        startIfs();
    }

    private void startIfs() {
        if(CurrentDay.equals("1")) {
            sunday();
        }else if (CurrentDay.equals("2")) {
            monTue();
        }else if ((CurrentDay.equals("3"))) {
            monTue();
        }else if ((CurrentDay.equals("4"))) {
            wedThu();
        }else if ((CurrentDay.equals("5"))) {
            wedThu();
        }else if ((CurrentDay.equals("6"))) {
            friSat();
        }else if ((CurrentDay.equals("7"))) {
            friSat();
        }
    }

    public void monTue() {
        if(currentHour < 9 && currentHour > 3) {
            webViewFood.loadUrl("https://dl.dropboxusercontent.com/u/72406826/Fira/Parrot/Food/Breakfast/MonTue%20Breakfast.html");
        }else if (currentHour > 9 && currentHour < 15) {
            webViewFood.loadUrl("https://dl.dropboxusercontent.com/u/72406826/Fira/Parrot/Food/Lunch/MonTue%20Lunch.html");
        }else if (currentHour > 15 && currentHour < 21) {
            webViewFood.loadUrl("https://dl.dropboxusercontent.com/u/72406826/Fira/Parrot/Food/Dinner/MonTue%20Dinner.html");
        }else {
            webViewFood.loadUrl("https://dl.dropboxusercontent.com/u/72406826/Fira/Parrot/Food/Snacks/MonTue%20Snacks.html");
        }
    }

    public void wedThu() {
        if(currentHour < 9 && currentHour > 3) {
            webViewFood.loadUrl("https://dl.dropboxusercontent.com/u/72406826/Fira/Parrot/Food/Breakfast/WedThu%20Breakfast.html");
        }else if (currentHour > 9 && currentHour < 15) {
            webViewFood.loadUrl("https://dl.dropboxusercontent.com/u/72406826/Fira/Parrot/Food/Lunch/WedThu%20Lunch.html");
        }else if (currentHour > 15 && currentHour < 21) {
            webViewFood.loadUrl("https://dl.dropboxusercontent.com/u/72406826/Fira/Parrot/Food/Dinner/WedThu%20Dinner.html");
        }else {
            webViewFood.loadUrl("https://dl.dropboxusercontent.com/u/72406826/Fira/Parrot/Food/Snacks/WedThu%20Snacks.html");
        }
    }

    public void friSat() {
        if(currentHour < 12 && currentHour > 3) {
            webViewFood.loadUrl("https://dl.dropboxusercontent.com/u/72406826/Fira/Parrot/Food/Breakfast/FriSat%20Breakfast.html");
        }else if (currentHour > 12 && currentHour < 15) {
            webViewFood.loadUrl("https://dl.dropboxusercontent.com/u/72406826/Fira/Parrot/Food/Lunch/FriSat%20Lunch.html");
        }else if (currentHour > 15 && currentHour < 23) {
            webViewFood.loadUrl("https://dl.dropboxusercontent.com/u/72406826/Fira/Parrot/Food/Dinner/FriSat%20Dinner.html");
        }else {
            webViewFood.loadUrl("https://dl.dropboxusercontent.com/u/72406826/Fira/Parrot/Food/Snacks/FriSat%20Snacks.html");
        }
    }

    public void sunday() {
        if(currentHour < 12 && currentHour > 3) {
            webViewFood.loadUrl("https://dl.dropboxusercontent.com/u/72406826/Fira/Parrot/Food/Breakfast/Sunday%20Breakfast.html");
        }else if (currentHour > 12 && currentHour < 15) {
            webViewFood.loadUrl("https://dl.dropboxusercontent.com/u/72406826/Fira/Parrot/Food/Lunch/Sunday%20Lunch.html");
        }else if (currentHour > 15 && currentHour < 23) {
            webViewFood.loadUrl("https://dl.dropboxusercontent.com/u/72406826/Fira/Parrot/Food/Dinner/Sunday%20Dinner.html");
        }else {
            webViewFood.loadUrl("https://dl.dropboxusercontent.com/u/72406826/Fira/Parrot/Food/Snacks/Sunday%20Snacks.html");
        }
    }
}
