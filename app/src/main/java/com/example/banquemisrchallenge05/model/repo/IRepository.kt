package com.example.banquemisrchallenge05.model.repo

import com.example.banquemisrchallenge05.model.local.ILocalDataSource
import com.example.banquemisrchallenge05.model.remote.IRemoteDataSource

interface IRepository:IRemoteDataSource,ILocalDataSource {
}