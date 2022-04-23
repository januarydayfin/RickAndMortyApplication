package com.krayapp.rickandmortyapplication.view

import android.opengl.Visibility
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.addRepeatingJob
import androidx.lifecycle.lifecycleScope
import by.kirich1409.viewbindingdelegate.viewBinding
import com.krayapp.rickandmortyapplication.R
import com.krayapp.rickandmortyapplication.databinding.MainFragmentBinding
import com.krayapp.rickandmortyapplication.toast
import com.krayapp.rickandmortyapplication.view.adapter.CharacterAdapter
import com.krayapp.rickandmortyapplication.viewmodel.MainViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainFragment : Fragment(R.layout.main_fragment), OpenCharacterDelegate {
    companion object {
        fun newInstance(): Fragment = MainFragment()
    }

    private val viewBinding: MainFragmentBinding by viewBinding()
    private val viewModel: MainViewModel by viewModel()
    private val characterAdapter = CharacterAdapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.loadCharacters()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewBinding.mainRecycler.adapter = characterAdapter
        toast("Loading...")
        getCharactersList()
    }

    private fun getCharactersList() {
        addRepeatingJob(Lifecycle.State.STARTED) {
            viewModel.characterListFlow.collectLatest {
                characterAdapter.submitData(it)
            }
        }
    }

    override fun clickCharacter(id: Int) {
        requireActivity().supportFragmentManager.apply {
            beginTransaction()
                .add(R.id.container, OpenedCharacterFragment.newInstance(id))
                .hide(this@MainFragment)
                .setTransition((FragmentTransaction.TRANSIT_FRAGMENT_FADE))
                .addToBackStack("")
                .commitAllowingStateLoss()
        }
    }


}