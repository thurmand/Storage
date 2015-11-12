package com.byui.andrewt.storage;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int count;
    private TextView textEl;
    public static final String PREFS_NAME = "MyPreferenceFile";
    private SharedPreferences counter;
    private SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textEl = (TextView) findViewById(R.id.textView);
        counter = getSharedPreferences(PREFS_NAME, 0);
        count = Integer.parseInt(counter.getString("savedCount", String.valueOf(0)));
        textEl.setText(String.valueOf(count));
    }

    public void advanceText(View v){
        count++;
        textEl.setText(String.valueOf(count));
    }

    public void saveCount(View v){
        counter = getSharedPreferences(PREFS_NAME, 0);
        editor = counter.edit();
        editor.putString("savedCount", String.valueOf(count));
        editor.commit();
    }


}
