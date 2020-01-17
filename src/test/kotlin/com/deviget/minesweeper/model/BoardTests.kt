package com.deviget.minesweeper.model

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.assertThrows
import java.lang.RuntimeException
import kotlin.random.Random

class BoardTests {

	@Test
	fun cantCreateBoardWithNoCells() {
		assertThrows<RuntimeException> {
			val board = Board(mineQuantity = 0, x = 0, y = 0)
		}
	}

	@Test
	fun cantCreateBoardWithNoMines() {
		assertThrows<RuntimeException> {
			val board = Board(mineQuantity = 0, x = 5, y = 5)
		}
	}

	@Test
	fun boardShouldNotHaveCellsOutsideDefinedNumberOfRowsCols() {
		assertThrows<RuntimeException> {
			val board = Board(mineQuantity = 0, x = 5, y = 5)
			board.cells[6][6]
		}
	}

	@Test
	fun boardShouldHaveCellsDefinedInsideNumberOfRowsCols() {
		val board = Board(mineQuantity = 1, x = 5, y = 5)
		Assertions.assertNotNull(board.cells[4][4])
	}

	@Test
	fun boardShouldHaveDefinedMinesQuantity() {
		val randomQuantity = Random.nextInt(1, 20)
		val board = Board(mineQuantity = randomQuantity, x = 5, y = 5)
		var mines = 0
		for (rows in board.cells){
			for (cell in rows){
				if (cell.mine) mines++
			}
		}
		Assertions.assertEquals(randomQuantity, mines)
	}

	@Test
	fun eachBoardShouldHaveRandomMines() {
		val randomQuantity = Random.nextInt(1, 20)
		val board1 = Board(mineQuantity = randomQuantity, x = 5, y = 5)
		val board2 = Board(mineQuantity = randomQuantity, x = 5, y = 5)
		val minesBoard1 = board1.cells.flatten().map { it.mine }
		val minesBoard2 = board2.cells.flatten().map { it.mine }
		Assertions.assertNotEquals(minesBoard1, minesBoard2)
	}

}
