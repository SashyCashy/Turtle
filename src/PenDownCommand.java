public class PenDownCommand implements Command {

	private Turtle turtle;
	public PenDownCommand(Turtle turtle) {
		this.turtle = turtle;
	}

	@Override
	public void execute() {
		turtle.penDown();

	}

	@Override
	public void undo() {
		turtle.penUp();

	}

}
