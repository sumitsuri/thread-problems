package com.solution.lld.chess.validate;

import com.solution.lld.chess.Board;
import com.solution.lld.chess.Position;

public class KingMoveValidator extends MoveValidator{

	@Override
	public boolean validate(Board board, Position source, Position destination) {
		throw new RuntimeException("Move not yet implement!!");
	}

}
