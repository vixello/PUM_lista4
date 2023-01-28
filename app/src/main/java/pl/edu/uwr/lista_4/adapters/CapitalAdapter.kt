package pl.edu.uwr.lista_4.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import pl.edu.uwr.lista_4.data.RestCountriesResponseItem
import pl.edu.uwr.lista_4.databinding.ListItemRvBinding

class CapitalAdapter (itemComparator: RestCountriesComparator)
    : ListAdapter<RestCountriesResponseItem, CountriesCapitalViewHolder>(itemComparator) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountriesCapitalViewHolder {
        return CountriesCapitalViewHolder(
            ListItemRvBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: CountriesCapitalViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    fun getItemAt(position: Int): RestCountriesResponseItem{
        return getItem(position)
    }
}