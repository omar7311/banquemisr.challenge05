package com.example.banquemisrchallenge05.viewmodel.movieslistVM

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.banquemisrchallenge05.model.repo.IRepository

class MoviesListViewModelFactory(private val repo: IRepository) : ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if(modelClass.isAssignableFrom( MoviesListViewModel::class.java)){
            MoviesListViewModel(repo) as T
        }else{
            throw IllegalArgumentException("view model can not found")
        }
    }
}
