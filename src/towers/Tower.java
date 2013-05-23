package towers;

import java.awt.Point;
import java.io.File;

import players.SelectableObject;

import map.Zone;
import towers.strategy.improvement.*;
import towers.strategy.shooter.*;

public class Tower implements SelectableObject {
	
	protected int width = 5;
	protected int height = 5;
	protected String imageName = System.getProperty("user.dir") + File.separator + "img" + File.separator + "icon.gif";
	
	protected ImproverInterface improver = new PowerImprovement(); // Ameliorateur
	protected ShooterInterface shooter = new Freeze(); // Tireur
	
	protected static int price = 0; // Co�t de placement de la tour
	protected static int shootSpeed = 0; // Vitesse de tir
	protected static int shootPower = 0; // Puissance de tir
	protected static int shootRange = 0; // Port�e de tir - rayon
	
	private int life = 10; // Vie de la tour - � 0, elle est d�truite
	private Zone zone = null; // Zone � laquelle appartient la tour
	
	private boolean selected = false;
	private Point coordInTiles = null;
	
	public int getLife() {
		return life;
	}

	public void setLife(int life) {
		this.life = life;
	}

	public ImproverInterface getImprover() {
		return improver;
	}

	public void setImprover(ImproverInterface improver) {
		this.improver = improver;
	}

	public ShooterInterface getShooter() {
		return shooter;
	}

	public void setShooter(ShooterInterface shooter) {
		this.shooter = shooter;
	}

	public int getPrice() {
		return price;
	}
	
	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public int getShootSpeed() {
		return shootSpeed;
	}

	public int getShootPower() {
		return shootPower;
	}

	public int getShootRange() {
		return shootRange;
	}
	
	public Tower ()
	{
		super ();
	}

	public String getImageName() {
		return imageName;
	}

	@Override
	public boolean isSelected() {
		// TODO Auto-generated method stub
		return selected;
	}

	@Override
	public void inverseSelected() {
		// TODO Auto-generated method stub
		selected = !selected;
	}

	@Override
	public void setSelected(boolean selected) {
		// TODO Auto-generated method stub
		this.selected = selected;
	}

	@Override
	public Point getCoordInTiles() {
		// TODO Auto-generated method stub
		return coordInTiles;
	}
}
