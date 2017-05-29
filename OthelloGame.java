public class OthelloGame{
	
	private static boolean isWhite = false;
	private Board board;
	private static boolean game;
	public static void main(String[] args){
		isWhite = false;
		game = true;
		Board board = new Board();
		//it work
		//System.out.println(board.checkMove(3, 2, isWhite));
		//board.updateBoard(4,5);
		for(int f = 0;f< 2;f++){//while(game){
			for(int i =0;i<board.getLength();i++){
				for(int z = 0;z<board.getWidth();z++){
					System.out.print(board.getTile(i,z));
				}
				System.out.println();
			}
			/*if(*/board.checkMove(3, 2, isWhite);//){
				//board.setTile(new Tile(true, isWhite),3,2);
				System.out.println("dabaroni");
			}
			System.out.println();
			
		}
		
	}

//}
