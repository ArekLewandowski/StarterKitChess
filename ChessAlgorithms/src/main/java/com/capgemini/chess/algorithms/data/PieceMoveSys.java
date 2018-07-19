package com.capgemini.chess.algorithms.data;

import java.util.List;

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
	
	public static List<Coordinate> anyMovePieceChecker(Board board, Coordinate from) throws InvalidMoveException {
		PieceType type = board.getPieceAt(from).getType();
		
		PieceMoveValidator moveValidator;
		switch (type) {
		case KING:
			moveValidator = new KingMoveValidator();
			return moveValidator.checkAnyMove(board, from);
			
		case QUEEN:
			moveValidator = new QueenMoveValidator();
			return moveValidator.checkAnyMove(board, from);
		case BISHOP:
			moveValidator = new BishopMoveValidator();
			return moveValidator.checkAnyMove(board, from);
		case KNIGHT:
			moveValidator = new KnightMoveValidator();
			return moveValidator.checkAnyMove(board, from);
		case ROOK:
			moveValidator = new RookMoveValidator();
			return moveValidator.checkAnyMove(board, from);
		case PAWN:
			moveValidator = new PawnMoveValidator();
			return moveValidator.checkAnyMove(board, from);

		default:
			break;
		}
		throw new InvalidMoveException();
	}

}
