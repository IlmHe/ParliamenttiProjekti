package fi.ilmarheinonen.parliamenttiprojekti.RoomDB

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import fi.ilmarheinonen.parliamenttiprojekti.api.MemberOfParliament

@Dao
interface MembersDao {

    @Query("SELECT * FROM MemberOfParliament")
    fun getAllMembers(): List<MemberOfParliament>

    @Insert
    fun insertMember(memberOfParliament: List<MemberOfParliament>)
}