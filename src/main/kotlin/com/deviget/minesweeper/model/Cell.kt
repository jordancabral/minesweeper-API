package com.deviget.minesweeper.model

data class Cell(
        var x: Int,
        var y: Int,
        var mine: Boolean = false,
        var visible: Boolean = false,
        var flagged: Boolean = false,
        var minesArround: Int = 0)