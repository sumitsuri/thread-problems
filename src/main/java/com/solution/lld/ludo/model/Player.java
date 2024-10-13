package com.solution.lld.ludo.model;

import java.util.List;

public class Player {
    private String color;
    private int numberRolled;
    private boolean hasRolledSix;
    private List<Piece> pieces;

    public Player(String color){
        this.color = color;
        for(int i=0;i<4;i++){
            pieces.add(new Piece(i, color));
        }
    }

    public void rollDice(){
        numberRolled = new Dice().roll();
        hasRolledSix = numberRolled == 6 ? true : false;
    }

    public boolean hasWon(){
        for(Piece piece : pieces){
            if(!piece.isCompleted()){
                return false;
            }
        }
        return true;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getNumberRolled() {
        return numberRolled;
    }

    public void setNumberRolled(int numberRolled) {
        this.numberRolled = numberRolled;
    }

    public boolean isHasRolledSix() {
        return hasRolledSix;
    }

    public void setHasRolledSix(boolean hasRolledSix) {
        this.hasRolledSix = hasRolledSix;
    }

    public List<Piece> getPieces() {
        return pieces;
    }

    public void setPieces(List<Piece> pieces) {
        this.pieces = pieces;
    }

    @Override
    public String toString() {
        return "Player{" +
                "color='" + color + '\'' +
                '}';
    }
}
