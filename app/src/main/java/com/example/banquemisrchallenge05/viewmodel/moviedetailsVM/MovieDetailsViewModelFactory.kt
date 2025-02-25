package com.example.banquemisrchallenge05.viewmodel.moviedetailsVM

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.banquemisrchallenge05.model.repo.IRepository

class MovieDetailsViewModelFactory(private val repo: IRepository) : ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if(modelClass.isAssignableFrom( MovieDetailsViewModel::class.java)){
            MovieDetailsViewModel(repo) as T
        }else{
            throw IllegalArgumentException("view model can not found")
        }
    }
}