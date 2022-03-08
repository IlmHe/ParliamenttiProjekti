package fi.ilmarheinonen.parliamenttiprojekti.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import fi.ilmarheinonen.parliamenttiprojekti.R
import fi.ilmarheinonen.parliamenttiprojekti.databinding.FragmentHomeBinding

/**
 * 08/03/2022
 * Ilmar Heinonen
 * 2110597
 * HomeFragment displays home screen
 */

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {

        //Creates an instance of the binding class for the activity
        val binding = DataBindingUtil.inflate<FragmentHomeBinding>(
            inflater,
            R.layout.fragment_home, container, false
        )

        //Utilizes navigation.xml to move to party fragment
        binding.homeButton.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_homeFragment_to_partyFragment)
        }


        //Inflates view
        return binding.root
    }

}





