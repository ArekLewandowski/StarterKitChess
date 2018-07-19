package com.capgemini.chess.algorithms.implementation;

import static org.junit.Assert.*;

import org.junit.Test;

import com.capgemini.chess.algorithms.data.Coordinate;
import com.capgemini.chess.algorithms.data.Move;
import com.capgemini.chess.algorithms.data.enums.BoardState;
import com.capgemini.chess.algorithms.data.enums.MoveType;
import com.capgemini.chess.algorithms.data.enums.Piece;
import com.capgemini.chess.algorithms.data.generated.Board;
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
//		//White Pawn 2 field move
		Coordinate from3 = new Coordinate(3, 1);
		Coordinate to3 = new Coordinate(3, 3);
		bManager.performMove(from3, to3);
//		//Black Knight to 3 4
		Coordinate from4 = new Coordinate(0, 5);
		Coordinate to4 = new Coordinate(2, 4);
		bManager.performMove(from4, to4);
//		//White Pawn 2 field move
		Coordinate from5 = new Coordinate(2, 1);
		Coordinate to5 = new Coordinate(2, 2);
		bManager.performMove(from5, to5);
////		//Black Knight to 3 2
//		Coordinate from6 = new Coordinate(2, 4);
//		Coordinate to6 = new Coordinate(3, 2);
//		bManager.performMove(from6, to6);
////		White Pawn 2 field move
//	//	Coordinate from7 = new Coordinate(6, 1);
//		//Coordinate to7 = new Coordinate(6, 2);
//	//	bManager.performMove(from7, to7);
////	
//		for(int y = 0; y<8; y++){
//			for(int x = 0; x<8; x++){
//				Coordinate coordinate = new Coordinate(x, y);
//				Piece checkedpiece = bManager.getBoard().getPieceAt(coordinate);
//				System.out.print("X: "+x+" , Y: "+y+" => ");
//				System.out.print(checkedpiece+"    ");
//			}
//			System.out.println(" ");
			//System.out.println(bManager.getBoard().getMoveHistory());
			
//		}		
		System.out.println(bManager.getBoard().getState());
	}
	@Test
	public void testUpdateBoardStateCheckMate() throws InvalidMoveException {
		// given
		Board board = new Board();
		board.getMoveHistory().add(createDummyMove(board));
		board.setPieceAt(Piece.WHITE_ROOK, new Coordinate(0, 1));
		board.setPieceAt(Piece.WHITE_ROOK, new Coordinate(1, 0));
		board.setPieceAt(Piece.BLACK_KING, new Coordinate(4, 0));
		board.setPieceAt(Piece.WHITE_KING, new Coordinate(7, 7));
		
		// when
		BoardManager boardManager = new BoardManager(board);
		BoardState boardState = boardManager.updateBoardState();
		
		
		
		// then
		assertEquals(BoardState.CHECK_MATE, boardState);
	}
	
	@Test
	public void shouldReturnQueenAfterPromotion() throws InvalidMoveException {
		// given
		Board board = new Board();
		board.setPieceAt(Piece.WHITE_PAWN, new Coordinate(1, 6));
		board.setPieceAt(Piece.WHITE_ROOK, new Coordinate(1, 0));
		board.setPieceAt(Piece.BLACK_KING, new Coordinate(4, 0));
		board.setPieceAt(Piece.WHITE_KING, new Coordinate(7, 7));
		
		// when
		BoardManager boardManager = new BoardManager(board);
		Move move = boardManager.performMove(new Coordinate(1, 6), new Coordinate(1, 7));
		
		// then
		assertEquals(MoveType.ATTACK, move.getType());		
		assertEquals(Piece.WHITE_PAWN, move.getMovedPiece());
		assertEquals(Piece.WHITE_QUEEN, board.getPieceAt(new Coordinate(1, 7)));
	}
	
private Move createDummyMove(Board board) {
		
		Move move = new Move();
		
		if (board.getMoveHistory().size() % 2 == 0) {
			board.setPieceAt(Piece.WHITE_ROOK, new Coordinate(0, 0));
			move.setMovedPiece(Piece.WHITE_ROOK);
		}
		else {
			board.setPieceAt(Piece.BLACK_ROOK, new Coordinate(0, 0));
			move.setMovedPiece(Piece.BLACK_ROOK);
		}
		move.setFrom(new Coordinate(0, 0));
		move.setTo(new Coordinate(0, 0));
		move.setType(MoveType.ATTACK);
		board.setPieceAt(null, new Coordinate(0, 0));
		return move;
	}
}
