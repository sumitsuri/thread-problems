package com.solution.lld.chess.validate;


import com.solution.lld.chess.Board;
import com.solution.lld.chess.Position;

public class QueenMoveValidator extends MoveValidator {

	@Override
	public boolean validate(Board board, Position source, Position destination) {
		// left and right
		if ((source.getX() == destination.getX()) || (source.getY() == destination.getY())) {
			return true;
		}

		// diagonal
		if ((source.getX() - destination.getX()) == (source.getY() - destination.getY())) {
			return true;
		}
		return false;
	}
}
