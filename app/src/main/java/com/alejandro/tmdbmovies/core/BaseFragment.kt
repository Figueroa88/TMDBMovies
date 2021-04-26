package com.alejandro.tmdbmovies.core

import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment

abstract class BaseFragment(@LayoutRes private val layout:Int) : Fragment(layout)
{

}