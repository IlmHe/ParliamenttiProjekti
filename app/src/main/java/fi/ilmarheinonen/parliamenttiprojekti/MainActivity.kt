package fi.ilmarheinonen.parliamenttiprojekti

import android.app.Application
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.lifecycle.*
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import com.bumptech.glide.Glide
import fi.ilmarheinonen.parliamenttiprojekti.RoomDB.MembersDatabase
import fi.ilmarheinonen.parliamenttiprojekti.api.MemberOfParliament
import fi.ilmarheinonen.parliamenttiprojekti.fragments.clickedParty
import fi.ilmarheinonen.parliamenttiprojekti.recyclerview.picture
import kotlinx.android.synthetic.main.fragment_member.*
import kotlinx.coroutines.launch
import java.util.concurrent.TimeUnit


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navController = this.findNavController(R.id.myNavHostFragment)
        NavigationUI.setupActionBarWithNavController(this, navController)

        /*var dataBase = Room.databaseBuilder(
            applicationContext, MembersDatabase::class.java, "MemberOfParliament"
        )
            .allowMainThreadQueries()
            .build()*/
        val factory = ViewModelProvider.AndroidViewModelFactory.getInstance(application)
        viewModel = ViewModelProvider(this, factory).get(MainActivityViewModel::class.java)

        //viewModel.ReadMembers()
    }


    override fun onSupportNavigateUp(): Boolean {
        val navController = this.findNavController(R.id.myNavHostFragment)
        return navController.navigateUp()
    }


}


lateinit var viewModel: MainActivityViewModel

var fullNameMemberOfParliament = mutableListOf<String>()
var firstNameMemberOfParliament = mutableListOf<String>()
var partiesMemberOfParliament = listOf<String>()
var lastNameMemberOfParliament = mutableListOf<String>()
var allPartiesDuplicate = listOf<String>()
var allmemberOfParliament = listOf<MemberOfParliament>()


class MainActivityViewModel(application: Application) : AndroidViewModel(application) {

    private val MembersDao = MembersDatabase.getDatabase(application).MembersDao()


    init {
        // Runs ReadMembers when viewmodel is created
        ReadMembers()
    }


    fun ReadMembers() {
        viewModelScope.launch {

            val members = MemberApi.retrofitService.getMemberList()

            MembersDao.insertMember(members)

            partiesMemberOfParliament = MembersDao.getParties().distinct()
            firstNameMemberOfParliament = MembersDao.getFirstName()
            lastNameMemberOfParliament = MembersDao.getLastName()
            allPartiesDuplicate = MembersDao.getParties()
            allmemberOfParliament = MembersDao.getAllMembers()


        }
    }


}


