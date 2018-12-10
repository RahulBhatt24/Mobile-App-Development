package com.example.saicm.jsondemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        JSONObject schoolInfo = new JSONObject();
        try {
            schoolInfo.put("name","Steven");
            schoolInfo.put("grade", 12);
            schoolInfo.put("id", 123456789);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        Log.d(TAG, schoolInfo.toString());

        JSONObject compSci = new JSONObject();
        JSONObject biology = new JSONObject();

        try {
            compSci.put("lettergrade", "A");
            compSci.put("percent", 100);

            biology.put("lettergrade", "A");
            biology.put("percent", 97);

            schoolInfo.put("Computer Science", compSci);
            schoolInfo.put("Biology", biology);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        Log.d(TAG, schoolInfo.toString());

        JSONArray clubs;
        clubs = new JSONArray();
        clubs.put("Computer Science");
        clubs.put("FBLA");
        clubs.put("Music");

        try {
            schoolInfo.put("clubs", clubs);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        Log.d(TAG, schoolInfo.toString());

        JSONObject findCourse;

        try {
            findCourse = schoolInfo.getJSONObject("Computer Science");
            Log.d(TAG, findCourse.toString());
            Log.d(TAG, findCourse.getString("lettergrade"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
