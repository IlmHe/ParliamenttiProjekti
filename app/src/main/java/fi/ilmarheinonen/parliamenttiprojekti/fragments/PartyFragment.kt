package fi.ilmarheinonen.parliamenttiprojekti.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import fi.ilmarheinonen.parliamenttiprojekti.R
import fi.ilmarheinonen.parliamenttiprojekti.databinding.FragmentHomeBinding
import fi.ilmarheinonen.parliamenttiprojekti.databinding.FragmentPartyBinding


class PartyFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val binding = DataBindingUtil.inflate<FragmentPartyBinding>(inflater,
            R.layout.fragment_party,container,false)
        binding.partyButton.setOnClickListener{view : View ->
            view.findNavController().navigate(R.id.action_partyFragment_to_membersListFragment)
        }
        return binding.root
    }
}