package com.deviget.minesweeper

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class GameTest {

    @Test
    fun revealCellWithMineLoseGame(){
        val game = Game(9, 3, 3)
        game.reveal(1,2)
        Assertions.assertEquals(game.status, GameStatus.LOSE)
    }

    @Test
    fun revealCellWithMineDontLoseGame(){
        val game = Game(0, 3, 3)
        game.reveal(1,2)
        Assertions.assertEquals(game.status, GameStatus.RUNNING)
    }

}