package com.example.a10012826.quiz1;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button buttonred, buttonblue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonred = findViewById(R.id.id_button_RED);
        buttonblue = findViewById(R.id.id_button_BLUE);

        buttonred.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((Button)v).setTextColor(Color.RED);
            }
        });

        buttonblue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((Button)v).setTextColor(Color.BLUE);

                String bluetext = (String)buttonblue.getText();
                buttonred.setText(bluetext);
            }
        });

    }
}
