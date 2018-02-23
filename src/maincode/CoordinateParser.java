package maincode;

import java.util.ArrayList;
import java.util.List;

public class CoordinateParser {

	private List<CoordinatePair> coordinates;

	public CoordinateParser(String args) {
		coordinates = new ArrayList<>();
		String[] tokens = args.split(",");
		if (tokens.length % 2 != 0) {
			System.err.println("ERROR: Coordinates not given in pairs");
			return;
		}

		for (int i = 0; i < tokens.length; i += 2) {
			try {
				int x = Integer.parseInt(tokens[i]);
				int y = Integer.parseInt(tokens[i + 1]);
				coordinates.add(new CoordinatePair(x, y));
			} catch (NumberFormatException e) {
				System.err.println("Only integers expected");
			}
		}

	}

	public void findFurthestAway() {
		double maxDist = 0;
		CoordinatePair origin = new CoordinatePair(0, 0);
		CoordinatePair furthestAway = new CoordinatePair(0, 0);
		for (CoordinatePair cp : coordinates) {
			if (origin.getDistance(cp) > maxDist) {
				maxDist = origin.getDistance(cp);
				furthestAway = cp;
			}
		}

		System.out.println("Point furthest away: (" + furthestAway.getX() + "," + furthestAway.getY() + ")");

	}

	public void findClosestToFirst() {
		if (coordinates.size() < 2) {
			throw new RuntimeException("Need atleast 2 pairs to execute function");
		}

		CoordinatePair origin = coordinates.get(0);
		CoordinatePair firstPoint = coordinates.get(1);
		CoordinatePair closestPair = firstPoint;
		double minDist = origin.getDistance(firstPoint);
		for (int i = 2; i < coordinates.size(); i++) {
			if (origin.getDistance(coordinates.get(i)) < minDist) {
				minDist = origin.getDistance(coordinates.get(i));
				closestPair = coordinates.get(i);
			}
		}
		if (closestPair != null)
			System.out.println("Point closest is: (" + closestPair.getX() + "," + closestPair.getY() + ")");
		else
			System.out.println("Could not find closest point!");
	}

	public List<CoordinatePair> getCoords() {
		return coordinates;
	}

}
