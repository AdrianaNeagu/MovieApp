package com.example.movieapp;

public class Movie {

    private String movieEpisodeName;
    private String movieName;
    private int movieImage;

    public Movie(String movieEpisodeName, String movieName, int movieImage) {
        this.movieEpisodeName = movieEpisodeName;
        this.movieName = movieName;
        this.movieImage = movieImage;
    }

    public String getMovieEpisodeName() {
        return movieEpisodeName;
    }

    public String getMovieName() {
        return movieName;
    }

    public int getMovieImage() {
        return movieImage;
    }
}
