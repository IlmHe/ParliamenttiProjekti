package fi.ilmarheinonen.parliamenttiprojekti.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.navigation.findNavController
import androidx.room.Room
import fi.ilmarheinonen.parliamenttiprojekti.R
import fi.ilmarheinonen.parliamenttiprojekti.RoomDB.MembersDatabase
import fi.ilmarheinonen.parliamenttiprojekti.api.MemberOfParliament
import fi.ilmarheinonen.parliamenttiprojekti.databinding.ActivityMainBinding
import fi.ilmarheinonen.parliamenttiprojekti.databinding.FragmentHomeBinding
import kotlinx.coroutines.launch


class HomeFragment : Fragment() {
    private lateinit var viewModel: MainActivityViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val binding = DataBindingUtil.inflate<FragmentHomeBinding>(
            inflater,
            R.layout.fragment_home, container, false
        )

        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)

        /*binding.homeButton.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_homeFragment_to_partyFragment)
        }*/

        binding.homeButton.setOnClickListener {
            viewModel.readMembers()
        }

        return binding.root
    }

}

class MainActivityViewModel : ViewModel() {


    var members: MutableLiveData<List<MemberOfParliament>> = MutableLiveData()

    fun readMembers() {
        viewModelScope.launch {
            try {
                members.value = PlayerApi.retrofitService.getMemberList()

                println("Read players from NW with great success.${members.toString()}")
            } catch (e: Exception) {
                println("No luck in reading players from NW: ${e}")
            }

        }
    }


}
