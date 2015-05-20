import java.util.ArrayList;

public class DistanceVisitor implements Visitor {
	private double totalMovesDistance=0.0;

	//Get the distance value from the move object and increment/update the total distance.
	@Override
	public void visit(Move move) {

		int value;
		value = move.getVisitorValue();
		totalMovesDistance += value;
	}

	@Override
	public void visit(Turn turn) {}

	
	//Call visit methods of the commands that are present within the repeat-end block.
	@Override
	public void visit(Repeat repeat) {

		TurtleState nextExpression;
		int repeatCounter;
		repeatCounter = repeat.getVisitorValue();

		while (0 < repeatCounter) {
			nextExpression = repeat.getNextCommand();
			while (!(nextExpression instanceof End)) {
				if (nextExpression instanceof Repeat) {
					Repeat repeatObject = (Repeat) nextExpression;
					visit(repeatObject);
					break;
				}
				else if (nextExpression instanceof Move) {
					Move move = (Move) nextExpression;
					visit(move);
				}
				nextExpression = nextExpression.getNextCommand();
			}
			repeatCounter--;

		}

	}

	@Override
	public void visit(PenUp penUp) {}

	@Override
	public void visit(PenDown penDown) {}

	@Override
	public void visit(End end) {}

	//Get the total distance traveled by move expression.
	public double getTotalDistance() {
		return totalMovesDistance;

	}

	@Override
	public ArrayList<Command> getList() {
		return null;
	}

}
