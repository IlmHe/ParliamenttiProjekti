import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import fi.ilmarheinonen.parliamenttiprojekti.api.MemberOfParliament
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL =
    "https://users.metropolia.fi/~peterh/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface PlayerApiService {
    @GET("mps.json")
    suspend fun getMemberList(): List<MemberOfParliament>
}

object PlayerApi {
    val retrofitService : PlayerApiService by lazy {
        retrofit.create(PlayerApiService::class.java) }
}