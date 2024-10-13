package com.solution.lld.chess.validate;


import com.solution.lld.chess.Board;
import com.solution.lld.chess.Position;

public class RookMoveValidator extends MoveValidator {

	@Override
	public boolean validate(Board board, Position source, Position destination) {
		isValidMove(source, destination);

		if ((source.getX() == destination.getX()) || (source.getY() == destination.getY())) {
			return true;
		}
		return false;
	}
}
