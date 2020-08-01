package com.example.padcx_movieapp_assignment.workers

import android.content.Context
import androidx.work.WorkerParameters

class GetMovieWorker(context: Context, workerParams: WorkerParameters) :
    BaseWorker(context, workerParams) {
    override fun doWork(): Result {
        var result = Result.failure()

        mMovieModel.firstTimeNowPlayingMovieSaveToDatabase(
            onSuccess = {
                result = Result.success()
            },
            onError = {
                result = Result.failure()
            }
        )

        mMovieModel.firstTimePopularMovieSaveToDatabase(
            onSuccess = {
                result = Result.success()
            },
            onError = {
                result = Result.failure()
            }
        )

        mMovieModel.firstTimeUpComingMovieSaveToDatabase(
            onSuccess = {
                result = Result.success()
            },
            onError = {
                result = Result.failure()
            }
        )

        mMovieModel.firstTimeTopRateMovieSaveToDatabase(
            onSuccess = {
                result = Result.success()
            },
            onError = {
                result = Result.failure()
            }
        )

        return result
    }
}

