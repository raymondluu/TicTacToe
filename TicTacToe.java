public class TicTacToe {
	private char whosTurn;
	private char[][] board;
	
	public TicTacToe() {
		board = new char[3][3];
		for( int r = 0; r < 3; r++ ) {
			for( int c = 0; c < 3; c++ ) {
				board[r][c] = ' ';
			}
		}
		whosTurn = 'X';
	} 
	
	public void switchTurns( char nextPlayer ) {
		if( nextPlayer == 'X' ) {
			whosTurn = 'O';
		} 
		else {
			whosTurn = 'X';
		}
	}
	
	public char getPlayer() {
		return whosTurn;
	}
	
	public boolean gameOver() {
		for( int r = 0; r < 3; r++ ) {
			for( int c = 0; c < 3; c++ ) {
				if( board[r][c] == ' ' ) {
					return false;
				}
			}
		}
		return true;
	}
	
	public boolean whoWon() {
		if( board[1][1] == board[0][0] && board[1][1] == board[2][2] && board[1][1] != ' ' ) {
			return true;
		}
		if( board[1][1] == board[2][0] && board[1][1] == board[0][2] && board[1][1] != ' ' ) {
			return true;
		}
		
		for( int r = 0; r < 3; r++ ) {
			if( board[r][1] == board[r][0] && board[r][1] == board[r][2] && board[r][1] != ' ' ) {
				return true;
			}
		}
		for( int c = 0; c < 3; c++ ) {
			if( board[1][c] == board[0][c] && board[1][c] == board[2][c] && board[1][c] != ' ' ) {
				return true;
			}
		}
		return false;
	}

	public boolean nextMove( int r, int c ) {
		if( r < 1 || r > 3 || c < 1 || c > 3 ) {
			return false;
		}
		else {
			r--;
			c--;
		}
		if( board[r][c] == 'X' || board[r][c] == 'O' ) {
			return false;
		}
		if( board[r][c] == ' ' ) {
			board[r][c] = whosTurn;
		}
		if( whosTurn == 'X' ) {
			switchTurns( whosTurn );
		} 
		else {
			whosTurn = 'X';
		}
		return true;
	}
	
	public String toString() {
		String display = "";
		for( int r = 0; r < 3; r++ ) {
			for( int c = 0; c < 3; c++ ) {
				display = display + "[" + board[r][c] + "]";
			}
			display = display + "\n";

		}
		return display;
	}
}