package com.test.lld.chess.validate;


import com.test.lld.chess.Board;
import com.test.lld.chess.Position;

public abstract class MoveValidator {

	public abstract boolean validate(Board board, Position source, Position destination);

	void isValidMove(Position source, Position destination) {
		isValidPosition(source);
		isValidPosition(destination);
		
		if (source.getX() == destination.getX() && source.getY() == destination.getY()) {
			throw new IllegalArgumentException(
					"Source and Destination position coordinates are the same. Cannot move");
		}
	}
	
	void isValidPosition(Position position) {
		int posX = position.getX();
		int posY = position.getY();
		boolean isValid = (posX < 0 || posX > 7 || posY < 0 || posY > 7);

		if (!isValid) {
			throw new IllegalArgumentException("Position coordinates incorrect : " + position);
		}
	}
}
