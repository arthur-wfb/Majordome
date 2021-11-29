package com.tooru.majordome.ui.custom

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.EditText
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import com.tooru.majordome.R
import com.tooru.majordome.useObtainedStyledAttributes

open class ComponentInput(context: Context, attrs: AttributeSet) : FrameLayout(context, attrs) {


    private var input: EditText

    init {
        LayoutInflater.from(getContext()).inflate(R.layout.component_input, this)

        input = findViewById(R.id.componentInput)

        context.useObtainedStyledAttributes(attrs, R.styleable.ComponentInput) {
            readArray(it)
        }
    }


    val text
        get() =
            input.text.toString()


    open fun readArray(array: TypedArray) {
        val title = array.getString(R.styleable.ComponentInput_inputTitle)
        val hint = array.getString(R.styleable.ComponentInput_inputHint)
        val isDropDown = array.getBoolean(R.styleable.ComponentInput_isDropDown, false)
        val lines = array.getInt(R.styleable.ComponentInput_lines, 1)

        findViewById<TextView>(R.id.inputTitle).text = title
        input.hint = hint
        input.setLines(lines)

        findViewById<ImageView>(R.id.dropdown_icon).visibility =
            if (isDropDown) View.VISIBLE else View.GONE
    }
}