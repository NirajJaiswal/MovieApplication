package com.example.movieapplication.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.databinding.DataBindingUtil
import com.example.movieapplication.R
import com.example.movieapplication.databinding.ActivityMovieDetailBinding
import com.example.movieapplication.model.Movie

class MovieDetailActivity : AppCompatActivity() {
    private var movie: Movie? = null
    private var activityMovieDetailBinding: ActivityMovieDetailBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)
        activityMovieDetailBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_movie_detail)
        val toolbar: Toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        val intent: Intent = intent
        movie = intent.getParcelableExtra("movie_tag")
        setValue()
    }

    private fun setValue() {
        title = movie!!.getOriginalTitle()
        activityMovieDetailBinding?.movie = movie
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}