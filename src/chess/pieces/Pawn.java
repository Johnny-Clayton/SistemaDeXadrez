package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Pawn extends ChessPiece{

	public Pawn(Board board, Color color) {
		super(board, color);
	}

	@Override
	public boolean[][] possibleMoves() {
		
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
		
		if (getColor() == Color.WHITE) {
			moveThereIsAPiece(-1, mat);
			moveThereIsAPiece2(-2, -1, mat);
			moveIsThereOpponent(-1, -1, mat);
			moveIsThereOpponent(-1, +1, mat);
		}
		else {
			moveThereIsAPiece(+1, mat);
			moveThereIsAPiece2(+2, -1, mat);	
			moveIsThereOpponent(+1, -1, mat);
			moveIsThereOpponent(+1, +1, mat);
		}
		return mat;
	}
	
	public boolean[][] moveThereIsAPiece(int rowIncrement, boolean[][] mat) {
		
		Position p = new Position(position.getRow(), position.getColumn());
		p.setValues(position.getRow() + rowIncrement, position.getColumn());
		if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}

	    return mat;
	}
	
	public boolean[][] moveThereIsAPiece2(int rowIncrement,int rowIncrementP2, boolean[][] mat) {
		
		Position p = new Position(position.getRow(), position.getColumn());
		p.setValues(position.getRow() + rowIncrement, position.getColumn());
		
		Position p2 = new Position(position.getRow() - rowIncrementP2, position.getColumn());
		if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p) && getBoard().positionExists(p2) && !getBoard().thereIsAPiece(p2) && getMoveCount() == 0) {
			mat[p.getRow()][p.getColumn()] = true;
		}

	    return mat;
	}
	
	public boolean[][] moveIsThereOpponent(int rowIncrement, int columnIncrement, boolean[][] mat) {

	    Position p = new Position(position.getRow(), position.getColumn());
	    p.setValues(p.getRow() + rowIncrement, p.getColumn() + columnIncrement);

	    if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
	        mat[p.getRow()][p.getColumn()] = true;
	    }
	    return mat;
	}
	
	@Override
	public String toString() {
		return "P";
	}
}
