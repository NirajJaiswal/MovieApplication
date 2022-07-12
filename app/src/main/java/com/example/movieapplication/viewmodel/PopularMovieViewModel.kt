package com.example.movieapplication.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.switchMap
import com.example.movieapplication.repository.PopularMovieRepository
import com.example.movieapplication.utils.Constant
import com.example.movieapplication.utils.Resource
import kotlinx.coroutines.Dispatchers

class PopularMovieViewModel(private val popularMovieRepository: PopularMovieRepository) :
    ViewModel() {
    private val key: String = Constant.key
    var result = MutableLiveData<Int>()


    fun getValue(page: Int) {
            result.postValue(page)
    }

    var data = result.switchMap {
        liveData(Dispatchers.IO) {
            emit(Resource.loading(data = null))
            try {
                emit(Resource.success(data = popularMovieRepository.getPopularMovie(key, it)))
            } catch (exception: Exception) {
                emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
            }
        }
    }

}