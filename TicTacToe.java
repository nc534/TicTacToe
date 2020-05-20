import java.util.Scanner;

public class TicTacToe {
	
	private static char[][] board = new char[3][3];
	static Scanner name = new Scanner(System.in);
	static String player1;
	static String player2;
	static Scanner input = new Scanner(System.in);
	private static char currentPlayer = 'X';
	static Scanner answer = new Scanner(System.in);
	
	public static void main(String[] args) {	
		
		String ans;
		
		do {
		
		System.out.println("Player 1, please enter your name: ");
			
			player1 = name.nextLine();
			
			System.out.println(player1 + " you are X. You go first. \n");
			
		System.out.println("Player 2, please enter your name: ");
			
			player2 = name.nextLine();
			
			System.out.println(player1 + " you are O. You go second.");	
			
		clearBoard();	
		play();
		
		System.out.println("Do you want to play again? Enter y/n: ");
			
			ans = answer.nextLine().toLowerCase();
			
			if(ans.equals("n")) {
				
				System.out.println("That is the end of the game. Bye Bye!");
				
			}else if(ans.equals("y")) {
				
				System.out.println("New game\n");
				
			}
		
		}while(ans.equals("y"));
		
	}
	
	public static void printBoard() {
		
		int row = 1;
		
		System.out.println("     1    2    3");
		
		System.out.println("   ----------------");
		
		for (int i = 0; i < 3; i++){
		
			System.out.print(row + "  | ");
				
				row++;
		
			for (int j = 0; j < 3; j++){
				
				System.out.print(board[i][j] +  "  | ");
			
			}
		
			System.out.println();
		
			System.out.println("   ----------------");
			
			}
	}
	
	public static void play() {
		
		boolean isPlaying = true;
		int row = 0;
		int col = 0;
		boolean isValid = true;
		boolean isValidRow = true;
		boolean isValidCol = true;
		
		printBoard();
		
		while(isPlaying) {
			
			String playerName;
			
			if(currentPlayer == 'X') {
				
				playerName = player1;
				
			}else {
				
				playerName = player2;
				
			}
			
			while(isValid) {
				
				do {
					
				System.out.println(playerName + ", enter a row number: ");
						
					row = input.nextInt() - 1;
					
					if(!(row >= 0 && row < 3)) {
						System.out.println("Row is not in the boundaries of 1 - 3");
					}else {
						break;
					}
					
				}while(isValidRow);
				
				do {
					
				System.out.println(playerName + ", enter a column number: ");
				
					col = input.nextInt() - 1;
					
					if(!(col >= 0 && col < 3)) {
						System.out.println("Column is not in the boundaries of 1 - 3");
					}else {
						break;
					}
				
				}while(isValidCol);
				
				if(board[row][col] == ' ') {	
					
					board[row][col] = currentPlayer;
						break;
					
				}else {
					
					System.out.println("The spot is already filled. \n");
					
				}
			}
			
			printBoard();
			
			if(isWinner() == true) {
				
				System.out.println(playerName + " is the winner! \n");
				
				isPlaying = false;
				
			}else if(boardFull(board) == true){
				
				System.out.println("Tie! There is no winner.");
				
				isPlaying = false;
				
			}
			
			if(currentPlayer == 'X') {
				
				currentPlayer = 'O';
				
			}else {
				
				currentPlayer = 'X';
				
			}
			
		}
		
	}
	
	public static boolean isWinner() {
		
		if(board[0][0] == currentPlayer && board[0][1] == currentPlayer && board[0][2] == currentPlayer)
			return true;
		if(board[1][0] == currentPlayer && board[1][1] == currentPlayer && board[1][2] == currentPlayer)
			return true;
		if(board[2][0] == currentPlayer && board[2][1] == currentPlayer && board[2][2] == currentPlayer)
			return true;
		if(board[0][0] == currentPlayer && board[1][0] == currentPlayer && board[2][0] == currentPlayer)
			return true;
		if(board[0][1] == currentPlayer && board[1][1] == currentPlayer && board[2][1] == currentPlayer)
			return true;
		if(board[0][2] == currentPlayer && board[1][2] == currentPlayer && board[2][2] == currentPlayer)
			return true;
		if(board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer)
			return true;
		if(board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer)
			return true;
		return false;
	}
	
	public static boolean boardFull(char[][] board) {
		
		boolean isFull = true;

		for(int i = 0; i < 3; i++) {
			
			for(int j = 0; j < 3; j++) {
				
				if(board[i][j] == ' ') {
					
					isFull = false;
					
				}
				
			}
			
		}
		
		return isFull;
		
	}
	
	public static void clearBoard() {
		
		for(int i = 0; i < 3; i++) {
			
			for(int j = 0; j < 3; j++) {
				
				board[i][j] = ' ';
				
			}
		}
		
	}

}
