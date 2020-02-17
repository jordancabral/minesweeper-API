package com.deviget.minesweeper.controller

import com.deviget.minesweeper.Game
import com.deviget.minesweeper.repository.GameRepository
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/game")
class GameController (private val repository: GameRepository) {

    /**
     * Create Game
     */
    @PostMapping("")
    fun createGame(@RequestBody gameConfig: GameConfig): Game {
        val game = Game.create(gameConfig.minesQty, gameConfig.x, gameConfig.y)
        repository.deleteAll()
        repository.save(game)
        return game
    }

    /**
     * Get Game
     */
    @GetMapping("")
    fun getGame(): Game {
        return repository.findAll().first()
    }

    /**
     * Reveal Cell
     */
    @PutMapping("/reveal")
    fun revealCell(@RequestBody cellPosition: Coordinates): Game {
        val game = repository.findAll().first()
        game.reveal(cellPosition.x, cellPosition.y)
        repository.save(game)
        return game
    }

    /**
     * Flag Cell
     */
    @PutMapping("/flag")
    fun flagCell(@RequestBody cellPosition: Coordinates): Game {
        val game = repository.findAll().first()
        game.addFlag(cellPosition.x, cellPosition.y)
        repository.save(game)
        return game
    }

}

data class GameConfig(val minesQty: Int, val x: Int, val y: Int)

data class Coordinates(val minesQty: Int, val x: Int, val y: Int)