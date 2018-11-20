package com.example.a10012826.layoutquiz1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.EventListener;

public class MainActivity extends AppCompatActivity {

    Button button1, button2;
    TextView tv1, tv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        tv1 = findViewById(R.id.tv1);
        tv2 = findViewById(R.id.tv2);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tv1.getText().equals("Not Clicked")) {
                    tv1.setText("Clicked");
                } else {
                    tv1.setText("Not Clicked");
                }
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tv2.getText().equals("Not Clicked")) {
                    tv2.setText("Clicked");
                } else {
                    tv2.setText("Not Clicked");
                }
            }
        });

    }


}
