package ru.wilddisk.common.ui

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import ru.wilddisk.common.model.CoConvertResult

@Composable
fun Table(list: List<Pair<Int, CoConvertResult>>) {
    LazyColumn {
        items(list) {
            Item(it)
        }
    }
}