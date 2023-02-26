package ru.wilddisk.common.model

class Pound(private val unit: Float) : UnitMeasure {
    constructor(kilogram: Kilogram) : this(unit = kilogram.out() * 2.20462f)
    override fun out(): Float = this.unit
    override fun toString(): String = this.out().toString()
}