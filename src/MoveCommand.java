public class MoveCommand implements Command {

	private Turtle turtle;
	private int moveValue;

	public MoveCommand(Turtle turtleObject, int value) {
		this.turtle = turtleObject;
		this.moveValue = value;
	}

	// calculate the distance of the turtle by invoking move method.
	@Override
	public void execute() {
		turtle.move(moveValue);

	}

	// undo the calculate distance of the turtle by invoking move method.
	@Override
	public void undo() {
		turtle.move(-(moveValue));
	}

}
