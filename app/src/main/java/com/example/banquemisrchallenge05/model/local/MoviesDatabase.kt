package com.example.banquemisrchallenge05.model.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.banquemisrchallenge05.model.remote.MovieDetails

@Database(entities = arrayOf(NowPlayingMovie::class, PopularMovie::class, UpcomingMovie::class,MovieDetails::class), version = 1)
@TypeConverters(Converters::class)
abstract class MoviesDatabase : RoomDatabase() {
    abstract fun getMoviesDao(): MoviesDao
    companion object {
        @Volatile
        private var INSTANCE: MoviesDatabase? = null
        fun getInstance(ctx: Context): MoviesDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    ctx.applicationContext, MoviesDatabase::class.java, "movie_database"
                )
                    .build()
                INSTANCE = instance
// return instance
                instance
            }
        }
    }
}