package com.capgemini.chess.algorithms.implementation.exceptions;

public class RookInvalidMoveException extends InvalidMoveException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public RookInvalidMoveException() {
		
		super("Rook invalid move!");
	}
	
	public RookInvalidMoveException(String message) {
		super("Rook invalid move! " + message);
	}
}


