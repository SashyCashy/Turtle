import java.util.ArrayList;


public interface Visitor  {
	public void visit(Move move);
	public void visit(Turn turn);
	public void visit(Repeat repeat);
	public void visit(PenUp penUp);
	public void visit(PenDown penDown);
	public void visit(End end);
	public ArrayList<Command> getList();
	public double getTotalDistance();
	
}


