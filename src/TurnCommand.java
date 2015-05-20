public class TurnCommand implements Command {

	private Turtle turtle;
	private int turnValue;

	public TurnCommand(Turtle turtleObject, int turnValue) {
		this.turtle = turtleObject;
		this.turnValue = turnValue;
	}

	@Override
	public void execute() {
		turtle.turn(turnValue);
	}

	@Override
	public void undo() {
		turtle.turn(-(turnValue));
	}

}
