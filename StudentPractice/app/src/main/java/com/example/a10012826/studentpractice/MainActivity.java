package com.example.a10012826.studentpractice;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RadioGroup radioGroup;
    TextView tvtop;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroup = findViewById(R.id.radioGroup);
        tvtop = findViewById(R.id.tvtop);
        imageView = findViewById(R.id.imageView);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.harry) {
                    imageView.setImageResource(R.drawable.harry);
                    Toast toast = Toast.makeText(MainActivity.this, "You have selected Harry!", Toast.LENGTH_SHORT);
                    toast.show();
                }
                if (checkedId == R.id.hermione) {
                    imageView.setImageResource(R.drawable.hermione);
                    Toast toast = Toast.makeText(MainActivity.this, "You have selected Hermione!", Toast.LENGTH_SHORT);
                    toast.show();
                }
                if (checkedId == R.id.ron) {
                    imageView.setImageResource(R.drawable.ron);
                    Toast toast = Toast.makeText(MainActivity.this, "You have selected Ron!", Toast.LENGTH_SHORT);
                    toast.show();
                }

            }
        });
    }
}
