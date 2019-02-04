package com.example.saicm.intentdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.saicm.intentdemo.MainActivity.INTENT_CODE;
import static com.example.saicm.intentdemo.MainActivity.NUMBER_CODE;

public class Main2Activity extends AppCompatActivity {

    Button close;
//    TextView info;
    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Toast.makeText(this, getIntent().getStringExtra(INTENT_CODE), Toast.LENGTH_SHORT).show();

        close = findViewById(R.id.button2);
//        info = findViewById(R.id.textView);
        editText = findViewById(R.id.editText);

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sendInfosBack = new Intent();
                sendInfosBack.putExtra(INTENT_CODE, editText.getText().toString());
                setResult(RESULT_OK, sendInfosBack);
                finish();
            }
        });
    }
}