package com.capgemini.chess.algorithms.data;

import com.capgemini.chess.algorithms.data.generated.Board;

public interface PieceMoveValidator {


	boolean checkMove(Board board, Coordinate from, Coordinate to);
}
