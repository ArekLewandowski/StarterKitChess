package com.capgemini.chess.algorithms.data;

import com.capgemini.chess.algorithms.data.enums.PieceType;
import com.capgemini.chess.algorithms.data.generated.Board;
import com.capgemini.chess.algorithms.implementation.exceptions.InvalidMoveException;

public class PieceMoveSys {
	
	public static boolean pieceChecker(Board board, Coordinate from, Coordinate to) throws InvalidMoveException {
		PieceType type = board.getPieceAt(from).getType();
		boolean isValidate = false;
		PieceMoveValidator moveValidator;
		switch (type) {
		case KING:
			moveValidator = new KingMoveValidator();
			isValidate = moveValidator.checkMove(board, from, to);
			break;
		case QUEEN:
			moveValidator = new QueenMoveValidator();
			isValidate = moveValidator.checkMove(board, from, to);
			break;
		case BISHOP:
			moveValidator = new BishopMoveValidator();
			isValidate = moveValidator.checkMove(board, from, to);
			break;
		case KNIGHT:
			moveValidator = new KnightMoveValidator();
			isValidate = moveValidator.checkMove(board, from, to);
			break;
		case ROOK:
			moveValidator = new RookMoveValidator();
			isValidate = moveValidator.checkMove(board, from, to);
			break;
		case PAWN:
			moveValidator = new PawnMoveValidator();
			isValidate = moveValidator.checkMove(board, from, to);
			break;

		default:
			break;
		}
		return isValidate;
	}

}
