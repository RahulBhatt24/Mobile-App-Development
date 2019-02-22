package com.example.saicm.criticalquestionsquiz;

import android.content.Intent;
import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RadioGroup radioGroup;
    Button run;
    Button launch;
    TextView tvname;

    ConstraintLayout layout;

    int checked = 0;

    static final String RADIO_KEY = "RADIO KEY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroup = findViewById(R.id.radioGroup);
        run = findViewById(R.id.buttonrun);
        launch = findViewById(R.id.launch);
        layout = findViewById(R.id.layout);
        tvname = findViewById(R.id.tvname);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(checkedId) {
                    case R.id.radioButtonOne:
                        checked = 1;
                        break;
                    case R.id.radioButtonTwo:
                        checked = 2;
                        break;
                    case R.id.radioButtonThree:
                        checked = 3;
                        break;
                }
            }
        });

        run.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (checked) {
                    case 0:
                        Toast.makeText(MainActivity.this, "Select a Radio Button", Toast.LENGTH_LONG).show();
                    case 1:
                        Toast.makeText(MainActivity.this, "Toast Selected", Toast.LENGTH_LONG).show();
                        break;
                    case 2:
                        int random = (int)(Math.random()*3)+1;
                        if (random == 1) {
                            layout.setBackgroundColor(Color.RED);
                        } else if (random == 2){
                            layout.setBackgroundColor(Color.BLUE);
                        } else {
                            layout.setBackgroundColor(Color.GREEN);
                        }
                        break;
                    case 3:
                        tvname.setText(tvname.getText().toString().toUpperCase());
                        break;
                }
            }
        });

        launch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra(RADIO_KEY, checked);
                startActivity(intent);
            }
        });


    }
}
