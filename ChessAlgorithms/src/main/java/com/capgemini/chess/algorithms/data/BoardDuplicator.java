package com.capgemini.chess.algorithms.data;

import com.capgemini.chess.algorithms.data.enums.Piece;
import com.capgemini.chess.algorithms.data.generated.Board;

public class BoardDuplicator {

	public static Board duplicateBoard(Board board) {
		Board copyOfPieces = new Board();
		for(int x = 0; x<board.SIZE; x++){
			for(int y = 0; y<board.SIZE; y++){
			Coordinate coordinate = new Coordinate(x, y);	
			Piece tempPiece = board.getPieceAt(coordinate);
			copyOfPieces.setPieceAt(tempPiece, coordinate);
			}
		}
		return copyOfPieces;
	}
}
