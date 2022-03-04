package fi.ilmarheinonen.parliamenttiprojekti.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import fi.ilmarheinonen.parliamenttiprojekti.R
import fi.ilmarheinonen.parliamenttiprojekti.databinding.FragmentHomeBinding
import fi.ilmarheinonen.parliamenttiprojekti.databinding.FragmentMembersListBinding
import fi.ilmarheinonen.parliamenttiprojekti.databinding.FragmentPartyBinding
import fi.ilmarheinonen.parliamenttiprojekti.fullNameMemberOfParliament
import fi.ilmarheinonen.parliamenttiprojekti.partiesMemberOfParliament
import fi.ilmarheinonen.parliamenttiprojekti.recyclerview.MemberListAdapter
import fi.ilmarheinonen.parliamenttiprojekti.recyclerview.PartiesAdapter

class MembersListFragment : Fragment() {

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
            adapter = MemberListAdapter(fullNameMemberOfParliament)

        }



        return binding.root

    }
}