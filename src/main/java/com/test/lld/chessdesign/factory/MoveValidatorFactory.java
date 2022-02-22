package com.test.lld.chessdesign.factory;

import com.test.lld.chessdesign.types.PieceType;
import com.test.lld.chessdesign.validator.*;

public class MoveValidatorFactory {

    public static MoveValidator getMoveValidator(PieceType pieceType){
        switch (pieceType){
            case PAWN:
                return new PawnMoveValidator();
            case ROOK:
                return new RookMoveValidator();
            case HORSE:
                return new HorseMoveValidator();
            case BISHOP:
                return new BishopMoveValidator();
            case KING:
                return new KingMoveValidator();
            case QUEEN:
                return new QueenMoveValidator();
            default:
                throw new RuntimeException(String.format("unsupported format type [%s]", pieceType));
        }
    }
}
