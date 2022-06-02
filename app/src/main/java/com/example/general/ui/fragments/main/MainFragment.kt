package com.example.general.ui.fragments.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.general.R
import com.example.general.base.BaseFragment
import com.example.general.data.models.Model
import com.example.general.databinding.FragmentMainBinding
import com.example.general.ui.adapter.RecyclerAdapter
import com.example.general.util.ItemClick

class MainFragment : BaseFragment<FragmentMainBinding>() {

    override lateinit var binding: FragmentMainBinding
    private lateinit var viewModel: MainViewModel
    private val adapter = RecyclerAdapter()
    private val args: MainFragmentArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        return binding.root
    }


    private fun getDataFromSecondFragment() {
        viewModel.list.add(Model(args.name, args.surename))
    }

    override fun setupListener() {
        itemClickListener()
    }

    private fun itemClickListener() {
        adapter.onItemClickListener(object : ItemClick {
            override fun onItemClickListener(model: Model) {
                findNavController().navigate(R.id.secondFragment)
            }
        })
    }

    override fun setupViews() {
        binding.recyclerView.adapter = adapter
    }

    override fun setupReguest() {
        viewModel.createData()
        viewModel.liveData.observe(viewLifecycleOwner) { list ->
            adapter.submitList(list)

        }
        getDataFromSecondFragment()
    }
}