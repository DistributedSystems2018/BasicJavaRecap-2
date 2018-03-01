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

	public double getDistance(CoordinatePair otherCoord) {
		int x = Math.abs(this.getX() - otherCoord.getX());
		int y = Math.abs(this.getY() - otherCoord.getY());
	        return Math.sqrt((x*x)+(y*y));
	        	
	}

}
