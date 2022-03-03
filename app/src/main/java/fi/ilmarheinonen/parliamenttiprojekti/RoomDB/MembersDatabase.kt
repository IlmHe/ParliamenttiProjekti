package fi.ilmarheinonen.parliamenttiprojekti.RoomDB

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

import fi.ilmarheinonen.parliamenttiprojekti.api.MemberOfParliament
import kotlinx.coroutines.CoroutineScope


/*@Database(entities = [MemberOfParliament::class], version = 1)
abstract class MembersDatabase : RoomDatabase(){
    abstract fun MembersDao(): MembersDao
}*/
@Database(entities = [MemberOfParliament::class], version = 1)
abstract class MembersDatabase : RoomDatabase() {
    abstract fun MembersDao(): MembersDao


    companion object {

        @Volatile
        private var instance: MembersDatabase? = null
        fun getDatabase(context: Context): MembersDatabase {
            return instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also { instance = it }
            }
        }

        private fun buildDatabase(context: Context): MembersDatabase {
            return Room.databaseBuilder(context, MembersDatabase::class.java, "MemberOfParliament")
                .allowMainThreadQueries()
                .build()
        }
    }

}
/*if (INSTANCE == null) {
                synchronized(this) {
                    INSTANCE =
                        Room.databaseBuilder(context,MembersDatabase::class.java, "MemberOfParliament")
                            .build()
                }
            }*/