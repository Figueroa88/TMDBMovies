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
import com.alejandro.tmdbmovies.presentation.movieList.MoviePopularListFragment
import com.alejandro.tmdbmovies.presentation.movieList.MovieTopListFragment
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : BaseActivity()
{
    private lateinit var mViewBinding:AMainBinding

    companion object
    {
        fun getInstance(context: Context): Intent
        {
            return Intent(context, MainActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        mViewBinding = AMainBinding.inflate(layoutInflater)
        setContentView(mViewBinding.root)

        //val navView: BottomNavigationView = findViewById(R.id.nav_view)
        val navView: BottomNavigationView = mViewBinding.navView

        val navController = findNavController(R.id.fcvContent)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.moviePopularListFragment, R.id.movieTopListFragment
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        //Initialize

        initView()
    }

    private fun initView()
    {
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
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

    override fun onOptionsItemSelected(item: MenuItem): Boolean
    {
        super.onOptionsItemSelected(item)

        onBackPressed()

        return true
    }

    fun showOrHideBottomBar(isShow:Boolean)
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