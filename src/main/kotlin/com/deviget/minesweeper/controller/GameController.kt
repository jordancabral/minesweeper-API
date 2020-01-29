package com.deviget.minesweeper.controller

import com.deviget.minesweeper.Game
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/game")
class GameController {

    lateinit var  game: Game

    /**
     * Create Game
     */
    @PostMapping("")
    fun createGame(@RequestBody gameConfig: GameConfig): Game {
        game = Game(gameConfig.minesQty, gameConfig.x, gameConfig.y)
        return game
    }

    /**
     * Reveal Cell
     */
    @PutMapping("/reveal")
    fun revealCell(@RequestBody cellPosition: Coordinates): Game {
        game.reveal(cellPosition.x, cellPosition.y)
        return game
    }

    /**
     * Flag Cell
     */
    @PutMapping("/flag")
    fun flagCell(@RequestBody cellPosition: Coordinates): Game {
        game.addFlag(cellPosition.x, cellPosition.y)
        return game
    }

}

data class GameConfig(val minesQty: Int, val x: Int, val y: Int)

data class Coordinates(val minesQty: Int, val x: Int, val y: Int)