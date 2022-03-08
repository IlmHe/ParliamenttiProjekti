package fi.ilmarheinonen.parliamenttiprojekti.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import fi.ilmarheinonen.parliamenttiprojekti.R
import fi.ilmarheinonen.parliamenttiprojekti.databinding.FragmentMemberBinding
import fi.ilmarheinonen.parliamenttiprojekti.recyclerview.MemberAdapter

//For storing First and Last name
var clickedMemberFirst: String = ""
var clickedMemberLast: String = ""

class MemberFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        //Creates an instance of the binding class for the activity
        val binding = DataBindingUtil.inflate<FragmentMemberBinding>(
            inflater,
            R.layout.fragment_member, container, false
        )

        //Save this context and pass it to MemberAdapter for Glide
        val contextThis = (context)


        binding.memberRecyclerView.apply {
            //LayoutManager for RecyclerView
            layoutManager = LinearLayoutManager(context)

            //Adapter for RecyclerView
            adapter = contextThis?.let { MemberAdapter(clickedMemberFirst, clickedMemberLast, it) }

        }

        //Inflates view
        return binding.root

    }
}