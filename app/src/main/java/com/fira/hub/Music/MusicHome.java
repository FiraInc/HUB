package com.fira.hub.Music;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.fira.hub.R;

import java.util.Calendar;

public class MusicHome extends Activity {

    Boolean doubleback = false;
    int currentHour;
    int currentDay;

    TextView PopularPlaylistsText;
    TextView popularPlaylistsTextDescription;
    ImageView moreButtonTimePlaylists;

    ImageView FirstAlbum;
    ImageView SecondAlbum;
    ImageView ThirdAlbum;

    String whatToLaunch = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.music_home);

        PopularPlaylistsText = (TextView) findViewById(R.id.PopularPlaylistsText);
        popularPlaylistsTextDescription = (TextView) findViewById(R.id.popularPlaylistsTextDescription);
        moreButtonTimePlaylists = (ImageView) findViewById(R.id.moreButtonTimePlaylists);

        FirstAlbum = (ImageView) findViewById(R.id.SecondFirstApp);
        SecondAlbum = (ImageView) findViewById(R.id.SecondSecondApp);
        ThirdAlbum = (ImageView) findViewById(R.id.SecondThirdApp);
        loadTime();


    }

    @Override
    protected void onResume() {
        super.onResume();
        loadTime();
    }

    private void loadTime() {
        Calendar c = Calendar.getInstance();
        currentHour = c.get(Calendar.HOUR_OF_DAY);
        currentDay = c.get(Calendar.DAY_OF_WEEK);
        setTime();
    }

    public void setTime() {
        Log.e("ERROR", "setTimeLoaded");
        if (currentDay < 6 && currentDay > 1) {
            if (currentHour < 5) {
                PopularPlaylistsText.setText(R.string.sleep_playlists);
                popularPlaylistsTextDescription.setText(R.string.playlists_for_sleep);
                whatToLaunch = "sleep";
                FirstAlbum.setImageDrawable(getResources().getDrawable(R.drawable.tuck_me_in));
                SecondAlbum.setImageDrawable(getResources().getDrawable(R.drawable.peaceful_piano));
                ThirdAlbum.setImageDrawable(getResources().getDrawable(R.drawable.late_night_drinks));
            }else if (currentHour >= 5 && currentHour < 9) {
                PopularPlaylistsText.setText(R.string.morning_playlists);
                popularPlaylistsTextDescription.setText(R.string.peaceful_morning);
                whatToLaunch = "morning";
                FirstAlbum.setImageDrawable(getResources().getDrawable(R.drawable.happy_hits));
                SecondAlbum.setImageDrawable(getResources().getDrawable(R.drawable.tuck_me_in));
                ThirdAlbum.setImageDrawable(getResources().getDrawable(R.drawable.relax_and_unwind));
            }else if (currentHour >= 9 && currentHour < 15) {
                PopularPlaylistsText.setText(R.string.focus_playlists);
                popularPlaylistsTextDescription.setText(R.string.better_focus);
                whatToLaunch = "focus";
                FirstAlbum.setImageDrawable(getResources().getDrawable(R.drawable.deep_focus_playlist));
                SecondAlbum.setImageDrawable(getResources().getDrawable(R.drawable.peaceful_piano));
                ThirdAlbum.setImageDrawable(getResources().getDrawable(R.drawable.chill_out_brain_playlist));
            }else if (currentHour >= 15 && currentHour < 18) {
                Log.e("ERROR", "Time is 15 or more");
                PopularPlaylistsText.setText(R.string.latest_and_greatest);
                popularPlaylistsTextDescription.setText(R.string.latest_and_greatest_playlists);
                whatToLaunch = "pop";
                FirstAlbum.setImageDrawable(getResources().getDrawable(R.drawable.global_top_fifty));
                SecondAlbum.setImageDrawable(getResources().getDrawable(R.drawable.global_viral_fifty));
                ThirdAlbum.setImageDrawable(getResources().getDrawable(R.drawable.hits_hits_hits_with_title));
            }else if (currentHour >= 18 && currentHour < 21) {
                PopularPlaylistsText.setText(R.string.chill_title);
                popularPlaylistsTextDescription.setText(R.string.chill_evening);
                whatToLaunch = "chill";
                FirstAlbum.setImageDrawable(getResources().getDrawable(R.drawable.chill_hits));
                SecondAlbum.setImageDrawable(getResources().getDrawable(R.drawable.deep_house_relax));
                ThirdAlbum.setImageDrawable(getResources().getDrawable(R.drawable.brain_food_playlist));
            }else if (currentHour >= 21) {
                PopularPlaylistsText.setText(R.string.sleep_playlists);
                popularPlaylistsTextDescription.setText(R.string.playlists_for_sleep);
                whatToLaunch = "sleep";
                FirstAlbum.setImageDrawable(getResources().getDrawable(R.drawable.tuck_me_in));
                SecondAlbum.setImageDrawable(getResources().getDrawable(R.drawable.peaceful_piano));
                ThirdAlbum.setImageDrawable(getResources().getDrawable(R.drawable.brain_food_playlist));
            }else {
                Log.e("ERROR", "WHAT THE F?");
            }
        }else if (currentDay == 1) {
            if (currentHour < 5) {
                PopularPlaylistsText.setText(R.string.sleep_playlists);
                popularPlaylistsTextDescription.setText(R.string.playlists_for_sleep);
                whatToLaunch = "sleep";
                FirstAlbum.setImageDrawable(getResources().getDrawable(R.drawable.tuck_me_in));
                SecondAlbum.setImageDrawable(getResources().getDrawable(R.drawable.peaceful_piano));
                ThirdAlbum.setImageDrawable(getResources().getDrawable(R.drawable.late_night_drinks));
            }else if (currentHour >= 5 && currentHour < 11) {
                PopularPlaylistsText.setText(R.string.morning_playlists);
                popularPlaylistsTextDescription.setText(R.string.peaceful_morning);
                whatToLaunch = "morning";
                FirstAlbum.setImageDrawable(getResources().getDrawable(R.drawable.happy_hits));
                SecondAlbum.setImageDrawable(getResources().getDrawable(R.drawable.tuck_me_in));
                ThirdAlbum.setImageDrawable(getResources().getDrawable(R.drawable.relax_and_unwind));
            }else if (currentHour >= 11 && currentHour < 18) {
                Log.e("ERROR", "Time is 15 or more");
                PopularPlaylistsText.setText(R.string.latest_and_greatest);
                popularPlaylistsTextDescription.setText(R.string.latest_and_greatest_playlists);
                whatToLaunch = "pop";
                FirstAlbum.setImageDrawable(getResources().getDrawable(R.drawable.global_top_fifty));
                SecondAlbum.setImageDrawable(getResources().getDrawable(R.drawable.global_viral_fifty));
                ThirdAlbum.setImageDrawable(getResources().getDrawable(R.drawable.hits_hits_hits_with_title));
            }else if (currentHour >= 18 && currentHour < 21) {
                PopularPlaylistsText.setText(R.string.chill_title);
                popularPlaylistsTextDescription.setText(R.string.chill_evening);
                whatToLaunch = "chill";
                FirstAlbum.setImageDrawable(getResources().getDrawable(R.drawable.chill_hits));
                SecondAlbum.setImageDrawable(getResources().getDrawable(R.drawable.deep_house_relax));
                ThirdAlbum.setImageDrawable(getResources().getDrawable(R.drawable.brain_food_playlist));
            }else if (currentHour >= 21) {
                PopularPlaylistsText.setText(R.string.sleep_playlists);
                popularPlaylistsTextDescription.setText(R.string.playlists_for_sleep);
                whatToLaunch = "sleep";
                FirstAlbum.setImageDrawable(getResources().getDrawable(R.drawable.tuck_me_in));
                SecondAlbum.setImageDrawable(getResources().getDrawable(R.drawable.peaceful_piano));
                ThirdAlbum.setImageDrawable(getResources().getDrawable(R.drawable.brain_food_playlist));
            }else {
                Log.e("ERROR", "WHAT THE F?");
            }
        }else if (currentDay == 6) {
            if (currentHour < 5) {
                PopularPlaylistsText.setText(R.string.sleep_playlists);
                popularPlaylistsTextDescription.setText(R.string.playlists_for_sleep);
                whatToLaunch = "sleep";
                FirstAlbum.setImageDrawable(getResources().getDrawable(R.drawable.tuck_me_in));
                SecondAlbum.setImageDrawable(getResources().getDrawable(R.drawable.peaceful_piano));
                ThirdAlbum.setImageDrawable(getResources().getDrawable(R.drawable.late_night_drinks));
            } else if (currentHour >= 5 && currentHour < 9) {
                PopularPlaylistsText.setText(R.string.morning_playlists);
                popularPlaylistsTextDescription.setText(R.string.peaceful_morning);
                whatToLaunch = "morning";
                FirstAlbum.setImageDrawable(getResources().getDrawable(R.drawable.happy_hits));
                SecondAlbum.setImageDrawable(getResources().getDrawable(R.drawable.tuck_me_in));
                ThirdAlbum.setImageDrawable(getResources().getDrawable(R.drawable.relax_and_unwind));
            } else if (currentHour >= 9 && currentHour < 15) {
                PopularPlaylistsText.setText(R.string.focus_playlists);
                popularPlaylistsTextDescription.setText(R.string.better_focus);
                whatToLaunch = "focus";
                FirstAlbum.setImageDrawable(getResources().getDrawable(R.drawable.deep_focus_playlist));
                SecondAlbum.setImageDrawable(getResources().getDrawable(R.drawable.peaceful_piano));
                ThirdAlbum.setImageDrawable(getResources().getDrawable(R.drawable.chill_out_brain_playlist));
            } else if (currentHour >= 15 && currentHour < 18) {
                Log.e("ERROR", "Time is 15 or more");
                PopularPlaylistsText.setText(R.string.latest_and_greatest);
                popularPlaylistsTextDescription.setText(R.string.latest_and_greatest_playlists);
                whatToLaunch = "pop";
                FirstAlbum.setImageDrawable(getResources().getDrawable(R.drawable.global_top_fifty));
                SecondAlbum.setImageDrawable(getResources().getDrawable(R.drawable.global_viral_fifty));
                ThirdAlbum.setImageDrawable(getResources().getDrawable(R.drawable.hits_hits_hits_with_title));
            } else if (currentHour >= 18 && currentHour < 23) {
                PopularPlaylistsText.setText(R.string.its_friday);
                popularPlaylistsTextDescription.setText(R.string.party_and_chill);
                whatToLaunch = "party";
                FirstAlbum.setImageDrawable(getResources().getDrawable(R.drawable.party_up_titled));
                SecondAlbum.setImageDrawable(getResources().getDrawable(R.drawable.late_night_drinks));
                ThirdAlbum.setImageDrawable(getResources().getDrawable(R.drawable.dancefloor_hits));
            } else if (currentHour >= 23) {
                PopularPlaylistsText.setText(R.string.sleep_playlists);
                popularPlaylistsTextDescription.setText(R.string.playlists_for_sleep);
                whatToLaunch = "sleep";
                FirstAlbum.setImageDrawable(getResources().getDrawable(R.drawable.tuck_me_in));
                SecondAlbum.setImageDrawable(getResources().getDrawable(R.drawable.peaceful_piano));
                ThirdAlbum.setImageDrawable(getResources().getDrawable(R.drawable.brain_food_playlist));
            }

        } else if (currentDay == 6) {
            if (currentHour < 5) {
                PopularPlaylistsText.setText(R.string.sleep_playlists);
                popularPlaylistsTextDescription.setText(R.string.playlists_for_sleep);
                whatToLaunch = "sleep";
                FirstAlbum.setImageDrawable(getResources().getDrawable(R.drawable.tuck_me_in));
                SecondAlbum.setImageDrawable(getResources().getDrawable(R.drawable.peaceful_piano));
                ThirdAlbum.setImageDrawable(getResources().getDrawable(R.drawable.late_night_drinks));
            } else if (currentHour >= 5 && currentHour < 9) {
                PopularPlaylistsText.setText(R.string.morning_playlists);
                popularPlaylistsTextDescription.setText(R.string.peaceful_morning);
                whatToLaunch = "morning";
                FirstAlbum.setImageDrawable(getResources().getDrawable(R.drawable.happy_hits));
                SecondAlbum.setImageDrawable(getResources().getDrawable(R.drawable.tuck_me_in));
                ThirdAlbum.setImageDrawable(getResources().getDrawable(R.drawable.relax_and_unwind));
            } else if (currentHour >= 9 && currentHour < 15) {
                PopularPlaylistsText.setText(R.string.focus_playlists);
                popularPlaylistsTextDescription.setText(R.string.better_focus);
                whatToLaunch = "focus";
                FirstAlbum.setImageDrawable(getResources().getDrawable(R.drawable.deep_focus_playlist));
                SecondAlbum.setImageDrawable(getResources().getDrawable(R.drawable.peaceful_piano));
                ThirdAlbum.setImageDrawable(getResources().getDrawable(R.drawable.chill_out_brain_playlist));
            } else if (currentHour >= 15 && currentHour < 18) {
                Log.e("ERROR", "Time is 15 or more");
                PopularPlaylistsText.setText(R.string.latest_and_greatest);
                popularPlaylistsTextDescription.setText(R.string.latest_and_greatest_playlists);
                whatToLaunch = "pop";
                FirstAlbum.setImageDrawable(getResources().getDrawable(R.drawable.global_top_fifty));
                SecondAlbum.setImageDrawable(getResources().getDrawable(R.drawable.global_viral_fifty));
                ThirdAlbum.setImageDrawable(getResources().getDrawable(R.drawable.hits_hits_hits_with_title));
            } else if (currentHour >= 18 && currentHour < 23) {
                PopularPlaylistsText.setText(R.string.its_friday);
                popularPlaylistsTextDescription.setText(R.string.party_and_chill);
                whatToLaunch = "party";
                FirstAlbum.setImageDrawable(getResources().getDrawable(R.drawable.party_up_titled));
                SecondAlbum.setImageDrawable(getResources().getDrawable(R.drawable.late_night_drinks));
                ThirdAlbum.setImageDrawable(getResources().getDrawable(R.drawable.dancefloor_hits));
            } else if (currentHour >= 23) {
                PopularPlaylistsText.setText(R.string.sleep_playlists);
                popularPlaylistsTextDescription.setText(R.string.playlists_for_sleep);
                whatToLaunch = "sleep";
                FirstAlbum.setImageDrawable(getResources().getDrawable(R.drawable.tuck_me_in));
                SecondAlbum.setImageDrawable(getResources().getDrawable(R.drawable.peaceful_piano));
                ThirdAlbum.setImageDrawable(getResources().getDrawable(R.drawable.brain_food_playlist));
            } else {
                Log.e("ERROR", "WHAT THE F?");
            }
        } else if (currentDay == 7) {
            if (currentHour < 6) {
                PopularPlaylistsText.setText(R.string.sleep_playlists);
                popularPlaylistsTextDescription.setText(R.string.playlists_for_sleep);
                whatToLaunch = "sleep";
                FirstAlbum.setImageDrawable(getResources().getDrawable(R.drawable.tuck_me_in));
                SecondAlbum.setImageDrawable(getResources().getDrawable(R.drawable.peaceful_piano));
                ThirdAlbum.setImageDrawable(getResources().getDrawable(R.drawable.late_night_drinks));
            } else if (currentHour >= 6 && currentHour < 11) {
                PopularPlaylistsText.setText(R.string.morning_playlists);
                popularPlaylistsTextDescription.setText(R.string.peaceful_morning);
                whatToLaunch = "morning";
                FirstAlbum.setImageDrawable(getResources().getDrawable(R.drawable.happy_hits));
                SecondAlbum.setImageDrawable(getResources().getDrawable(R.drawable.tuck_me_in));
                ThirdAlbum.setImageDrawable(getResources().getDrawable(R.drawable.relax_and_unwind));
            } else if (currentHour >= 11 && currentHour < 18) {
                PopularPlaylistsText.setText(R.string.latest_and_greatest);
                popularPlaylistsTextDescription.setText(R.string.latest_and_greatest_playlists);
                whatToLaunch = "pop";
                FirstAlbum.setImageDrawable(getResources().getDrawable(R.drawable.global_top_fifty));
                SecondAlbum.setImageDrawable(getResources().getDrawable(R.drawable.global_viral_fifty));
                ThirdAlbum.setImageDrawable(getResources().getDrawable(R.drawable.hits_hits_hits_with_title));
            } else if (currentHour >= 18 && currentHour < 23) {
                PopularPlaylistsText.setText(R.string.its_saturday);
                popularPlaylistsTextDescription.setText(R.string.party_and_chill);
                whatToLaunch = "party";
                FirstAlbum.setImageDrawable(getResources().getDrawable(R.drawable.party_up_titled));
                SecondAlbum.setImageDrawable(getResources().getDrawable(R.drawable.late_night_drinks));
                ThirdAlbum.setImageDrawable(getResources().getDrawable(R.drawable.dancefloor_hits));
            } else if (currentHour >= 23) {
                PopularPlaylistsText.setText(R.string.sleep_playlists);
                popularPlaylistsTextDescription.setText(R.string.playlists_for_sleep);
                whatToLaunch = "sleep";
                FirstAlbum.setImageDrawable(getResources().getDrawable(R.drawable.tuck_me_in));
                SecondAlbum.setImageDrawable(getResources().getDrawable(R.drawable.peaceful_piano));
                ThirdAlbum.setImageDrawable(getResources().getDrawable(R.drawable.brain_food_playlist));
            } else {
                Log.e("ERROR", "WHAT THE F?");
            }
        }
    }
    @Override
    public void onBackPressed() {
        if (doubleback) {
            super.onBackPressed();
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
    }

    public void spotifyButton (View view) {
        Intent launchIntent = getPackageManager().getLaunchIntentForPackage("com.spotify.music");
        if (launchIntent != null) {
            startActivity(launchIntent);
        }else {
            Toast.makeText(this, "Please install spotify", Toast.LENGTH_LONG).show();
        }
    }

    public void soundcloudButton (View view) {
        Intent launchIntent = getPackageManager().getLaunchIntentForPackage("com.soundcloud.android");
        if (launchIntent != null) {
            startActivity(launchIntent);
        }else {
            Toast.makeText(this, "Please install SoundCloud", Toast.LENGTH_LONG).show();
        }
    }

    public void playmusicButton (View view) {
        Intent intent=Intent.makeMainSelectorActivity(Intent.ACTION_MAIN,
                Intent.CATEGORY_APP_MUSIC);
        startActivity(intent);

        //https://open.spotify.com/user/spotify_norway_/playlist/1xiZVSQUHoCfAMr3TIYqPP
    }

    public void PopularMusicApps (View view) {
        Intent intent = new Intent(this, MusicApps.class);
        startActivity(intent);
    }

    public void sleepGenre(View view) {
        Intent intent = new Intent(this, GenreSleep.class);
        startActivity(intent);
    }

    public void Genres(View view) {
        Intent intent = new Intent(this, Genres.class);
        startActivity(intent);
    }

    public void tuckMeIn (View view) {
        String thirdAlbum = "https://open.spotify.com/user/spotify_norway_/playlist/1xiZVSQUHoCfAMr3TIYqPP";
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(thirdAlbum));
        startActivity(browserIntent);
    }

    public void peacefulPiano (View view) {
        String thirdAlbum = "https://open.spotify.com/user/spotify/playlist/63dDpdoVHvx5RkK87g4LKk";
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(thirdAlbum));
        startActivity(browserIntent);
    }

    public void lateNightDrinks (View view) {
        String thirdAlbum = "https://open.spotify.com/user/spotify_norway_/playlist/2FPT17DoFCEpsAyFkhFzlM";
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(thirdAlbum));
        startActivity(browserIntent);
    }

    public void popGenre(View view) {
        Intent intent = new Intent(this, GenrePop.class);
        startActivity(intent);
    }

    public void focusGenre (View view) {
        Intent intent = new Intent(this, GenreFocus.class);
        startActivity(intent);
    }

    public void moodGenre(View view) {
        Intent intent =new Intent(this, GenreMood.class);
        startActivity(intent);
    }
}
