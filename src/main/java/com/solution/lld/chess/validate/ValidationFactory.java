package com.solution.lld.chess.validate;


import com.solution.lld.chess.Piece;

public class ValidationFactory {

	public static MoveValidator find(Piece piece) {
		switch (piece.getType()) {
		case P:
			return new PawnMoveValidator();
		case B:
			return new BishopMoveValidator();
		case H:
			return new HorseMoveValidator();
		case K:
			return new KingMoveValidator();
		case Q:
			return new QueenMoveValidator();
		case R:
			return new RookMoveValidator();
		}
		throw new IllegalArgumentException("Invalid piece type!!");
	}
}
