package com.solution.lld.chessdesign.model;

import com.solution.lld.chessdesign.factory.MoveValidatorFactory;
import com.solution.lld.chessdesign.types.Color;
import com.solution.lld.chessdesign.validator.MoveValidator;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Player {

    private String name;
    private Color color;

    public boolean tryMovingPiece(Board board, Position startPosition, Position endPosition){
        //get cell at startPosition
        //get piece from cell.
        Piece piece = board.getCells()[startPosition.getX()][startPosition.getY()].getPiece();

        //Get validator for given piecetype.
        MoveValidator moveValidator = MoveValidatorFactory.getMoveValidator(piece.getPieceType());
        return moveValidator.validate(board, startPosition, endPosition);
    }

    public boolean movePiece(Board board, Piece piece, Position startPosition, Position endPosition){
        board.getCells()[endPosition.getX()][endPosition.getY()].setPiece(piece);
        board.getCells()[startPosition.getX()][startPosition.getY()].setPiece(null);
        return true;
        //return true false based on if current player has won or not.
    }
}
