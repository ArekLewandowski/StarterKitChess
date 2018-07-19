package com.capgemini.chess.algorithms.data;

import java.util.ArrayList;
import java.util.List;

import com.capgemini.chess.algorithms.data.enums.Color;
import com.capgemini.chess.algorithms.data.generated.Board;
import com.capgemini.chess.algorithms.implementation.exceptions.PawnInvalidMoveException;

public class PawnMoveValidator implements PieceMoveValidator {

	private int fromX;
	private int fromY;
	private int toX;
	private int toY;
	private int modY;
	private int startPos;
	List<Coordinate> validMove = new ArrayList<>();

	@Override
	public boolean checkMove(Board board, Coordinate from, Coordinate to) throws PawnInvalidMoveException {
		fromX = from.getX();
		fromY = from.getY();
		toX = to.getX();
		toY = to.getY();
		modY = board.getPieceAt(from).getColor() == Color.WHITE ? 1 : -1;
		startPos = board.getPieceAt(from).getColor() == Color.WHITE ? 1 : 6;

		if (isOnBoard(toX, toY)) {

			if (isItNull(board, from, to)) {

				if (fromY + modY == toY) {

					if (toX == fromX && board.getPieceAt(to) == null) {
						return true;
					} else if ((toX == fromX - 1 || toX == fromX + 1) && (board.getPieceAt(to) != null)) {
						return true;
					} else {
						throw new PawnInvalidMoveException();
					}
				} else if ((fromY == startPos) && (board.getPieceAt(new Coordinate(fromX, fromY + modY)) == null)) {
					if (fromY + (2 * modY) == toY) {
						return true;
					}
				} else {

					throw new PawnInvalidMoveException();
				}
			}
		}
		return false;
	}

	public List<Coordinate> checkAnyMove(Board board, Coordinate from) throws PawnInvalidMoveException {
		fromX = from.getX();
		fromY = from.getY();
		try {
			modY = board.getPieceAt(from).getColor() == Color.WHITE ? 1 : -1;
			Coordinate checkedCoordinate = new Coordinate(fromX, fromY + modY);
			if (checkMove(board, from, checkedCoordinate)) {
				validMove.add(checkedCoordinate);
			}
		} catch (PawnInvalidMoveException e) {

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

	private boolean isItNull(Board board, Coordinate from, Coordinate to) {

		if (board.getPieceAt(to) == null){
				//|| !board.getPieceAt(to).getColor().equals(board.getPieceAt(from).getColor())) {
			return true;
		} else {
			return false;
		}
	}

}
