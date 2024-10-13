package com.solution.lld.chess;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Cell {

	enum CellStatus {EMPTY , OCCUPIED}
	
	// default empty
	CellStatus status = CellStatus.EMPTY;

}