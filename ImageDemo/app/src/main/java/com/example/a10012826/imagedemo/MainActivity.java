package com.example.a10012826.imagedemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

        RadioGroup radioGroup;
        ImageView imageViewLeft;
        ImageView imageViewRight;
        TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageViewLeft = findViewById(R.id.imageLeft);
        imageViewRight = findViewById(R.id.imageRight);
        radioGroup = findViewById(R.id.radioGroup);

        imageViewRight.setImageResource(R.drawable.vader);
        textView = findViewById(R.id.textView);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.buttonleft) {
                    textView.setText("Luke");
                }
                if (checkedId == R.id.buttonright) {
                    textView.setText("Vader");
                    Toast toast = Toast.makeText(MainActivity.this, "Vader", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.TOP|Gravity.LEFT,0, 0);
                    toast.show();
                }
            }
        });
    }
}
