package pl.edu.uwr.lista_4.repository

import androidx.lifecycle.LiveData
import pl.edu.uwr.lista_4.RestDao
import pl.edu.uwr.lista_4.api.RetrofitInstance
import pl.edu.uwr.lista_4.data.Flags
import pl.edu.uwr.lista_4.data.RestCountriesResponse
import pl.edu.uwr.lista_4.data.RestCountriesResponseItem

class RestCountriesRepository {
    suspend fun getCountriesCapital() = RetrofitInstance.api.getCountriesCapital()
    suspend fun getCountriesFlags() = RetrofitInstance.api.getCountriesFlags()
//    val readAllData: LiveData<List<RestCountriesResponseItem>> = RestDao.getAllCountries()

}