public class Repeat implements TurtleState {
	private TurtleState currentExpression, nextExpression;

	public Repeat(TurtleState expression) {
		this.currentExpression = expression;
	}

	@Override
	public void setNextCommand(TurtleState nextExpression) {
		this.nextExpression = nextExpression;

	}

	//Set the turtles state to repeat
	//and then it calls the next expression,and all the expressions are looped within 
	//repeat-end block;
	@Override
	public int evaluator(Context context) {
		int iteratorCounter = 0;
		int totalLoopCounter = currentExpression.evaluator(context);
		context.setTotalCount(totalLoopCounter);
		while (iteratorCounter < totalLoopCounter) {
			context.setRepeatCounter(iteratorCounter + 1);
			nextExpression.evaluator(context);
			iteratorCounter++;
		}
		return 0;
	}

	@Override
	public void accept(Visitor visitor) {

		visitor.visit(this);

	}

	public int getVisitorValue() {
		return currentExpression.getValue();
		
	}

	@Override
	public TurtleState getNextCommand() {
		return nextExpression;
}

	@Override
	public int getValue() {
		// TODO Auto-generated method stub
		return 0;
	}

}