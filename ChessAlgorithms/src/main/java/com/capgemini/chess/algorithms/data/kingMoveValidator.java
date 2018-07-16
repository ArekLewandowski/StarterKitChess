package com.capgemini.chess.algorithms.data;

import com.capgemini.chess.algorithms.data.generated.Board;

public class kingMoveValidator implements PieceMoveValidator{

	private int fromX;
	private int fromY;
	private int toX;
	private int toY;
	
	@Override
	public boolean checkMove(Board board, Coordinate from, Coordinate to) {
		fromX = from.getX();
		fromY = from.getY();
		toX = to.getX();
		toY = to.getY();
	
		if ( fromY == toY || fromY-1 == toY || fromY+1 == toY ) {
			if(toX == fromX || toX == fromX-1 || toX == fromX+1){
				return true;
			}
		
		}
		
		return false;
	}

	
}
