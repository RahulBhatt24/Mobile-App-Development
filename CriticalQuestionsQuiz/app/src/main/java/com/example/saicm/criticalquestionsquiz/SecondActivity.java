package com.example.saicm.criticalquestionsquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    TextView tvselected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        tvselected = findViewById(R.id.tvselected);

        int radio = getIntent().getIntExtra(MainActivity.RADIO_KEY, 0);

        switch (radio) {
            case 0:
                tvselected.setText("No Radio Button Selected");
                break;
            case 1:
                tvselected.setText("Toast Radio Button Selected");
                break;
            case 2:
                tvselected.setText("Change Color Radio Button Selected");
                break;
            case 3:
                tvselected.setText("Uppercase Radio Button Selected");
                break;
        }

//        if (radio == 0) {
//            tvselected.setText("No Radio Button Selected");
//        } else if {
//            tvselected.setText("Toast Radio Button Selected");
//        }

    }
}
