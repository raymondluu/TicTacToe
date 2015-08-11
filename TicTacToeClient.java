import java.util.*;

public class TicTacToeClient {
	public static void main( String[] args ) {
		TicTacToe game = new TicTacToe();
		Scanner row = new Scanner(System.in);
		Scanner col = new Scanner(System.in);
		
		System.out.println( "Welcome to Tic Tac Toe." );
		
		while( !game.gameOver() && !game.whoWon() ) {
			System.out.println( "Your turn " + game.getPlayer() );
			System.out.print( game );
			System.out.println( "Row:" );
			int r = row.nextInt();
			System.out.println( "Column:" );
			int c = col.nextInt();
			while( !game.nextMove( r , c ) ) {
				System.out.println( "Illegal Move! Try again." );
				break;
			}
		}
		if( game.whoWon() ) {
			System.out.println( game );
			game.switchTurns( game.getPlayer() );
			System.out.println( game.getPlayer() + " Wins!" );
		}
		else if( game.gameOver() ) {
			System.out.println( game );
			System.out.println( "Cats game!" );
		}
	}
}