package com.test.lld.chessdesign.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Move {
    private Piece piece;
    private Position startPosition;
    private Position endPosition;
}
