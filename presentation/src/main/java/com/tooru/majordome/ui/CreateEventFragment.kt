package com.tooru.majordome.ui

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.tooru.majordome.databinding.ComponentInputBinding
import com.tooru.majordome.databinding.FragmentCreateEventBinding
import com.tooru.majordome.ui.custom.ComponentInput
import org.joda.time.DateTime

class CreateEventFragment : Fragment() {

    private var _binding: FragmentCreateEventBinding? = null
    private val binding get() = _binding!!
    private var date: DateTime? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCreateEventBinding.inflate(inflater, container, false)


        Log.d("Create", "onCreateView")
        return binding.root
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun showDatePicker() {
        Log.d("CreateEventFragment", "showDatePicker")
        val currentDate = DateTime.now()
        val dateSetListener =
            DatePickerDialog.OnDateSetListener { _, p1, p2, p3 ->
                date = DateTime().withDate(p1, p2, p3).withTime(0, 0, 0, 0)
            }

        DatePickerDialog(
            requireContext(),
            dateSetListener,
            currentDate.year,
            currentDate.monthOfYear,
            currentDate.dayOfMonth
        ).show()
    }


}