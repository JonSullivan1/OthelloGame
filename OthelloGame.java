import java.awt.Font;



public class OthelloGame{

	private static boolean isWhite = false;
	private Board board;
	private static boolean game;
	public static void main(String[] args){
		isWhite = false;
		game = true;
		Board board = new Board();
		//System.out.println(board.isValidMove(5, 4, isWhite));
		//board.effectMove(3, 2, isWhite);


		/*for(int i =0;i<board.getLength();i++){
			for(int z = 0;z<board.getWidth();z++){
				System.out.print(board.getTile(i,z));
			}
			System.out.println();
		}*/
		//int i = 0;
		
		while(game){
			draw(board, isWhite);
			isWhite = handleMouseClick(isWhite,board);
			if(board.checkIfOver(isWhite) && !(board.checkIfOver(!isWhite))){
				isWhite = !isWhite;
			}
			
			else if(board.checkIfOver(isWhite)){
				
				System.out.println("le game over");
				game = false;
			}
			//i++;
		}
		
		
	}
	
	public int checkScore(boolean isWhite) {
		int score = 0;
		for (int r = 0; r < 8; r++) {
			for (int c = 0; c < 8; c++) {
				if (board.getTile(r, c).isWhite() == isWhite) {
					score++;
				}
			}
		}
		return score;
	}
	
	public static void draw(Board board, boolean isWhite) {
		// TODO You have to write this
		StdDraw.clear();
		StdDraw.setScale(-1,8);
		
		
		for(int i =0;i<board.getLength();i++){
			for(int c =0;c<board.getWidth();c++){
				if(board.getTile(c,i).isWhite() && board.getTile(c, i).isTaken()){
					StdDraw.setPenColor(StdDraw.WHITE);
				}
				else if(board.getTile(c, i).isTaken() && !(board.getTile(c, i).isWhite())){
					StdDraw.setPenColor(StdDraw.BLACK);
				}
				else{
					StdDraw.setPenColor(StdDraw.GREEN);
				}

				
				StdDraw.filledSquare(i,c, .5);
				
			}
		}
		StdDraw.setPenColor(StdDraw.BLACK);
		if(isWhite){
			StdDraw.text(3.5, 7.7, "Current player: WHITE");
		}
		else{
			StdDraw.text(3.5, 7.7, "Current player: BLACK");
		}
		
		StdDraw.text(2, -.8,"");
	
		
		StdDraw.show(0);
	
	}
	
	
	
	public static boolean handleMouseClick(boolean isWhite, Board board) {
		while (!StdDraw.mousePressed()) {
			// Wait for mouse press
		}
		double x = Math.round(StdDraw.mouseX());
		double y = Math.round(StdDraw.mouseY());
		while (StdDraw.mousePressed()) {
			// Wait for mouse release
		}
		int a = (int) x;
		int b = (int) y;
		System.out.println("X: "+b+" Y: "+a);
		if(a<board.getLength() && a >=0&&b>=0&& b<board.getWidth() && board.isValidMove(b, a, isWhite) /*&&board.isValidMove(b, a, isWhite)*/){
			board.effectMove(b, a, isWhite);
			return !isWhite;
		}
		
		
		/*else{
			return isWhite;
		}*/
		System.out.println("Not valid");
		return isWhite;
	}
	
	
	
	
}
