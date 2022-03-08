package fi.ilmarheinonen.parliamenttiprojekti.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import fi.ilmarheinonen.parliamenttiprojekti.*
import fi.ilmarheinonen.parliamenttiprojekti.databinding.FragmentPartyBinding
import fi.ilmarheinonen.parliamenttiprojekti.recyclerview.MemberListAdapter

var clickedParty: String = ""

/**
 * 08/03/2022
 * Ilmar Heinonen
 * 2110597
 * Shows a list of members in the selected party
 */

class MembersListFragment : Fragment() {

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


        fullNameMemberOfParliament.clear()
        fullNames()


        binding.partyRecyclerView.apply {
            //LayoutManager for RecyclerView
            layoutManager = LinearLayoutManager(context)

            //Adapter for RecyclerView
            adapter = MemberListAdapter(fullNameMemberOfParliament)

        }

        //Inflates view
        return binding.root

    }
}

//Creates a list of First and Last from MemberOfParliament
fun fullNames() {
    var text: String
    var i = 0
    do {
        if (allPartiesDuplicate[i].equals(clickedParty)) {
            text = firstNameMemberOfParliament[i] + " " + lastNameMemberOfParliament[i]

            fullNameMemberOfParliament.add(text)

        }
        i++
    } while (i != 200)
}

//Gets the picture of the selected MemberOfParliament
fun getPicture(firstName: String, lastName: String): String {
    allMemberOfParliament.forEach {
        if (it.first.equals(firstName) && it.last.equals(lastName)) {
            return it.picture
        }
    }
    return "Something went wrong"

}


