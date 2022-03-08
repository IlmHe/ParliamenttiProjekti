package fi.ilmarheinonen.parliamenttiprojekti.RoomDB

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import fi.ilmarheinonen.parliamenttiprojekti.api.MemberOfParliament

/**
 * 08/03/2022
 * Ilmar Heinonen
 * 2110597
 * Functions for creating the Room database
 */

@Database(entities = [MemberOfParliament::class], version = 1)
abstract class MembersDatabase : RoomDatabase() {
    abstract fun MembersDao(): MembersDao


    companion object {

        //Used to return the database
        @Volatile
        private var instance: MembersDatabase? = null
        fun getDatabase(context: Context): MembersDatabase {
            return instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also { instance = it }
            }
        }

        //Used to create an instance of the database
        private fun buildDatabase(context: Context): MembersDatabase {
            return Room.databaseBuilder(context, MembersDatabase::class.java, "MemberOfParliament")
                .allowMainThreadQueries()
                .build()
        }
    }

}