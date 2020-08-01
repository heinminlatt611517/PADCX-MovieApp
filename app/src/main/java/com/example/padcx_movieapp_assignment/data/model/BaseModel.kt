package com.example.padcx_movieapp_assignment.data.model

import android.content.Context
import com.example.padcx_movieapp_assignment.network.MoviesApi
import com.example.padcx_movieapp_assignment.presistence.db.MovieDb
import com.example.padcx_movieapp_assignment.utils.base_url
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

abstract class BaseModel {

    protected  var mMoviesApi : MoviesApi
    protected lateinit var mMovieDb: MovieDb

    init {
      val okHttpClient = OkHttpClient.Builder()
          .addInterceptor(HttpLoggingInterceptor()
              .apply {
                  level = HttpLoggingInterceptor.Level.BODY
              })
          .connectTimeout(100,TimeUnit.SECONDS)
          .readTimeout(100,TimeUnit.SECONDS)
          .writeTimeout(100,TimeUnit.SECONDS)
          .build()

        val retrofit = Retrofit.Builder()
            .baseUrl(base_url)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()


        mMoviesApi=retrofit.create(MoviesApi::class.java)
    }

    fun getOKhttpClientinterceptor(): HttpLoggingInterceptor = HttpLoggingInterceptor()
        .apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    fun initDatabase(context: Context){
        mMovieDb= MovieDb.DbInstance(context)
    }
}