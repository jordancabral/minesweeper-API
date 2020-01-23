package com.deviget.minesweeper

import com.deviget.minesweeper.model.Board

class Game (minesQty: Int, x: Int, y: Int) {

    var board = Board(minesQty, x, y)
    var status: GameStatus = GameStatus.RUNNING


    fun reveal(x: Int, y: Int){
        val cell = board.reveal(x, y)
        if (cell.mine) status = GameStatus.LOSE
    }

}

enum class GameStatus {
    RUNNING,
    WIN,
    LOSE
}