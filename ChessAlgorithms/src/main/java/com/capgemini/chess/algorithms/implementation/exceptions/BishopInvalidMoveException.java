package com.capgemini.chess.algorithms.implementation.exceptions;

public class BishopInvalidMoveException extends InvalidMoveException{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BishopInvalidMoveException() {
		
		super("Bishop invalid move!");
	}
	
	public BishopInvalidMoveException(String message) {
		super("Bishop invalid move! " + message);
	}
}
