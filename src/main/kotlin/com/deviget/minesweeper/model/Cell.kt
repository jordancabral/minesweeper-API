package com.deviget.minesweeper.model

data class Cell(
        var x: Int,
        var y: Int,
        var mine: Boolean,
        var visible: Boolean,
        var minesArround: Int)