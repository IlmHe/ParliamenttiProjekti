package fi.ilmarheinonen.parliamenttiprojekti.fragments

import android.app.Application
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.*
import androidx.navigation.findNavController
import androidx.room.Room
import fi.ilmarheinonen.parliamenttiprojekti.MainActivity
import fi.ilmarheinonen.parliamenttiprojekti.R
import fi.ilmarheinonen.parliamenttiprojekti.RoomDB.MembersDao
import fi.ilmarheinonen.parliamenttiprojekti.RoomDB.MembersDatabase
import fi.ilmarheinonen.parliamenttiprojekti.api.MemberOfParliament
import fi.ilmarheinonen.parliamenttiprojekti.databinding.ActivityMainBinding
import fi.ilmarheinonen.parliamenttiprojekti.databinding.FragmentHomeBinding
import fi.ilmarheinonen.parliamenttiprojekti.viewModel
import kotlinx.coroutines.launch


class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {

        val binding = DataBindingUtil.inflate<FragmentHomeBinding>(
            inflater,
            R.layout.fragment_home, container, false
        )


        binding.homeButton.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_homeFragment_to_partyFragment)
        }



        return binding.root
    }

}





