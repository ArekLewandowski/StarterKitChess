package com.capgemini.chess.algorithms.data;

import java.util.ArrayList;
import java.util.List;

import com.capgemini.chess.algorithms.data.generated.Board;
import com.capgemini.chess.algorithms.implementation.exceptions.QueenInvalidMoveException;

public class QueenMoveValidator implements PieceMoveValidator {

	private int fromX;
	private int fromY;
	private int toX;
	private int toY;
	private int modY;
	private int modX;
	Coordinate checkedCoord;
	List<Coordinate> validMove = new ArrayList<>();

	@Override
	public boolean checkMove(Board board, Coordinate from, Coordinate to) throws QueenInvalidMoveException {
		fromX = from.getX();
		fromY = from.getY();
		toX = to.getX();
		toY = to.getY();

		if (isOnBoard(toX, toY)) {

			if (isItEnemyOrNull(board, from, to)) {

				if (fromY == toY) {
					modX = fromX > toX ? -1 : 1;
					if ((fromX + 1 != toX) && (fromX - 1 != toX)) {
						for (int x = fromX+1; x != toX+(-modX); x = x + modX) {
							checkedCoord = new Coordinate(x, fromY);
							if (board.getPieceAt(checkedCoord) != null) {
								throw new QueenInvalidMoveException();
							}
						}
					}

					return true;

				} else if (fromX == toX) {
					modY = fromY < toY ? 1 : -1;
					if ((fromY + 1 != toY) && (fromY - 1 != toY)) {
						for (int y = fromY+1; y != toY+(-modY); y = y + modY) {
							checkedCoord = new Coordinate(fromX, y);
							if (board.getPieceAt(checkedCoord) != null) {
								throw new QueenInvalidMoveException();
							}
						}
					}
					return true;
				} else {
					if (((toX + toY) == (fromX + fromY)) || ((toX - fromX) == (toY - fromY))) {
						modX = fromX < toX ? 1 : -1;
						modY = fromY < toY ? 1 : -1;
						if ((fromX + 1 != toX) && (fromX - 1 != toX)) {
							for (int i = 1; i != ((fromX - toX) * -modX) - 1; i++) {
								checkedCoord = new Coordinate(fromX + (i * modX), fromY + (i * modY));
								if (board.getPieceAt(checkedCoord) != null) {
									throw new QueenInvalidMoveException();			
								}
							}
						}
						return true;
					}
				}
			}
		}
		throw new QueenInvalidMoveException();
	}

	public List<Coordinate> checkAnyMove(Board board, Coordinate from) throws QueenInvalidMoveException {
		fromX = from.getX();
		fromY = from.getY();
		Coordinate checkedCoordinate = new Coordinate(fromX - 1, fromY);
		try {
			if (checkMove(board, from, checkedCoordinate)) {
				validMove.add(checkedCoordinate);
			}
		}catch (QueenInvalidMoveException e) {
				
			}

		checkedCoordinate = new Coordinate(fromX - 1, fromY - 1);
		try {
			if (checkMove(board, from, checkedCoordinate)) {
				validMove.add(checkedCoordinate);
			}
			
		} catch (QueenInvalidMoveException e) {
			// TODO: handle exception
		}
			checkedCoordinate = new Coordinate(fromX, fromY - 1);
		try {
			if (checkMove(board, from, checkedCoordinate)) {
				validMove.add(checkedCoordinate);
				}
	
			} catch (QueenInvalidMoveException e) {
	
			}
			checkedCoordinate = new Coordinate(fromX + 1, fromY - 1);
		try {
			if (checkMove(board, from, checkedCoordinate)) {
				validMove.add(checkedCoordinate);
			}
			
		} catch (QueenInvalidMoveException e) {
			
		}
			checkedCoordinate = new Coordinate(fromX + 1, fromY);
		try {
			if (checkMove(board, from, checkedCoordinate)) {
				validMove.add(checkedCoordinate);
			}
			
		} catch (QueenInvalidMoveException e) {
			
		}	
			checkedCoordinate = new Coordinate(fromX + 1, fromY + 1);
		try {
			if (checkMove(board, from, checkedCoordinate)) {
				validMove.add(checkedCoordinate);
			}
			
		} catch (QueenInvalidMoveException e) {
			
		}	
			checkedCoordinate = new Coordinate(fromX, fromY + 1);
		try {
			if (checkMove(board, from, checkedCoordinate)) {
				validMove.add(checkedCoordinate);
			}
			
		} catch (QueenInvalidMoveException e) {
			
		}	
			checkedCoordinate = new Coordinate(fromX - 1, fromY + 1);
		try {
			if (checkMove(board, from, checkedCoordinate)) {
				validMove.add(checkedCoordinate);
			}
			
		} catch (QueenInvalidMoveException e) {
			
		}	
		
		return validMove;
	}

	private boolean isOnBoard(int toX, int toY) {
		int x = toX;
		int y = toY;
		if ((x >= 0 && x <= 7) && (y >= 0 && y <= 7)) {
			return true;
		} else {
			return false;
		}
	}

	private boolean isItEnemyOrNull(Board board, Coordinate from, Coordinate to) {

		if (board.getPieceAt(to) == null) {
			return true;
		} else if (board.getPieceAt(to).getColor().equals(board.getPieceAt(from).getColor())) {
			return false;
		} else {
			return true;
		}
	}

}
