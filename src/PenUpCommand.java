public class PenUpCommand implements Command {
	private Turtle turtle;
	public PenUpCommand(Turtle turtle) {
		this.turtle = turtle;
	}
	
	@Override
	public void execute() {
		turtle.penUp();
	}

	@Override
	public void undo() {
		turtle.penDown();
	}
}
