package com.tooru.majordome

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import androidx.annotation.StyleableRes

/**
 * Получает [TypedArray], запускает лямбду [action], осуществляет освобождение ресурсов для [TypedArray]
 *
 * @param set пришедший на конструктор [android.view.View]] аргумент set
 * @param attrs идентификатор атрибутов вьюхи
 * @param action обработчик полученного [TypedArray]
 */
inline fun Context.useObtainedStyledAttributes(
    set: AttributeSet?,
    @StyleableRes attrs: IntArray,
    action: (a: TypedArray) -> Unit
) {
    var a: TypedArray? = null
    try {
        a = obtainStyledAttributes(set, attrs, 0, 0).also(action)
    } finally {
        a?.recycle()
    }
}