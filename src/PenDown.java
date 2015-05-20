
public class PenDown implements TurtleState {

	private TurtleState nextState;
	
	@Override
	public void setNextCommand(TurtleState nextState) {
		this.nextState=nextState;
	}

	//Changes current turtle state to penDown state
	//and calls the evaluator of the next expression present after penDown.
	@Override
	public int evaluator(Context context) {
		context.getTurtle().penDown();
		nextState.evaluator(context);
		return 0;
	}

	@Override
	public void accept(Visitor visitor) {}

	@Override
	public TurtleState getNextCommand() {
		return null;
	}

	@Override
	public int getValue() {
		return 0;
	}

	@Override
	public int getVisitorValue() {
		return 0;
	}
}
