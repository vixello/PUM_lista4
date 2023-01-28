package pl.edu.uwr.lista_4

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import pl.edu.uwr.lista_4.data.Flags
import pl.edu.uwr.lista_4.data.RestCountriesResponse
import pl.edu.uwr.lista_4.repository.RestCountriesRepository
import pl.edu.uwr.lista_4.util.Resource
import retrofit2.Response


class RestCountriesViewModel(application: Application) : AndroidViewModel(application) {
    private val repository=  RestCountriesRepository()
    private val _capitallist: MutableLiveData<Resource<RestCountriesResponse>> = MutableLiveData()
    private val _flaglist: MutableLiveData<Resource<RestCountriesResponse>> = MutableLiveData()

    val restCountriesCapitalList: LiveData<Resource<RestCountriesResponse>>
        get() = _capitallist
    val restCountriesFlagsList: LiveData<Resource<RestCountriesResponse>>
        get() = _flaglist

//    init {
//        repository = RestCountriesRepository()
//    }

    private fun handleRestCountriesResponse(response: Response<RestCountriesResponse>)
            : Resource<RestCountriesResponse> {
        if (response.isSuccessful)
            response.body()?.let { return Resource.Success(it) }
        return Resource.Error(response.message())

    }


    fun getCapitalList() = viewModelScope.launch {
        _capitallist.postValue(Resource.Loading())
        val response = repository.getCountriesCapital()
        _capitallist.postValue(handleRestCountriesResponse(response))
    }

    fun getFlagList() = viewModelScope.launch {
        _flaglist.postValue(Resource.Loading())
        val response = repository.getCountriesFlags()
        _flaglist.postValue(handleRestCountriesResponse(response))
    }
}
