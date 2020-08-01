package com.example.padcx_movieapp_assignment.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import com.example.padcx_movieapp_assignment.R
import com.example.padcx_movieapp_assignment.adapters.FragmentMovieAdapter
import com.example.padcx_movieapp_assignment.data.vos.MovieListVO
import com.example.padcx_movieapp_assignment.mvp.presenters.FragmentPresenter
import com.example.padcx_movieapp_assignment.mvp.presenters.impls.FragmentPresenterImpl
import com.example.padcx_movieapp_assignment.mvp.views.FragmentView
import kotlinx.android.synthetic.main.fragment_action.*

class FragmentAction : Fragment(),FragmentView {

    private lateinit var mFragmentMovieAdapter : FragmentMovieAdapter
    private lateinit var mPresenter : FragmentPresenter

    private var genreId : Int? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        genreId = arguments?.getInt(ID)
        return inflater.inflate(R.layout.fragment_action, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpPresenter()
        setUpRecyclerView()

       mPresenter.getMovieListByID(genreId?:0)

    }


    private fun setUpPresenter(){
        mPresenter=ViewModelProviders.of(this).get(FragmentPresenterImpl::class.java)
        mPresenter.initPresenter(this)

    }

    private fun setUpRecyclerView(){
        mFragmentMovieAdapter= FragmentMovieAdapter()
        recyclerView.adapter=mFragmentMovieAdapter
    }


    companion object {
        private const val ID = "genre-id"
        fun newInstance(id: Int) : FragmentAction {
            val bundle = Bundle()
            bundle.putInt(ID, id)
            val fragment = FragmentAction()
            fragment.arguments = bundle
            return fragment
        }
    }


    override fun showMovieList(movieLists: List<MovieListVO>) {
        Log.d("GenreList",movieLists.count().toString())
        mFragmentMovieAdapter.setNewData(movieLists.toMutableList())

    }

    override fun showErrorMessage(errorMessage: String) {

    }
}