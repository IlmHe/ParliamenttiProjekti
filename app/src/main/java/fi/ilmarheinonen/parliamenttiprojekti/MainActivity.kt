package fi.ilmarheinonen.parliamenttiprojekti

import MemberApi
import android.app.Application
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import fi.ilmarheinonen.parliamenttiprojekti.RoomDB.MembersDatabase
import fi.ilmarheinonen.parliamenttiprojekti.api.MemberOfParliament
import kotlinx.coroutines.launch

/**
 * 08/03/2022
 * Ilmar Heinonen
 * 2110597
 * Initializes navController, ViewModel, navigateUp
 */

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Enables the usage of navigation.xml
        val navController = this.findNavController(R.id.myNavHostFragment)
        NavigationUI.setupActionBarWithNavController(this, navController)

        //Provides ViewModel for scope
        val factory = ViewModelProvider.AndroidViewModelFactory.getInstance(application)
        viewModel = ViewModelProvider(this, factory).get(MainActivityViewModel::class.java)


    }

    //Enables navigateUp to correctly go to previous layout
    override fun onSupportNavigateUp(): Boolean {
        val navController = this.findNavController(R.id.myNavHostFragment)
        return navController.navigateUp()
    }


}


lateinit var viewModel: MainActivityViewModel


//For storing data from the RoomDB
var fullNameMemberOfParliament = mutableListOf<String>()
var firstNameMemberOfParliament = mutableListOf<String>()
var partiesMemberOfParliament = listOf<String>()
var lastNameMemberOfParliament = mutableListOf<String>()
var allPartiesDuplicate = listOf<String>()
var allMemberOfParliament = listOf<MemberOfParliament>()



/**
 * 08/03/2022
 * Ilmar Heinonen
 * 2110597
 * ViewModel class, also creates the Database and fetches/inserts data
 */

class MainActivityViewModel(application: Application) : AndroidViewModel(application) {

    //Save MembersDao to variable
    private val membersDao = MembersDatabase.getDatabase(application).MembersDao()


    init {
        // Runs ReadMembers when viewmodel is created
        readMembers()
    }


    private fun readMembers() {

        viewModelScope.launch {

            //Insert data from retrofit to RoomDB
            val members = MemberApi.retrofitService.getMemberList()
            membersDao.insertMember(members)

            //Save data to variables for usage
            partiesMemberOfParliament = membersDao.getParties().distinct()
            firstNameMemberOfParliament = membersDao.getFirstName()
            lastNameMemberOfParliament = membersDao.getLastName()
            allPartiesDuplicate = membersDao.getParties()
            allMemberOfParliament = membersDao.getAllMembers()


        }
    }


}


