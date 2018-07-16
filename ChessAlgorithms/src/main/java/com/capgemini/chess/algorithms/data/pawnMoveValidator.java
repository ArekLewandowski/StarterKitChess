package com.capgemini.chess.algorithms.data;

import com.capgemini.chess.algorithms.data.enums.Color;
import com.capgemini.chess.algorithms.data.generated.Board;

public class pawnMoveValidator implements PieceMoveValidator{

	private int fromX;
	private int fromY;
	private int toX;
	private int toY;
	private int modY;
	
	@Override
	public boolean checkMove(Board board, Coordinate from, Coordinate to) {
		fromX = from.getX();
		fromY = from.getY();
		toX = to.getX();
		toY = to.getY();
		modY = board.getPieceAt(from).getColor()==Color.WHITE ? -1 : 1;
	
		if (fromY+modY==toY) {
			if(toX == fromX-1 || toX == fromX-1 || toX == fromX-1){
				return true;
			}
		}else if(fromY==1){
			if(fromY+(2*modY)==toY){
				return true;
			}
		}
		
		return false;
	}

	
	
	

}
