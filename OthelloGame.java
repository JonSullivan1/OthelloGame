public class OthelloGame{
	
	private static boolean isWhite = false;
	private Board board;
	public static void main(String[] args){
		isWhite = false;
		
		Board board = new Board();
		//it work
		System.out.println(board.checkMove(3, 5, isWhite));
		//board.updateBoard(4,5);
			
		
	}

}

