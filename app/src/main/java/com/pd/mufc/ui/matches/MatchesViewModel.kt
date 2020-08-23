package com.pd.mufc.ui.matches

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.pd.mufc.data.MatchesRepository
import com.pd.mufc.data.entities.Matches

class MatchesViewModel : ViewModel() {

    var matchesLiveData = MutableLiveData<Matches>()
    private val matchesRepository = MatchesRepository()

    fun getMatches(id: Int){
        matchesLiveData = matchesRepository.getMatches(id)
    }
}