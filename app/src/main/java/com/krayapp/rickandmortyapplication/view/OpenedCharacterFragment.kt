package com.krayapp.rickandmortyapplication.view
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.krayapp.rickandmortyapplication.R

class OpenedCharacterFragment:Fragment(R.layout.opened_character_fragment) {
    companion object{
        private val CHARACTER_KEY = "CHARACTER_KEY"
        fun newInstance(id:Int):Fragment {
            val fragment = OpenedCharacterFragment()
            fragment.arguments = bundleOf(Pair(CHARACTER_KEY, id))
            return fragment
        }
    }
}