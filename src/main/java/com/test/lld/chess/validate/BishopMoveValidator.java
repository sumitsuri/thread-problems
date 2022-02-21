package lld.chess.validate;

import lld.chess.Board;
import lld.chess.Position;

public class BishopMoveValidator extends MoveValidator {

	@Override
	public boolean validate(Board board, Position source, Position destination) {

		isValidMove(source, destination);

		if ((source.getX() - destination.getX()) == (source.getY() - destination.getY())) {
			return true;
		}

		return false;
	}

}
