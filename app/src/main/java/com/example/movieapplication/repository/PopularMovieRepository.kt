package com.example.movieapplication.repository

import com.example.movieapplication.service.ApiHelper

class PopularMovieRepository(private val apiHelper: ApiHelper) {
    suspend fun getPopularMovie(key: String, page: Int) = apiHelper.getPopularMovie(key, page)
}