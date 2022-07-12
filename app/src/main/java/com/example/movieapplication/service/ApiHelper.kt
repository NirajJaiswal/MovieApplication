package com.example.movieapplication.service

class ApiHelper(private val apiService: ApiService) {
    suspend fun getPopularMovie(key: String, page: Int) = apiService.getPopularMovie(key, page)
}