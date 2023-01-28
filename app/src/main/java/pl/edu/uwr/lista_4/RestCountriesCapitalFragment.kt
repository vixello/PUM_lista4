package pl.edu.uwr.lista_4

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import pl.edu.uwr.lista_4.adapters.CapitalAdapter
import pl.edu.uwr.lista_4.adapters.RestCountriesComparator
import pl.edu.uwr.lista_4.databinding.FragmentRestCountriesListCapitalBinding
import pl.edu.uwr.lista_4.util.Resource

class RestCountriesCapitalFragment: Fragment() {
    private lateinit var binding: FragmentRestCountriesListCapitalBinding
    private val restCountriesViewModel: RestCountriesViewModel by activityViewModels()
    private val TAG = "RestCountresCapitalFragment"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRestCountriesListCapitalBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        restCountriesViewModel.getCapitalList()

        val adapter = CapitalAdapter(RestCountriesComparator())
        setupRecyclerView(adapter)

        observeFood(adapter)
    }
    private fun hideProgressBar(){
        binding.progressBar.visibility = View.INVISIBLE
    }

    private fun showProgressBar(){
        binding.progressBar.visibility = View.VISIBLE
    }

    private fun setupRecyclerView(capitalAdapter: CapitalAdapter) {
        binding.countriesRV.apply {
            adapter = capitalAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
    }

    private fun observeFood(capitalAdapter: CapitalAdapter) {
        restCountriesViewModel.restCountriesCapitalList.observe(viewLifecycleOwner) { response ->
            when (response) {
                is Resource.Success -> {
                    hideProgressBar()
                    response.data?.let {
                        capitalAdapter.submitList(it)
//                        binding.categoryFullNameTextView.text = it.nobelPrizes.first().categoryFullName.en
//                        binding.dateAwardTextView.text = it.nobelPrizes.first().dateAwarded
//                        laureateAdapter.submitList(it.nobelPrizes.first().laureates)
                    }
                    println("PRRRRRRRRRINTINGGG NOWQWWWW"+binding.root )

                    /*              response.data?.let { res ->
                                      capitalAdapter.submitList(res.)
                                  }*/
                }
                is Resource.Error -> {
                    hideProgressBar()
                    response.message?.let { Log.e(TAG, "Error occurred: $it") }
                }
                is Resource.Loading -> showProgressBar()
            }
        }
    }

}