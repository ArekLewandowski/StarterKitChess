package com.capgemini.chess.algorithms.data;

import java.util.ArrayList;
import java.util.List;

import com.capgemini.chess.algorithms.data.generated.Board;
import com.capgemini.chess.algorithms.implementation.exceptions.RookInvalidMoveException;

public class RookMoveValidator implements PieceMoveValidator {

	private int fromX;
	private int fromY;
	private int toX;
	private int toY;
	private int modY;
	private int modX;
	Coordinate checkedCoord;
	List<Coordinate> validMove = new ArrayList<>();

	@Override
	public boolean checkMove(Board board, Coordinate from, Coordinate to) throws RookInvalidMoveException {
		fromX = from.getX();
		fromY = from.getY();
		toX = to.getX();
		toY = to.getY();

		if (isOnBoard(toX, toY)) {

			if (isItEnemyOrNull(board, from, to)) {

				if (fromY == toY) {
					modX = fromX > toX ? -1 : 1;
					for (int x = fromX; x == toX - modX; x = x + modX) {
						checkedCoord = new Coordinate(x, fromY);
						if (board.getPieceAt(checkedCoord) != null) {
							throw new RookInvalidMoveException();
						}

					}

					return true;

				} else if (fromX == toX) {
					modY = fromY > toY ? -1 : 1;
					for (int y = fromY; y == toY - modY; y = y + modY) {
						checkedCoord = new Coordinate(fromX, y);
						if (board.getPieceAt(checkedCoord) != null) {
							throw new RookInvalidMoveException();
						}
					}

					return true;
				}
			}
		}
		throw new RookInvalidMoveException();
	}

	public List<Coordinate> checkAnyMove(Board board, Coordinate from) throws RookInvalidMoveException {
		fromX = from.getX();
		fromY = from.getY();
			Coordinate checkedCoordinate = new Coordinate(fromX - 1, fromY);
			try {
				if (checkMove(board, from, checkedCoordinate)) {
					validMove.add(checkedCoordinate);
				}
			} catch (RookInvalidMoveException e) {

			}
			checkedCoordinate = new Coordinate(fromX, fromY - 1);
			try {
				if (checkMove(board, from, checkedCoordinate)) {
					validMove.add(checkedCoordinate);
				}
				
			} catch (RookInvalidMoveException e) {
				
			}
			checkedCoordinate = new Coordinate(fromX + 1, fromY);
			try {
				if (checkMove(board, from, checkedCoordinate)) {
					validMove.add(checkedCoordinate);
				}
				
			} catch (RookInvalidMoveException e) {
				
			}
			checkedCoordinate = new Coordinate(fromX, fromY + 1);
			try {
				
				if (checkMove(board, from, checkedCoordinate)) {
					validMove.add(checkedCoordinate);
				}
			} catch (RookInvalidMoveException e) {
				
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

		if (board.getPieceAt(to) == null
				|| !board.getPieceAt(to).getColor().equals(board.getPieceAt(from).getColor())) {
			return true;
		} else {
			return false;
		}
	}
}
