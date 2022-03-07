package fi.ilmarheinonen.parliamenttiprojekti.recyclerview

import android.graphics.Bitmap
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.util.Log
import android.util.Log.d
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import fi.ilmarheinonen.parliamenttiprojekti.R
import fi.ilmarheinonen.parliamenttiprojekti.fragments.*
import fi.ilmarheinonen.parliamenttiprojekti.viewModel

private val View.membersId: TextView
    get() = findViewById(R.id.membersId)

var picture = ""


class MemberListAdapter(private val members: MutableList<String>) :
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

        holder.view.setOnClickListener { view: View ->
            clickedMemberFirst = members[position]
            val list = clickedMemberFirst.split(" ")
            clickedMemberFirst = list[0]
            clickedMemberLast = list[1]
            picture = GetPicture(clickedMemberFirst, clickedMemberLast)

            view.findNavController().navigate(R.id.action_membersListFragment_to_memberFragment)
        }
    }


    override fun getItemCount() = members.size

    inner class ViewHolder(val view: View) : RecyclerView.ViewHolder(view)


}
