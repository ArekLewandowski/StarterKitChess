package com.capgemini.chess.algorithms.data;

import java.util.ArrayList;
import java.util.List;

import com.capgemini.chess.algorithms.data.generated.Board;
import com.capgemini.chess.algorithms.implementation.exceptions.BishopInvalidMoveException;

public class BishopMoveValidator implements PieceMoveValidator {

	private int fromX;
	private int fromY;
	private int toX;
	private int toY;
	private int modY;
	private int modX;
	Coordinate checkedCoord;
	List<Coordinate> validMove = new ArrayList<>();;

	@Override
	public boolean checkMove(Board board, Coordinate from, Coordinate to) throws BishopInvalidMoveException {
		fromX = from.getX();
		fromY = from.getY();
		toX = to.getX();
		toY = to.getY();

		if (isOnBoard(toX, toY)) {

			if (isItEnemyOrNull(board, from, to)) {
				if ((toX + toY) == (fromX + fromY) || (toX - fromX) == (toY - fromY)) {
					modX = fromX < toX ? 1 : -1;
					modY = fromY < toY ? 1 : -1;
					if ((fromX + 1 != toX) && (fromX - 1 != toX)) {
						for (int i = 1; i != ((fromX - toX) * -modX) - 1; i++) {
							checkedCoord = new Coordinate(fromX + (i * modX), fromY + (i * modY));
							if (board.getPieceAt(checkedCoord) != null) {
								throw new BishopInvalidMoveException();
							}
						}

					}
					return true;
				}
			}
		}

		throw new BishopInvalidMoveException();
	}

	public List<Coordinate> checkAnyMove(Board board, Coordinate from) throws BishopInvalidMoveException {
		fromX = from.getX();
		fromY = from.getY();
		Coordinate checkedCoordinate = new Coordinate(fromX - 1, fromY - 1);
		try {
			if (checkMove(board, from, checkedCoordinate)) {
				validMove.add(checkedCoordinate);
			}
		} catch (BishopInvalidMoveException e) {

		}
		checkedCoordinate = new Coordinate(fromX + 1, fromY - 1);
		try {
			if (checkMove(board, from, checkedCoordinate)) {
				validMove.add(checkedCoordinate);
			}

		} catch (BishopInvalidMoveException e) {

		}
		checkedCoordinate = new Coordinate(fromX + 1, fromY + 1);
		try {
			if (checkMove(board, from, checkedCoordinate)) {
				validMove.add(checkedCoordinate);
			}

		} catch (Exception e) {

		}
		checkedCoordinate = new Coordinate(fromX - 1, fromY + 1);
		try {
			if (checkMove(board, from, checkedCoordinate)) {
				validMove.add(checkedCoordinate);
			}

		} catch (BishopInvalidMoveException e) {

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
