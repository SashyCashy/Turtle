import static org.junit.Assert.*;
import java.awt.geom.Point2D;
import java.awt.geom.Point2D.Double;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Test {
	private Point2D.Double finalLocation;
	private int finalDirection;
	private Turtle turtle;
	private TreeTraversal traverse = new TreeTraversal();
	private Parser parseObject = new Parser();
	private Context contextObject = new Context();

	@org.junit.Test
	public void testInterpreter() throws FileNotFoundException {
		String fileName = "sample.txt";
		TurtleState rootCommand;
		parseObject.parseFile(fileName);
		rootCommand = parseObject.getRootState();
		rootCommand.evaluator(contextObject);
		turtle = contextObject.getTurtle();
		finalLocation = (Double) turtle.location();
		finalDirection = turtle.direction();
		assertEquals(finalLocation.getX(), 22.99038105676658, 0.0);
		assertEquals(finalLocation.getY(), 27.5, 0.0);
		assertEquals(finalDirection, 30);

	}

	@org.junit.Test
	public void testCommandVisitor() throws FileNotFoundException {
		String str = "sample.txt";
		Point2D.Double finalLocation;
		int finalDirection;
		TurtleState rootCommand;
		Turtle turtle = new Turtle();
		TreeTraversal traverse = new TreeTraversal();
		ArrayList<Command> commands;
		Parser parseObject = new Parser();
		parseObject.parseFile(str);
		rootCommand = parseObject.getRootState();
		Visitor visitor = new CommandVisitor(turtle);
		traverse.visitTree(rootCommand, visitor);
		commands = visitor.getList();
		
		assertEquals(commands.get(0).toString(), "penUp");
		assertEquals(commands.get(1).toString(), "move10");
		assertEquals(commands.get(2).toString(), "turn90");
		assertEquals(commands.get(3).toString(), "move20");
		assertEquals(commands.get(4).toString(), "turn-60");
		assertEquals(commands.get(5).toString(), "move15");

		finalLocation = (Double) turtle.location();
		finalDirection = turtle.direction();
		assertEquals(finalLocation.getX(), 22.99038105676658, 0.0);
		assertEquals(finalLocation.getY(), 27.5, 0.0);
		assertEquals(finalDirection, 30);
		commands.get(5).undo();
		assertEquals(finalLocation.getX(), 10.0, 0.0);
		assertEquals(finalLocation.getY(), 20.0, 0.0);
		assertEquals(finalDirection, 30);

	}

	@org.junit.Test
	public void testRepeatInterpreter() throws FileNotFoundException {
		String str = "sample4.txt";
		TurtleState rootCommand;
		parseObject.parseFile(str);
		rootCommand = parseObject.getRootState();
		rootCommand.evaluator(contextObject);
		turtle = contextObject.getTurtle();
		finalLocation = (Double) turtle.location();
		finalDirection = turtle.direction();
		assertEquals(finalLocation.getX(), 19.39692620785906, 0.0);
		assertEquals(finalLocation.getY(), -3.4202014332566826, 0.0);
		assertEquals(finalDirection, 1240);

	}

	@org.junit.Test
	public void testRepeatCommandVisitor() throws FileNotFoundException {
		String str = "sample2.txt";
		Point2D.Double finalLocation;
		int finalDirection;
		TurtleState rootNode;
		Turtle turtle = new Turtle();
		TreeTraversal traverse = new TreeTraversal();
		ArrayList<Command> commands;
		Parser parseObject = new Parser();
		parseObject.parseFile(str);
		rootNode = parseObject.getRootState();
		Visitor visitor = new CommandVisitor(turtle);
		traverse.visitTree(rootNode, visitor);
		commands = visitor.getList();
		for (Command command : commands) {
			command.execute();
		}

		assertEquals(commands.get(0).toString(), "move10");
		assertEquals(commands.get(1).toString(), "turn90");
		assertEquals(commands.get(2).toString(), "move30");
		assertEquals(commands.get(3).toString(), "turn180");

		finalLocation = (Double) turtle.location();
		finalDirection = turtle.direction();
		assertEquals(finalLocation.getX(), 10.0, 0.0);
		assertEquals(finalLocation.getY(), 30.0, 0.0);
		assertEquals(finalDirection, 270);

	}

	@org.junit.Test
	public void testRepeatDistanceVisitor() throws FileNotFoundException {
		double totalDistanceTravelled;
		String str = "sample2.txt";
		TurtleState rootNode;
		TreeTraversal traverse = new TreeTraversal();
		Parser parse = new Parser();
		parse.parseFile(str);
		rootNode = parse.getRootState();
		Visitor visitor = new DistanceVisitor();
		traverse.visitTree(rootNode, visitor);
		totalDistanceTravelled = visitor.getTotalDistance();
		assertEquals(totalDistanceTravelled, 15.0, 0.0);

	}

	@org.junit.Test
	public void testDistanceVisitor() throws FileNotFoundException {
		double totalDistanceTravelled;
		String str = "sample8.txt";
		TurtleState rootNode;
		TreeTraversal traverse = new TreeTraversal();

		Parser parseObject = new Parser();
		parseObject.parseFile(str);
		rootNode = parseObject.getRootState();
		Visitor visitor = new DistanceVisitor();
		traverse.visitTree(rootNode, visitor);
		totalDistanceTravelled = visitor.getTotalDistance();
		assertEquals(totalDistanceTravelled, 20.0, 0.0);

	}

}
