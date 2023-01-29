package pl.edu.uwr.lista_4.repository

import pl.edu.uwr.lista_4.api.RetrofitInstance

class RestCountriesRepository {
    suspend fun getCountriesCapital() = RetrofitInstance.api.getCountriesCapital()
    suspend fun getCountriesFlags() = RetrofitInstance.api.getCountriesFlags()
//    val readAllData: LiveData<List<RestCountriesResponseItem>> = RestDao.getAllCountries()

}