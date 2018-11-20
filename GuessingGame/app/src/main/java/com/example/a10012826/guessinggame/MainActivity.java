package com.example.a10012826.guessinggame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    RadioGroup radioGroup;
    ImageView imageView;
    TextView tvresult;
    TextView tvtotal;
    Button button;
    int user = 0;
    int cpu = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroup = findViewById(R.id.radioGroup);
        imageView = findViewById(R.id.imageView);
        tvresult = findViewById(R.id.tvresult);
        tvtotal = findViewById(R.id.tvtotal);
        button = findViewById(R.id.button);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.radioButton:
                        user = 1;
                        break;
                    case R.id.radioButton2:
                        user = 2;
                        break;
                }

                tvtotal.setText("Total");
                tvresult.setText("Result");
                imageView.setImageResource(R.drawable.cpu);
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (user == 0) {
                    Toast.makeText(MainActivity.this, "Error: Click a number.", Toast.LENGTH_LONG).show();
                } else {
                    cpu = (int)(Math.random()*2)+1;
                    if (cpu == 1) {
                        imageView.setImageResource(R.drawable.one);
                    } else if (cpu == 2) {
                        imageView.setImageResource(R.drawable.two);
                    }

                    tvtotal.setText("Total is " + (user + cpu));
                    if ((user + cpu) % 2 == 1) {
                        tvresult.setText("You Lose.");
                    } else if ((user + cpu) % 2 == 0) {
                        tvresult.setText("You Win!");
                    }
                }
            }
        });


    }
}
