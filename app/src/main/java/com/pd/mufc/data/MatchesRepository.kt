package com.pd.mufc.data

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.pd.mufc.data.entities.Matches
import com.pd.mufc.data.remote.MUFCApiService.apiInterface
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class MatchesRepository {

    companion object{
        private val TAG: String? = MatchesRepository::class.simpleName
    }

    private val matchesLiveData = MutableLiveData<Matches>()
    private val compositeDisposable = CompositeDisposable()

    fun getMatches(id: Int): MutableLiveData<Matches>{

        compositeDisposable.add(
            apiInterface.getTeamMatches(id = id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    value -> handleSuccess(value)
                },{
                    error -> handleError(error)
                },{
                    Log.d(TAG, "Completed")
                })
        )
        return matchesLiveData
    }

    private fun handleSuccess(matches: Matches){
        matchesLiveData.value = matches
        Log.d(TAG, "Next item: ${matches.matches[0].score}")
    }

    private fun handleError(throwable: Throwable){
        matchesLiveData.value = null
        Log.d(TAG, "Error: ${throwable.localizedMessage}")
    }
}