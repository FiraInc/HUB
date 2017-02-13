package com.fira.hub.News;

import android.util.Log;
import android.widget.TextView;

/**
 * Created by Johannett321 on 12.02.2017.
 */

public class NewsSites {
    static String currentWord = "";
    static String currentImage = "";
    static String currentLink = "";

    static String emptyImage = "https://dl.dropboxusercontent.com/u/72406826/Fira/HUB/Bilder/NewsLogos/test.png";
    static String emptyLink = "http://www.google.com";

    static String linkTV2 = "http://www.tv2.no/";
    static String imageTV2 = "https://dl.dropboxusercontent.com/u/72406826/Fira/HUB/Bilder/NewsLogos/tv2.png";

    static String linkBBC = "http://www.bbc.com/";
    static String imageBBC = "https://dl.dropboxusercontent.com/u/72406826/Fira/HUB/Bilder/NewsLogos/bbc.png";

    static String linkCNN = "http://www.cnn.com/";
    static String imageCNN = "https://dl.dropboxusercontent.com/u/72406826/Fira/HUB/Bilder/NewsLogos/cnn.png";
    
    static String linkGOOGLE = "https://news.google.com/";
    static String imageGOOGLE = "https://dl.dropboxusercontent.com/u/72406826/Fira/HUB/Bilder/NewsLogos/google.png";

    static String linkTELEGRAPH = emptyLink;
    static String imageTELEGRAPH = emptyImage;

    static String linkTHESUN = emptyLink;
    static String imageTHESUN = emptyImage;

    static String linkEXPRESS = emptyLink;
    static String imageEXPRESS = emptyImage;

    static String linkMSN = emptyLink;
    static String imageMSN = emptyImage;

    static String linkMIRROR = emptyLink;
    static String imageMIRROR = emptyImage;

    public static void calculate() {
        String converted = currentWord.toUpperCase();
        if (converted.contains("BBC")) {
            currentImage = imageBBC;
            if (!converted.startsWith("HTTP")) {
                currentLink = linkBBC;
            }
        }else if (converted.contains("CNN")){
            currentImage = imageCNN;
            if (!converted.startsWith("HTTP")) {
                currentLink = linkCNN;
            }
        }else if (converted.contains("TV2")){
            currentImage = imageTV2;
            if (!converted.startsWith("HTTP")) {
                currentLink = linkTV2;
            }
        }else if (converted.contains("GOOGLE")){
            currentImage = imageGOOGLE;
            if (!converted.startsWith("HTTP")) {
                currentLink = linkGOOGLE;
            }
        }else {
            currentImage = emptyImage;
        }

        if (converted.startsWith("HTTP")) {
            Log.e("CurrentWord starts", "It starts with HTTP");
            currentLink = currentWord;
        }


        /*else if (currentWord.equals("BBC")){
            currentImage = "";
            currentLink = "";
        }
        */
    }
}
