package map;

public enum Tile {
	
	Field ("", false, true, false),
	Mountain ("", true, false, false),
	Buttress ("", false, false, true);
	
	public static int width = 20;
	
	private String image = "";
	private boolean destroyable = false;
	private boolean walkable = true;
	private boolean constructible = false;

	private Tile(String image, boolean destroyable, boolean walkable,
			boolean constructible) {
		this.image = image;
		this.destroyable = destroyable;
		this.walkable = walkable;
		this.constructible = constructible;
	}
	
	public void print ()
	{
		return;
	}

}
