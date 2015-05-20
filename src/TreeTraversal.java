public class TreeTraversal {

	public void visitTree(TurtleState rootExpression, Visitor visitor) {
		while (rootExpression != null) {
			rootExpression.accept(visitor);
			if (rootExpression instanceof Repeat) {
				while (!(rootExpression instanceof End)) {
					rootExpression = rootExpression.getNextCommand();
				}
			}
			rootExpression = rootExpression.getNextCommand();

		}
	}

}
