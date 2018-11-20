package com.example.a10012826.practiceprojecttwo;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    Button red, blue, green, cyan, gray, magenta;
    LinearLayout parent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        red = findViewById(R.id.red);
        blue = findViewById(R.id.blue);
        green = findViewById(R.id.green);
        cyan = findViewById(R.id.cyan);
        gray = findViewById(R.id.gray);
        magenta = findViewById(R.id.magenta);
        parent = findViewById(R.id.parent);

        cyan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                parent.setBackgroundColor(Color.CYAN);
            }
        });
        gray.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                parent.setBackgroundColor(Color.GRAY);
            }
        });
        magenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                parent.setBackgroundColor(Color.MAGENTA);
            }
        });
        red.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cyan.setTextColor(Color.RED);
                gray.setTextColor(Color.RED);
                magenta.setTextColor(Color.RED);
            }
        });
        blue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cyan.setTextColor(Color.BLUE);
                gray.setTextColor(Color.BLUE);
                magenta.setTextColor(Color.BLUE);
            }
        });
        green.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                red.setTextColor(Color.GREEN);
                blue.setTextColor(Color.GREEN);
                green.setTextColor(Color.GREEN);
                cyan.setTextColor(Color.GREEN);
                gray.setTextColor(Color.GREEN);
                magenta.setTextColor(Color.GREEN);
            }
        });
    }
}
