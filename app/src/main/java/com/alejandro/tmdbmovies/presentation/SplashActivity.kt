package com.alejandro.tmdbmovies.presentation

import android.os.Bundle
import androidx.constraintlayout.motion.widget.MotionLayout
import com.alejandro.tmdbmovies.R
import com.alejandro.tmdbmovies.core.BaseActivity
import com.alejandro.tmdbmovies.databinding.ASplashBinding


/**
 * @since 1.0.0
 *
 * createdDate 26/04/2021
 * updatedDate 26/04/2021
 *
 * ACTIVITY inicial de la app que muestra un SPLASH
 */
class SplashActivity : BaseActivity()
{
    //View

    private lateinit var mViewBinding: ASplashBinding

    ////////////////////////////
    ///                      ///
    ///       OVERRIDE       ///
    ///                      ///
    ////////////////////////////

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        mViewBinding = ASplashBinding.inflate(layoutInflater)
        setContentView(mViewBinding.root)

        //Initialize

        initView()
        initListener()
    }

    ////////////////////////////
    ///                      ///
    ///         INIT         ///
    ///                      ///
    ////////////////////////////

    private fun initView()
    {
        supportActionBar?.hide()

        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
    }

    private fun initListener()
    {
        animationListener(mViewBinding.mlContent)
    }

    ////////////////////////////
    ///                      ///
    ///        EVENTS        ///
    ///                      ///
    ////////////////////////////

    private fun animationListener(mlContent: MotionLayout)
    {
        mlContent.setTransitionListener(object : MotionLayout.TransitionListener
        {
            override fun onTransitionStarted(p0: MotionLayout?, p1: Int, p2: Int)
            {

            }

            override fun onTransitionChange(p0: MotionLayout?, p1: Int, p2: Int, p3: Float)
            {

            }

            override fun onTransitionCompleted(p0: MotionLayout?, p1: Int)
            {
                startActivity(MainActivity.getInstance(this@SplashActivity))

                finish()
            }

            override fun onTransitionTrigger(p0: MotionLayout?, p1: Int, p2: Boolean, p3: Float)
            {
            }
        })
    }
}