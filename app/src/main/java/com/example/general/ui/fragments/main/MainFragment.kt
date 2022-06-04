package com.example.general.ui.fragments.main

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.general.R
import com.example.general.base.BaseFragment
import com.example.general.data.models.Model
import com.example.general.databinding.FragmentMainBinding
import com.example.general.ui.adapter.RecyclerAdapter
import com.example.general.util.ItemClick

class MainFragment : BaseFragment<FragmentMainBinding>() {

    override lateinit var binding: FragmentMainBinding
    private lateinit var viewModel: MainViewModel
    private val recyclerAdapter = RecyclerAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        return binding.root
    }

    override fun setupListener() {
        itemClickListener()
    }

    private fun itemClickListener() {
        recyclerAdapter.onItemClickListener(object : ItemClick {
            override fun onItemClickListener(model: Model) {
                findNavController().navigate(R.id.secondFragment)
            }
        })
    }

    override fun setupViews() {
        binding.recyclerView.adapter = recyclerAdapter
    }

    override fun setupReguest() {
        getDataFromSecondFragment()
        viewModel.liveData.observe(viewLifecycleOwner) { list ->
            recyclerAdapter.submitList(list)
            Log.e("tag", viewModel.list.size.toString())
        }
    }

    private fun getDataFromSecondFragment() {
        findNavController().currentBackStackEntry?.savedStateHandle?.getLiveData<Bundle>("key")
            ?.observe(
                viewLifecycleOwner
            ) { result ->
                viewModel.list.add(
                    Model(
                        result.getString("name")!!,
                        result.getString("surname")!!
                    )
                )
            }
    }


}
