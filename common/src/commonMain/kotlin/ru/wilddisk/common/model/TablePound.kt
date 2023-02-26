package ru.wilddisk.common.model

object TablePound {
    fun table() = listOf<Pair<Int, CoConvertResult>>(
        25 to CoConvertResult(Kilogram(Pound(25f)), 2),
        40 to CoConvertResult(Kilogram(Pound(40f)), 2),
        55 to CoConvertResult(Kilogram(Pound(55f)), 2),
        70 to CoConvertResult(Kilogram(Pound(70f)), 2),
        85 to CoConvertResult(Kilogram(Pound(85f)), 2),
        100 to CoConvertResult(Kilogram(Pound(100f)), 2),
        115 to CoConvertResult(Kilogram(Pound(115f)), 2),
        130 to CoConvertResult(Kilogram(Pound(130f)), 2),
        145 to CoConvertResult(Kilogram(Pound(145f)), 2),
        160 to CoConvertResult(Kilogram(Pound(160f)), 2),
        175 to CoConvertResult(Kilogram(Pound(175f)), 2),
        190 to CoConvertResult(Kilogram(Pound(190f)), 2),
        205 to CoConvertResult(Kilogram(Pound(205f)), 2),
        220 to CoConvertResult(Kilogram(Pound(220f)), 2),
        235 to CoConvertResult(Kilogram(Pound(235f)), 2),
        250 to CoConvertResult(Kilogram(Pound(250f)), 2),
    )
}