package com.borisov.harrypotter.presentation

import android.content.Context
import androidx.annotation.StringRes

/**
 * @author Borisov Andrey on 04.04.2022
 **/
interface ResourceProvider {
    fun getString(@StringRes id: Int): String

    class Base(private val context: Context): ResourceProvider{
        override fun getString(id: Int): String = context.getString(id)
    }

}