package com.example.harkkaty_movielist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.os.StrictMode;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView text;
    Context context = null;
    ArrayList<String> movies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = MainActivity.this;
        movies = new ArrayList<>();
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        MovieList movielist = new MovieList();
        for (int i = 0; i < movielist.movieList.size(); i++) {
            movies.add(movielist.movieList.get(i).name.toString());
        }
        text = (ListView) findViewById(R.id.listview);
        ArrayAdapter<String> linesAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, movies);
        text.setAdapter(linesAdapter);    }

}