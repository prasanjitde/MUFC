package com.pd.mufc.ui.matches

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.pd.mufc.R

class MatchesFragment : Fragment() {

    private lateinit var matchesViewModel: MatchesViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        matchesViewModel =
                ViewModelProviders.of(this).get(MatchesViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_matches, container, false)
        val textView: TextView = root.findViewById(R.id.text_dashboard)

        matchesViewModel.getMatches(86)
        matchesViewModel.matchesLiveData.observe(viewLifecycleOwner, Observer {
            textView.text = it.matches[0].score.winner
        })
        return root
    }
}