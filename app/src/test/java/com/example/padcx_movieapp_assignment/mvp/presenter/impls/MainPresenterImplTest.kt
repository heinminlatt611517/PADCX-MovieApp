package com.example.padcx_movieapp_assignment.mvp.presenter.impls

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LifecycleRegistry
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.padcx_movieapp_assignment.data.model.MovieModel
import com.example.padcx_movieapp_assignment.data.model.impls.MovieModelImpl
import com.example.padcx_movieapp_assignment.data.model.impls.MockMovieImpls
import com.example.padcx_movieapp_assignment.data.vos.NowPlayingMovieVO
import com.example.padcx_movieapp_assignment.mvp.presenters.impls.MainPresenterImpl
import com.example.padcx_movieapp_assignment.mvp.views.MainView
import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.verify
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito
import org.robolectric.annotation.Config

@RunWith(AndroidJUnit4::class)
@Config(manifest = Config.NONE)
class MainPresenterImplTest {

    private lateinit var mPresenter: MainPresenterImpl

    @RelaxedMockK
    private lateinit var mView: MainView

    private lateinit var mMovieModel: MovieModel

    @Before
    fun setupPresenter() {
        MockKAnnotations.init(this)

        MovieModelImpl.initDatabase(ApplicationProvider.getApplicationContext())
        mMovieModel = MockMovieImpls

        mPresenter = MainPresenterImpl()
        mPresenter.initPresenter(mView)
        mPresenter.mMovieModel = this.mMovieModel
    }

    @Test
    fun onUIReady_displayMovieList(){
        val lifeCycleOwner = Mockito.mock(LifecycleOwner::class.java)
        val lifeCycleRegistry = LifecycleRegistry(lifeCycleOwner)
        lifeCycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_RESUME)
        Mockito.`when`(lifeCycleOwner.lifecycle).thenReturn(lifeCycleRegistry)

        mPresenter.onUIReady(lifeCycleOwner)

        verify {
            mView.showNowPlayingMovieSlider(
                mutableListOf(NowPlayingMovieVO(), NowPlayingMovieVO(), NowPlayingMovieVO()))
        }

    }
}