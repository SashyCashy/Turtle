
public interface TurtleState {
	public void  setNextCommand(TurtleState nextCommand);
	public TurtleState getNextCommand();
	public int evaluator(Context context);
	public void accept(Visitor visitor);
	public int getValue();
	public int getVisitorValue();
}


