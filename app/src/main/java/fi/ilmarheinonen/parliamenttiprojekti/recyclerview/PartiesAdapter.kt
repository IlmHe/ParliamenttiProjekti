package fi.ilmarheinonen.parliamenttiprojekti.recyclerview

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.CheckBox
import android.widget.ExpandableListView
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import fi.ilmarheinonen.parliamenttiprojekti.MainActivity
import fi.ilmarheinonen.parliamenttiprojekti.R
import fi.ilmarheinonen.parliamenttiprojekti.api.MemberOfParliament
import fi.ilmarheinonen.parliamenttiprojekti.databinding.FragmentPartyBinding
import fi.ilmarheinonen.parliamenttiprojekti.fragments.MemberFragment
import fi.ilmarheinonen.parliamenttiprojekti.fragments.PartyFragment
import fi.ilmarheinonen.parliamenttiprojekti.fragments.clickedParty

private val View.partiesId: TextView
    get() = findViewById(R.id.partiesId)


class PartiesAdapter(private val parties: List<String>) :
    RecyclerView.Adapter<PartiesAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_party, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount() = parties.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.view.partiesId.text = parties[position]

        holder.view.setOnClickListener { view: View ->
            clickedParty = parties[position]
            view.findNavController().navigate(R.id.action_partyFragment_to_membersListFragment)
        }
    }
    /*holder.view.setOnClickListener {
        val intent = Intent(holder.view.context,MainActivity::class.java)
        holder.view.context.startActivity(intent)
    }*/
    inner class ViewHolder(val view: View) : RecyclerView.ViewHolder(view)

}





