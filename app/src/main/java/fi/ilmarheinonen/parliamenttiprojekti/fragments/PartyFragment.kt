package fi.ilmarheinonen.parliamenttiprojekti.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import fi.ilmarheinonen.parliamenttiprojekti.R
import fi.ilmarheinonen.parliamenttiprojekti.databinding.FragmentPartyBinding


class PartyFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = DataBindingUtil.inflate<FragmentPartyBinding>(
            inflater,
            R.layout.fragment_party, container, false
        )
        return binding.root
    }
}