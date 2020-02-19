package com.deviget.minesweeper.model

data class Cell(
        var x: Int,
        var y: Int,
        var mine: Boolean = false,
        var visible: Boolean = false,
        var flagged: Boolean = false,
        var minesAround: Int = 0) {

    fun toResponse(): String {
        return if (visible) {
            if (mine) "X"
            else minesAround.toString()
        } else {
            if (flagged) "?"
            else "#"
        }
    }
}