package com.deviget.minesweeper.model

import java.lang.RuntimeException

data class Board(val mineQuantity: Int, val x: Int, val y: Int) {

    var cells = arrayOf<Array<Cell>>()

    init {

        // Basic validations
        if (x < 1 || y < 1 || x > 100 || y > 100) throw RuntimeException() // TODO: Custom Exception

        // Initialize cells
        for (i in 0 until x){
            var array = arrayOf<Cell>()
            for (j in 0 until y){
                array += Cell(x = i, y = j)
            }
            cells += array
        }

        // Initialize random mines
        cells.flatten().shuffled()
                .take(mineQuantity)
                .map { cell ->  cell.mine = true }

        // Initialize mines counters
        for (i in 0 until x){
            for (j in 0 until y){
                getCell(i,j)?.minesAround = minesArround(i,j)
            }
        }
    }

    fun print(){
        cells.forEach { row ->
            row.forEach {
                if (it.mine) print("X")
                else print("${it.minesAround}")
            }
            println()
        }
    }

    private fun reveal(cell: Cell): Cell? = reveal(cell.x + 1, cell.y + 1)

    fun reveal(x: Int, y: Int): Cell? {
        val cell = getCell(x - 1, y -1)
        cell?.visible = true
        if (cell?.minesAround == 0 ){
            cellsAround(cell).forEach { if (!it.visible) reveal(it) }
        }
        return cell
    }

    fun addFlag(x: Int, y: Int): Cell {
        val cell = cells[x - 1][y - 1]
        cell.flagged = true
        return cell
    }

    fun getCell(x: Int, y: Int): Cell? {
        if (x >= 0 &&
            y >= 0 &&
            x < cells.size &&
            y < cells[x].size){
            return cells[x][y]
        }
        return null
    }

    private fun cellsAround(cell: Cell): List<Cell> =  cellsAround(cell.x, cell.y)

    private fun cellsAround(x: Int, y: Int): List<Cell> {
        var cellsAround = arrayListOf<Cell>()

        for (i in x-1..x+1){
            for(j in y-1..y+1){
                if (!(i == x && j == y)){
                    getCell(i, j)?.let { cellsAround.add(it) }
                }

            }
        }

        return cellsAround
    }

    private fun minesArround(x: Int, y: Int): Int {
        val cellsArround = cellsAround(x,y)
        var total = 0
        cellsArround.forEach{
            if (it.mine) total ++
        }
        //return cellsArround.fold(0,{ acc, cell -> if (cell.mine) acc + 1 else acc })
        return total
    }

}