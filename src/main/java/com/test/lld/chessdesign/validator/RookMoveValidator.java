package com.test.lld.chessdesign.validator;

import com.test.lld.chessdesign.model.Board;
import com.test.lld.chessdesign.model.Position;

public class RookMoveValidator extends MoveValidator{
    @Override
    public boolean validate(Board board, Position startPosition, Position endPosition) {
        return false;
    }
}
