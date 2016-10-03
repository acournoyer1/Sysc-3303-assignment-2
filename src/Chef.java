import java.util.LinkedList;

public class Chef extends Thread{
	private Ingredient ingredient;
	private Table table;
	
	public Chef(Ingredient ingredient, Table table)
	{
		this.ingredient = ingredient;
		this.table = table;
	}
	
	private void getFromTable()
	{
		
					LinkedList<Ingredient> sandwich = new LinkedList<Ingredient>();
					sandwich.add(ingredient);
					sandwich.add(table.get());
					sandwich.add(table.get());
					
					if(sandwich.contains(Ingredient.PEANUT_BUTTER) &&
							sandwich.contains(Ingredient.JELLY) &&
							sandwich.contains(Ingredient.BREAD))
					{
						System.out.println("The chef that had " + ingredient.getString() + " has made and eaten a sandwich.");
					}
	}
	
	@Override
	public void run()
	{
		getFromTable();
	}
}
