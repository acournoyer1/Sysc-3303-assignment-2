
public enum Ingredient {
	PEANUT_BUTTER(1, "peanut butter"),
	JELLY(2, "jelly"),
	BREAD(3, "bread");
	
	private int value;
	private String string;
	
	private Ingredient(int value, String string)
	{
		this.value = value;
		this.string = string;
	}
	
	public int getValue()
	{
		return value;
	}
	
	public String getString()
	{
		return string;
	}
}
