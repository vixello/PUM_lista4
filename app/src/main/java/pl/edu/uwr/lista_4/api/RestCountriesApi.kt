package pl.edu.uwr.lista_4.api

import pl.edu.uwr.lista_4.data.Flags
import pl.edu.uwr.lista_4.data.RestCountriesResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface RestCountriesApi {
    @GET("v2/all?fields=name,capital")
    suspend fun getCountriesCapital() : Response<RestCountriesResponse>

//    @GET("v2/all?fields=name,flags")
//    suspend fun getCountriesFlags(@Query("flags") id: String) : Response<RestCountriesResponse>

    @GET("v2/all?fields=name,capital,flags")
    suspend fun getCountriesFlags() : Response<RestCountriesResponse>
}
