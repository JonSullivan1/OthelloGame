import java.awt.List;
import java.util.ArrayList;

public class Board {
	private static Tile[][] board;

	private int length;
	private int width;
	/** move offset for row */
	private static final int[] sOFFSET_MOVE_ROW = {-1, -1, -1,  0,  0,  1,  1,  1};
	/** move offset for column */
	private static final int[] sOFFSET_MOVE_COL = {-1,  0,  1, -1,  1, -1,  0,  1};
	
	/**
	 * Default constructor, creates board and sets centre 4 to correct arrangement.
	 */
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
	/*
	 * Getters and Setters.
	 */
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
	

	@Deprecated
	public boolean checkMove(int r, int c, boolean isWhite){
		return isWhite;
			
	}
		
		
		
	@Deprecated
	public void updateBoard(int r, int c, boolean isWhite){
		if(board[r][c].isTaken() && board[r][c].isWhite() != isWhite){
			board[r][c].take();
			board[r][c].changeColor();
		}
		else if(!board[r][c].isTaken()){
			board[r][c].take();
			board[r][c].changeIsWhite(isWhite);
			System.out.println("TAKEN");
		}
	}
	
	/**
	 * Checks if there are available moves for the given player.
	 * 
	 * @param isWhite the current player.
	 * @return
	 */
	public boolean availableMoves(boolean isWhite) {
		for(int r = 0; r < 8; r++) {
			for(int c = 0; c < 8; c++) {
				if (isValidMove(r, c, isWhite)) {
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * Counts the amount of white tiles.
	 * 
	 * @return
	 */
	public static int getWhite() {
		int skor = 0;
		for (int r = 0; r < 8; r++) {
			for (int c = 0; c < 8; c++) {
				if (board[r][c].isTaken() && board[r][c].isWhite()) {
					skor++;
				}
			}
		}
		return skor;
	}
	/**
	 * Counts the amount of black tiles.
	 * 
	 * @return
	 */
	public static int getBlack() {
		int skor = 0;
		for (int r = 0; r < 8; r++) {
			for (int c = 0; c < 8; c++) {
				if (board[r][c].isTaken() && !board[r][c].isWhite()) {
					skor++;
				}
			}
		}
		return skor;
	}
	
	/**
	 * Checks if the game is over.
	 * 
	 * @param isWhite the current player.
	 * @return
	 */
	public boolean checkIfOver(boolean isWhite){
		if(!availableMoves(isWhite)){
			return true;
		}
		for(int r =0;r<length;r++){
			for(int c = 0; c<width;c++){
				if(board[r][c].isTaken()){
					return false;
				}
			}
		}
		return true;
		
	}
	/**
	 * Assess whether or not placing a tile of given player would be a valid move at row, col.
	 * 
	 * @param row the row of input.
	 * @param col the column of input.
	 * @param isWhite the current player.
	 * @return validity of the move.
	 */
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
				//Check to see if there is opponent's piece between prospective mode location and available end point.
				if (board[curRow][curCol].isTaken() && board[curRow][curCol].isWhite() == oppPiece)
					hasOppPieceBetween = true;
				//Using input from previous line, assign true to valid.
				else if (board[curRow][curCol].isTaken() && (board[curRow][curCol].isWhite() == isWhite) && hasOppPieceBetween)
				{
					isValid = true;
					break;
				}
				else
					break;
				//Update the current row and column.
				curRow += sOFFSET_MOVE_ROW[i];
				curCol += sOFFSET_MOVE_COL[i];
			}
			if (isValid)
				break;
		}
		return isValid;
	}
	/**
	 * Changes the board to reflect the move after checking validity of move.
	 * 
	 * @param row the row of input.
	 * @param col the column of input.
	 * @param isWhite the current player.
	 */
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
				//Check for correct color of tile and presence of oppPiece between start and end point.
				if ((board[curRow][curCol].isWhite() == isWhite) && hasOppPieceBetween)
				{
					//Update row and column of current piece.
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
				//Update current row and column.
				curRow += sOFFSET_MOVE_ROW[i];
				curCol += sOFFSET_MOVE_COL[i];
			}
		}
	}
	

}
