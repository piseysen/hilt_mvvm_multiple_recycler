package com.pisey.hiltmvvmexample.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.pisey.hiltmvvmexample.R
import com.pisey.hiltmvvmexample.data.network.Resource
import com.pisey.hiltmvvmexample.databinding.MainFragmentBinding
import com.pisey.hiltmvvmexample.ui.main.adapter.HomeRecyclerViewAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    //private lateinit var viewModel: MainViewModel
    private val viewModel by viewModels<MainViewModel>()
    private lateinit var binding: MainFragmentBinding
    private val homeRecyclerViewHolder = HomeRecyclerViewAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = MainFragmentBinding.inflate(layoutInflater)

        //return inflater.inflate(R.layout.main_fragment, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(requireContext())
            adapter = homeRecyclerViewHolder
        }

        viewModel.homeListItemsLiveData.observe(requireActivity()) {result ->
            when(result){
                is Resource.Failure -> {
                    binding.progressBar.hide()
                }
                Resource.Loading -> binding.progressBar.show()

                is Resource.Success -> {
                    binding.progressBar.hide()
                    homeRecyclerViewHolder.items = result.value
                }

            }
        }
    }

}