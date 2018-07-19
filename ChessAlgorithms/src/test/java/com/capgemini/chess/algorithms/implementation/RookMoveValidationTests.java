package com.capgemini.chess.algorithms.implementation;

import static org.junit.Assert.*;

import org.junit.Test;

import com.capgemini.chess.algorithms.data.Coordinate;
import com.capgemini.chess.algorithms.data.Move;
import com.capgemini.chess.algorithms.data.enums.MoveType;
import com.capgemini.chess.algorithms.data.enums.Piece;
import com.capgemini.chess.algorithms.data.generated.Board;
import com.capgemini.chess.algorithms.implementation.exceptions.InvalidMoveException;

public class RookMoveValidationTests {

	@Test
	public void shouldReturnQueenAttack1() throws InvalidMoveException {
		// given
		Board board = new Board();
		board.setPieceAt(Piece.WHITE_ROOK, new Coordinate(1, 1));
		board.setPieceAt(Piece.BLACK_KNIGHT, new Coordinate(1, 6));
		board.setPieceAt(Piece.BLACK_KING, new Coordinate(4, 0));
		board.setPieceAt(Piece.WHITE_KING, new Coordinate(7, 7));
		
		// when
		BoardManager boardManager = new BoardManager(board);
		Move move = boardManager.performMove(new Coordinate(1, 1), new Coordinate(0, 1));	
	
		// then		
		assertEquals(MoveType.ATTACK, move.getType());		
		assertEquals(Piece.WHITE_ROOK, move.getMovedPiece());
	}
	
	@Test
	public void shouldReturnQueenAttack2() throws InvalidMoveException {
		// given
		Board board = new Board();
		board.setPieceAt(Piece.WHITE_ROOK, new Coordinate(1, 1));
		board.setPieceAt(Piece.BLACK_KNIGHT, new Coordinate(1, 6));
		board.setPieceAt(Piece.BLACK_KING, new Coordinate(4, 0));
		board.setPieceAt(Piece.WHITE_KING, new Coordinate(7, 7));
		
		// when
		BoardManager boardManager = new BoardManager(board);
		Move move = boardManager.performMove(new Coordinate(1, 1), new Coordinate(1, 6));	
	
		// then		
		assertEquals(MoveType.CAPTURE, move.getType());		
		assertEquals(Piece.WHITE_ROOK, move.getMovedPiece());
	}

	
	@Test
	public void shouldReturnQueenAttack4() throws InvalidMoveException {
		// given
		Board board = new Board();
		board.setPieceAt(Piece.WHITE_ROOK, new Coordinate(1, 1));
		board.setPieceAt(Piece.BLACK_KNIGHT, new Coordinate(3, 3));
		board.setPieceAt(Piece.BLACK_KING, new Coordinate(4, 0));
		board.setPieceAt(Piece.WHITE_KING, new Coordinate(7, 7));
		
		// when
		BoardManager boardManager = new BoardManager(board);
		Move move = boardManager.performMove(new Coordinate(1, 1), new Coordinate(7, 1));	
	
		// then		
		assertEquals(MoveType.ATTACK, move.getType());		
		assertEquals(Piece.WHITE_ROOK, move.getMovedPiece());
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
		Move move = boardManager.performMove(new Coordinate(1, 1), new Coordinate(0, 0));	
	
		// then		
		assertEquals(MoveType.ATTACK, move.getType());		
		assertEquals(Piece.WHITE_QUEEN, move.getMovedPiece());
	}
	
	@Test
	public void shouldReturnQueenAttack3() throws InvalidMoveException {
		// given
		Board board = new Board();
		board.setPieceAt(Piece.WHITE_ROOK, new Coordinate(1, 1));
		board.setPieceAt(Piece.BLACK_KNIGHT, new Coordinate(3, 3));
		board.setPieceAt(Piece.BLACK_KING, new Coordinate(4, 0));
		board.setPieceAt(Piece.WHITE_KING, new Coordinate(7, 7));
		
		// when
		BoardManager boardManager = new BoardManager(board);
		Move move = boardManager.performMove(new Coordinate(1, 1), new Coordinate(1, 0));	
	
		// then		
		assertEquals(MoveType.ATTACK, move.getType());		
		assertEquals(Piece.WHITE_ROOK, move.getMovedPiece());
	}

}
