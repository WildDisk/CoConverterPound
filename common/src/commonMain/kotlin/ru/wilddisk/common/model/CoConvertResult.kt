package ru.wilddisk.common.model

class CoConvertResult(private val unit: UnitMeasure, private val roundUp: Int) {
    override fun toString(): String = String.format("%.${this.roundUp}f", this.unit.out())
}