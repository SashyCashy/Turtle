import java.awt.*;
import java.awt.geom.Point2D;

public class Turtle {

	private int currentDirection;
	private Point2D currentLocation;
	private boolean penState;

	Turtle() {
		currentDirection = 0;
		currentLocation = new Point2D.Double();
		penState = false;
	}

	// method is used to calculate the distance traversed by turtle.
	void move(int distance) {
		double deltaX, deltaY;
		double currentX, currentY;
		int degrees;
		degrees = currentDirection;
		double radians;
		radians = Math.toRadians(degrees);
		deltaY = Math.sin(radians) * distance;
		deltaX = Math.cos(radians) * distance;
		currentX = currentLocation.getX() + deltaX;
		currentY = currentLocation.getY() + deltaY;
		currentLocation.setLocation(currentX,currentY);
		
	}

	void penUp() {
		penState = false;
	}

	void penDown() {
		penState = true;
	}

	void turn(int degrees) {
		currentDirection = currentDirection + degrees;
	}

	public boolean isPenUp() {
		if (penState == true)
			return false;
		return true;

	}
	public int direction(){
		return currentDirection;
	}
	public Point2D location() {
		return currentLocation;
	}

}
