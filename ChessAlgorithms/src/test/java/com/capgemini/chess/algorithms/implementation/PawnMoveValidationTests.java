package com.capgemini.chess.algorithms.implementation;

import static org.junit.Assert.*;

import org.junit.Test;

import com.capgemini.chess.algorithms.data.Coordinate;
import com.capgemini.chess.algorithms.data.Move;
import com.capgemini.chess.algorithms.data.enums.MoveType;
import com.capgemini.chess.algorithms.data.enums.Piece;
import com.capgemini.chess.algorithms.data.generated.Board;
import com.capgemini.chess.algorithms.implementation.exceptions.InvalidMoveException;

public class PawnMoveValidationTests {

	@Test
	public void shouldReturnPawnCapture1() throws InvalidMoveException {
		// given
		Board board = new Board();
		board.setPieceAt(Piece.WHITE_PAWN, new Coordinate(1, 1));
		board.setPieceAt(Piece.BLACK_PAWN, new Coordinate(0, 2));
		board.setPieceAt(Piece.BLACK_KNIGHT, new Coordinate(3, 3));
		board.setPieceAt(Piece.BLACK_KING, new Coordinate(4, 0));
		board.setPieceAt(Piece.WHITE_KING, new Coordinate(7, 7));
		
		// when
		BoardManager boardManager = new BoardManager(board);
		Move move = boardManager.performMove(new Coordinate(1, 1), new Coordinate(0, 2));	
	
		// then		
		assertEquals(MoveType.CAPTURE, move.getType());		
		assertEquals(Piece.WHITE_PAWN, move.getMovedPiece());
	}
	
	@Test
	public void shouldReturnkingAttack2() throws InvalidMoveException {
		// given
		Board board = new Board();
		board.setPieceAt(Piece.WHITE_PAWN, new Coordinate(1, 1));
		board.setPieceAt(Piece.BLACK_KNIGHT, new Coordinate(3, 3));
		board.setPieceAt(Piece.BLACK_KING, new Coordinate(4, 0));
		board.setPieceAt(Piece.WHITE_KING, new Coordinate(7, 7));
		
		// when
		boolean exceptionThrown = false;
		BoardManager boardManager = new BoardManager(board);
		Move move = boardManager.performMove(new Coordinate(1, 1), new Coordinate(1, 2));	

		// then 
			assertEquals(MoveType.ATTACK, move.getType());		
			assertEquals(Piece.WHITE_PAWN, move.getMovedPiece());
		}

	@Test
	public void shouldReturnPawnAttack3Exception() throws InvalidMoveException {
		// given
		Board board = new Board();
		board.setPieceAt(Piece.WHITE_PAWN, new Coordinate(1, 1));
		board.setPieceAt(Piece.BLACK_KNIGHT, new Coordinate(3, 3));
		board.setPieceAt(Piece.BLACK_KING, new Coordinate(4, 0));
		board.setPieceAt(Piece.WHITE_KING, new Coordinate(7, 7));
		
		// when
		boolean exceptionThrown = false;
		BoardManager boardManager = new BoardManager(board);
		try{
			Move move = boardManager.performMove(new Coordinate(1, 1), new Coordinate(2, 2));	
	
		} catch (InvalidMoveException e) {
			exceptionThrown = true;
		}
	}
	
	@Test
	public void shouldReturnKingnAttack4Exception() throws InvalidMoveException {
		// given
		Board board = new Board();
		board.setPieceAt(Piece.WHITE_PAWN, new Coordinate(1, 1));
		board.setPieceAt(Piece.BLACK_KNIGHT, new Coordinate(3, 3));
		board.setPieceAt(Piece.BLACK_KING, new Coordinate(4, 0));
		board.setPieceAt(Piece.WHITE_KING, new Coordinate(7, 7));
		
		// when
		boolean exceptionThrown = false;
		BoardManager boardManager = new BoardManager(board);
		try{
			Move move = boardManager.performMove(new Coordinate(1, 1), new Coordinate(2, 2));	
	
		} catch (InvalidMoveException e) {
			exceptionThrown = true;
		}
	
		// then 
		assertTrue(exceptionThrown);
		
	}



}
