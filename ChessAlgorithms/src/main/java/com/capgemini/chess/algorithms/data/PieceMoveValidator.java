package com.capgemini.chess.algorithms.data;

import com.capgemini.chess.algorithms.data.generated.Board;
import com.capgemini.chess.algorithms.implementation.exceptions.InvalidMoveException;


public interface PieceMoveValidator {


	boolean checkMove(Board board, Coordinate from, Coordinate to) throws InvalidMoveException;
}
