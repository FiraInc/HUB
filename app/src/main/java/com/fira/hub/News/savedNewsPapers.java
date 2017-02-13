package com.fira.hub.News;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.fira.hub.R;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import static android.R.attr.bitmap;

/**
 * Created by Johannett321 on 11.02.2017.
 */

public class savedNewsPapers extends Activity implements AdapterView.OnItemClickListener {

    File file;
    StringBuilder text;

    String tempFolder = "Fira/HUB/temp/";
    String personalInformationFolder = "Fira/HUB/PersonalInformation/";
    String favoriteAppsGeneral = "Fira/HUB/FavoriteApps/General/";

    static String selectedBoxContent = "";
    static int currentNumber = 1;

    static ArrayList<String> where;
    GridView myGrid;

    Boolean createOnFinished = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.saved_news_papers);

        createON();
    }

    private void createON() {
        if (createOnFinished) {
            createOnFinished = false;
            currentNumber = 1;
            myGrid = (GridView) findViewById(R.id.gridView);
            myGrid.setOnItemClickListener(this);
            where = new ArrayList<>();
            loadSubscriptions();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        createON();
    }

    @Override
    protected void onPause() {
        super.onPause();
        currentNumber = 1;
    }

    private void loadSubscriptions() {
        file = new File(Environment.getExternalStorageDirectory(),personalInformationFolder + "newsSubscription" + Integer.toString(currentNumber) + ".txt");

        if (file.exists()) {
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
                Log.e("got called", "loadSusbscription is not empty");
                where.add(text.toString());
            }

            Log.e("got called", "loadSubscription");


            text.setLength(0);
            currentNumber = currentNumber + 1;
            loadSubscriptions();
        }else {
            Log.e("got called", "loadSusbscription doesnt exist");
            myGrid.setAdapter(new VivzAdapter(this));
            Log.e("got called", where.toString());
            createOnFinished = true;
        }
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        NewsHomeExperimental.selectedBoxContent = where.get(position);
        Intent intent = new Intent(this, newsWebLoader.class);
        startActivity(intent);
        overridePendingTransition(R.animator.pull_in_right, R.animator.push_out_left);
    }
}



    class VivzAdapter extends BaseAdapter {

        ArrayList<String> list;
        Context context;

        VivzAdapter(Context context) {
            Log.e("got called", "VivzAdapter");
            this.context = context;
            list = savedNewsPapers.where;
        }

        @Override
        public int getCount() {
            Log.e("got called", "getCount");
            return list.size();
        }

        @Override
        public Object getItem(int i) {
            Log.e("got called", "getItem");
            return list.get(i);
        }

        @Override
        public long getItemId(int i) {
            Log.e("got called", "getItemID");
            return i;
        }

        class ViewHolder {
            ImageView myImageView;
            ViewHolder(View v) {
                Log.e("got called", "ViewHolder");
                myImageView = (ImageView) v.findViewById(R.id.imageView);
                Log.e("got called", "ViewHolder found image");
            }
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {

            Log.e("got called", "getView");
            View row = view;
            ViewHolder holder = null;
            if(row == null) {
                LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                row = inflater.inflate(R.layout.single_item, viewGroup, false);
                holder = new ViewHolder(row);
                row.setTag(holder);
            }else {
                holder = (ViewHolder) row.getTag();
            }


            holder.myImageView.setImageResource(R.drawable.loading_news);
            NewsSites.currentWord = list.get(i);
            NewsSites.calculate();
            new DownloadImageTask(holder.myImageView).execute(NewsSites.currentImage);



            return row;
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
                    e.printStackTrace();
                }
                return mIcon11;
            }

            protected void onPostExecute(Bitmap result) {
                Drawable d = new BitmapDrawable(result);
                bmImage.setImageResource(android.R.color.transparent);
                bmImage.setBackground(d);
            }
        }
    }


