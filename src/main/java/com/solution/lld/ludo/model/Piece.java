package com.solution.lld.ludo.model;

import lombok.Data;

@Data
public class Piece {
    private int number;
    private int xCoordinate;
    private int yCoordinate;
    private String color;
    private boolean takenOut;
    private boolean completed;
    public Piece(int number, String color){
        this.number = number;
        this.color = color;
    }
}
