package fi.ilmarheinonen.parliamenttiprojekti

import android.app.Application
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.*
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import fi.ilmarheinonen.parliamenttiprojekti.RoomDB.MembersDatabase
import fi.ilmarheinonen.parliamenttiprojekti.api.MemberOfParliament
import kotlinx.coroutines.launch
import java.lang.reflect.Member


var allListMembers = mutableListOf<MemberOfParliament>()
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


        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
    }


    override fun onSupportNavigateUp(): Boolean {
        val navController = this.findNavController(R.id.myNavHostFragment)
        return navController.navigateUp()
    }

}

//val listMembers = mutableListOf<MemberOfParliament>()

lateinit var viewModel: MainActivityViewModel


class MainActivityViewModel(application: Application) : AndroidViewModel(application) {

    //private var members: MutableLiveData<List<MemberOfParliament>> = MutableLiveData()
    private val MembersDao = MembersDatabase.getDatabase(application).MembersDao()

    val liveMember = MutableLiveData<MemberOfParliament>()

    init {
        // fetches a quote when ViewModel object is create
        readMembers()
    }



    fun readMembers() {
        viewModelScope.launch {

                val members = MemberApi.retrofitService.getMemberList()

                MembersDao.insertMember(members)
                /*MemberApi.retrofitService.getMemberList()?.let { listMembers.addAll(it) }
                MembersDatabase.getDatabase(MainActivity).MembersDao().insertMember(MemberApi.retrofitService.getMemberList())*/

        }
    }


}


