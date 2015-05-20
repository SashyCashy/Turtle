import java.util.ArrayList;

public class CommandVisitor implements Visitor {

	private ArrayList<Command> commands;
	private Turtle turtle;
	// Initialize the arrayList.
	public CommandVisitor(Turtle turtle) {
		commands = new ArrayList<Command>();
		turtle=new Turtle();
		this.turtle=turtle;
	}

	// Add MoveCommand Objects into the Command List.
	@Override
	public void visit(Move move) {
		Command command = new MoveCommand(turtle, move.getVisitorValue());
		commands.add(command);
	}

	// Add TurnCommand Objects into the Command List.
	@Override
	public void visit(Turn turn) {
		Command command = new TurnCommand(turtle, turn.getVisitorValue());
		commands.add(command);
	}
	
	// Add PenUpCommand Objects into the Command List.
	@Override
	public void visit(PenUp penUp) {
		Command command = new PenUpCommand(turtle);
		commands.add(command);

	}
	// Add PenDownCommand Objects into the Command List.
	@Override
	public void visit(PenDown penDown) {
		Command command = new PenDownCommand(turtle);
		commands.add(command);

	}
	// Add RepeatCommand Objects into the Command List.
	@Override
	public void visit(Repeat repeat) {
		TurtleState nextExpression;
		int currentExpressionValue, nextExpressionValue;
		currentExpressionValue = repeat.getVisitorValue();
		//Run the Commands within the Repeat-End Block
		while (0 < currentExpressionValue) {
			nextExpression = repeat.getNextCommand();
			while (!(nextExpression instanceof End)) {
				nextExpressionValue = nextExpression.getVisitorValue();
				if (nextExpression instanceof Repeat) {
					Repeat repeatExpression = (Repeat) nextExpression;
					visit(repeatExpression);
					break;
				}
				if (nextExpression instanceof Move) {
					Command command = new MoveCommand(turtle,
							nextExpressionValue);
					commands.add(command);

				}
				if (nextExpression instanceof Turn) {
					Command command = new TurnCommand(turtle,
							nextExpressionValue);
					commands.add(command);
				}
				nextExpression = nextExpression.getNextCommand();
			}
			currentExpressionValue--;
		}
	}

	// Retrieve the Command List.
	public ArrayList<Command> getList() {
		return commands;
	}

	@Override
	public void visit(End end) {}

	@Override
	public double getTotalDistance() {
		return 0;
	}

}
