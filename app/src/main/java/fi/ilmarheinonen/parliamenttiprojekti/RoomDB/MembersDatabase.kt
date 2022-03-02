package fi.ilmarheinonen.parliamenttiprojekti.RoomDB

import androidx.room.Database
import androidx.room.RoomDatabase
import fi.ilmarheinonen.parliamenttiprojekti.api.MemberOfParliament

@Database(entities = [MemberOfParliament::class], version = 1)
abstract class MembersDatabase : RoomDatabase(){
    abstract fun MembersDao(): MembersDao
}