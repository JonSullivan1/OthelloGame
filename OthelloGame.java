import java.awt.Font;

public class OthelloGame{

	private static boolean isWhite = false;
	private static Board board;
	private static boolean game;
	public static void main(String[] args){
		isWhite = false;
		game = true;
		Board board = new Board();
		while(game){
			draw(board, isWhite);
			isWhite = handleMouseClick(isWhite,board);
			//Check if there are available moves for current player, switch if there 
			//are no available moves for current, but available moves for opposite.
			if(board.checkIfOver(isWhite) && !(board.checkIfOver(!isWhite))){
				StdDraw.text(3.5, 4, "NO VALID MOVES, SWAPPING PLAYER");
				StdDraw.pause(500);
				isWhite = !isWhite;
			}
			//Check for game over of current player.
			else if(board.checkIfOver(isWhite)){
				System.out.println("le game over");
				System.out.print("White Score: " + board.getWhite());
				System.out.print("Black Score: " + board.getBlack());
				draw(board, isWhite);
				game = false;
			}
		}
	}
	/**
	 * Method that draws the graphical aspect of the game.
	 * 
	 * @param board
	 * @param isWhite
	 */
	public static void draw(Board board, boolean isWhite) {
		// TODO You have to write this
		StdDraw.clear();
		StdDraw.setScale(-1,8);
		for(int i =0;i<board.getLength();i++) {
			for(int c =0;c<board.getWidth();c++) {
				//Draw board and placed tiles.
				StdDraw.setPenColor(StdDraw.GREEN);
				StdDraw.filledSquare(i, c, .5);
				if(board.getTile(c,i).isWhite() && board.getTile(c, i).isTaken()) {
					StdDraw.setPenColor(StdDraw.WHITE);
				}
				else if(board.getTile(c, i).isTaken() && !(board.getTile(c, i).isWhite())) {
					StdDraw.setPenColor(StdDraw.BLACK);
				}
				else {
					StdDraw.setPenColor(StdDraw.GREEN);
				}


				StdDraw.filledCircle(i,c, .45);

			}
		}
		//Draw grid.
		StdDraw.setPenColor(StdDraw.BLACK);
		for (int i = 0; i < 9; i++) {
			StdDraw.line(-0.5 + i, -0.5, -0.5 + i, 7.5);
		}
		for (int i = 0; i < 9; i++) {
			StdDraw.line(-0.5, -0.5 + i, 7.5, -0.5 + i);
		}
		//Draw current player and score.
		if(isWhite){
			StdDraw.text(3.5, 7.7, "Current player: WHITE");
		}
		else{
			StdDraw.text(3.5, 7.7, "Current player: BLACK");
		}
		//print scores
		StdDraw.text(3.5, -.8, "Black Score: " + board.getBlack() + "    White Score: " + board.getWhite());

		StdDraw.show(0);//enable double buffering

	}


	/**
	 * Receives input from the mouse and effects the move on the board.
	 * 
	 * @param isWhite
	 * @param board
	 * @return
	 */
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
