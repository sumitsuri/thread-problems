package com.solution.lld.chessdesign.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Cell {

    private Position position;
    private Piece piece;

    public Cell(Position position){
        this.position = position;
    }

    public Cell(Position position, Piece piece){
        this.position = position;
        this.piece = piece;
    }
}
