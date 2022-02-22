package com.test.lld.chessdesign.model;

import com.test.lld.chessdesign.types.Color;
import com.test.lld.chessdesign.types.PieceType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Piece {

    private PieceType pieceType;
    private Color color;

}
