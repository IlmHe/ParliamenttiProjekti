package fi.ilmarheinonen.parliamenttiprojekti.recyclerview

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import fi.ilmarheinonen.parliamenttiprojekti.R
import fi.ilmarheinonen.parliamenttiprojekti.fragments.*
import fi.ilmarheinonen.parliamenttiprojekti.viewModel
import kotlinx.android.synthetic.main.card_member.*

private val View.firstName: TextView
    get() = findViewById(R.id.firstName)
private val View.lastName: TextView
    get() = findViewById(R.id.lastName)
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

        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.card_member, parent, false)

        return ViewHolder(view)
    }


    override fun onBindViewHolder(holder: MemberAdapter.ViewHolder, position: Int) {
        holder.view.firstName.text = members
        holder.view.lastName.text = membersLast

        val circularProgressDrawable = CircularProgressDrawable(context)
        circularProgressDrawable.strokeWidth = 10f
        circularProgressDrawable.centerRadius = 30f
        circularProgressDrawable.start()


        Glide.with(context)
            .load("https://avoindata.eduskunta.fi/" + picture)
            .placeholder(circularProgressDrawable)
            .into(holder.view.imgView)


    }


    override fun getItemCount() = members.length

    inner class ViewHolder(val view: View) : RecyclerView.ViewHolder(view)


}