package com.test.lld.chess;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Piece extends Cell {

	public enum Color {
		W("WHITE"), B("BLACK");

		String name;

		Color(String name) {
			this.name = name;
		}
	}

	public enum Type {
		P("PAWN"), B("BISHOP"), R("ROOK"), H("HORSE"), Q("QUEEN"), K("KING");

		String name;

		Type(String name) {
			this.name = name;
		}
	}

	private Color color;

	private Type type;

	private Position position;

	public Piece(Color color, Type type, Position position) {
		this.color = color;
		this.type = type;
		this.position = position;

		if (type != null && color != null) {
			this.status = CellStatus.OCCUPIED;
		}
	}

	public static Piece empty(Position position) {
		return new Piece(null, null, position);
	}

	public static Piece of(Color color, Type type, Position position) {
		return new Piece(color, type, position);
	}

	@Override
	public String toString() {
		if (status == CellStatus.EMPTY) {
			return "--";
		}
		return color.name() + type.name();
	}
	
	public String fullName() {
		if (status == CellStatus.EMPTY) {
			return "--";
		}
		return color.name + type.name;
	}

}
