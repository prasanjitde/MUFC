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

class TeamFragment : Fragment() {

    private lateinit var teamViewModel: TeamViewModel
    private val TAG = TeamFragment::class.simpleName

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        Observable.just(1, 3, 5, 8, 10)
            .map { it * 5 }
            .subscribe { value -> Log.d("Print", "$value")}

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
}