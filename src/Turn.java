public class Turn implements TurtleState {
	private TurtleState currentState, nextState;

	public Turn(TurtleState currentState) {
		this.currentState = currentState;
	}

	@Override
	public void setNextCommand(TurtleState nextState) {
		this.nextState = nextState;
	}

	// Set the turtles state to turn
	// then calls the evaluator of the next expression using object oriented
	// recursion that is present after turn command.
	@Override
	public int evaluator(Context context) {
		try {
			context.getTurtle().turn(currentState.evaluator(context));
			nextState.evaluator(context);
		} catch (NullPointerException nullException) {
			return 0;
		}
		return 0;
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

	@Override
	public TurtleState getNextCommand() {
		return nextState;
	}

	public int getVisitorValue() {
		return currentState.getValue();
	}

	@Override
	public int getValue() {
		return 0;
	}

}
