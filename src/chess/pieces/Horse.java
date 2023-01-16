package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Horse extends ChessPiece{

	public Horse(Board board, Color color) {
		super(board, color);
	}
	
	@Override
	public String toString() {
		return "H";
	}
	
	private boolean canMove(Position position) {
		ChessPiece p = (ChessPiece)getBoard().piece(position);
		return p == null || p.getColor() != getColor();
	}

	@Override
	public boolean[][] possibleMoves() {
		
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
		
		Position p = new Position(0, 0);
		
 		move(-1, -2, mat);
 		move(-2, -1, mat);
 		move(-2, +1, mat);
 		move(-1, +2, mat);
 		move(+1, 2, mat);
 		move(+2, +1, mat);
 		move(+2, -1, mat);
 		move(+1, -2, mat);

		return mat;
	}
	
	public boolean[][] move(int rowIncrement, int columnIncrement, boolean[][] mat) {

	    Position p = new Position(position.getRow(), position.getColumn());
	    p.setValues(p.getRow() + rowIncrement, p.getColumn() + columnIncrement);

	    if (getBoard().positionExists(p) && canMove(p)) {
	        mat[p.getRow()][p.getColumn()] = true;
	    }
	    return mat;
	}

}
