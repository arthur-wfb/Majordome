package com.tooru.majordome.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.tooru.domain.model.Event
import com.tooru.majordome.Status
import com.tooru.majordome.databinding.FragmentCreateEventBinding
import com.tooru.majordome.viewmodels.CreateEventViewModel
import dagger.hilt.android.AndroidEntryPoint
import org.joda.time.DateTime

@AndroidEntryPoint
class CreateEventFragment : Fragment() {

    private val viewModel: CreateEventViewModel by viewModels()

    private var _binding: FragmentCreateEventBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCreateEventBinding.inflate(inflater, container, false)

        binding.confirm.setOnClickListener {

            val event = Event(
                null,
                binding.titleInput.text,
                DateTime().withDate(
                    binding.dateInput.date.year,
                    binding.dateInput.date.monthOfYear,
                    binding.dateInput.date.dayOfMonth
                ).withTime(
                    binding.timeInput.date.hourOfDay,
                    binding.timeInput.date.minuteOfHour,
                    0,
                    0
                ),
                binding.descriptionInput.text
            )

            viewModel.createEvent(event)

        }

        observeEvents()

        Log.d("Create", "onCreateView")
        return binding.root
    }

    private fun observeEvents() {
        viewModel.eventCreatingStatus.observe(viewLifecycleOwner) {
            when (it.status) {
                Status.LOADING -> {

                }
                Status.SUCCESS -> {

                }
                Status.ERROR -> {
                    Log.d(TAG, "Error while event creating")
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        private const val TAG = "CreateEventFragment"
    }
}