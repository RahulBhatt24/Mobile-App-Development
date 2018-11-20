package com.example.a10012826.conversionproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    Button buttonshahil;
    Button buttonkris;
    Button buttonsai;
    Button buttonayush;
    TextView tvanswer;
    int ayush;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        buttonshahil = findViewById(R.id.buttonshahil);
        buttonkris = findViewById(R.id.buttonKris);
        buttonsai = findViewById(R.id.buttonSai);
        buttonayush = findViewById(R.id.buttonAyush);
        tvanswer = findViewById(R.id.tvanswer);

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                try {
                    if (Character.isDigit(s.charAt(0)))
                        ayush = Integer.parseInt(s.toString());
                } catch(Exception e) {
                    Toast.makeText(MainActivity.this, "Please enter a real number", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        buttonshahil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvanswer.setText((ayush*4) +"");
            }
        });
    }
}
