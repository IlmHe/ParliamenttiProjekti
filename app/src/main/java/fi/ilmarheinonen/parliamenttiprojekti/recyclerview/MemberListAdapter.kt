package fi.ilmarheinonen.parliamenttiprojekti.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import fi.ilmarheinonen.parliamenttiprojekti.R
import fi.ilmarheinonen.parliamenttiprojekti.fragments.clickedMemberFirst
import fi.ilmarheinonen.parliamenttiprojekti.fragments.clickedMemberLast
import fi.ilmarheinonen.parliamenttiprojekti.fragments.getPicture

//Save TextView membersId to val membersId
private val View.membersId: TextView
    get() = findViewById(R.id.membersId)

//Saves the image attachment of the clicked member
var picture = ""


class MemberListAdapter(private val members: MutableList<String>) :
    RecyclerView.Adapter<MemberListAdapter.ViewHolder>() {


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MemberListAdapter.ViewHolder {

        //Obtains LayoutInflater from context and inflates card_member_list
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.card_members_list, parent, false)

        return ViewHolder(view)
    }


    override fun onBindViewHolder(holder: MemberListAdapter.ViewHolder, position: Int) {

        //Populate RecyclerView with list of members (fullNameMemberOfParliament)
        holder.view.membersId.text = members[position]

        holder.view.setOnClickListener { view: View ->

            //Stores First name to clickedMemberFirst and Last name to clickedMemberLast
            clickedMemberFirst = members[position]
            val list = clickedMemberFirst.split(" ")
            clickedMemberFirst = list[0]
            clickedMemberLast = list[1]

            //Uses getPicture function to save the picture attachment of the clicked member
            picture = getPicture(clickedMemberFirst, clickedMemberLast)

            //Utilizes navigation.xml to move to member fragment
            view.findNavController().navigate(R.id.action_membersListFragment_to_memberFragment)
        }
    }

    //Returns members size
    override fun getItemCount() = members.size

    //Describes an item view and metadata about its place within the RecyclerView
    inner class ViewHolder(val view: View) : RecyclerView.ViewHolder(view)


}
