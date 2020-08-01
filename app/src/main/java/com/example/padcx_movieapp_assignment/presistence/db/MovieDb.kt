package com.example.padcx_movieapp_assignment.presistence.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import com.example.padcx_movieapp_assignment.data.vos.*
import com.example.padcx_movieapp_assignment.presistence.daos.MoviesDao
import com.example.padcx_movieapp_assignment.presistence.typeConverters.GenreTypeConverter


@Database(entities = [PopularMovieVO::class,UpcomingMovieVO::class,NowPlayingMovieVO::class,TopRateVO::class],version = 2,exportSchema = false )
abstract class MovieDb : RoomDatabase() {
    companion object{
        val DB_NAME ="MOVIE.DB"
        var dbInstance : MovieDb? = null

        fun DbInstance(context: Context) : MovieDb{
            when(dbInstance){
                null-> {
                    dbInstance= Room.databaseBuilder(context,MovieDb::class.java, DB_NAME)
                        .allowMainThreadQueries()
                        .fallbackToDestructiveMigration()
                        .build()
                }
            }
            val i = dbInstance
            return i!!
        }

    }

    abstract fun moviesDao() : MoviesDao

}