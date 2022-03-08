package fi.ilmarheinonen.parliamenttiprojekti.RoomDB

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import fi.ilmarheinonen.parliamenttiprojekti.api.MemberOfParliament

/**
 * 08/03/2022
 * Ilmar Heinonen
 * 2110597
 * Handles data from MembersDatabase
 */

@Dao
interface MembersDao {

    @Query("SELECT * FROM MemberOfParliament")
    fun getAllMembers(): MutableList<MemberOfParliament>

    @Query("SELECT party FROM MemberOfParliament")
    fun getParties(): List<String>

    @Query("SELECT first FROM MemberOfParliament")
    fun getFirstName(): MutableList<String>

    @Query("SELECT last FROM MemberOfParliament")
    fun getLastName(): MutableList<String>

    @Insert
    fun insertMember(MemberOfParliament: MutableList<MemberOfParliament>)
}