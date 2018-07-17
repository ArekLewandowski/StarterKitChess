package com.capgemini.chess.algorithms.data;

import com.capgemini.chess.algorithms.data.generated.Board;
import com.capgemini.chess.algorithms.implementation.exceptions.BishopInvalidMoveException;

public class BishopMoveValidator implements PieceMoveValidator{


	private int fromX;
	private int fromY;
	private int toX;
	private int toY;
	private int modY;
	private int modX;
	Coordinate checkedCoord;

	@Override
	public boolean checkMove(Board board, Coordinate from, Coordinate to) throws BishopInvalidMoveException {
		fromX = from.getX();
		fromY = from.getY();
		toX = to.getX();
		toY = to.getY();
	
		  
		if ((toX+toY)==(fromX+fromY)||(toX-fromX)==(toY-fromY)) {
			modX = fromX<toX ? 1 : -1;
			modY = fromY<toY ? 1 : -1;
			for(int i = 0; i!=((fromX-toX)*modX)-1; i++){
				checkedCoord = new Coordinate(fromX+i, fromY+i);
				if (board.getPieceAt(checkedCoord)!=null) {
					throw new BishopInvalidMoveException();
				} 
				
			}
			return true;
		}
		
		throw new BishopInvalidMoveException();
	}


}
