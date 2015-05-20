public class Move implements TurtleState {

	private TurtleState currentState, nextState;

	public Move(TurtleState currentState) {
		this.currentState = currentState;
	}

	public int getVisitorValue() {
		return currentState.getValue();
	}

	@Override
	public void setNextCommand(TurtleState nextState) {
		this.nextState = nextState;
	}
	
	//Set the turtles state to move
	//then calls the evaluator of the next expression using object oriented recursion 
	//that is present after move command.
	@Override
	public int evaluator(Context context) {
		try {
			context.getTurtle().move(currentState.evaluator(context));
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

	@Override
	public int getValue() {
		return 0;
	}

}
