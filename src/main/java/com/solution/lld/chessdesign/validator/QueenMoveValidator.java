package com.solution.lld.chessdesign.validator;

import com.solution.lld.chessdesign.model.Board;
import com.solution.lld.chessdesign.model.Position;

public class QueenMoveValidator extends MoveValidator{
    @Override
    public boolean validate(Board board, Position startPosition, Position endPosition) {
        return false;
    }
}
