package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Rook extends ChessPiece{

	public Rook(Board board, Color color) {
		super(board, color);
	}
	
	@Override
	public String toString() {
		return "R";
	}

	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

		move(-1, 0, mat);
		move(0, -1, mat);
		move(0, 1, mat);
		move(1, 0, mat);
		
		return mat;
	}
	
	public boolean[][] move(int rowIncrement, int columnIncrement, boolean[][] mat) {

	    Position p = new Position(position.getRow(), position.getColumn());
	    p.setValues(p.getRow() + rowIncrement, p.getColumn() + columnIncrement);
	    
	    while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
	        mat[p.getRow()][p.getColumn()] = true;
	        p.setValues(p.getRow() + rowIncrement, p.getColumn() + columnIncrement);
	    }
	    if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
	        mat[p.getRow()][p.getColumn()] = true;
	    }
	    return mat;
	}
}
