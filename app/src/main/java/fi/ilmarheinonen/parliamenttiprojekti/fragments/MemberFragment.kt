package fi.ilmarheinonen.parliamenttiprojekti.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.util.Log.d
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import fi.ilmarheinonen.parliamenttiprojekti.R
import fi.ilmarheinonen.parliamenttiprojekti.databinding.FragmentHomeBinding
import fi.ilmarheinonen.parliamenttiprojekti.databinding.FragmentMemberBinding
import fi.ilmarheinonen.parliamenttiprojekti.fullNameMemberOfParliament
import fi.ilmarheinonen.parliamenttiprojekti.recyclerview.MemberAdapter
import fi.ilmarheinonen.parliamenttiprojekti.recyclerview.MemberListAdapter
import fi.ilmarheinonen.parliamenttiprojekti.recyclerview.picture
import kotlinx.android.synthetic.main.card_member.*


class MemberFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = DataBindingUtil.inflate<FragmentMemberBinding>(
            inflater,
            R.layout.fragment_member, container, false
        )
        val contextt = (context)

        binding.memberRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = contextt?.let { MemberAdapter(clickedMemberFirst, clickedMemberLast, it) }

        }
        return binding.root

    }
}