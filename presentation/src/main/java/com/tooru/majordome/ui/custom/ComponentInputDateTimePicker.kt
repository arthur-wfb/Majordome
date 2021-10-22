package com.tooru.majordome.ui.custom

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.util.Log
import android.widget.EditText
import com.tooru.majordome.R
import org.joda.time.DateTime

class ComponentInputDateTimePicker(context: Context, attrs: AttributeSet): ComponentInput(context, attrs) {

    var date = DateTime()

    override fun readArray(array: TypedArray) {
        super.readArray(array)

        val input = findViewById<EditText>(R.id.componentInput)
        val isDatePicker = array.getBoolean(R.styleable.ComponentInput_isDatePicker, false)
        val isTimePicker = array.getBoolean(R.styleable.ComponentInput_isTimePicker, false)

        if (isDatePicker) {
            input.isFocusable = false
            input.setOnClickListener {
                showDatePicker(input)
            }
        }
        if (isTimePicker) {
            input.isFocusable = false
            input.setOnClickListener {
                showTimePicker(input)

            }
        }
    }

    private fun showDatePicker(input: EditText) {
        Log.d("CreateEventFragment", "showDatePicker")
        val currentDate = DateTime.now()
        val dateSetListener =
            DatePickerDialog.OnDateSetListener { _, p1, p2, p3 ->
                date = DateTime().withDate(p1, p2, p3).withTime(0, 0, 0, 0)
                input.setText(date.toString())
            }

        DatePickerDialog(
            context,
            dateSetListener,
            currentDate.year,
            currentDate.monthOfYear,
            currentDate.dayOfMonth
        ).show()
    }

    private fun showTimePicker(input: EditText) {
        val timeSetListener =
            TimePickerDialog.OnTimeSetListener() { _, p1, p2 ->
                date = DateTime().withTime(p1, p2, 0, 9)
                input.setText(date.toString())
            }
        TimePickerDialog(context, timeSetListener, 0, 0, true).show()
    }
}