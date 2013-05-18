package towers;
/**
 * 
 */

import java.util.LinkedList;

import towers.strategy.improvement.*;
import towers.strategy.shooter.*;
import towers.towertypes.*;



/**
 * @author Tha�s
 *
 */


public class Tower {
	
	protected ImproverInterface improver = new PowerImprovement(); // Ameliorateur
	protected ShooterInterface shooter = new Freeze(); // Tireur
	protected int price = 0; // Co�t de placement de la tour
	protected int shootSpeed = 0; // Vitesse de tir
	protected int shootPower = 0; // Puissance de tir
	protected int shootRange = 0; // Port�e de tir - rayon
	protected LinkedList<Object> position2d = new LinkedList<Object> (); // Position 2D sur la map
	int life = 10; // Vie de la tour - � 0, elle est d�truite
	// private Player ownerPlayer; // Joueur propri�taire
	
	public int getLife() {
		return life;
	}

	public void setLife(int life) {
		this.life = life;
	}

	public void setPosition2d(LinkedList<Object> position2d) {
		this.position2d = position2d;
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

	public void setPrice(int price) {
		this.price = price;
	}

	public int getShootSpeed() {
		return shootSpeed;
	}

	public void setShootSpeed(int shootSpeed) {
		this.shootSpeed = shootSpeed;
	}

	public int getShootPower() {
		return shootPower;
	}

	public void setShootPower(int shootPower) {
		this.shootPower = shootPower;
	}

	public int getShootRange() {
		return shootRange;
	}

	public void setShootRange(int shootRange) {
		this.shootRange = shootRange;
	}

	/**
	 * 
	 */
	public Tower(int price, int shootSpeed,
			int shootPower, int shootRange, LinkedList<Object> position2d) {
		super();
		this.price = price;
		this.shootSpeed = shootSpeed;
		this.shootPower = shootPower;
		this.shootRange = shootRange;
		this.position2d = position2d;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Tower tower = new MedicalTower(0,0,0,0,new LinkedList<Object>());
		Tower tower2 = new LaserTower (0,0,0,0,new LinkedList<Object>());
		tower2.shooter.shoot(tower);
		tower2.shooter.shoot(tower);
	}

}