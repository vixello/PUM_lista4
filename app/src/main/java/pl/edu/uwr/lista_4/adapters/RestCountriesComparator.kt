package pl.edu.uwr.lista_4.adapters

import androidx.recyclerview.widget.DiffUtil
import pl.edu.uwr.lista_4.data.Flags
import pl.edu.uwr.lista_4.data.RestCountriesResponseItem

class RestCountriesComparator : DiffUtil.ItemCallback<RestCountriesResponseItem>() {
    override fun areItemsTheSame(
        oldItem: RestCountriesResponseItem,
        newItem: RestCountriesResponseItem
    ): Boolean {
        return newItem.name == oldItem.name
    }

    override fun areContentsTheSame(oldItem: RestCountriesResponseItem, newItem: RestCountriesResponseItem): Boolean {
        return newItem.capital == oldItem.capital
//        return newItem.name == oldItem.name

    }
}