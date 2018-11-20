package com.example.a10012826.spinnerpractice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Spinner prefix;
    Spinner names;
    EditText name;
    Button add;
    TextView tvcurrentname;
    TextView tvnames;
    ArrayList<String> prefixlist;
    ArrayList<String> nameslist;
    String currentprefix;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        prefix = findViewById(R.id.spinner);
        names = findViewById(R.id.spinner2);
        name = findViewById(R.id.editText);
        add = findViewById(R.id.button);
        tvcurrentname = findViewById(R.id.textView2);
        tvnames = findViewById(R.id.textView3);

        prefixlist = new ArrayList<>();
        prefixlist.add("Sith Lord");
        prefixlist.add("Jedi Knight");

        nameslist = new ArrayList<>();


        ArrayAdapter<String> prefixAdapter = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, prefixlist);
        prefix.setAdapter(prefixAdapter);

        prefix.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                currentprefix = prefixlist.get(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nameslist.add(currentprefix + " " + name.getText());
                ArrayAdapter<String> nameAdapter = new ArrayAdapter<>(MainActivity.this, R.layout.support_simple_spinner_dropdown_item, nameslist);
                names.setAdapter(nameAdapter);
                //nameAdapter.notifyDataSetChanged();

                //Swap to notify dataset changed
            }
        });

    }
}
