import java.util.Hashtable;


public class Context {
	private Hashtable<String,Integer> hashValues;
	private int counter;
	private int totalCount;
	private Turtle turtle;
	
	public Context()
	{
		 hashValues=new Hashtable<String,Integer>();
		 turtle=new Turtle();
	}
	
	//Set the corresponding <Key,Value> pair in the HashTable
	public void set(String variableName,int variableValue)
	{
		hashValues.put(variableName, variableValue);
	}
	
	//Get the corresponding Value by Key.
	public int getValue(String name)
	{
		return hashValues.get(name);
	}
	
	public Turtle getTurtle()
	{
		return turtle;
	}
	
	//Set the total number of iterations of commands within repeat-end block.
	public void  setTotalCount(int totalCount)
	{
		this.totalCount=totalCount;
	}
	
	//Get the total number of iterations of commands within repeat-end block.
	public int getTotalCount()
	{
		return totalCount;
	}
	
	//Get the dynamically incremented loop counter within repeat-end block.
	public int getRepeatCounter()
	{
		return counter;
	}
	
	//Set the dynamically incremented loop counter within repeat-end block.
	public void setRepeatCounter(int counter)
	{
		this.counter=counter;
	}
	
}
