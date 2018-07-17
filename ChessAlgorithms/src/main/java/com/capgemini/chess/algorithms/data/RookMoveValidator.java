package com.capgemini.chess.algorithms.data;

import com.capgemini.chess.algorithms.data.generated.Board;
import com.capgemini.chess.algorithms.implementation.exceptions.RookInvalidMoveException;

public class RookMoveValidator implements PieceMoveValidator{
	
		private int fromX;
		private int fromY;
		private int toX;
		private int toY;
		private int modY;
		private int modX;
		Coordinate checkedCoord;
		@Override
		public boolean checkMove(Board board, Coordinate from, Coordinate to) throws RookInvalidMoveException {
			fromX = from.getX();
			fromY = from.getY();
			toX = to.getX();
			toY = to.getY();
		
			if ( fromY == toY ) {
				modX = fromX > toX ? -1 : 1;
				for(int x = fromX; x==toX-modX; x=x+modX ){
					checkedCoord = new Coordinate(x, fromY);
					if(board.getPieceAt(checkedCoord)!=null){
						throw new RookInvalidMoveException();
					}
					
				}
				
				return true;
			
			}else if (fromX == toX) {
				modY = fromY > toY ? -1 : 1;
				for(int y = fromY; y==toY-modY; y=y+modY ){
					checkedCoord = new Coordinate(fromX, y);
					if(board.getPieceAt(checkedCoord)!=null){
						throw new RookInvalidMoveException();
						}
					}
			
				return true;
			}
			throw new RookInvalidMoveException();
		}

}
