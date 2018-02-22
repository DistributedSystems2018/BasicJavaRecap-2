package maincode;

public class CoordinatePair {

	private int x;
	private int y;

	public CoordinatePair(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getDistance(CoordinatePair otherCoord) {
		return Math.abs(this.getX() - otherCoord.getX()) + Math.abs(this.getY() - otherCoord.getY());
	}

}
