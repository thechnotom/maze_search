/*
Developer: Thomas Roller
File:      Point.java
Class:     Point
Java:      SE8
*/

import java.io.Serializable;

public class Point implements Serializable {
	
	private int x, y;
	private Point prePoint;

	public Point () {

		x = 0;
		y = 0;

	}

	public Point (int x, int y) {

		this.x = x;
		this.y = y;

	}

	public Point (int x, int y, Point prePoint) {

		this.x = x;
		this.y = y;
		this.prePoint = prePoint;

	}

	// Setter methods
	public void setX (int x) { this.x = x; }
	public void setY (int y) { this.y = y; }
	public void setPrePoint (Point prePoint) { this.prePoint = prePoint; };

	// Getter methods
	public int getX () { return this.x; }
	public int getY () { return this.y; }
	public Point getPrePoint () { return prePoint; }

	// METHOD
	// Checks if a point is in a given Point array
	public boolean inArray (Point [] points) {

		for (int a = 0; a < points.length; a += 1) {

			if (points[a].equals(this)) {

				return true;

			}

		}

		return false;

	}

	// METHOD
	// Tests for equality
	public boolean equals (Object point) {

		return ((Point)point).getX() == this.x && ((Point)point).getY() == this.y;

	}

	// METHOD
	// Hash code
	public int hashCode (Object point) {

		return ((Point)point).getX() + ((Point)point).getY();

	}

	public String toString() {

		return "(" + this.x + ", " + this.y + ")";

	}

}
