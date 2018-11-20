package com.example.a10012826.spinnerpractice2;

import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    Spinner spinner;
    Button button;
    TextView tvremoved;
    TextView tvland;
    ArrayList<String> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = new ArrayList<>();

        list.add("Ayush");
        list.add("Sai");
        list.add("Shahil");

        spinner = findViewById(R.id.id_spinner);
        button = findViewById(R.id.id_button);
        tvremoved = findViewById(R.id.id_tvremoved);
        tvland = findViewById(R.id.id_tvland);

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            final ArrayAdapter<String> spinneradapter = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, list);
            spinner.setAdapter(spinneradapter);

            spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    tvremoved.setText(list.get(position));
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {
                    tvremoved.setText("All elements removed");
                }
            });

            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    list.clear();
                    spinneradapter.notifyDataSetChanged();
                }
            });
        }

    }
}
