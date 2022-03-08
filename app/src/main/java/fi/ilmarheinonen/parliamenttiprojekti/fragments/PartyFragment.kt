package fi.ilmarheinonen.parliamenttiprojekti.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import fi.ilmarheinonen.parliamenttiprojekti.R
import fi.ilmarheinonen.parliamenttiprojekti.databinding.FragmentPartyBinding
import fi.ilmarheinonen.parliamenttiprojekti.partiesMemberOfParliament
import fi.ilmarheinonen.parliamenttiprojekti.recyclerview.PartiesAdapter

class PartyFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        //Creates an instance of the binding class for the activity
        val binding = DataBindingUtil.inflate<FragmentPartyBinding>(
            inflater,
            R.layout.fragment_party, container, false
        )

        binding.partyRecyclerView.apply {
            //LayoutManager for RecyclerView
            layoutManager = LinearLayoutManager(context)

            //Adapter for RecyclerView
            adapter = PartiesAdapter(partiesMemberOfParliament)

        }

        //Inflates view
        return binding.root

    }

}