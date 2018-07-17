package com.capgemini.chess.algorithms.implementation.exceptions;

public class KingInvalidMoveException extends InvalidMoveException{

	private static final long serialVersionUID = 1L;

	public KingInvalidMoveException() {
		
		super("King invalid move!");
	}
	
	public KingInvalidMoveException(String message) {
		super("King nvalid move! " + message);
	}
}

