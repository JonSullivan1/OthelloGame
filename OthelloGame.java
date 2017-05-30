import java.util.Scanner;

public class OthelloGame{

	private static boolean isWhite = false;
	private Board board;
	private static boolean game;
	public static void main(String[] args){
		isWhite = true;
		game = true;
		Board board = new Board();
		boolean player1 = true;
		int playerInX = 0;
		int playerInY = 0;
		boolean inValid = false;
		Scanner in = new Scanner(System.in);

		while(game) {
			if (isWhite) {
				while (!inValid) {
					System.out.println("Player 1, enter X coord from 0-7: ");
					playerInX = in.nextInt();
					System.out.println("Player 1, enter Y coord from 0-7: ");
					playerInY = in.nextInt();
					if (board.isValidMove(playerInY, playerInX, isWhite)) {
						inValid = true;
					}
					else {
						System.out.println("NOT VALID. RETRY.");
					}
				}
				inValid = false;
				board.effectMove(playerInY, playerInX, isWhite);
				for(int i =0;i<board.getLength();i++){
					for(int z = 0;z<board.getWidth();z++){
						System.out.print(board.getTile(i,z));
					}
					System.out.println();
				}
			}
			else {
				while (!inValid) {
					System.out.println("Player 2, enter X coord from 0-7: ");
					playerInX = in.nextInt();
					System.out.println("Player 2, enter Y coord from 0-7: ");
					playerInY = in.nextInt();
					if (board.isValidMove(playerInY, playerInX, isWhite)) {
						inValid = true;
					}
					else {
						System.out.println("NOT VALID. RETRY.");
					}
				}
				inValid = false;
				board.effectMove(playerInY, playerInX, isWhite);
				for(int i =0;i<board.getLength();i++){
					for(int z = 0;z<board.getWidth();z++){
						System.out.print(board.getTile(i,z));
					}
					System.out.println();
				}
			}
			isWhite = !isWhite;
		}
	}
}





