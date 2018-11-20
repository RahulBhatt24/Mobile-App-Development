package com.example.a10012826.widgetintrostudentpractice;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    TextView switchtext;
    TextView displaycolor;
    Button testbutton;
    SeekBar slider;
    Switch aSwitch;
    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        switchtext = findViewById(R.id.switchtext);
        displaycolor = findViewById(R.id.editTextView);
        editText = findViewById(R.id.editText);
        aSwitch = findViewById(R.id.switchtext);
        testbutton = findViewById(R.id.testbutton);
        slider = findViewById(R.id.slider);

        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                    slider.setEnabled(true);
                else
                    slider.setEnabled(false);
            }
        });

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String str = s.toString();
                if (str.length() > 0) {
                    switch (str.toLowerCase()) {
                        case "red":
                            displaycolor.setTextColor(Color.RED);
                            break;
                        case "blue":
                            displaycolor.setTextColor(Color.BLUE);
                            break;
                        case "green":
                            displaycolor.setTextColor(Color.GREEN);
                            break;
                        default:
                            displaycolor.setTextColor(Color.BLACK);
                            break;
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        slider.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                testbutton.getLayoutParams().width = 200 + progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


    }
}
