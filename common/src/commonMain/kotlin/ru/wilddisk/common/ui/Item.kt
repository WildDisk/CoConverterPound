package ru.wilddisk.common.ui

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.wilddisk.common.model.CoConvertResult

@Composable
fun Item(item: Pair<Int, CoConvertResult>) {
    Card(modifier = Modifier.padding(8.dp).fillMaxWidth()) {
        Text(
            text = "Фунт:${item.first} = Кило:${item.second}",
            style = MaterialTheme.typography.h5,
            modifier = Modifier.padding(8.dp)
        )
    }
}