package pl.edu.uwr.lista_4.data

import androidx.room.Entity
import androidx.room.PrimaryKey


class RestCountriesResponse : ArrayList<RestCountriesResponseItem>()

//data class RestCountriesResponse(
//    val countries: List<RestCountriesResponseItem>
//)
@Entity(tableName = "country")
data class RestCountriesResponseItem(
    @PrimaryKey
    val name: String,
    val capital: String,
    val flags: Flags

)

data class Flags(
    val png: String,
    val svg: String
)

