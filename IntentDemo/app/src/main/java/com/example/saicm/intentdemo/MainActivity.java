package com.example.saicm.intentdemo;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvname;
    TextView tvphone;
    Button button;

    static final int NUMBER_CODE = 1234;
    static final String INTENT_CODE = "number code";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvname = findViewById(R.id.textView);
        tvphone = findViewById(R.id.phoneTextView);
        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                intent.putExtra(INTENT_CODE, NUMBER_CODE);
                startActivityForResult(intent, NUMBER_CODE);

                //STARTACTIVITYFORRESULT waits for a result to come back from the activity
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == NUMBER_CODE && resultCode == RESULT_OK)
            tvphone.setText(data.getStringExtra(INTENT_CODE));
    }
}