package fi.ilmarheinonen.parliamenttiprojekti

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.room.Room
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import fi.ilmarheinonen.parliamenttiprojekti.RoomDB.MembersDatabase
import fi.ilmarheinonen.parliamenttiprojekti.api.MemberOfParliament
import fi.ilmarheinonen.parliamenttiprojekti.databinding.ActivityMainBinding
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navController = this.findNavController(R.id.myNavHostFragment)
        NavigationUI.setupActionBarWithNavController(this, navController)

        val database = Room.databaseBuilder(
            applicationContext, MembersDatabase::class.java, "MembersOfParliament"
        )
            .allowMainThreadQueries()
            .build()

        val allMembers = database.MembersDao().getAllMembers()
        allMembers.forEach {
            Log.i("tag"," ${it.first}, ")
        }

    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = this.findNavController(R.id.myNavHostFragment)
        return navController.navigateUp()
    }


}