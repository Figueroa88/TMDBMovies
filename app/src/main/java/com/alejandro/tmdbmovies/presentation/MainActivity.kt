package com.alejandro.tmdbmovies.presentation

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.alejandro.tmdbmovies.R
import com.alejandro.tmdbmovies.core.BaseActivity
import com.alejandro.tmdbmovies.databinding.AMainBinding
import com.alejandro.tmdbmovies.presentation.movieList.popularMovies.MoviePopularListFragment
import com.alejandro.tmdbmovies.presentation.movieList.topRated.MovieTopListFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint


/**
 * @since 1.0.0
 *
 * createdDate 26/04/2021
 * updatedDate 26/04/2021
 *
 * ACTIVITY que servira como contenedor de la vistas de la app
 */
@AndroidEntryPoint
class MainActivity : BaseActivity()
{
    //View

    private lateinit var mViewBinding: AMainBinding

    ////////////////////////////
    ///                      ///
    ///       INSTANCE       ///
    ///                      ///
    ////////////////////////////

    companion object
    {
        fun getInstance(context: Context): Intent
        {
            return Intent(context, MainActivity::class.java)
        }
    }

    ////////////////////////////
    ///                      ///
    ///       OVERRIDE       ///
    ///                      ///
    ////////////////////////////

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        mViewBinding = AMainBinding.inflate(layoutInflater)
        setContentView(mViewBinding.root)

        //Initialize

        initView()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean
    {
        super.onOptionsItemSelected(item)

        onBackPressed()

        return true
    }

    override fun onBackPressed()
    {
        val navigationFragment: Fragment? = supportFragmentManager.findFragmentById(R.id.fcvContent)
        val fragmentList = navigationFragment?.childFragmentManager?.fragments

        if (fragmentList?.size!! > 0 && (fragmentList[0] is MoviePopularListFragment || fragmentList[0] is MovieTopListFragment))
        {
            finish()
        }
        else
        {
            super.onBackPressed()
        }
    }

    ////////////////////////////
    ///                      ///
    ///         INIT         ///
    ///                      ///
    ////////////////////////////

    private fun initView()
    {
        //Animacion

        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)

        //Configuracion de navegacion

        val navView: BottomNavigationView = mViewBinding.navView

        val navController = findNavController(R.id.fcvContent)

        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.moviePopularListFragment, R.id.movieTopListFragment
            )
        )

        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }

    ////////////////////////////
    ///                      ///
    ///       METHODS        ///
    ///                      ///
    ////////////////////////////

    fun showOrHideBottomBar(isShow: Boolean)
    {
        if (isShow)
        {
            mViewBinding.navView.visibility = View.VISIBLE
        }
        else
        {
            mViewBinding.navView.visibility = View.GONE
        }
    }
}