package com.solution.lld.chess;


import com.solution.lld.chess.validate.ValidationFactory;

public class Board {

	private Piece[][] board;

	public Board() {
		init();
	}

	private void init() {
		// set size
		board = new Piece[8][8];

		// init empty pieces on the board
		for (int x = 0; x < 8; x++) {
			for (int y = 0; y < 8; y++) {
				board[x][y] = Piece.empty(Position.of(x, y));
			}
		}

		// init WHITE
		initWhitePieces();

		// init BLACK
		initBlackPieces();

		print();
	}

	private void initWhitePieces() {

		// init Rook
		board[0][0] = Piece.of(Piece.Color.W, Piece.Type.R, Position.of(0, 0));
		board[0][7] = Piece.of(Piece.Color.W, Piece.Type.R, Position.of(0, 7));

		// init Bishop
		board[0][1] = Piece.of(Piece.Color.W, Piece.Type.H, Position.of(0, 1));
		board[0][6] = Piece.of(Piece.Color.W, Piece.Type.H, Position.of(0, 6));

		// init Horse
		board[0][2] = Piece.of(Piece.Color.W, Piece.Type.B, Position.of(0, 2));
		board[0][5] = Piece.of(Piece.Color.W, Piece.Type.B, Position.of(0, 5));

		// init Queen
		board[0][3] = Piece.of(Piece.Color.W, Piece.Type.Q, Position.of(0, 3));

		// init King
		board[0][4] = Piece.of(Piece.Color.W, Piece.Type.K, Position.of(0, 4));

		// init Pawns
		for (int x = 0; x < 8; x++) {
			board[1][x] = Piece.of(Piece.Color.W, Piece.Type.P, Position.of(1, x));
		}
	}

	private void initBlackPieces() {

		// init Rook
		board[7][0] = Piece.of(Piece.Color.B, Piece.Type.R, Position.of(7, 0));
		board[7][7] = Piece.of(Piece.Color.B, Piece.Type.R, Position.of(7, 7));

		// init Bishop
		board[7][1] = Piece.of(Piece.Color.B, Piece.Type.H, Position.of(7, 1));
		board[7][6] = Piece.of(Piece.Color.B, Piece.Type.H, Position.of(7, 6));

		// init Horse
		board[7][2] = Piece.of(Piece.Color.B, Piece.Type.B, Position.of(7, 2));
		board[7][5] = Piece.of(Piece.Color.B, Piece.Type.B, Position.of(7, 5));

		// init Queen
		board[7][3] = Piece.of(Piece.Color.B, Piece.Type.K, Position.of(7, 3));

		// init King
		board[7][4] = Piece.of(Piece.Color.B, Piece.Type.Q, Position.of(7, 4));

		// init Pawns
		for (int x = 0; x < 8; x++) {
			board[6][x] = Piece.of(Piece.Color.B, Piece.Type.P, Position.of(6, x));
		}
	}

	public void print() {
		for (int x = 0; x < 8; x++) {
			for (int y = 0; y < 8; y++) {
				System.out.print(board[x][y] + " ");
			}
			System.out.println();
		}
	}

	public void tryMove(Position source, Position destination) {
		Piece piece = board[source.getX()][source.getY()];
		System.out.println("\nTrying to move " + piece.fullName() + " from " + source + " to " + destination);

		boolean isValid = ValidationFactory.find(piece).validate(this, source, destination);

		if (isValid) {
			System.out.println("Valid move");
			move(source, destination);
			print();
		} else {
			System.out.println("Invalid move");
		}
	}

	private void move(Position source, Position destination) {
		Piece srcPiece = board[source.getX()][source.getY()];
		Piece dstPiece = board[destination.getX()][destination.getY()];

		// swap them
		if (dstPiece.status == Cell.CellStatus.EMPTY) {
			board[source.getX()][source.getY()] = dstPiece;
			board[destination.getX()][destination.getY()] = srcPiece;
		} else {
			// possible attack
		}
	}
}
