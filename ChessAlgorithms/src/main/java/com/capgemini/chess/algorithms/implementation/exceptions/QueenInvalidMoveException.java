package com.capgemini.chess.algorithms.implementation.exceptions;

public class QueenInvalidMoveException extends InvalidMoveException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public QueenInvalidMoveException() {
		
		super("Queen invalid move!");
	}
	
	public QueenInvalidMoveException(String message) {
		super("Queen invalid move! " + message);
	}
}
