import java.util.Scanner;

public class connect4 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		char[][] grid = new char[7][7];
		
		for (int row = 0; row < grid.length; row++){
			for (int col = 0; col < grid[0].length; col++){
				grid[row][col] = ' ';
			}
		}
		int turn = 1;
		char player = 'R';
		
		
		boolean winner = false;		
		
		while (winner == false && turn <= 49){
			boolean Play1;
			
			
			int Play;
			do {
				pattern(grid);
				
				
				System.out.print("Player " + player + ", choose a column to place dot in: ");
				Play = in.nextInt();
				Play1 = trues(Play,grid);
				
			}while (Play1 == false);
			
			for (int row = grid.length-1; row >= 0; row--){
				if(grid[row][Play] == ' '){
					grid[row][Play] = player;
					
					
					
					break;
				}
			}
			winner = yWinner(player,grid);
			if (player == 'R'){
				player = 'Y';
			}else{
				player = 'R';
			}
			
			turn++;			
		}
		pattern(grid);
		
		if (winner){
			if (player=='R'){
				System.out.println("Yellow won");
			}else{
				System.out.println("Red won");
			}
		}else{
			System.out.println("Tie game");
		}
		
	}
	
	public static void pattern(char[][] grid){
		System.out.println("0 1 2 3 4 5 6 7");
		
		
		System.out.println("_______________");
		for (int row = 0; row < grid.length; row++){
			System.out.print("|");
			
			
			for (int col = 0; col < grid[0].length; col++){
				System.out.print(grid[row][col]);
				
				
				System.out.print("|");
				
				
			}
			System.out.println();
			
			System.out.println("_______________");
		}
		System.out.println("0 1 2 3 4 5 6 7");
		System.out.println();
	}
	
	public static boolean trues(int column, char[][] grid){
		if (column < 0 || column > grid[0].length){
			return false;
		}
	
		if (grid[0][column] != ' '){
			return false;
		}
		
		return true;
	}
	
	public static boolean yWinner(char player, char[][] grid){
		for(int row = 0; row<grid.length; row++){
		    
		    
		    
			for (int col = 0;col < grid[0].length - 3;col++){
			    
				if (grid[row][col] == player   && 
				
					grid[row][col+1] == player &&
					
					grid[row][col+2] == player &&
					
					grid[row][col+3] == player){
					return true;
				}
			}			
		}
		for(int row = 0; row < grid.length - 3; row++){
		    
		    
			for(int col = 0; col < grid[0].length; col++){
				if (grid[row][col] == player   && 
				
					grid[row+1][col] == player &&
					
					grid[row+2][col] == player &&
					
					grid[row+3][col] == player){
					return true;
				}
			}
		}
		for(int row = 3; row < grid.length; row++){
			for(int col = 0; col < grid[0].length - 3; col++){
				if (grid[row][col] == player   && 
				
				
				
				
					grid[row-1][col+1] == player &&
					
					grid[row-2][col+2] == player &&
					
					grid[row-3][col+3] == player){
					return true;
				}
			}
		}
		for(int row = 0; row < grid.length - 3; row++){
		    
			for(int col = 0; col < grid[0].length - 3; col++){
				if (grid[row][col] == player   && 
				
				
				
					grid[row+1][col+1] == player &&
					
					grid[row+2][col+2] == player &&
					
					grid[row+3][col+3] == player){
					return true;
				}
			}
		}
		return false;
	}
}
