package com.example.padcx_movieapp_assignment.instrumentationtests

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.example.padcx_movieapp_assignment.data.vos.NowPlayingMovieVO
import com.example.padcx_movieapp_assignment.presistence.daos.MoviesDao
import com.example.padcx_movieapp_assignment.presistence.db.MovieDb
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class DatabaseTest {
    private lateinit var mMovieDao : MoviesDao
    private lateinit var  mMovieDb : MovieDb

    @Before
    fun createDb(){
        val context = ApplicationProvider.getApplicationContext<Context>()

        mMovieDb= Room.inMemoryDatabaseBuilder(context
            ,MovieDb::class.java).build()

        mMovieDao=mMovieDb.moviesDao()
    }

    @After
    fun closeDb(){
        mMovieDb.close()
    }

   @Test
   fun insertDatabaseTest(){
       val movieOne = NowPlayingMovieVO()
       movieOne.posterPath=""
       movieOne.adult=false
       movieOne.backdropPath=""
       movieOne.genreIds= arrayListOf()
       movieOne.id=1
       movieOne.originalLanguage=""
       movieOne.overView=""
       movieOne.title="Test Database"
       movieOne.popularity=""
       movieOne.video=false
       movieOne.voteCount=""
       movieOne.releaseData=""
       movieOne.voteAverage=""

       mMovieDao.insertNowPlayingMovie(movieOne)
       assert(mMovieDao.getNowPlayingMovieById(movieOne.id).value?.id == movieOne.id)

   }
}