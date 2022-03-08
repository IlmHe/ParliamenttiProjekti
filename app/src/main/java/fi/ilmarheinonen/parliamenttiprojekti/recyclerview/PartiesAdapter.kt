package fi.ilmarheinonen.parliamenttiprojekti.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import fi.ilmarheinonen.parliamenttiprojekti.R
import fi.ilmarheinonen.parliamenttiprojekti.fragments.clickedParty

//Save TextView partiesId to val partiesId
private val View.partiesId: TextView
    get() = findViewById(R.id.partiesId)

/**
 * 08/03/2022
 * Ilmar Heinonen
 * 2110597
 * Adapter for PartyFragmentRecyclerView, handles data
 */

class PartiesAdapter(private val parties: List<String>) :
    RecyclerView.Adapter<PartiesAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        //Obtains LayoutInflater from context and inflates card_party
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_party, parent, false)

        return ViewHolder(view)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        //Populate RecyclerView with list of parties (partiesMemberOfParliament)
        holder.view.partiesId.text = parties[position]

        holder.view.setOnClickListener { view: View ->

            //save clicked party to clickedParty
            clickedParty = parties[position]

            //Utilizes navigation.xml to move to memberList fragment
            view.findNavController().navigate(R.id.action_partyFragment_to_membersListFragment)
        }
    }

    //Returns members length
    override fun getItemCount() = parties.size

    //Describes an item view and metadata about its place within the RecyclerView
    inner class ViewHolder(val view: View) : RecyclerView.ViewHolder(view)

}





