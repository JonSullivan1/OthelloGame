public class OthelloGame{

	private static boolean isWhite = false;
	private Board board;
	private static boolean game;
	public static void main(String[] args){
		isWhite = false;
		game = true;
		Board board = new Board();

		System.out.println(board.checkMove(5, 4, isWhite));
		board.updateBoard(3, 2, isWhite);
		//board.updateBoard(4,5);
		//board.checkMove(5, 4, isWhite);

		for(int i =0;i<board.getLength();i++){
			for(int z = 0;z<board.getWidth();z++){
				System.out.print(board.getTile(i,z));
			}
			System.out.println();
		}	
	}
}


