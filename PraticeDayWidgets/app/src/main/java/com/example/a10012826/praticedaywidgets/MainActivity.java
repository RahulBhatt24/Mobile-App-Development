package com.example.a10012826.praticedaywidgets;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText editText1;
    EditText editText2;
    TextView tv1;
    TextView tv2;
    TextView tv3;
    TextView tvcolor;
    TextView tvverify;
    TextView tvdatabase;
    TextView tvtextsize;
    Button buttonverify;
    Button buttoncheck;
    SeekBar slider;
    Switch switch1;
    Switch switch2;
    Switch switch3;
    ArrayList<String> list = new ArrayList<>();
    boolean verified;
    boolean check;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText editText1 = findViewById(R.id.editText1);
        EditText edittext2 = findViewById(R.id.editText2);
        TextView tv1 = findViewById(R.id.tv1);
        TextView tv2 = findViewById(R.id.tv2);
        TextView tv3 = findViewById(R.id.tv3);
        TextView tvcolor = findViewById(R.id.tvcolor);
        final TextView tvverify = findViewById(R.id.tvverify);
        final TextView tvdatabase = findViewById(R.id.tvdatabase);
        TextView tvtextsize = findViewById(R.id.tvtextsize);
        Button buttonverify = findViewById(R.id.buttonverify);
        Button buttoncheck = findViewById(R.id.buttoncheck);
        SeekBar slider = findViewById(R.id.slider);
        Switch switch1 = findViewById(R.id.switch1);
        Switch switch2 = findViewById(R.id.switch2);
        Switch switch3 = findViewById(R.id.switch3);
        list.add("sai@.com");

        editText1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String str = s.toString();
                if (str.length() > 4 && (str.substring(str.length() - 4, str.length()).equals(".com")) && str.indexOf("@") > -1) {
                    verified = true;
                } else {
                    verified = false;
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        buttonverify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (verified)
                    tvverify.setText("Verified");
                else
                    tvverify.setText("Not Verified");
            }
        });
        editText2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String str = s.toString();
                for (String string: list) {
                    if (string.equals(s)){
                        check = true;
                        break;
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        buttoncheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (check)
                    tvdatabase.setText("In Database");
                else
                    tvdatabase.setText("Not In Database");
            }
        });
    }
}
