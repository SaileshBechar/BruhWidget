package com.example.bruhwidget;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RemoteViews;

public class config extends AppCompatActivity {
    public static final String SHARED_PRES = "prefs";
    public static final String SELECTED_BUTTON = "0";

    private int appWidgetId = AppWidgetManager.INVALID_APPWIDGET_ID;
    private Button bruh2;
    private Button bruh50;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config);

        Intent configIntent = getIntent();
        Bundle extras = configIntent.getExtras();

        if (extras != null){
            appWidgetId = extras.getInt(AppWidgetManager.EXTRA_APPWIDGET_ID,
                                AppWidgetManager.INVALID_APPWIDGET_ID);
        }

        Intent resultValue = new Intent();
        resultValue.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, appWidgetId);
        setResult(RESULT_CANCELED, resultValue);

        if (appWidgetId == AppWidgetManager.INVALID_APPWIDGET_ID){
            finish();
        }

        bruh2 = findViewById(R.id.bruh2_button);
        bruh50 = findViewById(R.id.bruh50_button);
    }

    public void confimConfiguration(View v){
        final AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(this);

        final Intent intent = new Intent(this, BruhWidget.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);

        final RemoteViews views = new RemoteViews(this.getPackageName(), R.layout.bruh_widget);
        views.setOnClickPendingIntent(R.id.bruh_button, pendingIntent);


        bruh2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appWidgetManager.updateAppWidget(appWidgetId, views);
                SharedPreferences prefs = getSharedPreferences(SHARED_PRES, MODE_PRIVATE);
                SharedPreferences.Editor editor = prefs.edit();
                editor.putString(SELECTED_BUTTON + appWidgetId, "bruh2");
                editor.apply();

                Intent resultValue = new Intent();
                resultValue.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, appWidgetId);
                setResult(RESULT_OK, resultValue);

                finish();

            }
        });

        bruh50.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appWidgetManager.updateAppWidget(appWidgetId, views);
                SharedPreferences prefs = getSharedPreferences(SHARED_PRES, MODE_PRIVATE);
                SharedPreferences.Editor editor = prefs.edit();
                editor.putString(SELECTED_BUTTON + appWidgetId, "bruh2");
                editor.apply();

                Intent resultValue = new Intent();
                resultValue.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, appWidgetId);
                setResult(RESULT_OK, resultValue);

                finish();
            }
        });


    }
}
