package com.capgemini.chess.algorithms.data;

import com.capgemini.chess.algorithms.data.enums.Color;
import com.capgemini.chess.algorithms.data.generated.Board;
import com.capgemini.chess.algorithms.implementation.exceptions.PawnInvalidMoveException;

public class PawnMoveValidator implements PieceMoveValidator{

	private int fromX;
	private int fromY;
	private int toX;
	private int toY;
	private int modY;
	private int startPos;
	
	@Override
	public boolean checkMove(Board board, Coordinate from, Coordinate to) throws PawnInvalidMoveException {
		fromX = from.getX();
		fromY = from.getY();
		toX = to.getX();
		toY = to.getY();
		modY = board.getPieceAt(from).getColor()==Color.WHITE ? 1 : -1;
		startPos = board.getPieceAt(from).getColor()==Color.WHITE ? 1 : 6;
	
		if (fromY+modY==toY) {
			//trzeba sprawdzic czy jest bicie czy nie
			if(toX == fromX && board.getPieceAt(to)==null){
				return true;
			}else if ((toX == fromX-1 || toX == fromX+1) && (!board.getPieceAt(to).equals(null)) 
					&& (!board.getPieceAt(to).getColor().equals(board.getPieceAt(from).getColor()))){
				return true;
			}else{
				throw new PawnInvalidMoveException();
			}
		}else if((fromY == startPos) && (board.getPieceAt(new Coordinate(fromX, fromY+modY))==null)){
			if(fromY+(2*modY)==toY){
				return true;
			}
		}else{
		
		throw new PawnInvalidMoveException();
		}
		return false;
	}

	
	
	

}
