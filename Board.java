public class Board {
	private Tile[][] board;
	
	/** move offset for row */
	private static final int[] sOFFSET_MOVE_ROW = {-1, -1, -1,  0,  0,  1,  1,  1};
	
	/** move offset for column */
	private static final int[] sOFFSET_MOVE_COL = {-1,  0,  1, -1,  1, -1,  0,  1};
	
	public Board() {
		board = new Tile[8][8];
		
		for (int r = 0; r < board.length;r++) {
			for (int c = 0; c < board[0].length;c++) {
				board[r][c] = new Tile();
			}
		}
		
		board[3][3] = new Tile(true, true);
		board[3][4] = new Tile(true, false);
		board[4][3] = new Tile(true, false);
		board[4][4] = new Tile(true, true);
	}
	
	public Tile getTile (int r, int c) {
		return board[r][c];
	}
	
	public void setTile (Tile t, int r, int c) {
		board[r][c] = t;
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
