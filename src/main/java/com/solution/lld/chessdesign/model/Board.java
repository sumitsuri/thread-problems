package com.solution.lld.chessdesign.model;

import com.google.common.collect.Lists;
import com.solution.lld.chessdesign.types.Color;
import com.solution.lld.chessdesign.types.PieceType;
import lombok.Getter;
import lombok.Setter;

import java.util.Queue;

@Getter
@Setter
public class Board {

    private Cell[][] cells;
    private Queue<Player> players;

    public Board(){
        initBoard();
    }

    public void initBoard(){
        this.cells = new Cell[8][8];
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                this.cells[i][j] = new Cell(new Position(i,j));
            }
        }

        initWhitePieces();
        initBlackPieces();
        initPlayers();
    }

    public void initWhitePieces(){
        cells[0][0].setPiece(new Piece(PieceType.ROOK, Color.WHITE));
        cells[0][7].setPiece(new Piece(PieceType.ROOK, Color.WHITE));

        cells[0][1].setPiece(new Piece(PieceType.HORSE, Color.WHITE));
        cells[0][6].setPiece(new Piece(PieceType.HORSE, Color.WHITE));

        cells[0][2].setPiece(new Piece(PieceType.BISHOP, Color.WHITE));
        cells[0][5].setPiece(new Piece(PieceType.BISHOP, Color.WHITE));

        cells[0][3].setPiece(new Piece(PieceType.KING, Color.WHITE));
        cells[0][4].setPiece(new Piece(PieceType.QUEEN, Color.WHITE));

        for(int i=0;i<8;i++){
            cells[1][i].setPiece(new Piece(PieceType.PAWN, Color.WHITE));
        }
    }

    public void initBlackPieces(){

        cells[7][0].setPiece(new Piece(PieceType.ROOK, Color.BLACK));
        cells[7][7].setPiece(new Piece(PieceType.ROOK, Color.BLACK));

        cells[7][1].setPiece(new Piece(PieceType.HORSE, Color.BLACK));
        cells[7][6].setPiece(new Piece(PieceType.HORSE, Color.BLACK));

        cells[7][2].setPiece(new Piece(PieceType.BISHOP, Color.BLACK));
        cells[7][5].setPiece(new Piece(PieceType.BISHOP, Color.BLACK));

        cells[0][3].setPiece(new Piece(PieceType.KING, Color.BLACK));
        cells[0][4].setPiece(new Piece(PieceType.QUEEN, Color.BLACK));

        for(int i=0;i<8;i++){
            cells[6][i].setPiece(new Piece(PieceType.PAWN, Color.BLACK));
        }

    }

    public void initPlayers(){
        this.players = Lists.newLinkedList();
        this.players.add(new Player("p1", Color.WHITE));
        this.players.add(new Player("p2", Color.BLACK));
    }
}
