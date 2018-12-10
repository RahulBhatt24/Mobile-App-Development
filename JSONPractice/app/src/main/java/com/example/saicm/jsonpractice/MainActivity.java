package com.example.saicm.jsonpractice;

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

        JSONObject trainers = new JSONObject();
        JSONObject ash = new JSONObject();
        JSONObject brock = new JSONObject();
        JSONObject misty = new JSONObject();
        JSONObject may = new JSONObject();

        JSONObject pikachu = new JSONObject();
        JSONArray moveslist;
        moveslist = new JSONArray();
        JSONArray trainerslist;
        trainerslist = new JSONArray();

        try {
            pikachu.put("name", "Pikachu");
            pikachu.put("level", 37);
            moveslist.put("Thunderbolt");
            moveslist.put("Iron Tail");
            moveslist.put("Thundershock");
            moveslist.put("Volt Switch");

            pikachu.put("moves", moveslist);

            ash.put("firstpokemon", pikachu);
            ash.put("secondpokemon", "Bulbasaur");
            ash.put("thirdpokemon", "Charmander");
            ash.put("fourthpokemon", "Squirtle");


            brock.put("firstpokemon", "Geodude");
            brock.put("secondpokemon", "Onix");
            brock.put("thirdpokemon", "Steelix");
            brock.put("fourthpokemon", "Golem");

            misty.put("firstpokemon", "Staryu");
            misty.put("secondpokemon", "Starmie");
            misty.put("thirdpokemon", "Horsea");
            misty.put("fourthpokemon", "Seadra");

            may.put("firstpokemon", "Torchic");
            may.put("secondpokemon", "Beautifly");
            may.put("thirdpokemon", "Wailmer");
            may.put("fourthpokemon", "Eevee");

            trainerslist.put(ash);
            trainerslist.put(brock);
            trainerslist.put(misty);
            trainerslist.put(may);
            trainers.put("Trainers", trainerslist);
            Log.d(TAG, trainers.toString());

            Log.d(TAG, trainers.getJSONArray("Trainers").getJSONObject(0).getJSONObject("firstpokemon").getString("name"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
