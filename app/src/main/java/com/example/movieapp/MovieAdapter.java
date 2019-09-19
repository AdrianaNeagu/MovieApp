package com.example.movieapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import androidx.recyclerview.widget.RecyclerView;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {

    ArrayList<Movie> movieList;
    Context context;

    public MovieAdapter(ArrayList<Movie> movieList) {
        this.movieList = movieList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_movie, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        context = parent.getContext();
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        Movie movie = movieList.get(position);
        holder.bind(movie);
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    public void removeFirstItem() {
        movieList.remove(0);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView movieImage;
        TextView movieEpisode;
        TextView movieName;
        Button detailsButton;
        Button shareButton;

        private ViewHolder(View itemView) {
            super(itemView);
            movieImage = itemView.findViewById(R.id.movie_image);
            movieEpisode = itemView.findViewById(R.id.movie_episode);
            movieName = itemView.findViewById(R.id.movie_name);
            detailsButton = itemView.findViewById(R.id.details_button);
            shareButton = itemView.findViewById(R.id.share_button);
        }

        private void bind(Movie movie) {
            Glide.with(context).load(movie.getMovieImage()).into(movieImage);
            movieEpisode.setText(movie.getMovieEpisodeName());
            movieName.setText(movie.getMovieName());

            detailsButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, String.format(context.getString(R.string.details), movie.getMovieEpisodeName()), Toast.LENGTH_SHORT).show();
                }
            });

            shareButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Intent.ACTION_SEND);
                    intent.putExtra(Intent.EXTRA_SUBJECT, movie.getMovieEpisodeName());
                    intent.setType("text/plain");
                    context.startActivity(Intent.createChooser(intent, "Send To"));
                }
            });
        }
    }
}
