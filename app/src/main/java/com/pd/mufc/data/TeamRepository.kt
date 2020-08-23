package com.pd.mufc.data

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.pd.mufc.data.entities.Team
import com.pd.mufc.data.remote.MUFCApiService.apiInterface
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers

class TeamRepository {

    private val TAG: String? = TeamRepository::class.simpleName
    private var teamDetail = MutableLiveData<Team>()
    private val compositeDisposable = CompositeDisposable()

    fun getTeamDetail(id: Int): MutableLiveData<Team> {

        Log.d(TAG, Thread.currentThread().name)

        /**
         * subscribe returns a disposable
         */
        compositeDisposable.add(
            apiInterface.getTeamDetail(id = id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { result -> handleSuccess(result) }
        )


        /**
         * doing the same thing with retrofit callback
         */

        /*val call = apiInterface.getTeamDetail(id = id)
        call.enqueue(object : Callback<Team> {
            override fun onResponse(call: Call<Team>, response: Response<Team>) {
                Log.d(TAG!!, "URL " + call.request().url.toString())

                if (response.isSuccessful) {
                    Log.d(TAG!!, "Response " + response.message())
                    teamDetail.value = response.body()
                }
            }

            override fun onFailure(call: Call<Team>, t: Throwable) {
                teamDetail.value = null
                Log.d(TAG!!, "Error " + t.localizedMessage)
            }
        })*/

        return teamDetail
    }

    private fun handleSuccess(team: Team) {
        Log.d(TAG, Thread.currentThread().name)
        teamDetail.value = team
    }

    private fun handleError(throwable: Throwable) {
        teamDetail.value = null
        Log.e(TAG, "Error ${throwable.localizedMessage}")
    }

}