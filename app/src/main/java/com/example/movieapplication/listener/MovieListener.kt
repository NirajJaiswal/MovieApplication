package com.example.movieapplication.listener

import com.example.movieapplication.model.Movie


interface MovieListener {
    fun onMovieClick(movie: Movie)
}