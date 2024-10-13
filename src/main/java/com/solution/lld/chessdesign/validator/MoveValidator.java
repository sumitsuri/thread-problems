package com.solution.lld.chessdesign.validator;

import com.solution.lld.chessdesign.model.Board;
import com.solution.lld.chessdesign.model.Position;

public abstract class MoveValidator {

    public abstract boolean validate(Board board, Position startPosition, Position endPosition);

    public boolean isValidMove(Board board, Position startPosition, Position endPosition){
        if(!isMoveWithinBoard(startPosition) || !isMoveWithinBoard(endPosition)){
            return false;
        }
        if(isAtSamePosition(startPosition, endPosition)){
            return false;
        }
        return true;

    }

    public boolean isAtSamePosition(Position startPosition, Position endPosition){
        if((startPosition.getX() == endPosition.getX()) && (startPosition.getY() == endPosition.getY())){
            return false;
        }
        return true;
    }

    public boolean isMoveWithinBoard(Position position){
        if(position.getX() < 0 || position.getX() > 7 || position.getY() < 0 || position.getY() > 7){
            return false;
        }
        return true;
    }

}
