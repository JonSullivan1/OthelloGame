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
			if((isWhite != board[r][i].white()) && board[r][i].isTaken()){
				mid = true;
			}
			else if(mid && board[r][i].isTaken() && isWhite == board[r][i].white()){
				return true;
			}
		}
		mid = false;
		for(int i = c;i>=0;i--){
			if((isWhite != board[r][i].white()) && board[r][i].isTaken()){
				mid = true;
			}
			else if(mid && board[r][i].isTaken() && isWhite == board[r][i].white()){
				return true;
			}
		}
		mid = false;
		for(int i = r;i<board[0].length;i++){
			if((isWhite != board[i][c].white()) && board[i][c].isTaken()){
				mid = true;
			}
			else if(mid && board[i][c].isTaken() && isWhite == board[i][c].white()){
				return true;
			}
		}
		mid = false;
		for(int i = r;i>board[0].length;i--){
			if((isWhite != board[i][c].white()) && board[i][c].isTaken()){
				mid = true;
			}
			else if(mid && board[i][c].isTaken() && isWhite == board[i][c].white()){
				return true;
			}
		}
		
		return false;
		
		}
	
	public void updateBoard(int r, int c, boolean isWhite) {
		int rTemp = r;
		int cTemp = c;
		if (board[r][c].isTaken()) {
			for (int i = 0; i < 8; i++) {
				if(i = 0) {
					int j = r;
					while (j >= 0) {
						j--;
						if (board[j][c].isWhite() == !isWhite) {
							board[j][c].changeColor();
						}
						else {
							break;
						}
					}
				}
				if(i = 1) {
					int j = r;
					int k = c;
					while (j >= 0 && k >= 0) {
						j--;
						k--;
						if (board[j][k].isWhite() == !isWhite) {
							board[j][k].changeColor();
						}
						else {
							break;
						}
					}
				}
				if(i = 2) {
					int k = c;
					while (c < board[0].length) {
						j--;
						if (board[r][k].isTaken() && board[r][k].isWhite() == !isWhite) {
							board[r][k].changeColor();
						}
						else {
							break;
						}
					}
				}
			}
		}
	}

}
