package com.capgemini.chess.algorithms.implementation.exceptions;

public class NoKingOnBoardException extends InvalidMoveException{
	

		/**
	 * 
	 */
	private static final long serialVersionUID = -830153365129095256L;

		public NoKingOnBoardException() {
			// TODO Auto-generated constructor stub
			super("No king on board!");
		}
		
		public NoKingOnBoardException(String message) {
			super("No king on board! " + message);
		}
	}



