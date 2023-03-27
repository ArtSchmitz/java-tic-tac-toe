package jogoDaVelha;

public class GameClass {
	private String[][] board;
	private static final int size = 3;
	
	PlayerClass player1 = new PlayerClass("X");
	PlayerClass player2 = new PlayerClass("Y");
	
	public GameClass(){
		board = new String[size][size];
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				board[i][j] = "-";
			}
		}
	}
	
	public boolean Move(PlayerClass player, int play1, int play2) {
		if(board[play1][play2].equals("-")) {
			board[play1][play2] = player.getSymbol();
			return true;
		} else {
			return false;
		}
	}
	
	public boolean Win(PlayerClass player) {
		String symbol = player.getSymbol();
		
		for (int i = 0; i < size; i++) {
            if (board[i][0].equals(symbol) && board[i][1].equals(symbol) && board[i][2].equals(symbol)){
                return true;
            }
		}
		for (int j = 0; j < size; j++) {
            if (board[0][j].equals(symbol) && board[1][j].equals(symbol) && board[2][j].equals(symbol)) {
                return true;
            }
        }
		
		if (board[0][0].equals(symbol) && board[1][1].equals(symbol) && board[2][2].equals(symbol)) {
            return true;
	
		}
		if (board[0][2].equals(symbol) && board[1][1].equals(symbol) && board[2][0].equals(symbol)) {
            return true;
        }
		return false;
	}
	
	public void printBoard() {
		System.out.println("-------------");
        for (int i = 0; i < size; i++) {
            System.out.print("| ");
            for (int j = 0; j < size; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }
	
	public boolean isFull() {
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				if(board[i][j].equals("-")) {
					return false;
				}
			}
		}		
		return true;
	}

	public boolean checkTie() {
		return this.isFull() && !this.Win(player1) && !this.Win(player2);
	}

	
	
}
