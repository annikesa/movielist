package com.example.harkkaty_movielist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {
    ListView text;
    Context context = null;
    ArrayList<String> movies;
    EditText search;
    Button button;
    MovieList movielist;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = MainActivity.this;
        movies = new ArrayList<>();
        search = (EditText) findViewById(R.id.search);
        button = (Button) findViewById(R.id.button);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        movielist = new MovieList();
        for (int i = 0; i < movielist.list1.size(); i++) {
            movies.add(movielist.list1.get(i).name.toString());

        }
        text = (ListView) findViewById(R.id.listview);
        ArrayAdapter<String> linesAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, movies);
        text.setAdapter(linesAdapter);

    }


    public void searchMovie(View v) {
        System.out.println("moi1");
        String input = search.getText().toString();
        String firstLetter = input.substring(0, 1);
        String remainingLetters = input.substring(1, input.length());

        // change the first letter to uppercase
        firstLetter = firstLetter.toUpperCase();

        // join the two substrings
        input = firstLetter + remainingLetters;

        ArrayList<String> find = new ArrayList<>();
            if (!input.isEmpty()){
                System.out.println("moi2");
                for(int i = 0; i < movies.size(); i++){

                    System.out.println(movies.get(i));
                    if(movielist.list1.get(i).name.contains(input)) {
                        System.out.println("moi4");
                        find.add(movies.get(i));

            }
                    if(movielist.list1.get(i).genre.contains(input)) {
                        System.out.println("moi5");
                        find.add(movies.get(i));


                    }
        }
                ArrayAdapter<String> adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, find);
                text.setAdapter(adapter);

    }
    }
}