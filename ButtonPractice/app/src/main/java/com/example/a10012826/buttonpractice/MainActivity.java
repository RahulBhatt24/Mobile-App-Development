package com.example.a10012826.buttonpractice;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button button1;
    Button button2;
    Button button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = findViewById(R.id.id_button_changeTextColor);
        button2 = findViewById(R.id.id_button_resizeTextBox);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button2.setTextSize(16);
            }
        });
    }

    public void buttonClick (View view) {
        button1.setTextColor(Color.BLUE);
    }

}
