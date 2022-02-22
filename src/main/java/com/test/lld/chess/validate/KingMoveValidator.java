package com.test.lld.chess.validate;

import com.test.lld.chess.Board;
import com.test.lld.chess.Position;

public class KingMoveValidator extends MoveValidator{

	@Override
	public boolean validate(Board board, Position source, Position destination) {
		throw new RuntimeException("Move not yet implement!!");
	}

}
