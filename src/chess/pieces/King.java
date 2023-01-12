package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class King extends ChessPiece{

	public King(Board board, Color color) {
		super(board, color);
	}
	
	@Override
	public String toString() {
		return "K";
	}
	
	private boolean canMove(Position position) {
		ChessPiece p = (ChessPiece)getBoard().piece(position);
		return p == null || p.getColor() != getColor();
	}

	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
		
		// Move para cima
		move(-1, 0, mat);

		// Move para esquerda
		move(0, -1, mat);

		// Move para direita
		move(0, 1, mat);

		// Move para baixo
		move(1, 0, mat);
		//------------------
		// Move para cima
		move(-1, -1, mat);

		// Move para esquerda
		move(-1, +1, mat);

		// Move para direita
		move(+1, -1, mat);

		// Move para baixo
		move(+1, +1, mat);
		

		return mat;
	}
	
	public boolean[][] move(int rowIncrement, int columnIncrement, boolean[][] mat) {

	    Position p = new Position(position.getRow(), position.getColumn());
	    p.setValues(p.getRow() + rowIncrement, p.getColumn() + columnIncrement);
	    
//	    while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
//	        mat[p.getRow()][p.getColumn()] = true;
//	        p.setValues(p.getRow() + rowIncrement, p.getColumn() + columnIncrement);
//	    }
	    if (getBoard().positionExists(p) && canMove(p)) {
	        mat[p.getRow()][p.getColumn()] = true;
	    }
	    return mat;
	}

}
