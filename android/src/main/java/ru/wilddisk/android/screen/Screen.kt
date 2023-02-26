package ru.wilddisk.android.screen

import androidx.annotation.StringRes
import ru.wilddisk.android.R

sealed class Screen(val route: String, @StringRes val resourceId: Int) {
    object Converter : Screen("converter", R.string.converter)
    object Table : Screen("table", R.string.table)
}