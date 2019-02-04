package com.example.saicm.criticalquestionspractice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SecondActivity extends AppCompatActivity {

    EditText editText;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        editText = findViewById(R.id.editTextIntent);
        button = findViewById(R.id.buttonIntent);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editText.getText().length() > 0) {
                    Intent sendInfoBack = new Intent();
                    sendInfoBack.putExtra(MainActivity.INTENT_CODE, editText.getText().toString());
                    setResult(RESULT_OK, sendInfoBack);
                    finish();
                }
            }
        });
    }
}
