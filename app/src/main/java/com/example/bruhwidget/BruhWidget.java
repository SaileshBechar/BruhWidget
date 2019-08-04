package com.example.bruhwidget;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.VolumeProvider;
import android.util.Log;
import android.widget.RemoteViews;
import android.widget.Toast;

import static com.example.bruhwidget.config.SELECTED_BUTTON;
import static com.example.bruhwidget.config.SHARED_PRES;

/**
 * Implementation of App Widget functionality.
 */
public class BruhWidget extends AppWidgetProvider {
    public static String YOUR_AWESOME_ACTION = "bruh2";

    static void updateAppWidget(Context context, AppWidgetManager appWidgetManager,
                                int appWidgetId) {

        Intent intent = new Intent(context, BruhWidget.class);



//        SharedPreferences prefs = context.getSharedPreferences(SHARED_PRES, Context.MODE_PRIVATE);
//        String selectedButton = prefs.getString(SELECTED_BUTTON + appWidgetId, "bruh2");

        intent.setAction("bruh2");
        PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0, intent, 0);
        // Construct the RemoteViews object
        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.bruh_widget);
        views.setOnClickPendingIntent(R.id.bruh_button, pendingIntent);

        // Instruct the widget manager to update the widget
        appWidgetManager.updateAppWidget(appWidgetId, views);
    }


    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        // There may be multiple widgets active, so update all of them
        for (int appWidgetId : appWidgetIds) {

            updateAppWidget(context, appWidgetManager, appWidgetId);
        }


    }


    @Override
    public void onReceive(Context context, Intent intent) {
        super.onReceive(context, intent);
        if (intent.getAction().equals("bruh2")) {
            AudioManager am =
                    (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);

            am.setStreamVolume(
                    AudioManager.STREAM_MUSIC,
                    am.getStreamMaxVolume(AudioManager.STREAM_MUSIC),
                    0);
            Log.d("Widget", "Hit");
            MediaPlayer mp = MediaPlayer.create(context, R.raw.bruh);
            mp.start();

//            Log.d("Widget", (String) mp.getVolume);
//            mp.setVolume(0,0);
            //do some really cool stuff here
        }

        if (intent.getAction().equals("bruh50")) {
            AudioManager am =
                    (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);

            am.setStreamVolume(
                    AudioManager.STREAM_MUSIC,
                    am.getStreamMaxVolume(AudioManager.STREAM_MUSIC),
                    0);
            Log.d("Widget", "Bruh50");
            MediaPlayer mp = MediaPlayer.create(context, R.raw.bruh);
            mp.start();

//            Log.d("Widget", (String) mp.getVolume);
//            mp.setVolume(0,0);
            //do some really cool stuff here
        }
        Log.d("Widget", "else");
    }

    @Override
    public void onEnabled(Context context) {
        // Enter relevant functionality for when the first widget is created
    }

    @Override
    public void onDisabled(Context context) {
        // Enter relevant functionality for when the last widget is disabled
    }
}

