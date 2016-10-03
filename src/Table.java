import java.util.LinkedList;

public class Table {
	private LinkedList<Ingredient> ingredients;
	
	public Table()
	{
		ingredients = new LinkedList<Ingredient>();
	}
	
	public boolean isEmpty()
	{
		return ingredients.isEmpty();
	}
	
	public boolean isFull()
	{
		return ingredients.size() >= 2;
	}
	
	public synchronized void put(Ingredient ingredient)
	{
		if(!isFull())
		{
			ingredients.add(ingredient);
		}
		notifyAll();
	}
	
	public synchronized LinkedList<Ingredient> get(Ingredient ingredient)
	{
		while(!(ingredient.getValue() + getContents() == 6))
		{
			try {
				wait();
			} catch (InterruptedException e) {
				
			}
		}
		LinkedList<Ingredient> 
		
	}
	
	public synchronized int getContents()
	{
		int sum = 0;
		for(Ingredient i: ingredients)
		{
			sum += i.getValue();
		}
		return sum;
	}
	
	public static void main(String args[])
	{
		Table table = new Table();
		Agent agent = new Agent(table);
		Chef peanutButter = new Chef(Ingredient.PEANUT_BUTTER, table);
		Chef bread = new Chef(Ingredient.BREAD, table);
		Chef jelly = new Chef(Ingredient.JELLY, table);
		
		agent.start();
		peanutButter.start();
		bread.start();
		jelly.start();
	}
}
