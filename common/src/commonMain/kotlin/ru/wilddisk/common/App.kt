package ru.wilddisk.common

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.material.Button
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import ru.wilddisk.common.model.CoConvertResult
import ru.wilddisk.common.model.Kilogram
import ru.wilddisk.common.model.Pound

@Composable
fun App() {
    var text by remember { mutableStateOf("Hello, World!") }
    val platformName = getPlatformName()

    Column {
        Button(onClick = {
            text = "Hello, ${platformName}"
        }) {
            Text(text)
        }
        Text("Kilogram: ${CoConvertResult(Kilogram(Pound(1f)), 2)}")
        Text("Pound: ${CoConvertResult(Pound(Kilogram(1f)), 2)}")
    }
}
