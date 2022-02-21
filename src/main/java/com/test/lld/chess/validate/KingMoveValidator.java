package lld.chess.validate;

import lld.chess.Board;
import lld.chess.Position;

public class KingMoveValidator extends MoveValidator{

	@Override
	public boolean validate(Board board, Position source, Position destination) {
		throw new RuntimeException("Move not yet implement!!");
	}

}
