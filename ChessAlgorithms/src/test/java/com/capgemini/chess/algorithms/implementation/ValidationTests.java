package com.capgemini.chess.algorithms.implementation;

import static org.junit.Assert.*;

import org.junit.Test;

import com.capgemini.chess.algorithms.data.Coordinate;
import com.capgemini.chess.algorithms.data.enums.Piece;
import com.capgemini.chess.algorithms.implementation.exceptions.InvalidMoveException;

public class ValidationTests {

	@Test
	public void shouldReturnPiece() throws InvalidMoveException {
		//given
		BoardManager bManager = new BoardManager();
		//when
		Coordinate from = new Coordinate(0, 1);
		Coordinate to = new Coordinate(0, 2);
		bManager.performMove(from, to);
		//next move Knight
		Coordinate from2 = new Coordinate(1, 7);
		Coordinate to2 = new Coordinate(0, 5);
		bManager.performMove(from2, to2);
		//White Pawn 2 field move
		Coordinate from3 = new Coordinate(3, 1);
		Coordinate to3 = new Coordinate(3, 3);
		bManager.performMove(from3, to3);
		//Black Knight to 3 4
		Coordinate from4 = new Coordinate(0, 5);
		Coordinate to4 = new Coordinate(2, 4);
		bManager.performMove(from4, to4);
		//White Pawn 2 field move
		Coordinate from5 = new Coordinate(2, 1);
		Coordinate to5 = new Coordinate(2, 2);
		bManager.performMove(from5, to5);
//		//Black Knight to 3 2
		Coordinate from6 = new Coordinate(2, 4);
		Coordinate to6 = new Coordinate(3, 2);
		bManager.performMove(from6, to6);
//		White Pawn 2 field move
	//	Coordinate from7 = new Coordinate(6, 1);
		//Coordinate to7 = new Coordinate(6, 2);
	//	bManager.performMove(from7, to7);
//		//Invalid move of White
		Coordinate from8 = new Coordinate(4, 1);
		Coordinate to8 = new Coordinate(3, 2);
		bManager.performMove(from8, to8);
//		
		for(int y = 0; y<8; y++){
			for(int x = 0; x<8; x++){
				Coordinate coordinate = new Coordinate(x, y);
				Piece checkedpiece = bManager.getBoard().getPieceAt(coordinate);
				System.out.print("X: "+x+" , Y: "+y+" => ");
				System.out.print(checkedpiece+"    ");
			}
			System.out.println(" ");
			//System.out.println(bManager.getBoard().getMoveHistory());
			
		}		
		System.out.println(bManager.getBoard().getState());
	}

}
