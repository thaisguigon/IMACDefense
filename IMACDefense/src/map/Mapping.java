package map;

import java.io.InputStream;
import java.util.Hashtable;
import java.util.LinkedList;

public class Mapping {
	
	int widthTiles = 20; // Largeur de la map en tiles
	int heightTiles = 20; // Hauteur de la map en tiles
	Hashtable<Integer,Hashtable<Integer, Tile>> Tiles = new Hashtable<Integer,Hashtable<Integer, Tile>>();

	public Mapping(int widthTiles, int heightTiles) {
		// TODO Auto-generated constructor stub
		this.widthTiles = widthTiles;
		this.heightTiles = heightTiles;
		Hashtable<Integer,Tile> LineOfTiles = new Hashtable<Integer,Tile>();
		LineOfTiles.put(0, Tile.Field);
		LineOfTiles.put(1, Tile.Buttress);
		LineOfTiles.put(2, Tile.Mountain);
		this.Tiles.put(0, LineOfTiles);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Mapping mapping = new Mapping (20, 20);
		System.out.println(mapping.Tiles);
	}
	
	public void readTextFile (InputStream input)
	{
		return;
	}
	
	public void readImageFile ()
	{
		return;
	}
	
	public void print ()
	{
		return;
	}

}
