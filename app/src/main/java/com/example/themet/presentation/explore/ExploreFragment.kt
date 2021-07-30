package com.example.themet.presentation.explore

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.themet.R
import com.example.themet.presentation.home.HomeViewModel

class ExploreFragment : Fragment() {
    private lateinit var viewModel: ExploreViewModel

    private val TAG = "ExploreFragment"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_explore, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(requireActivity())[ExploreViewModel::class.java]
        viewModel.loadDepartments()
        viewModel.departments.observe(viewLifecycleOwner, Observer { departments ->
            Log.d(TAG, departments[0].displayName)
        })
    }
}