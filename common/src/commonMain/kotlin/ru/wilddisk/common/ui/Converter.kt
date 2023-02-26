package ru.wilddisk.common.ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import ru.wilddisk.common.model.CoConvertResult
import ru.wilddisk.common.model.Kilogram
import ru.wilddisk.common.model.Pound

@Composable
fun Converter() {
    Box {
        var expanded by remember { mutableStateOf(false) }
        var unit by remember { mutableStateOf("Килограммы") }
        var unitResult by remember { mutableStateOf("Фунты") }
        var unitValue by remember { mutableStateOf("0") }
        Column {
            Row {
                TextField(
                    value = unitValue,
                    onValueChange = { unitValue = it },
                    modifier = Modifier
                        .padding(
                            start = 8.dp,
                            top = 8.dp,
                            end = 4.dp,
                            bottom = 8.dp
                        )
                        .fillMaxWidth()
                        .weight(0.1f),
                    textStyle = MaterialTheme.typography.body1,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal)
                )
                Column(
                    modifier = Modifier
                        .padding(
                            start = 4.dp,
                            top = 8.dp,
                            end = 8.dp,
                            bottom = 8.dp
                        )
                        .width(140.dp)
                ) {
                    Button(
                        onClick = { expanded = !expanded },
                        modifier = Modifier.height(56.dp).fillMaxWidth()
                    ) {
                        Text(unit)
                    }
                    AnimatedVisibility(visible = expanded, modifier = Modifier.fillMaxWidth()) {
                        Card {
                            Column {
                                Text(
                                    text = "Килограммы",
                                    modifier = Modifier
                                        .padding(8.dp)
                                        .clickable {
                                            unit = "Килограммы"
                                            unitResult = "Фунты"
                                        }
                                )
                                Text(
                                    text = "Фунты",
                                    modifier = Modifier
                                        .padding(8.dp)
                                        .clickable {
                                            unit = "Фунты"
                                            unitResult = "Килограммы"
                                        }
                                )
                            }
                        }
                    }
                }
            }
            val result: CoConvertResult = when(unit) {
                "Килограммы" -> CoConvertResult(Pound(Kilogram(unitValue.toFloatOrNull() ?: 0f)), 2)
                "Фунты" -> CoConvertResult(Kilogram(Pound(unitValue.toFloatOrNull() ?: 0f)), 2)
                else -> throw Exception("Не выбрана масса!")
            }
            Text(
                text = "$unitResult: ${
                    try {
                        result
                    } catch (e: Exception) {
                        e.localizedMessage
                    }
                }",
                modifier = Modifier.padding(8.dp).fillMaxWidth(),
                style = MaterialTheme.typography.h3
            )
        }
    }
}