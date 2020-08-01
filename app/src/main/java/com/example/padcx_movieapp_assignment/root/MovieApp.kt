package com.example.padcx_movieapp_assignment.root

import android.app.Application
import androidx.work.OneTimeWorkRequest
import androidx.work.WorkManager
import com.example.padcx_movieapp_assignment.data.model.impls.MovieModelImpl
import com.example.padcx_movieapp_assignment.workers.GetMovieWorker

class MovieApp : Application() {



    override fun onCreate() {
        super.onCreate()
        MovieModelImpl.initDatabase(applicationContext)

        getNowPlayingMovieOneTime()
    }

    private fun getNowPlayingMovieOneTime(){
        val getEventsWorkRequest = OneTimeWorkRequest
            .Builder(GetMovieWorker::class.java)
            .build()
        WorkManager.getInstance(applicationContext)
            .enqueue(getEventsWorkRequest)
    }

}