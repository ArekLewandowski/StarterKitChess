package com.capgemini.chess.algorithms.data;

import java.util.ArrayList;
import java.util.List;

import com.capgemini.chess.algorithms.data.generated.Board;
import com.capgemini.chess.algorithms.implementation.exceptions.KnightInvalidMoveException;

public class KnightMoveValidator implements PieceMoveValidator{


	private int fromX;
	private int fromY;
	private int toX;
	private int toY;
	private int modY;
	private int modX;
	List<Coordinate> validMove = new ArrayList<>();
	
	@Override
	public boolean checkMove(Board board, Coordinate from, Coordinate to) throws KnightInvalidMoveException {
		fromX = from.getX();
		fromY = from.getY();
		toX = to.getX();
		toY = to.getY();
		modX = fromX < toX ? 1 : -1;
		modY = fromY < toY ? 1 : -1;
		if(isOnBoard(toX, toY)){
			
			if(isItEnemyOrNull(board, from, to)){
				
				if ( fromX + modX == toX) {
					if(fromY + (modY*2) == toY){
						return true;
					}
		
				}else if (fromY + modY == toY){
					if (fromX + (modX*2) == toX) {
						return true;
					}			
				}		
			}
		}
		throw new KnightInvalidMoveException();
	}

	public List<Coordinate> checkAnyMove(Board board, Coordinate from) throws KnightInvalidMoveException{
		fromX = from.getX();
		fromY = from.getY();
			Coordinate checkedCoordinate =new Coordinate(fromX-2, fromY+1);
			try{
				if (checkMove(board, from, checkedCoordinate)) {
					validMove.add(checkedCoordinate);
				}
			}catch(KnightInvalidMoveException e){
			
			}
			checkedCoordinate = new Coordinate(fromX-2, fromY-1);
			try {
				
				if (checkMove(board, from, checkedCoordinate)) {
					validMove.add(checkedCoordinate);
				}
			} catch (KnightInvalidMoveException e) {
				
			}
			checkedCoordinate = new Coordinate(fromX-1, fromY-2);
			try {
				if (checkMove(board, from, checkedCoordinate)) {
					validMove.add(checkedCoordinate);
				}
				
			} catch (KnightInvalidMoveException e) {
				
			}
			checkedCoordinate = new Coordinate(fromX+1, fromY-2);
			try {
				if (checkMove(board, from, checkedCoordinate)) {
					validMove.add(checkedCoordinate);
				}
				
			} catch (KnightInvalidMoveException e) {
				
			}
			checkedCoordinate =new Coordinate(fromX+2, fromY-1);
			try {
				if (checkMove(board, from, checkedCoordinate)) {
					validMove.add(checkedCoordinate);
				}
				
			} catch (KnightInvalidMoveException e) {
				
			}
			checkedCoordinate = new Coordinate(fromX+2, fromY+1);
			try {
				if (checkMove(board, from, checkedCoordinate)) {
					validMove.add(checkedCoordinate);
				}
				
			} catch (KnightInvalidMoveException e) {
				
			}
			checkedCoordinate = new Coordinate(fromX+1, fromY+2);
			try {
				if (checkMove(board, from, checkedCoordinate)) {
					validMove.add(checkedCoordinate);
				}
				
			} catch (KnightInvalidMoveException e) {
				
			}
			checkedCoordinate = new Coordinate(fromX-1, fromY+2);
			try {
				if (checkMove(board, from, checkedCoordinate)) {
					validMove.add(checkedCoordinate);
				}
				
			} catch (KnightInvalidMoveException e) {
				
			}
		return validMove;
	}
	private boolean isOnBoard(int toX, int toY) {
		int x = toX; 
		int y = toY;
		if((x>=0 && x<=7) && (y>=0 && y<=7)){
			return true;
		}else{
			return false;
		}
	}
	
	private boolean isItEnemyOrNull(Board board, Coordinate from, Coordinate to) {
		
		if (board.getPieceAt(to)==null || !board.getPieceAt(to).getColor().equals(board.getPieceAt(from).getColor())) {
			return true;
		}else{
			return false;
		}
	}

}


