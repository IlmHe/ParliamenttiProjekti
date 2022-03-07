package fi.ilmarheinonen.parliamenttiprojekti.fragments

import android.os.Bundle
import android.util.Log
import android.util.Log.d
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import fi.ilmarheinonen.parliamenttiprojekti.*
import fi.ilmarheinonen.parliamenttiprojekti.databinding.FragmentHomeBinding
import fi.ilmarheinonen.parliamenttiprojekti.databinding.FragmentMembersListBinding
import fi.ilmarheinonen.parliamenttiprojekti.databinding.FragmentPartyBinding
import fi.ilmarheinonen.parliamenttiprojekti.recyclerview.MemberListAdapter
import fi.ilmarheinonen.parliamenttiprojekti.recyclerview.PartiesAdapter

var clickedMemberFirst: String = ""
var clickedMemberLast: String = ""


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

        fullNameMemberOfParliament.clear()
        FullNames()


        binding.partyRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = MemberListAdapter(fullNameMemberOfParliament)

        }
        return binding.root

    }
}

fun FullNames() {
    var text: String = ""
    var i: Int = 0
    do {
        if (allPartiesDuplicate[i].equals(clickedParty)) {
            text = firstNameMemberOfParliament[i] + " " + lastNameMemberOfParliament[i]

            fullNameMemberOfParliament.add(text)

        }
        i++
    } while (i != 200)
}

fun GetPicture(firstName: String, lastName: String): String {
    allmemberOfParliament.forEach {
        if (it.first.equals(firstName) && it.last.equals(lastName)) {
            return it.picture
        }
    }
    return "Something went wrong"

}


