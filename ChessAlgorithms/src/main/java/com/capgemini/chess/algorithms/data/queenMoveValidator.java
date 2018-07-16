package com.capgemini.chess.algorithms.data;

import com.capgemini.chess.algorithms.data.generated.Board;

public class queenMoveValidator implements PieceMoveValidator{

	private int fromX;
	private int fromY;
	private int toX;
	private int toY;
	private int modY;
	private int modX;
	Coordinate checkedCoord;
	@Override
	public boolean checkMove(Board board, Coordinate from, Coordinate to) {
		fromX = from.getX();
		fromY = from.getY();
		toX = to.getX();
		toY = to.getY();
	
		if ( fromY == toY ) {
			modX = fromX > toX ? -1 : 1;
			for(int x = fromX; x!=toX-modX; x=x+modX ){
				checkedCoord = new Coordinate(x, fromY);
				if(board.getPieceAt(checkedCoord)!=null){
					return false;
				}
				
			}
			
			return true;
		
		}else if (fromX == toX) {
			modY = fromY > toY ? -1 : 1;
			for(int y = fromY; y!=toY-modY; y=y+modY ){
				checkedCoord = new Coordinate(fromX, y);
				if(board.getPieceAt(checkedCoord)!=null){
					return false;
					}
				}
		
			return true;
		}else{
			if ((toX+toY)==(fromX+fromY)||(toX-fromX)==(toY-fromY)) {
				modX = fromX<toX ? 1 : -1;
				modY = fromY<toY ? 1 : -1;
				for(int i = 0; i!=((fromX-toX)*modX)-1; i++){
					checkedCoord = new Coordinate(fromX+i, fromY+i);
					if (board.getPieceAt(checkedCoord)!=null) {
						return false;
					}
					
				}
				return true;
			}
		}
		return false;
	}


}
