package pl.edu.uwr.lista_4

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import pl.edu.uwr.lista_4.data.RestCountriesResponse
import pl.edu.uwr.lista_4.data.RestCountriesResponseItem
import java.nio.charset.CodingErrorAction.REPLACE

@Dao
interface RestDao {
//    @Insert(onConflict = REPLACE)
//    suspend fun insert(meal: RestCountriesResponseItem)
//
//    @Delete
//    suspend fun delete(meal: RestCountriesResponseItem)

    @Query("SELECT * FROM country")
    fun getAllCountries() : LiveData<List<RestCountriesResponseItem>>
}