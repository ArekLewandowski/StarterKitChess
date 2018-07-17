package com.capgemini.chess.algorithms.implementation.exceptions;

public class PawnInvalidMoveException extends InvalidMoveException{


	private static final long serialVersionUID = 1L;

	public PawnInvalidMoveException() {
		
		super("Pawn invalid move!");
	}
	
	public PawnInvalidMoveException(String message) {
		super("Pawn nvalid move! " + message);
	}
}
