package com.example.a10012826.practiceprojectone;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button button1, button2, button3, button4, button5;
    TextView tv1, tv2, tv3, tv4, tv5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);

        tv1 = findViewById(R.id.tv_button1);
        tv2 = findViewById(R.id.tv_button2);
        tv3 = findViewById(R.id.tv_button3);
        tv4 = findViewById(R.id.tv_button4);
        tv5 = findViewById(R.id.tv_button5);



        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((tv1.getText()).equals("OFF")) {
                    tv1.setText("ON");
                } else {
                    tv1.setText("OFF");
                }
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((tv2.getText()).equals("OFF")) {
                    tv2.setText("ON");
                } else {
                    tv2.setText("OFF");
                }
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((tv3.getText()).equals("OFF")) {
                    tv3.setText("ON");
                } else {
                    tv3.setText("OFF");
                }
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((tv4.getText()).equals("OFF")) {
                    tv4.setText("ON");
                } else {
                    tv4.setText("OFF");
                }
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((tv5.getText()).equals("OFF")) {
                    tv5.setText("ON");
                } else {
                    tv5.setText("OFF");
                }
            }
        });
    }
}
