
public class PenUp implements TurtleState {

	private TurtleState nextState;
	
	@Override
	public void setNextCommand(TurtleState next) {
		this.nextState=next;
		
	}
	//Changes current turtle state to penUp state
	//and calls the evaluator of the next expression present after penUp.
	@Override
	public int evaluator(Context context) {
		context.getTurtle().penUp();
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

