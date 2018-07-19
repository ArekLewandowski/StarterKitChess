package com.capgemini.chess.algorithms.implementation;

import static org.junit.Assert.*;

import org.junit.Test;

import com.capgemini.chess.algorithms.data.Coordinate;
import com.capgemini.chess.algorithms.data.Move;
import com.capgemini.chess.algorithms.data.enums.MoveType;
import com.capgemini.chess.algorithms.data.enums.Piece;
import com.capgemini.chess.algorithms.data.generated.Board;
import com.capgemini.chess.algorithms.implementation.exceptions.InvalidMoveException;

public class BishopMoveValidationTest {

	@Test
	public void shouldReturnBishopAttack1() throws InvalidMoveException {
		// given
		Board board = new Board();
		board.setPieceAt(Piece.WHITE_BISHOP, new Coordinate(1, 1));
		board.setPieceAt(Piece.BLACK_KNIGHT, new Coordinate(3, 3));
		board.setPieceAt(Piece.BLACK_KING, new Coordinate(4, 0));
		board.setPieceAt(Piece.WHITE_KING, new Coordinate(7, 7));
		
		// when
		BoardManager boardManager = new BoardManager(board);
		Move move = boardManager.performMove(new Coordinate(1, 1), new Coordinate(0, 2));	
	
		// then		
		assertEquals(MoveType.ATTACK, move.getType());		
		assertEquals(Piece.WHITE_BISHOP, move.getMovedPiece());
	}
	

	@Test
	public void shouldReturnBishopCapture3() throws InvalidMoveException {
		// given
		Board board = new Board();
		board.setPieceAt(Piece.WHITE_BISHOP, new Coordinate(1, 1));
		board.setPieceAt(Piece.BLACK_KNIGHT, new Coordinate(3, 3));
		board.setPieceAt(Piece.BLACK_KING, new Coordinate(4, 0));
		board.setPieceAt(Piece.WHITE_KING, new Coordinate(7, 7));
		
		// when
		BoardManager boardManager = new BoardManager(board);
		Move move = boardManager.performMove(new Coordinate(1, 1), new Coordinate(3, 3));	
	
		// then		
		assertEquals(MoveType.CAPTURE, move.getType());		
		assertEquals(Piece.WHITE_BISHOP, move.getMovedPiece());
	}
	

	@Test
	public void shouldReturnQueenAttack5() throws InvalidMoveException {
		// given
		Board board = new Board();
		board.setPieceAt(Piece.WHITE_QUEEN, new Coordinate(1, 1));
		board.setPieceAt(Piece.BLACK_KNIGHT, new Coordinate(3, 3));
		board.setPieceAt(Piece.BLACK_KING, new Coordinate(4, 0));
		board.setPieceAt(Piece.WHITE_KING, new Coordinate(7, 7));
		
		// when
		BoardManager boardManager = new BoardManager(board);
		Move move = boardManager.performMove(new Coordinate(1, 1), new Coordinate(2, 1));	
	
		// then		
		assertEquals(MoveType.ATTACK, move.getType());		
		assertEquals(Piece.WHITE_QUEEN, move.getMovedPiece());
	}
	
	@Test
	public void shouldReturnBishopAttack6() throws InvalidMoveException {
		// given
		Board board = new Board();
		board.setPieceAt(Piece.WHITE_QUEEN, new Coordinate(1, 1));
		board.setPieceAt(Piece.BLACK_KNIGHT, new Coordinate(3, 3));
		board.setPieceAt(Piece.BLACK_KING, new Coordinate(4, 0));
		board.setPieceAt(Piece.WHITE_KING, new Coordinate(7, 7));
		
		// when
		BoardManager boardManager = new BoardManager(board);
		Move move = boardManager.performMove(new Coordinate(1, 1), new Coordinate(0, 0));	
	
		// then		
		assertEquals(MoveType.ATTACK, move.getType());		
		assertEquals(Piece.WHITE_QUEEN, move.getMovedPiece());
	}

}
