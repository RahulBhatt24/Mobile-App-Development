package com.example.saicm.criticalquestionspractice;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    TextView textView;
    ImageView imageView;
    Spinner spinner;
    RadioGroup radioGroup;
    Button button;

    static final int CODE = 1234;
    static final String INTENT_CODE = "INTENT CODE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        textView = findViewById(R.id.textView);
        imageView = findViewById(R.id.imageView);
        spinner = findViewById(R.id.spinner);
        radioGroup = findViewById(R.id.radioGroup);
        button = findViewById(R.id.button);

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                textView.setText(s.toString());
                Toast.makeText(MainActivity.this, "CHANGED TEXT", Toast.LENGTH_LONG).show();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

//        imageView.setImageResource();
        final ArrayList<String> list = new ArrayList<>();
        list.add("Mr. Schiff");
        list.add("Ms. Lehre");
        list.add("Mr. Martorano");

        ArrayAdapter<String> listAdapter = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, list);
        spinner.setAdapter(listAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "CLICKED " + list.get(position), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.radioButtonOne:
                        Toast.makeText(MainActivity.this, "RADIO BUTTON ONE CHECKED", Toast.LENGTH_LONG).show();
                        break;
                    case R.id.radioButtonTwo:
                        Toast.makeText(MainActivity.this, "RADIO BUTTON TWO CHECKED", Toast.LENGTH_LONG).show();
                        break;
                    case R.id.radioButtonThree:
                        Toast.makeText(MainActivity.this, "RADIO BUTTON TWO CHECKED", Toast.LENGTH_LONG).show();
                }
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra(INTENT_CODE, CODE);
                startActivityForResult(intent, CODE);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
            if (requestCode == CODE && resultCode == RESULT_OK) {
                Toast.makeText(MainActivity.this, data.getStringExtra(INTENT_CODE), Toast.LENGTH_LONG).show();
            }
    }
}
