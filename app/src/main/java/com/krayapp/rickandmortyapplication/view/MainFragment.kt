package com.krayapp.rickandmortyapplication.view

import androidx.fragment.app.Fragment
import com.krayapp.rickandmortyapplication.R

class MainFragment : Fragment(R.layout.main_fragment) {
    companion object {
        fun newInstance(): Fragment = MainFragment()
    }
}