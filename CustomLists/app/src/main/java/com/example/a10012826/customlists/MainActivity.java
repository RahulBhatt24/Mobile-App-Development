package com.example.a10012826.customlists;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<String> list;

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = new ArrayList<>();
        listView = findViewById(R.id.id_list);

        list.add("Sai");
        list.add("Ayush");
        list.add("Shahil");

        CustomAdapter adapter = new CustomAdapter(this, R.layout.custom_layout, list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "Clicked on " + list.get(position), Toast.LENGTH_LONG).show();
            }
        });
    }

    public class CustomAdapter extends ArrayAdapter<String> {

        Context context;
        int resource;
        List<String> list;

//      If this class was in a different file, you would need the instance variables. However, because the class
//      CustomAdapter is the inner-class of MainActivity, it has access to context and objects.

        public CustomAdapter(@NonNull Context context, int resource, @NonNull List<String> objects) {
            super(context, resource, objects);

            this.context = context;
            this.resource = resource;
            this.list = objects;

        }

        @NonNull
        @Override
        public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {

//            Do not put ANY loops in here! You will blow the entire program up!

            LayoutInflater layoutInflater = (LayoutInflater)context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            View adapterLayout = layoutInflater.inflate(resource, null);
            TextView textView = adapterLayout.findViewById(R.id.id_textview);
            ImageView imageView = adapterLayout.findViewById(R.id.id_image);
            Button button = adapterLayout.findViewById(R.id.id_button);

            textView.setText(list.get(position) + " " + position);

            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    list.remove(position);
                    notifyDataSetChanged();
                }
            });

            return adapterLayout;
        }
    }
}
