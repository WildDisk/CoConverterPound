package ru.wilddisk.common.model

class Kilogram(private val unit: Float) : UnitMeasure {
    constructor(pound: Pound) : this(unit = pound.out() / 2.20462f)
    override fun out(): Float = this.unit
    override fun toString(): String = this.out().toString()
}