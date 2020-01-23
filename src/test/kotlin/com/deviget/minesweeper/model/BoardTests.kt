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
	fun cantCreateBoardWithBiggerThan100x100() {
		assertThrows<RuntimeException> {
			val board = Board(mineQuantity = 0, x = 101, y = 101)
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

	@Test
	fun aCellShouldHaveDefinedMinesArround() {
		val board = Board(mineQuantity = 5, x = 5, y = 5)
		for (rows in board.cells){
			for (cell in rows){
				var total = 0
				if (board.getCell(cell.x -1, cell.y -1)?.mine == true) total++
				if (board.getCell(cell.x -1, cell.y)?.mine == true) total++
				if (board.getCell(cell.x -1, cell.y + 1)?.mine == true) total++
				if (board.getCell(cell.x, cell.y -1)?.mine == true) total++

				if (board.getCell(cell.x, cell.y + 1)?.mine == true) total++
				if (board.getCell(cell.x +1, cell.y -1)?.mine == true) total++
				if (board.getCell(cell.x +1, cell.y)?.mine == true) total++
				if (board.getCell(cell.x +1 , cell.y + 1)?.mine == true) total++
				Assertions.assertEquals(cell.minesArround, total)
			}
		}
	}





}
