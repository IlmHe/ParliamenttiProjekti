package fi.ilmarheinonen.parliamenttiprojekti.api

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class MemberOfParliament(
    @PrimaryKey(autoGenerate = true) val uid: Int = 0,
    val personNumber: Int,
    val seatNumber: Int = 0,
    val last: String,
    val first: String,
    val party: String,
    val minister: Boolean = false,
    val picture: String = "",
    val twitter: String = "",
    val bornYear: Int = 0,
    val constituency: String = ""
)