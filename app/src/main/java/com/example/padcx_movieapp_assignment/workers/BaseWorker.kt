package com.example.padcx_movieapp_assignment.workers

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.example.padcx_movieapp_assignment.data.model.MovieModel
import com.example.padcx_movieapp_assignment.data.model.impls.MovieModelImpl

abstract class BaseWorker(context: Context, workerParams: WorkerParameters) : Worker(context, workerParams) {
    val mMovieModel : MovieModel =
        MovieModelImpl
}