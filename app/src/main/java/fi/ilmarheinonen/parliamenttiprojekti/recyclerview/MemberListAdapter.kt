package fi.ilmarheinonen.parliamenttiprojekti.recyclerview

import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import fi.ilmarheinonen.parliamenttiprojekti.R
import fi.ilmarheinonen.parliamenttiprojekti.fragments.clickedParty
import fi.ilmarheinonen.parliamenttiprojekti.fullNameMemberOfParliament

private val View.membersId: TextView
    get() = findViewById(R.id.membersId)

class MemberListAdapter(private val members: List<String>) :
    RecyclerView.Adapter<MemberListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MemberListAdapter.ViewHolder {

        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.card_members_list, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: MemberListAdapter.ViewHolder, position: Int) {

        holder.view.membersId.text = members[position]
        Log.i("tag","${fullNameMemberOfParliament}")


        holder.view.setOnClickListener {
        }

        holder.view.setOnClickListener { view: View ->
            //clickedParty = members[position]
            //view.findNavController().navigate(R.id.action_partyFragment_to_membersListFragment)
        }
    }


    override fun getItemCount() = members.size

    inner class ViewHolder(val view: View) : RecyclerView.ViewHolder(view)


}
