import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Parser {

	private String[] storeValue = new String[20];
	private TurtleState rootState = null, leafState = null, temporaryState = null;
	private Context context = new Context();

	public void parseFile(String inputFile) throws FileNotFoundException {

		int loopCounter = 0;
		
		File readFile = new File(inputFile);
		Scanner scanFile = new Scanner(readFile);

		while (scanFile.hasNextLine()) {
			storeValue[loopCounter] = scanFile.nextLine();
			loopCounter++;
		}
		for (int tokenCounter = 0; tokenCounter < loopCounter; tokenCounter++) {
			
			String[] splitTokens = new String[2];
			String token = storeValue[tokenCounter];
			splitTokens = token.split(" ");
			

			if (token.contains("$") || token.length() == 2) {
				context.set(splitTokens[0],Integer.parseInt(splitTokens[1]));
			}
			
			if (rootState == null) {
				if (token.equals("penUp"))
					rootState = new PenUp();

				else if (token.equals("penDown"))
					rootState = new PenDown();

				else if (splitTokens[0].equals("move"))
					rootState=getMoveObject(splitTokens[1]);
			
				else if (splitTokens[0].equals("turn"))
					rootState=getTurnObject(splitTokens[1]);

				leafState = rootState;
				if (splitTokens[0].equals("repeat")) {
					getRepeatObject(splitTokens, tokenCounter);
				}
			}
			else {
				if (token.equals("penUp")) {
					temporaryState = new PenUp();
					leafState.setNextCommand(temporaryState);
					leafState = temporaryState;

				}

				else if (token.equals("end")) {
					temporaryState = new End();
					leafState.setNextCommand(temporaryState);
					leafState = temporaryState;

				}

				else if (token.equals("penUp")) {
					temporaryState = new PenDown();
					leafState.setNextCommand(temporaryState);
					leafState = temporaryState;

					
				}
				else if (splitTokens[0].equals("move")) {
					temporaryState=getMoveObject(splitTokens[1]);
					leafState.setNextCommand(temporaryState);
					leafState = temporaryState;
				}
				if (splitTokens[0].equals("turn")) {
					temporaryState=getTurnObject(splitTokens[1]);
					leafState.setNextCommand(temporaryState);
					leafState = temporaryState;

				}

				else if (splitTokens[0].equals("repeat")) {
					getRepeatObject(splitTokens, tokenCounter);
				}

			}

		}

	}
	public Turn getTurnObject(String command){
		if (command.contains("$"))
			return new Turn(new Variable(command,context.getValue(command)));
		return new Turn(new Constant(Integer.parseInt(command)));
		
	}
	public Move getMoveObject(String command){
		if (command.contains("$"))
				return new Move(new Variable(command,context.getValue(command)));
		return new Move(new Constant(Integer.parseInt(command)));
	}
	public void getRepeatObject(String parseFile[], int tokenCounter) {
		if (parseFile[1].contains("$"))
			rootState = new Repeat(new Variable(parseFile[1],
					context.getValue(parseFile[1])));
		else
		rootState = new Repeat(new Constant(Integer.parseInt(parseFile[1])));

		leafState = rootState;
		while (!storeValue[tokenCounter + 1].contains("end")) {
			parseFile = storeValue[tokenCounter + 1].split(" ");
			if (parseFile[0].equals("move"))
				temporaryState = new Move(new Constant(
						Integer.parseInt(parseFile[1])));

			if (parseFile[0].equals("turn"))
				temporaryState = new Turn(new Constant(
						Integer.parseInt(parseFile[1])));

			if (parseFile[0].equals("repeat"))
				temporaryState = new Repeat(new Constant(
						Integer.parseInt(parseFile[1])));

			leafState.setNextCommand(temporaryState);
			leafState = temporaryState;
			tokenCounter++;

		}
	}

	public TurtleState getRootState() {
		return rootState;
	}

}
