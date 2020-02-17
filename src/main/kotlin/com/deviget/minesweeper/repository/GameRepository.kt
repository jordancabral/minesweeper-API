package com.deviget.minesweeper.repository

import com.deviget.minesweeper.Game
import org.springframework.data.mongodb.repository.MongoRepository

interface GameRepository: MongoRepository<Game, String> {
}