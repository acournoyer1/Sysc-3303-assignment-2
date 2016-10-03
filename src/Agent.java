import java.util.Random;

public class Agent extends Thread{
	
	private final Ingredient[] ingredients = {Ingredient.BREAD, Ingredient.JELLY, Ingredient.PEANUT_BUTTER};
	private Random random;
	private Table table;
	
	public Agent(Table table)
	{
		random = new Random();
		this.table = table;
	}
	
	private synchronized void putOnTable()
	{
		for(int i = 0; i < 10; i++)
		{
			while(!table.isEmpty())
			{
				try {
					wait();
				} catch (InterruptedException e) {
					
				}
			}
			int firstIngredient = random.nextInt(ingredients.length);
			int secondIngredient = firstIngredient;
			while(firstIngredient == secondIngredient)
			{
				secondIngredient = random.nextInt(ingredients.length);
			}
			table.put(ingredients[firstIngredient]);
			table.put(ingredients[secondIngredient]);
			System.out.println("The agent has put " + ingredients[firstIngredient].getString() + " and " + ingredients[secondIngredient].getString() + " on the table.");
		}
	}
	
	@Override
	public void run()
	{
		putOnTable();
	}
}
