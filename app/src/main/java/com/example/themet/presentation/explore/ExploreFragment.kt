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


        viewModel.loadSingleObject(1)
        viewModel.singleObject.observe(viewLifecycleOwner, Observer {
            Log.d(TAG, "Id: ${it.title}")
        })
    }
}