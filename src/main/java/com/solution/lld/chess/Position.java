package com.solution.lld.chess;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Position {

	private int x, y;

	public Position(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	public static Position of(int x, int y) {
		return new Position(x, y);
	}

	@Override
	public String toString() {
		return "(" + x + ", " + y + ")";
	}

}
