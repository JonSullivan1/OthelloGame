

import java.awt.List;
import java.util.ArrayList;

public class Board {
	private Tile[][] board;

	private int length;
	private int width;


	/** move offset for row */
	private static final int[] sOFFSET_MOVE_ROW = {-1, -1, -1,  0,  0,  1,  1,  1};

	/** move offset for column */
	private static final int[] sOFFSET_MOVE_COL = {-1,  0,  1, -1,  1, -1,  0,  1};

	public Board() {
		board = new Tile[8][8];
		length = 8;
		width  =8;
		for (int r = 0; r < board.length;r++) {
			for (int c = 0; c < board[0].length;c++) {
				board[r][c] = new Tile();
			}
		}
		//
		board[3][3] = new Tile(true, true);
		board[3][4] = new Tile(true, false);
		board[4][3] = new Tile(true, false);
		board[4][4] = new Tile(true, true);
	}

	public Tile getTile (int r, int c) {
		return board[r][c];
	}
	public int getLength(){
		return length;
	}
	public int getWidth(){
		return width;
	}

	public void setTile (Tile t, int r, int c) {
		board[r][c] = t;
	}



	public boolean checkMove(int r, int c, boolean isWhite){
		boolean possible = true;
		boolean mid = false;
		for(int i = c;i<board.length;i++){
			if((isWhite != board[r][i].isWhite()) && board[r][i].isTaken()){
				mid = true;
			}
			else if(!(board[r][i].isTaken())){
				mid = false;
				break;
			}
			else if(mid && board[r][i].isTaken() && isWhite == board[r][i].isWhite()){
				return true && !(board[r][c].isTaken());
			}

		}
		mid = false;
		for(int i = c;i>=0;i--){
			if((isWhite != board[r][i].isWhite()) && board[r][i].isTaken()){
				mid = true;
			}
			else if(!(board[r][i].isTaken())){
				mid = false;
				break;
			}
			else if(mid && board[r][i].isTaken() && isWhite == board[r][i].isWhite()){
				return true && !(board[r][c].isTaken());
			}
		}
		mid = false;
		for(int i = r;i<board[0].length;i++){
			if((isWhite != board[i][c].isWhite()) && board[i][c].isTaken()){
				mid = true;
			}
			else if(!(board[i][c].isTaken())){
				mid = false;
				break;
			}
			else if(mid && board[i][c].isTaken() && isWhite == board[i][c].isWhite()){
				return true && !(board[r][c].isTaken());
			}
		}
		mid = false;
		for(int i = r;i>board[0].length;i--){
			if((isWhite != board[i][c].isWhite()) && board[i][c].isTaken()){
				mid = true;
			}
			else if(!(board[i][c].isTaken())){
				mid = false;
				break;
			}
			else if(mid && board[i][c].isTaken() && isWhite == board[i][c].isWhite()){
				return true && !(board[r][c].isTaken());
			}
		}

		return false;

	}

	public void updateBoard(int r, int c, boolean isWhite){
		boolean toUpdate = false;
		for(int  i =0; i<8; i++){
			for(int j =0;j<8;j++){
				if(board[r+ sOFFSET_MOVE_ROW[i]][c+sOFFSET_MOVE_COL[j]].isTaken() && (isWhite != board[r+ sOFFSET_MOVE_ROW[i]][c+sOFFSET_MOVE_COL[j]].isWhite())){
					//If a valid tile is taken and the opposite color
					board[r+ sOFFSET_MOVE_ROW[i]][c+sOFFSET_MOVE_COL[j]].changeColor();
				}
			}
		}
		board[r][c] = new Tile(true, isWhite);
	}

	public boolean isValidMove(int row, int col, boolean isWhite) {
		// check whether this square is empty
		if (board[row][col].isTaken()) {
			return false;
		}
		boolean oppPiece = !isWhite;
		boolean isValid = false;
		// check 8 directions
		for (int i = 0; i < 8; ++i) {
			int curRow = row + sOFFSET_MOVE_ROW[i];
			int curCol = col + sOFFSET_MOVE_COL[i];
			boolean hasOppPieceBetween = false;
			while (curRow >=0 && curRow < 8 && curCol >= 0 && curCol < 8) {

				if (board[curRow][curCol].isTaken() && board[curRow][curCol].isWhite() == oppPiece)
					hasOppPieceBetween = true;
				else if (board[curRow][curCol].isTaken() && (board[curRow][curCol].isWhite() == isWhite) && hasOppPieceBetween)
				{
					isValid = true;
					break;
				}
				else
					break;

				curRow += sOFFSET_MOVE_ROW[i];
				curCol += sOFFSET_MOVE_COL[i];
			}
			if (isValid)
				break;
		}
		return isValid;
	}

	public void effectMove(int row, int col, boolean isWhite) {
		board[row][col] = new Tile(true, isWhite);

		// check 8 directions
		for (int i = 0; i < 8; ++i) {
			int curRow = row + sOFFSET_MOVE_ROW[i];
			int curCol = col + sOFFSET_MOVE_COL[i];
			boolean hasOppPieceBetween = false;
			while (curRow >=0 && curRow < 8 && curCol >= 0 && curCol < 8) {
				// if empty square, break
				if (!board[curRow][curCol].isTaken())
					break;

				if (board[curRow][curCol].isTaken())
					hasOppPieceBetween = true;

				if ((board[curRow][curCol].isWhite() == isWhite) && hasOppPieceBetween)
				{
					int effectPieceRow = row + sOFFSET_MOVE_ROW[i];
					int effectPieceCol = col + sOFFSET_MOVE_COL[i];
					while (effectPieceRow != curRow || effectPieceCol != curCol)
					{
						board[effectPieceRow][effectPieceCol] = new Tile(true, isWhite);
						effectPieceRow += sOFFSET_MOVE_ROW[i];
						effectPieceCol += sOFFSET_MOVE_COL[i];
					}

					break;
				}

				curRow += sOFFSET_MOVE_ROW[i];
				curCol += sOFFSET_MOVE_COL[i];
			}
		}
	}

}
