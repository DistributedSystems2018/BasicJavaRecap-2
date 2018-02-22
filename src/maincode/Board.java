package maincode;

public class Board {

	char[][] boardGame;
	private int n;
	private int m;

	private static final char MISS = '.';
	private static final char HIT = 'X';

	public Board(int n, int m) {
		this.n = n;
		this.m = m;
		boardGame = new char[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				boardGame[i][j] = MISS;
			}
		}
	}

	private void printBoard() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(boardGame[i][j]);
			}
			System.out.println();
		}
	}

	private void hitBoard(CoordinatePair cp) {
		if (cp.getX() > n || cp.getY() > m || cp.getX() < 0 || cp.getY() < 0) {
			throw new RuntimeException("Coordinate out of bounds");
		}

		if (boardGame[cp.getX()-1][cp.getY()-1] == MISS) {
			boardGame[cp.getX()-1][cp.getY()-1] = HIT;
		} else {
			System.out.println("This location has already been hit!");
		}
	}

	public void shootBoardWithArgs(String args) {
		CoordinateParser parser = new CoordinateParser(args);
		for (CoordinatePair cp : parser.getCoords()) {
			hitBoard(cp);
		}
		printBoard();
	}
}
