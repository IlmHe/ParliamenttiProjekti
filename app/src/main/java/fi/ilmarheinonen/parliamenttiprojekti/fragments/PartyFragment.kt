package fi.ilmarheinonen.parliamenttiprojekti.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import fi.ilmarheinonen.parliamenttiprojekti.R
import fi.ilmarheinonen.parliamenttiprojekti.api.MemberOfParliament
import fi.ilmarheinonen.parliamenttiprojekti.databinding.FragmentPartyBinding
import fi.ilmarheinonen.parliamenttiprojekti.partiesMemberOfParliament
import fi.ilmarheinonen.parliamenttiprojekti.recyclerview.PartiesAdapter

var clickedParty: String = ""
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

        binding.partyRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = PartiesAdapter(partiesMemberOfParliament)

        }



        return binding.root

    }

}