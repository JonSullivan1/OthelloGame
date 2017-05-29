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
			else if(mid && board[r][i].isTaken() && isWhite == board[r][i].isWhite()){
				return true;
			}
		}
		mid = false;
		for(int i = c;i>=0;i--){
			if((isWhite != board[r][i].isWhite()) && board[r][i].isTaken()){
				mid = true;
			}
			else if(mid && board[r][i].isTaken() && isWhite == board[r][i].isWhite()){
				return true;
			}
		}
		mid = false;
		for(int i = r;i<board[0].length;i++){
			if((isWhite != board[i][c].isWhite()) && board[i][c].isTaken()){
				mid = true;
			}
			else if(mid && board[i][c].isTaken() && isWhite == board[i][c].isWhite()){
				return true;
			}
		}
		mid = false;
		for(int i = r;i>board[0].length;i--){
			if((isWhite != board[i][c].isWhite()) && board[i][c].isTaken()){
				mid = true;
			}
			else if(mid && board[i][c].isTaken() && isWhite == board[i][c].isWhite()){
				return true;
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

}
