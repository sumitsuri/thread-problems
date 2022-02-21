package lld.chess.validate;

import lld.chess.Board;
import lld.chess.Position;

public class HorseMoveValidator extends MoveValidator {

	@Override
	public boolean validate(Board board, Position source, Position destination) {

		isValidMove(source, destination);
		
		int fromX = source.getX();
		int fromY = source.getY();

		int toX = destination.getX();
		int toY = destination.getY();

		if (toX != fromX - 1 && toX != fromX + 1 && toX != fromX + 2 && toX != fromX - 2)
			return false;
		if (toY != fromY - 2 && toY != fromY + 2 && toY != fromY - 1 && toY != fromY + 1)
			return false;

		return true;
	}

}
