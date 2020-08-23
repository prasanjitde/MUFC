package com.pd.mufc.ui.team

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.pd.mufc.R
import com.pd.mufc.data.MatchesRepository
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class TeamFragment : Fragment() {

    private lateinit var teamViewModel: TeamViewModel
    private val TAG = TeamFragment::class.simpleName
    private val compositeDisposable = CompositeDisposable()

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        Observable.just(1, 3, 5, 8, 10)
            .map { it * 5 }
            .subscribe { value -> Log.d("Print", "$value")}


        compositeDisposable.add(Observable.fromArray("Foo", "Faa", "Hoo", "Soo", "Poo")
            .subscribeOn(Schedulers.computation())
            .map { it == it + "Bar" }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {value -> Log.d("Print", "$value")},
                {error -> Log.e("Print", "$error")},
                {Log.d("Print", "Complete")},
                {Log.d("Print", "onSubscribe()")}
            )
        )

        teamViewModel =
                ViewModelProviders.of(this).get(TeamViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_team, container, false)
        val textView: TextView = root.findViewById(R.id.text_home)

        Log.d(TAG, Thread.currentThread().name)

        teamViewModel.getTeamDetail(86)

        teamViewModel.team.observe(viewLifecycleOwner, Observer {
            textView.text = it?.name
        })
        return root
    }

    override fun onDestroy() {
        super.onDestroy()
        if(!compositeDisposable.isDisposed){
            compositeDisposable.dispose()
        }
    }
}