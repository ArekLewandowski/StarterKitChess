package com.capgemini.chess.algorithms.implementation.exceptions;

public class KnightInvalidMoveException extends InvalidMoveException{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public KnightInvalidMoveException() {
		
		super("Knight invalid move!");
	}
	
	public KnightInvalidMoveException(String message) {
		super("Knight invalid move! " + message);
	}
}
