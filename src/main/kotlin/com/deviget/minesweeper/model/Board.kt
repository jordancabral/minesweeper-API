package com.deviget.minesweeper.model

import java.lang.RuntimeException
import kotlin.random.Random

data class Board(val mineQuantity: Int, val x: Int, val y: Int) {

    var cells = arrayOf<Array<Cell>>()

    init {

        if (x < 1 || y < 1 || mineQuantity < 1) throw RuntimeException()

        // Initialize cells
        for (i in 0..x){
            var array = arrayOf<Cell>()
            for (j in 0..y){
                array += Cell(mine = false, visible = true)
            }
            cells += array
        }

        // Initialize random mines
        cells.flatten().shuffled()
             .take(mineQuantity)
             .map { it.mine = true }
    }

}