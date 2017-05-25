public class Board {
	private Tile[][] board;
	
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
}
