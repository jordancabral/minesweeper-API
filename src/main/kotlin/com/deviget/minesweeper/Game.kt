package com.deviget.minesweeper

import com.deviget.minesweeper.model.Board
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDateTime

@Document
class Game (
            @Id
            var id: String? = null,
            val board: Board,
            var status: GameStatus,
            val date: LocalDateTime = LocalDateTime.now()) {

    fun reveal(x: Int, y: Int){
        val cell = board.reveal(x, y)
        cell ?: throw RuntimeException()
        if (cell.mine) status = GameStatus.LOSE
    }

    fun addFlag(x: Int, y: Int){
        val cell = board.addFlag(x, y)
    }

    companion object {
        fun create(minesQty: Int, x: Int, y: Int) = run {
            var board = Board(minesQty, x, y)
            var status: GameStatus = GameStatus.RUNNING
            Game(board = board, status = status)
        }
    }

}

enum class GameStatus {
    RUNNING,
    WIN,
    LOSE
}