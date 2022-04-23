package com.krayapp.rickandmortyapplication.view
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import by.kirich1409.viewbindingdelegate.viewBinding
import com.krayapp.rickandmortyapplication.NetworkListener
import com.krayapp.rickandmortyapplication.R
import com.krayapp.rickandmortyapplication.databinding.OpenedCharacterFragmentBinding
import com.krayapp.rickandmortyapplication.model.CharacterInfo
import com.krayapp.rickandmortyapplication.model.retrofit.ImageLoader
import com.krayapp.rickandmortyapplication.toast
import com.krayapp.rickandmortyapplication.viewmodel.OpenedCharacterViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class OpenedCharacterFragment:Fragment(R.layout.opened_character_fragment) {
    companion object{
        private val CHARACTER_KEY = "CHARACTER_KEY"
        fun newInstance(id:Int):Fragment {
            val fragment = OpenedCharacterFragment()
            fragment.arguments = bundleOf(Pair(CHARACTER_KEY, id))
            return fragment
        }
    }

    private val viewBinding:OpenedCharacterFragmentBinding by viewBinding()
    private val viewModel:OpenedCharacterViewModel by viewModel()
    private val networkListener: NetworkListener by inject()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if(networkListener.isOnline()){
            viewModel.getCharacterById(requireArguments().getInt(CHARACTER_KEY))
        }else{
            toast("Need internet connection")
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        toast("Loading...")
            collectInfo()
    }
    private fun collectInfo(){
        viewModel.characterFlow.onEach {
            renderCharacter(it)
        }.launchIn(lifecycleScope)
    }
    private fun renderCharacter(characterInfo: CharacterInfo){
        with(viewBinding){
            name.text = "${characterInfo.name}"
            race.text = "Race: ${characterInfo.race}"
            gender.text = "Gender: ${characterInfo.gender}"
            liveStatus.text = "Alive? - ${characterInfo.status}"
            lastLocation.text = "Last location: ${characterInfo.lastLocation}"
            episodeCount.text = "Played in Episodes of: ${characterInfo.episodeCount.toString()}"
            if (characterInfo.image != ""){
                ImageLoader.loadPortrait(characterInfo.image, image)
            }
        }
    }
}