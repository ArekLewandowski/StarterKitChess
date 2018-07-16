package com.capgemini.chess.algorithms.data;

import com.capgemini.chess.algorithms.data.generated.Board;

public class knightMoveValidator implements PieceMoveValidator{


	private int fromX;
	private int fromY;
	private int toX;
	private int toY;
	private int modY;
	private int modX;
	
	@Override
	public boolean checkMove(Board board, Coordinate from, Coordinate to) {
		fromX = from.getX();
		fromY = from.getY();
		toX = to.getX();
		toY = to.getY();
		modX = fromX < toX ? 1 : -1;
		modY = fromY < toY ? 1 : -1;
	
		if ( fromX + modX == toX) {
			if(fromY + (modY*2) == toY){
				return true;
			}
		
		}else if (fromY + modY == toY){
			if (fromX + (modX*2) == toX) {
				return true;
			}
			
		}
		
		return false;
	}

	
}


