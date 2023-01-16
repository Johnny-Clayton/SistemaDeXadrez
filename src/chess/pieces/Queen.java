package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Queen extends ChessPiece{

	public Queen(Board board, Color color) {
		super(board, color);
	}
	
	@Override
	public String toString() {
		return "Q";
	}

	@Override
	public boolean[][] possibleMoves() {
		
boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
		
		Position p = new Position(0, 0);
		
		move(-1, 0, mat);
		move(0, -1, mat);
		move(0, +1, mat);
		move(+1, 0, mat);
//		// above
//		p.setValues(position.getRow() - 1, position.getColumn());
//		while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
//			mat[p.getRow()][p.getColumn()] = true;
//			p.setRow(p.getRow() - 1);
//		}
//		if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
//			mat[p.getRow()][p.getColumn()] = true;
//		}
//		
//		// left
//		p.setValues(position.getRow(), position.getColumn() - 1);
//		while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
//			mat[p.getRow()][p.getColumn()] = true;
//			p.setColumn(p.getColumn() - 1);
//		}
//		if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
//			mat[p.getRow()][p.getColumn()] = true;
//		}
//		
//		// right
//		p.setValues(position.getRow(), position.getColumn() + 1);
//		while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
//			mat[p.getRow()][p.getColumn()] = true;
//			p.setColumn(p.getColumn() + 1);
//		}
//		if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
//			mat[p.getRow()][p.getColumn()] = true;
//		}
//		
//		// below
//		p.setValues(position.getRow() + 1, position.getColumn());
//		while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
//			mat[p.getRow()][p.getColumn()] = true;
//			p.setRow(p.getRow() + 1);
//		}
//		if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
//			mat[p.getRow()][p.getColumn()] = true;
//		}
		
		move(-1, -1, mat);
		move(-1, +1, mat);
		move(+1, +1, mat);
		move(+1, -1, mat);
		
//		// nw
//		p.setValues(position.getRow() - 1, position.getColumn() - 1);
//		while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
//			mat[p.getRow()][p.getColumn()] = true;
//			p.setValues(p.getRow() - 1, p.getColumn() - 1);
//		}
//		if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
//			mat[p.getRow()][p.getColumn()] = true;
//		}
//		
//		// ne
//		p.setValues(position.getRow() - 1, position.getColumn() + 1);
//		while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
//			mat[p.getRow()][p.getColumn()] = true;
//			p.setValues(p.getRow() - 1, p.getColumn() + 1);
//		}
//		if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
//			mat[p.getRow()][p.getColumn()] = true;
//		}
//		
//		// se
//		p.setValues(position.getRow() + 1, position.getColumn() + 1);
//		while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
//			mat[p.getRow()][p.getColumn()] = true;
//			p.setValues(p.getRow() + 1, p.getColumn() + 1);
//		}
//		if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
//			mat[p.getRow()][p.getColumn()] = true;
//		}
//		
//		// sw
//		p.setValues(position.getRow() + 1, position.getColumn() - 1);
//		while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
//			mat[p.getRow()][p.getColumn()] = true;
//			p.setValues(p.getRow() + 1, p.getColumn() - 1);
//		}
//		if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
//			mat[p.getRow()][p.getColumn()] = true;
//		}
		
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
