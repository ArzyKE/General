package com.example.general.base

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.example.general.data.models.Model

abstract class BaseFragment<VB : ViewBinding> : Fragment() {

    protected abstract val binding: VB

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViews()
        setupReguest()
        setupListener()

    }


    protected open fun setupViews() {

    }

    protected open fun setupReguest() {
    }

    protected open fun setupListener() {
    }
}
