package com.example.harkkaty_movielist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    ListView text;
    Context context = null;
    ArrayList<String> movies;
    EditText search;
    Button button;
    MovieList movielist;
    private Object LayoutInflater;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("Movisio");
        /*androidx.appcompat.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.ic_launcher_background));
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        actionBar.setDisplayShowCustomEnabled(true);
        LayoutInflater inflater = (LayoutInflater)this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.custom_image, null);
        actionBar.setCustomView(v);*/

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

        if (input.contains(" ")){
            String[] arrOfInput = input.split(" ",2);
            input = arrOfInput[0] + " "+ arrOfInput[1];
        }

        ArrayList<String> find = new ArrayList<>();
        if (!input.isEmpty()) {
            System.out.println("moi2");
            for (int i = 0; i < movies.size(); i++) {

                System.out.println(movies.get(i));
                if (movielist.list1.get(i).name.contains(input)) {
                    System.out.println("moi4");
                    find.add(movies.get(i));

                }
                if (movielist.list1.get(i).genre.contains(input)) {
                    System.out.println("moi5");
                    find.add(movies.get(i));

                }
                System.out.println("2222222222222");
                for (Actor a : movielist.list1.get(i).actorArrayList) {
                    String fullName = a.getFirstname()+" "+a.getLastname();

                    System.out.println(("###################"));
                    if (fullName.equalsIgnoreCase(input)) {
                        System.out.println(fullName);
                        find.add(movies.get(i));
                    }

                }
            }
            if (find.isEmpty()){

                find.add("Movie not found");
            }

            ArrayAdapter<String> adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, find);
            text.setAdapter(adapter);
        }
        }
    }


