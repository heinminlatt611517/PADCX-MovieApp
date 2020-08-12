package com.example.padcx_movieapp_assignment.activities

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.padcx_movieapp_assignment.R
import com.example.padcx_movieapp_assignment.adapters.*
import com.example.padcx_movieapp_assignment.data.vos.*
import com.example.padcx_movieapp_assignment.mvp.presenters.MainPresenter
import com.example.padcx_movieapp_assignment.mvp.presenters.impls.MainPresenterImpl
import com.example.padcx_movieapp_assignment.mvp.views.MainView
import com.example.padcx_movieapp_assignment.views.viewPods.EmptyViewPod
import com.example.padcx_movieapp_assignment.views.viewPods.ReactionViewPod
import com.smarteist.autoimageslider.IndicatorAnimations
import com.smarteist.autoimageslider.SliderAnimations
import com.smarteist.autoimageslider.SliderView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity(),MainView{


    companion object{
        fun newIntent(context : Context) : Intent {
            val intent = Intent(context,MainActivity::class.java)
            return intent
        }
    }

    private lateinit var mPresenter : MainPresenter
    private lateinit var mViewPodEmpty : EmptyViewPod
    private lateinit var mShowCaseAdapter: ShowCaseAdapter
    private lateinit var mBestActorAdapter: BestActorAdapter
    private lateinit var mBestPopularMovieAdapter : BestPopularMovieAdapter
    private lateinit var mTopMovieSliderAdapter : TopMovieImageSliderAdapter
    private lateinit var mImageSlider : SliderView

    private lateinit var showCaseViewPod : ReactionViewPod
    private lateinit var bestActorViewPod : ReactionViewPod

    private var genreMovieList : ArrayList<GenresVO> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setUpPresenter()
        setUpTopMovieSliderRecycler()
        setUpBestPopularMovieRecyclerView()
        setUpBestActorRecyclerView()
        setUpShowCaseRecyclerView()
        setUpEmptyViewPod()
        setUpShowCaseViewPod()
        setUpBestActorViewPod()

        mPresenter.onUIReady(this)
        mPresenter.onPopularMovie(this)
        mPresenter.onGenreMovie()
        mPresenter.onUpComingMovie(this)
        mPresenter.onTopRateMovie(this)



    }

    private fun setUpTopMovieSliderRecycler() {
        mImageSlider =findViewById(R.id.topMovieSlider)
        mTopMovieSliderAdapter = TopMovieImageSliderAdapter(mPresenter,arrayListOf(),this!!.applicationContext!!)
        mImageSlider.sliderAdapter=mTopMovieSliderAdapter

        setUpImageSlider()



    }

    private fun setUpImageSlider() {
        mImageSlider.setIndicatorAnimation(IndicatorAnimations.FILL)
        mImageSlider.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION)
        mImageSlider.autoCycleDirection = SliderView.AUTO_CYCLE_DIRECTION_RIGHT
        mImageSlider.indicatorSelectedColor = Color.WHITE
        mImageSlider.indicatorUnselectedColor = Color.GRAY
    }

    private fun setUpBestActorViewPod() {
        showCaseViewPod = showCase_view_pod_reaction as ReactionViewPod
        showCaseViewPod.setData("ShowCases","More ShowCases")
        showCaseViewPod.showText()
    }

    private fun setUpShowCaseViewPod() {
        bestActorViewPod = bestActor_view_pod_reaction as ReactionViewPod
        bestActorViewPod.setData("Best Actors","More Actors")
        bestActorViewPod.showText()
    }

    private fun setUpBestPopularMovieRecyclerView() {
        mBestPopularMovieAdapter= BestPopularMovieAdapter(mPresenter)
        val linearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false)
        rvBestPopularMovie.layoutManager=linearLayoutManager
        rvBestPopularMovie.adapter=mBestPopularMovieAdapter

    }

    private fun setUpBestActorRecyclerView() {
        mBestActorAdapter= BestActorAdapter(mPresenter)
        val linearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false)
        rvBestActor.layoutManager=linearLayoutManager
        rvBestActor.adapter=mBestActorAdapter

    }

    private fun setUpShowCaseRecyclerView() {
        mShowCaseAdapter= ShowCaseAdapter(mPresenter)
        val linearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false)
        rvShowCases.layoutManager=linearLayoutManager
        rvShowCases.adapter=mShowCaseAdapter

    }

    private fun setUpEmptyViewPod(){
        mViewPodEmpty = vpEmpty as EmptyViewPod

    }

    private fun setUpPresenter(){
        mPresenter=ViewModelProviders.of(this).get(MainPresenterImpl::class.java)
        mPresenter.initPresenter(this)
    }

    override fun showNowPlayingMovie(movieLists: List<NowPlayingMovieVO>) {
        Log.d("NowPlayingMovies",movieLists.toString())

    }

    override fun showPopularMovie(movieLists: List<PopularMovieVO>) {
        Log.d("PopularMovies",movieLists.toString())
        mBestPopularMovieAdapter.setNewData(movieLists.toMutableList())
    }

    override fun navigateToMovieDetailScreen(movieId: Int) {
        startActivity(MovieDetailActivity.newIntent(this,movieId))
    }

    override fun showNowPlayingMovieSlider(movieLists: List<NowPlayingMovieVO>) {
        mTopMovieSliderAdapter.setData(movieLists as ArrayList<NowPlayingMovieVO>)
        Log.d("SliderSize",movieLists.count().toString())

    }

    override fun showUpComingMovie(movieLists: List<UpcomingMovieVO>) {
        mShowCaseAdapter.setNewData(movieLists.toMutableList())
    }

    override fun showTopRateMovie(movieLists: List<TopRateVO>) {
        Log.d("TopRateMovies",movieLists.toString())
       mBestActorAdapter.setNewData(movieLists.toMutableList())

    }

    override fun showGenreMovie(movieLists: List<GenresVO>) {
        genreMovieList= movieLists as ArrayList<GenresVO>
        Log.d("genreMovieList",movieLists.toString())
        setupPagerWithTab(genreMovieList)
    }

    private fun setupPagerWithTab(genres: List<GenresVO>) {
        val viewPagerAdapter = TabPagerAdapter(supportFragmentManager, genres)
        viewPager.adapter = viewPagerAdapter
        viewPager.currentItem = 0
        tabLayout.setupWithViewPager(viewPager)
    }

    override fun enableSwipeRefresh()
    {
    }

    override fun disableSwipeRefresh() {

    }

    override fun showErrorMessage(errorMessage: String) {
        Log.d("Error",errorMessage)
    }
    fun showEmptyView(){
    mViewPodEmpty.visibility= View.VISIBLE
    }

    fun hideEmptyView(){
    mViewPodEmpty.visibility=View.GONE
    }


}