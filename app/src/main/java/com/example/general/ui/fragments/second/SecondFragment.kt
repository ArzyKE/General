package com.example.general.ui.fragments.second

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.general.base.BaseFragment
import com.example.general.databinding.FragmentSecondBinding
import com.example.general.ui.fragments.main.MainViewModel

class SecondFragment : BaseFragment<FragmentSecondBinding>() {

    override lateinit var binding: FragmentSecondBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun setupListener() {
        binding.btn.setOnClickListener {
            findNavController().navigate(
                SecondFragmentDirections.actionSecondFragmentToMainFragment(
                    binding.etEt.text.toString(), binding.etSecond.text.toString()
                )
            )
        }

    }
}