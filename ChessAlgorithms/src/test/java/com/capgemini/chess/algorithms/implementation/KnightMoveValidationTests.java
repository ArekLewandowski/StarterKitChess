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

public class KnightMoveValidationTests {

	@Test
	public void testPerformMoveKnightAttack() throws InvalidMoveException {
		// given
		Board board = new Board();
		board.setPieceAt(Piece.WHITE_KING, new Coordinate(4, 0));
		board.setPieceAt(Piece.BLACK_KING, new Coordinate(4, 7));
		board.setPieceAt(Piece.WHITE_KNIGHT, new Coordinate(0, 4));
		
		// when
		BoardManager boardManager = new BoardManager(board);
		Move move1 = boardManager.performMove(new Coordinate(0, 4), new Coordinate(1, 6));	
	
		// then		
		assertEquals(MoveType.ATTACK, move1.getType());		
		assertEquals(Piece.WHITE_KNIGHT, move1.getMovedPiece());

	}
	
	@Test
	public void testPerformMoveKnightAttack1() throws InvalidMoveException {
		// given
		Board board = new Board();
		board.setPieceAt(Piece.WHITE_KING, new Coordinate(4, 0));
		board.setPieceAt(Piece.BLACK_KING, new Coordinate(4, 7));
		board.setPieceAt(Piece.WHITE_KNIGHT, new Coordinate(0, 4));
		
		// when
		BoardManager boardManager = new BoardManager(board);
		Move move2 = boardManager.performMove(new Coordinate(0, 4), new Coordinate(2, 5));
		
		// then
		assertEquals(MoveType.ATTACK, move2.getType());
		assertEquals(Piece.WHITE_KNIGHT, move2.getMovedPiece());

	}
	
	@Test
	public void testPerformMoveKnightAttack3() throws InvalidMoveException {
		// given
		Board board = new Board();
		board.setPieceAt(Piece.WHITE_KING, new Coordinate(4, 0));
		board.setPieceAt(Piece.BLACK_KING, new Coordinate(4, 7));
		board.setPieceAt(Piece.WHITE_KNIGHT, new Coordinate(0, 4));
		
		// when
		BoardManager boardManager = new BoardManager(board);
		Move move3 = boardManager.performMove(new Coordinate(0, 4), new Coordinate(2, 3));

		// then
		assertEquals(MoveType.ATTACK, move3.getType());
		assertEquals(Piece.WHITE_KNIGHT, move3.getMovedPiece());

	}
	
	@Test
	public void testPerformMoveKnightAttack4() throws InvalidMoveException {
		// given
		Board board = new Board();
		board.setPieceAt(Piece.WHITE_KING, new Coordinate(4, 0));
		board.setPieceAt(Piece.BLACK_KING, new Coordinate(4, 7));
		board.setPieceAt(Piece.WHITE_KNIGHT, new Coordinate(0, 4));
		board.setPieceAt(Piece.BLACK_KNIGHT, new Coordinate(1, 2));
		
		// when
		BoardManager boardManager = new BoardManager(board);
		Move move4 = boardManager.performMove(new Coordinate(0, 4), new Coordinate(1, 2));

		// then

		assertEquals(MoveType.CAPTURE, move4.getType());
		assertEquals(Piece.WHITE_KNIGHT, move4.getMovedPiece());
	}

	@Test
	public void testPerformMoveKnightAttack5() throws InvalidMoveException {
		// given
		Board board = new Board();
		board.setPieceAt(Piece.WHITE_KING, new Coordinate(4, 0));
		board.setPieceAt(Piece.BLACK_KING, new Coordinate(3, 3));
		board.setPieceAt(Piece.WHITE_KNIGHT, new Coordinate(0, 4));
		
		// when
		BoardManager boardManager = new BoardManager(board);
		Move move4 = boardManager.performMove(new Coordinate(0, 4), new Coordinate(1, 2));

		for(int y = 0; y<8; y++){
			for(int x = 0; x<8; x++){
				Coordinate coordinate = new Coordinate(x, y);
				Piece checkedpiece = boardManager.getBoard().getPieceAt(coordinate);
				System.out.print("X: "+x+" , Y: "+y+" => ");
				System.out.print(checkedpiece+"    ");
			}
			System.out.println(" ");
		}
	
		// then
		assertEquals(MoveType.ATTACK, move4.getType());
		assertEquals(Piece.WHITE_KNIGHT, move4.getMovedPiece());
		assertEquals(BoardState.CHECK, board.getState());

	}

	@Test
	public void testPerformMoveBishopCapture() throws InvalidMoveException {
		// given
		Board board = new Board();
		board.setPieceAt(Piece.WHITE_BISHOP, new Coordinate(0, 6));
		board.setPieceAt(Piece.WHITE_KING, new Coordinate(4, 0));
		board.setPieceAt(Piece.BLACK_ROOK, new Coordinate(1, 5));
		board.setPieceAt(Piece.BLACK_KING, new Coordinate(4, 7));
		
		// when
		BoardManager boardManager = new BoardManager(board);
		Move move = boardManager.performMove(new Coordinate(0, 6), new Coordinate(1, 5));
		
		// then
		assertEquals(MoveType.CAPTURE, move.getType());
		assertEquals(Piece.WHITE_BISHOP, move.getMovedPiece());
	}
}
