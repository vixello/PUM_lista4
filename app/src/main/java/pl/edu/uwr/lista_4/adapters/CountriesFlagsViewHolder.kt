package pl.edu.uwr.lista_4.adapters

import androidx.navigation.NavDirections
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import pl.edu.uwr.lista_4.data.Flags
import pl.edu.uwr.lista_4.data.RestCountriesResponse
import pl.edu.uwr.lista_4.data.RestCountriesResponseItem
import pl.edu.uwr.lista_4.databinding.ListItemRvBinding
import pl.edu.uwr.lista_4.databinding.ListItemRvFlagBinding

class CountriesFlagsViewHolder (private val binding: ListItemRvFlagBinding)
    : RecyclerView.ViewHolder(binding.root){
    fun bind(item: RestCountriesResponseItem){
        binding.name.text = item.name
        println("HELLLOOOOOOOOOOOOOOOOOOOOO"+ item.flags )

        Glide.with(binding.root)
            .load(item.flags.png)
            .into(binding.image)

    }
}