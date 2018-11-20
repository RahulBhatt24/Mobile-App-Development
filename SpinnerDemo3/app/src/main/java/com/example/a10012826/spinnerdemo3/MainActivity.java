package com.example.a10012826.spinnerdemo3;

import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    TextView textView;
    TextView port;
    TextView land;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.id_textview);
        port = findViewById(R.id.id_portrait);
        land = findViewById(R.id.id_landscape);

        textView.setText("Demo");

        Log.d(TAG, getResources().getConfiguration().orientation+"");

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            land.setText("LANDSCAPE");
        }

//        if (land!= null) {
//            land.setText("LANDSCAPE");
//        }
    }
}
