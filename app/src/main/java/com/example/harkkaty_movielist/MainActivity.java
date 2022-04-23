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
        MovieList movielist = new MovieList();
        for (int i = 0; i < movielist.list1.size(); i++) {
            movies.add(movielist.list1.get(i).name.toString());
        }
        text = (ListView) findViewById(R.id.listview);
        ArrayAdapter<String> linesAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, movies);
        text.setAdapter(linesAdapter);

    }


    public void searchMovie(View v) {
        System.out.println("moi1");
        String name = search.getText().toString();
        System.out.println(name);
            if (!name.isEmpty()){
                System.out.println("moi2");
                for(int i = 0; i < movies.size(); i++){
                    System.out.println(movies.get(i));
                    if(name.equals(movies.get(i))) {
                        System.out.println("moi4");
                        ArrayAdapter<String> adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, Collections.singletonList(movies.get(i)));
                        text.setAdapter(adapter);
            }
        }

    }
    }
}