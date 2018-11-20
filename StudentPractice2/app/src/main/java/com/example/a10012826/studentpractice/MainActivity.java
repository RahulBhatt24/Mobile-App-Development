package com.example.a10012826.studentpractice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RadioGroup volumegroup;
    RadioGroup rpsgroup;
    RadioButton rock;
    RadioButton paper;
    RadioButton scissor;
    TextView tvwinner;
    TextView tvscore;
    ImageView image;
    Button play;
    int user;
    int cpu;
    int userscore;
    int cpuscore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvwinner = findViewById(R.id.tvwinner);
        tvscore = findViewById(R.id.tvscore);
        volumegroup = findViewById(R.id.volume);
        rpsgroup = findViewById(R.id.rps);
        image = findViewById(R.id.imagepicture);
        play = findViewById(R.id.button);
        rock = findViewById(R.id.rock);
        paper = findViewById(R.id.paper);
        scissor = findViewById(R.id.scissor);

        volumegroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.volumefour:
                        Toast.makeText(MainActivity.this, "WARNING: HIGH VOLUME", Toast.LENGTH_SHORT).show();
                        T
                }
            }
        });

        rpsgroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rock:
                        user = 1;
                        break;
                    case R.id.paper:
                        user = 2;
                        break;
                    case R.id.scissor:
                        user = 3;
                        break;
                    default:
                        user = 0;
                }
            }
        });

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                cpu = (int)(Math.random()*3+1);

                switch (cpu) {
                    case 1:
                        image.setImageResource(R.drawable.rock);
                        break;
                    case 2:
                        image.setImageResource(R.drawable.paper);
                        break;
                    case 3:
                        image.setImageResource(R.drawable.scissor);
                        break;
                    default:
                        image.setImageResource(R.drawable.playrps);
                }

                if (user == 0) {
                  tvwinner.setText("Make a Selection");
                } else if (user == 1 && cpu == 2) {
                    tvwinner.setText("You Lose.");
                    cpuscore++;
                } else if (user == 1 && cpu == 3) {
                    userscore++;
                    tvwinner.setText("You Win!");
                } else if (user == 1 && cpu == 3) {
                    tvwinner.setText("It's a tie!");
                } else if (user == 2 && cpu == 1) {
                    userscore++;
                    tvwinner.setText("You Win!");
                } else if (user == 2 && cpu == 2) {
                    tvwinner.setText("It's a tie!");
                } else if (user == 2 && cpu == 3) {
                    cpuscore++;
                    tvwinner.setText("You Lose.");
                } else if (user == 3 && cpu == 1) {
                    cpuscore++;
                    tvwinner.setText("You Lose.");
                } else if (user == 3 && cpu == 2) {
                    userscore++;
                    tvwinner.setText("You win!");
                } else {
                    tvwinner.setText("It's a tie");
                }

                user = 0;
                cpu = 0;

                rock.setChecked(false);
                paper.setChecked(false);
                scissor.setChecked(false);
                tvscore.setText("Player: " + userscore + "CPU: " + cpuscore);
            }
        });



    }
}
