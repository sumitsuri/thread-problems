package com.solution.lld.chessdesign.model;

import com.solution.lld.chessdesign.types.Color;
import com.solution.lld.chessdesign.types.PieceType;
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
