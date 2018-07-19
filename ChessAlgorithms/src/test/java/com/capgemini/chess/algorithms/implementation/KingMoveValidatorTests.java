package com.capgemini.chess.algorithms.implementation;

import static org.junit.Assert.*;

import org.junit.Test;

import com.capgemini.chess.algorithms.data.Coordinate;
import com.capgemini.chess.algorithms.data.Move;
import com.capgemini.chess.algorithms.data.enums.MoveType;
import com.capgemini.chess.algorithms.data.enums.Piece;
import com.capgemini.chess.algorithms.data.generated.Board;
import com.capgemini.chess.algorithms.implementation.exceptions.InvalidMoveException;

public class KingMoveValidatorTests {

	@Test
	public void shouldReturnKingAttack1() throws InvalidMoveException {
		// given
		Board board = new Board();
		board.setPieceAt(Piece.WHITE_KING, new Coordinate(1, 1));
		board.setPieceAt(Piece.BLACK_KNIGHT, new Coordinate(3, 3));
		board.setPieceAt(Piece.BLACK_KING, new Coordinate(4, 0));
		board.setPieceAt(Piece.WHITE_KING, new Coordinate(7, 7));
		
		// when
		BoardManager boardManager = new BoardManager(board);
		Move move = boardManager.performMove(new Coordinate(1, 1), new Coordinate(0, 1));	
	
		// then		
		assertEquals(MoveType.ATTACK, move.getType());		
		assertEquals(Piece.WHITE_KING, move.getMovedPiece());
	}
	
	@Test
	public void shouldReturnkingAttack2() throws InvalidMoveException {
		// given
		Board board = new Board();
		board.setPieceAt(Piece.WHITE_KING, new Coordinate(1, 1));
		board.setPieceAt(Piece.BLACK_KNIGHT, new Coordinate(3, 3));
		board.setPieceAt(Piece.BLACK_KING, new Coordinate(4, 0));
		board.setPieceAt(Piece.BLACK_PAWN, new Coordinate(2, 1));
		
		// when
		boolean exceptionThrown = false;
		BoardManager boardManager = new BoardManager(board);
		try{
			Move move = boardManager.performMove(new Coordinate(1, 1), new Coordinate(1, 2));	
	
		} catch (InvalidMoveException e) {
			exceptionThrown = true;
		}
	
		// then 
		assertTrue(exceptionThrown);
		}

	@Test
	public void shouldReturnKingCapture3() throws InvalidMoveException {
		// given
		Board board = new Board();
		board.setPieceAt(Piece.WHITE_KING, new Coordinate(1, 1));
		board.setPieceAt(Piece.BLACK_KNIGHT, new Coordinate(3, 3));
		board.setPieceAt(Piece.BLACK_KING, new Coordinate(4, 0));
		board.setPieceAt(Piece.BLACK_PAWN, new Coordinate(2, 1));
		
		// when
		BoardManager boardManager = new BoardManager(board);
		Move move = boardManager.performMove(new Coordinate(1, 1), new Coordinate(2, 2));	
	
		// then		
		assertEquals(MoveType.ATTACK, move.getType());		
		assertEquals(Piece.WHITE_KING, move.getMovedPiece());
	}
	
	@Test
	public void shouldReturnKingnAttack4() throws InvalidMoveException {
		// given
		Board board = new Board();
		board.setPieceAt(Piece.WHITE_KING, new Coordinate(1, 1));
		board.setPieceAt(Piece.BLACK_KNIGHT, new Coordinate(3, 3));
		board.setPieceAt(Piece.BLACK_KING, new Coordinate(4, 0));
		board.setPieceAt(Piece.BLACK_PAWN, new Coordinate(2, 1));
		
		// when
		boolean exceptionThrown = false;
		BoardManager boardManager = new BoardManager(board);
		try{
			Move move = boardManager.performMove(new Coordinate(1, 1), new Coordinate(2, 1));	
	
		} catch (InvalidMoveException e) {
			exceptionThrown = true;
		}
	
		// then 
		assertTrue(exceptionThrown);
		
	}

	@Test
	public void shouldReturnKingAttack5() throws InvalidMoveException {
		// given
		Board board = new Board();
		board.setPieceAt(Piece.WHITE_KING, new Coordinate(1, 1));
		board.setPieceAt(Piece.BLACK_KNIGHT, new Coordinate(3, 3));
		board.setPieceAt(Piece.BLACK_KING, new Coordinate(4, 0));
		board.setPieceAt(Piece.BLACK_PAWN, new Coordinate(2, 1));
		
		// when
		BoardManager boardManager = new BoardManager(board);
		Move move = boardManager.performMove(new Coordinate(1, 1), new Coordinate(2, 0));	
	
		// then		
		assertEquals(MoveType.ATTACK, move.getType());		
		assertEquals(Piece.WHITE_KING, move.getMovedPiece());
	}
	
	@Test
	public void shouldReturnKingAttack6() throws InvalidMoveException {
		// given
		Board board = new Board();
		board.setPieceAt(Piece.WHITE_KING, new Coordinate(1, 1));
		board.setPieceAt(Piece.BLACK_KNIGHT, new Coordinate(3, 3));
		board.setPieceAt(Piece.BLACK_KING, new Coordinate(4, 0));
		board.setPieceAt(Piece.BLACK_PAWN, new Coordinate(2, 1));
		
		// when
		boolean exceptionThrown = false;
		BoardManager boardManager = new BoardManager(board);
		try{
		Move move = boardManager.performMove(new Coordinate(1, 1), new Coordinate(1, 0));	
	
		} catch (InvalidMoveException e) {
			exceptionThrown = true;
		}
	
		// then 
		assertTrue(exceptionThrown);
		}
	
	@Test
	public void shouldReturnKingAttack7() throws InvalidMoveException {
		// given
		Board board = new Board();
		board.setPieceAt(Piece.WHITE_KING, new Coordinate(1, 1));
		board.setPieceAt(Piece.BLACK_KNIGHT, new Coordinate(3, 3));
		board.setPieceAt(Piece.BLACK_KING, new Coordinate(4, 0));
		board.setPieceAt(Piece.BLACK_PAWN, new Coordinate(2, 1));
		
		// when
		BoardManager boardManager = new BoardManager(board);
		Move move = boardManager.performMove(new Coordinate(1, 1), new Coordinate(0, 0));	
	
		// then		
		assertEquals(MoveType.ATTACK, move.getType());		
		assertEquals(Piece.WHITE_KING, move.getMovedPiece());
	}
	
	@Test
	public void shouldReturnKingAttack8() throws InvalidMoveException {
		// given
		Board board = new Board();
		board.setPieceAt(Piece.WHITE_KING, new Coordinate(1, 1));
		board.setPieceAt(Piece.BLACK_KNIGHT, new Coordinate(3, 3));
		board.setPieceAt(Piece.BLACK_KING, new Coordinate(4, 0));
		board.setPieceAt(Piece.BLACK_PAWN, new Coordinate(2, 1));
		
		// when
		BoardManager boardManager = new BoardManager(board);
		Move move = boardManager.performMove(new Coordinate(1, 1), new Coordinate(0, 1));	
	
		// then		
		assertEquals(MoveType.ATTACK, move.getType());		
		assertEquals(Piece.WHITE_KING, move.getMovedPiece());
	}

}
