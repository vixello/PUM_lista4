package pl.edu.uwr.lista_4.adapters

import androidx.navigation.NavDirections
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import pl.edu.uwr.lista_4.RestCountriesCapitalFragment
import pl.edu.uwr.lista_4.data.RestCountriesResponseItem
import pl.edu.uwr.lista_4.databinding.ListItemRvBinding

class CountriesCapitalViewHolder(private val binding: ListItemRvBinding)
    : RecyclerView.ViewHolder(binding.root){
    fun bind(item: RestCountriesResponseItem){
        binding.name.text = item.name
        binding.capital.text = item.capital
/*        Glide.with(binding.root)
            .load(item.capital)
            .into(binding)*/
//        binding.root.setOnClickListener {
//            val action: NavDirections = RestCountriesCapitalFragment
//                .actionFoodListFragmentToFoodDetailFragment(
//                    item.idMeal
//                )
//            Navigation.findNavController(binding.root).navigate(action)
//        }
    }
}