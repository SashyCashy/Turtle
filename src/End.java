

public class End implements TurtleState {
	
	private TurtleState nextState;

	@Override
	public void setNextCommand(TurtleState nextState) {
		this.nextState=nextState;
	}

	@Override
	public TurtleState getNextCommand() {
		return nextState;
	}
	
	//calculates the repeat Counter of the repeat expression and
	//then calls the evaluator of the next expression using object oriented recursion 
	//that is present after the repeat-end block.
	@Override
	public int evaluator(Context context) {
		int repeatCounter=context.getRepeatCounter();
		int totalCounter=context.getTotalCount();
		try{
			nextState.evaluator(context);
			if(repeatCounter!=totalCounter)
				throw null;
		}catch(NullPointerException nullException){
			return 0;
		}
		return 0;
	}
		

	
	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

	@Override
	public int getValue() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getVisitorValue() {
		// TODO Auto-generated method stub
		return 0;
	}
	

}
