package com.tooru.majordome.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.tooru.majordome.R
import com.tooru.majordome.databinding.FragmentEventsListBinding
import com.tooru.majordome.viewmodels.EventsListViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class EventsListFragment : Fragment() {

    private val viewModel: EventsListViewModel by viewModels()

    private var _binding: FragmentEventsListBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentEventsListBinding.inflate(inflater, container, false)

        binding.createEventButton.setOnClickListener {
            Log.d("EventsListFragment", "createEventButton")
            findNavController().navigate(R.id.action_eventsListFragment_to_createEventFragment)
        }

        loadData()
        observeEvents()
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun loadData() {
        viewModel.getEvents()
    }

    private fun observeEvents() {
        viewModel.events.observe(viewLifecycleOwner, {
            Log.d("MojordomeLog", it.toString())
        })
    }
}