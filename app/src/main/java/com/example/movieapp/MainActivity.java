package com.example.movieapp;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private MovieAdapter movieAdapter;
    private ArrayList<Movie> movieList;
    static View.OnClickListener myOnClickListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view);
        movieList = new ArrayList<>();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        movieAdapter = new MovieAdapter(movieList);
        recyclerView.setAdapter(movieAdapter);

        prepareMovieList();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.add:
                addListItem();
                return true;
            case R.id.subtract:
                removeListItem();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void removeListItem() {
        movieAdapter.removeFirstItem();
    }

    private void addListItem() {
        movieAdapter.addDeletedElement();
    }

    private void prepareMovieList() {
        Movie movie = new Movie(getString(R.string.episode_one), getString(R.string.movie_name), R.drawable.mars_attack_resize);
        movieList.add(movie);
        movie = new Movie(getString(R.string.episode_two), getString(R.string.movie_name), R.drawable.dumb_resize);
        movieList.add(movie);
        movie = new Movie(getString(R.string.episode_three), getString(R.string.movie_name), R.drawable.iron_resize);
        movieList.add(movie);
        movie = new Movie(getString(R.string.episode_four), getString(R.string.movie_name), R.drawable.jay);
        movieList.add(movie);
        movie = new Movie(getString(R.string.episode_five), getString(R.string.movie_name), R.drawable.zoo);
        movieList.add(movie);
        movie = new Movie(getString(R.string.episode_six), getString(R.string.movie_name), R.drawable.muppet_png);
        movieList.add(movie);
        movie = new Movie(getString(R.string.episode_seven), getString(R.string.movie_name), R.drawable.squirrel);
        movieList.add(movie);
        movieAdapter.notifyDataSetChanged();
    }
}


