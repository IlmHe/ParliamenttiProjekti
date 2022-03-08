package fi.ilmarheinonen.parliamenttiprojekti.recyclerview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import fi.ilmarheinonen.parliamenttiprojekti.R

//Save TextView firstName to val firstName
private val View.firstName: TextView
    get() = findViewById(R.id.firstName)

//Save TextView lastName to val lastName
private val View.lastName: TextView
    get() = findViewById(R.id.lastName)

//Save ImageView idImageView to val imgView
private val View.imgView: ImageView
    get() = findViewById(R.id.idImageView)


class MemberAdapter(
    private val members: String,
    private val membersLast: String,
    private val context: Context
) :
    RecyclerView.Adapter<MemberAdapter.ViewHolder>() {


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MemberAdapter.ViewHolder {

        //Obtains LayoutInflater from context and inflates card_member
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.card_member, parent, false)

        return ViewHolder(view)
    }


    override fun onBindViewHolder(holder: MemberAdapter.ViewHolder, position: Int) {

        //Set TextView to members(first name) and membersLast (last name)
        holder.view.firstName.text = members
        holder.view.lastName.text = membersLast

        //Load animation for pictures
        val circularProgressDrawable = CircularProgressDrawable(context)
        circularProgressDrawable.strokeWidth = 10f
        circularProgressDrawable.centerRadius = 30f
        circularProgressDrawable.start()

        //Uploads pictures to imgView
        Glide.with(context)
            .load("https://avoindata.eduskunta.fi/$picture")
            .placeholder(circularProgressDrawable)
            .into(holder.view.imgView)


    }

    //Returns members.length
    override fun getItemCount() = members.length


    //Describes an item view and metadata about its place within the RecyclerView
    inner class ViewHolder(val view: View) : RecyclerView.ViewHolder(view)


}