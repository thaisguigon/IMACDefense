package towers.towertypes;

import java.util.LinkedList;

import towers.Tower;
import towers.strategy.shooter.Hurt;

public class LaserTower extends Tower {
	
	private Object lastTarget;
	private int currentPower;

	public LaserTower(int price, int shootSpeed, int shootPower,
			int shootRange, LinkedList<Object> position2d) {
		super(price, shootSpeed, shootPower, shootRange, position2d);
		// TODO Auto-generated constructor stub
		this.shooter = new Hurt();
	}

	public Object getLastTarget() {
		return lastTarget;
	}

	public void setLastTarget(Object lastTarget) {
		this.lastTarget = lastTarget;
	}

	public int getCurrentPower() {
		return currentPower;
	}

	public void setCurrentPower(int currentPower) {
		this.currentPower = currentPower;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}