
public class Constant implements TurtleState{
	private int constantValue;
	
	
	public Constant(int constantValue)
	{
		this.constantValue=constantValue;
	}
	

	@Override
	public int evaluator(Context context) {
		return constantValue;
	}


	@Override
	public void setNextCommand(TurtleState next) {}


	@Override
	public void accept(Visitor visitor) {}


	@Override
	public TurtleState getNextCommand() {
		//Return the next Expression.
		return null;
	}


	


	@Override
	public int getValue() {
		return constantValue;
	}


	@Override
	public int getVisitorValue() {
		// TODO Auto-generated method stub
		return 0;
	}
	

}




