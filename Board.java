import java.awt.List;
import java.util.ArrayList;

public class Board {
	private Tile[][] board;
	private int length;
	private int width;
	public Board() {
		board = new Tile[8][8];
		length = 8;
		width  =8;
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
	public int getLength(){
		return length;
	}
	public int getWidth(){
		return width;
	}
	
	public void setTile (Tile t, int r, int c) {
		board[r][c] = t;
	}
	
	
	public void checkMove(int r, int c, boolean isWhite){
		boolean possible = true;
		boolean mid = false;
		for(int i = c;i<board.length;i++){
			ArrayList<Integer[]> dab = new ArrayList();
			if((isWhite != board[r][i].white()) && board[r][i].isTaken()){
				mid = true;
				//board[r][i] = new Tile(true, isWhite);
				Integer[] temp = {r,i};
				dab.add(temp);
				
			}
			else if(mid && board[r][i].isTaken() && isWhite == board[r][i].white()){
				//return true;
				board[r][c] = new Tile(true, isWhite);
				for(int d = 0; d<dab.size();d++){
					board[dab.get(d)[0]][dab.get(d)[1]] = new Tile(true, isWhite);
				}
			}
		}
		mid = false;
		for(int i = c;i>=0;i--){
			ArrayList<Integer[]> dab = new ArrayList();
			if((isWhite != board[r][i].white()) && board[r][i].isTaken()){
				mid = true;
				Integer[] temp = {r,i};
				dab.add(temp);
			}
			else if(mid && board[r][i].isTaken() && isWhite == board[r][i].white()){
				//return true;
				board[r][c] = new Tile(true, isWhite);
				for(int d = 0; d<dab.size();d++){
					board[dab.get(d)[0]][dab.get(d)[1]] = new Tile(true, isWhite);
				}
			}
		}
		mid = false;
		for(int i = r;i<board[0].length;i++){
			ArrayList<Integer[]> dab = new ArrayList();
			if((isWhite != board[i][c].white()) && board[i][c].isTaken()){
				mid = true;
				Integer[] temp = {r,i};
				dab.add(temp);
			}
			else if(mid && board[i][c].isTaken() && isWhite == board[i][c].white()){
				//return true;
				board[r][c] = new Tile(true, isWhite);
				for(int d = 0; d<dab.size();d++){
					board[dab.get(d)[0]][dab.get(d)[1]] = new Tile(true, isWhite);
				}
			}
		}
		mid = false;
		for(int i = r;i>board[0].length;i--){
			ArrayList<Integer[]> dab = new ArrayList();
			if((isWhite != board[i][c].white()) && board[i][c].isTaken()){
				mid = true;
				Integer[] temp = {r,i};
				dab.add(temp);
			}
			else if(mid && board[i][c].isTaken() && isWhite == board[i][c].white()){
				//return true;
				board[r][c] = new Tile(true, isWhite);
				for(int d = 0; d<dab.size();d++){
					board[dab.get(d)[0]][dab.get(d)[1]] = new Tile(true, isWhite);
				}
			}
		}
		
		//return false;
		
		}
	
	
	
}
