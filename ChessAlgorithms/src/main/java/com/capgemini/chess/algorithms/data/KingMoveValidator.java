package com.capgemini.chess.algorithms.data;

import java.util.ArrayList;
import java.util.List;

import com.capgemini.chess.algorithms.data.generated.Board;
import com.capgemini.chess.algorithms.implementation.exceptions.KingInvalidMoveException;

public class KingMoveValidator implements PieceMoveValidator{

	private int fromX;
	private int fromY;
	private int toX;
	private int toY;
	List<Coordinate> validMove = new ArrayList<>();
	
	@Override
	public boolean checkMove(Board board, Coordinate from, Coordinate to) throws KingInvalidMoveException {
		fromX = from.getX();
		fromY = from.getY();
		toX = to.getX();
		toY = to.getY();
		if(isOnBoard(toX, toY)){
			
			if(isItEnemyOrNull(board, from, to)){
				if ( fromY == toY || fromY-1 == toY || fromY+1 == toY ) {
					if(toX == fromX || toX == fromX-1 || toX == fromX+1){
						return true;
					}
					
				}
			}
		}	
		throw new KingInvalidMoveException();
	}

	public List<Coordinate> checkAnyMove(Board board, Coordinate from) throws KingInvalidMoveException {
		fromX = from.getX();
		fromY = from.getY();
		
			Coordinate checkedCoordinate1 =new Coordinate(fromX-1, fromY);
			try{
				if (checkMove(board, from, checkedCoordinate1)) {
					validMove.add(checkedCoordinate1);
				}
			}catch (KingInvalidMoveException e) {
					
			}
			
			Coordinate checkedCoordinate2 =new Coordinate(fromX-1, fromY-1);
			try{
				if (checkMove(board, from, checkedCoordinate2)) {
					validMove.add(checkedCoordinate2);
				}
			}catch(KingInvalidMoveException e){
				
			}
			
			Coordinate checkedCoordinate3 = new Coordinate(fromX, fromY-1);
			try{
				if (checkMove(board, from, checkedCoordinate3)) {
					validMove.add(checkedCoordinate3);
				}
			}catch(KingInvalidMoveException e){
				
			}
			
			Coordinate checkedCoordinate4 = new Coordinate(fromX+1, fromY-1);
			try{
				if (checkMove(board, from, checkedCoordinate4)) {
					validMove.add(checkedCoordinate4);
				}
			}catch(KingInvalidMoveException e){
				
			}
			
			Coordinate checkedCoordinate5 = new Coordinate(fromX+1, fromY);
			try {
				if (checkMove(board, from, checkedCoordinate5)) {
				validMove.add(checkedCoordinate5);
			}
			} catch (KingInvalidMoveException e) {
				
			}
						
			Coordinate checkedCoordinate6 = new Coordinate(fromX+1, fromY+1);
			try{
				if (checkMove(board, from, checkedCoordinate6)) {
					validMove.add(checkedCoordinate6);
				}
			}catch(KingInvalidMoveException e){
				
			}
			
			Coordinate checkedCoordinate7 = new Coordinate(fromX, fromY+1);
			try{
				if (checkMove(board, from, checkedCoordinate7)) {
					validMove.add(checkedCoordinate7);
				}
			}catch(KingInvalidMoveException e){
				
			}
			
			Coordinate checkedCoordinate8 = new Coordinate(fromX-1, fromY+1);
			try{
				if (checkMove(board, from, checkedCoordinate8)) {
					validMove.add(checkedCoordinate8);
				}
			}catch(KingInvalidMoveException e){
				
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
