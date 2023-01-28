package pl.edu.uwr.lista_4.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import pl.edu.uwr.lista_4.data.RestCountriesResponseItem
import pl.edu.uwr.lista_4.databinding.ListItemRvFlagBinding

class FlagAdapter (itemComparator: RestCountriesComparator)
    : ListAdapter<RestCountriesResponseItem, CountriesFlagsViewHolder>(itemComparator) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountriesFlagsViewHolder {
        return CountriesFlagsViewHolder(
            ListItemRvFlagBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: CountriesFlagsViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    fun getItemAt(position: Int): RestCountriesResponseItem{
        return getItem(position)
    }
}