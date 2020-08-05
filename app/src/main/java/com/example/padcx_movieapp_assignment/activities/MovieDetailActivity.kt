package com.example.padcx_movieapp_assignment.activities

import android.content.Context
import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.padcx_movieapp_assignment.R
import com.example.padcx_movieapp_assignment.adapters.ActorAdapter
import com.example.padcx_movieapp_assignment.adapters.BestPopularMovieAdapter
import com.example.padcx_movieapp_assignment.adapters.CreatorAdapter
import com.example.padcx_movieapp_assignment.data.vos.*
import com.example.padcx_movieapp_assignment.mvp.presenters.MovieDetailPresenter
import com.example.padcx_movieapp_assignment.mvp.presenters.impls.MovieDetailPresenterImpl
import com.example.padcx_movieapp_assignment.mvp.views.MovieDetailView
import com.example.padcx_movieapp_assignment.utils.IMAGE_BASE_URL
import com.example.padcx_movieapp_assignment.utils.hourMin
import com.example.padcx_movieapp_assignment.views.viewPods.ReactionViewPod
import com.google.android.material.chip.Chip
import kotlinx.android.synthetic.main.about_flim_layout.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_movie_detail.*
import kotlin.math.log
import kotlin.time.hours

class MovieDetailActivity : BaseActivity(),MovieDetailView {

    companion object{
        const val MOVIE_ID_EXTRA = "Movie Id Extra"
        fun newIntent(context : Context,movieId : Int) : Intent{
            val intent = Intent(context,MovieDetailActivity::class.java)
            intent.putExtra(MOVIE_ID_EXTRA,movieId)
            return intent
        }
    }

    private lateinit var mActorAdapter : ActorAdapter
    private lateinit var mPresenter : MovieDetailPresenter
    private lateinit var actorViewPod : ReactionViewPod
    private lateinit var creatorViewPod : ReactionViewPod
    private lateinit var mCreatorAdapter: CreatorAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)

        setUpPresenter()
        setUpActorRecyclerView()
        setUpCreatorRecyclerView()
        setUpActorViewPod()
        setUpCreatorViewPod()
        intent.getIntExtra(MOVIE_ID_EXTRA,0).let { mPresenter.getMovieByID(it) }
        intent.getIntExtra(MOVIE_ID_EXTRA,0).let { mPresenter.getCastMovieByID(it) }
        intent.getIntExtra(MOVIE_ID_EXTRA,0).let { mPresenter.getCrewMovieByID(it) }


    }

    private fun setUpCreatorViewPod() {
        creatorViewPod = creator_view_pod_reaction as ReactionViewPod
        creatorViewPod.setData("Creators","More Creators")
        creatorViewPod.showText()
    }

    private fun setUpCreatorRecyclerView() {
        mCreatorAdapter= CreatorAdapter()
        val linearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false)
        rvCreator.layoutManager=linearLayoutManager
        rvCreator.adapter=mCreatorAdapter

    }

    private fun setUpActorViewPod() {
        actorViewPod = actor_view_pod_reaction as ReactionViewPod
        actorViewPod.setData("Actors","")
        actorViewPod.hideText()

    }

    private fun setUpActorRecyclerView() {
        mActorAdapter= ActorAdapter()
        val linearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false)
        rvActor.layoutManager=linearLayoutManager
        rvActor.adapter=mActorAdapter


    }

    private fun setUpPresenter() {
        mPresenter=ViewModelProviders.of(this).get(MovieDetailPresenterImpl::class.java)
        mPresenter.initPresenter(this)
    }

    override fun showMovieById(movie: MovieVO) {
        bindData(movie)
        Log.d("MovieDetail",movie.toString())


    }

    override fun navigateToMain() {
        startActivity(MainActivity.newIntent(this))
    }

    override fun showNowPlayingMovie(movieLists: List<NowPlayingMovieVO>) {
//        mActorAdapter.setNewData(movieLists.toMutableList())
//        mCreatorAdapter.setNewData(movieLists.toMutableList())
    }

    override fun showCastMovie(movieLists: List<CastVO>) {
        mActorAdapter.setNewData(movieLists.toMutableList())
    }

    override fun showCrewMovie(movieLists: List<CrewVO>) {
      mCreatorAdapter.setNewData(movieLists.toMutableList())
    }

    private fun bindData(movie: MovieVO) {



        tvMovieTitle.text=movie.title
        tv_storylineText.text=movie.overview
        btn_movieYear.text=movie.releaseDate
        tvDateTime.text=movie.runtime.hourMin()
        Glide.with(this).
            load(movie.homepage)
            .into(ivDetail)


        rating.rating=movie.vote_average
        tvVoteCount.text=movie.vote_count.toString()
        Glide.with(this).load(IMAGE_BASE_URL+movie.posterPath)
            .into(ivDetail)

        //bind genre chip
        bindGenreChips(movie)


        //about Film
        tvOriginalTitleName.text=movie.originalTitle
        tvTypeDec.text=movie.genres[0].name
        tvProductionDec.text=movie.productionCompanies[0].name +","+movie.productionCompanies[0].origin_country
        tvPremiereDec.text=movie.releaseDate
        tvMovieDescriptionText.text=movie.overview



    }

    private fun bindGenreChips(movie: MovieVO) {
       val genres = movie.genres.map { it.name }
        chip_group.removeAllViews()
        for (index in genres.indices)
        {
            val chip = Chip(chip_group.context)
            chip.text= genres[index]
            chip.maxWidth = 8
            chip.minEms = 4
            chip.setTextColor(Color.WHITE)
            chip.chipBackgroundColor = ColorStateList.valueOf(ContextCompat.getColor(chip_group.context, R.color.colorPrimary))
            chip_group.addView(chip)
        }
    }


    override fun showErrorMessage(errorMessage: String) {
        Log.d("MovieDetailError", errorMessage)
    }
}