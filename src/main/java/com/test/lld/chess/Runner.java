package lld.chess;

public class Runner {

	public static void main(String[] args) {
		Board board = new  Board();
		
		
		board.tryMove(Position.of(0, 1), Position.of(20, 0));
		board.tryMove(Position.of(0, 1), Position.of(2, 0));
		
		
	}
}
