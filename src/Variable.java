public class Variable implements TurtleState {

	private String variableName;
	private int variableValue;

	public Variable(String name, int value) {
		this.variableName = name;
		this.variableValue = value;
	}

	// Stores the corresponding <Key,Value> in hashTable.
	@Override
	public int evaluator(Context context) {
		context.set(variableName, variableValue);
		return context.getValue(variableName);
	}

	@Override
	public void setNextCommand(TurtleState next) {
	}

	@Override
	public void accept(Visitor visitor) {
	}

	@Override
	public TurtleState getNextCommand() {
		return null;
	}

	@Override
	public int getValue() {
		return variableValue;
	}

	@Override
	public int getVisitorValue() {
		return 0;
	}

}
