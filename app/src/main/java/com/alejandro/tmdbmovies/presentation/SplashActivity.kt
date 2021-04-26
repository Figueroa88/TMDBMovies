package com.alejandro.tmdbmovies.presentation

import android.os.Bundle
import com.alejandro.tmdbmovies.R
import com.alejandro.tmdbmovies.core.BaseActivity
import com.alejandro.tmdbmovies.databinding.ASplashBinding


class SplashActivity : BaseActivity()
{
    private lateinit var mViewBinding: ASplashBinding

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        mViewBinding = ASplashBinding.inflate(layoutInflater)
        setContentView(mViewBinding.root)

        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)

        supportActionBar?.let {
            it.hide()
        }
    }
}