package com.pd.mufc.ui.team

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.pd.mufc.data.TeamRepository
import com.pd.mufc.data.entities.Team

class TeamViewModel(application: Application) : AndroidViewModel(application) {

    private val teamRepository = TeamRepository()
    var team: LiveData<Team> = MutableLiveData<Team>()

    private val TAG = TeamViewModel::class.simpleName

    companion object{}

    fun getTeamDetail(id: Int){
        Log.d(TAG, Thread.currentThread().name)
        team = teamRepository.getTeamDetail(id)
    }

}