package towers;

import java.awt.Point;
import java.awt.geom.Rectangle2D;
import java.io.File;

import map.Mapping;
import map.Zone;
import map.tiles.Tile;
import players.Player;
import players.SelectableObject;
import towers.strategy.improvement.ImproverInterface;
import towers.strategy.improvement.PowerImprovement;
import towers.strategy.shooter.Freeze;
import towers.strategy.shooter.ShootableObject;
import towers.strategy.shooter.ShooterInterface;
import towers.strategy.shooter.shootType.AttackingObject;
import agents.Agent;

public class Tower implements SelectableObject, ShootableObject {
	
	protected int width = 2; // Largeur en tiles
	protected int height = 2; // Longueur en tiles
	protected String imageName = System.getProperty("user.dir") + File.separator + "img" + File.separator + "icon.gif";
	
	protected ImproverInterface improver = new PowerImprovement(); // Ameliorateur
	protected ShooterInterface shooter = new Freeze(this); // Tireur
	
	protected static int price = 0; // Co�t de placement de la tour
	protected int shootSpeed = 0; // Vitesse de tir
	protected int shootPower = 0; // Puissance de tir
	protected int shootRange = 0; // Port�e de tir - rayon
	
	private int life = 10; // Vie de la tour - � 0, elle est d�truite
	private Zone zone = null; // Zone � laquelle appartient la tour
	
	private boolean selected = false;
	private Point coordInTiles = null;
	
	private ShootableObject target;
	
	private boolean frozen = false;
	private int frozentime = 0;
	
	protected Rectangle2D.Double hitbox;
	
	/* ----- CONSTRUCTEURS ----- */
	
	public Tower() {
		super();
	}
	
	/* ----- GETTERS & SETTERS ----- */
	
	/* Life */

	public int getLife() {
		return life;
	}

	public void setLife(int life) {
		this.life = life;
	}

	/* ImproverInterface */
	
	public ImproverInterface getImprover() {
		return improver;
	}

	public void setImprover(ImproverInterface improver) {
		this.improver = improver;
	}

	/* ShooterInterface */
	
	public ShooterInterface getShooter() {
		return shooter;
	}

	public void setShooter(ShooterInterface shooter) {
		this.shooter = shooter;
	}

	/* Price */
	
	public int getPrice() {
		return price;
	}
	
	/* ShootSpeed */
	
	public int getShootSpeed() {
		return shootSpeed;
	}

	/* ShootPower */
	
	public int getShootPower() {
		return shootPower;
	}

	/* ShootRange */
	
	public int getShootRange() {
		return shootRange;
	}
	
	/* ImageName */
	
	public String getImageName() {
		return imageName;
	}
	
	/* Zone */
	
	public Zone getZone() {
		return zone;
	}

	public void setZone(Zone zone) {
		this.zone = zone;
	}
	
	/* Target */
	
	public void setTarget(ShootableObject target) {
		this.target = target;
	}

	public ShootableObject getTarget() {
		// TODO Auto-generated method stub
		return target;
	}
	
	/* ----- FROM SELECTABLEOBJECT INTERFACE ----- */

	@Override
	public int getObjectWidth() {
		return width;
	}

	@Override
	public int getObjectHeight() {
		return height;
	}

	@Override
	public void setCoordInTiles(Point coordInTiles) {
		this.coordInTiles = coordInTiles;
		this.setHitBox();
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
	
	/* ----- FROM SHOOTABLEOBJECT INTERFACE ----- */

	@Override
	public void destruct(Mapping map) {
		// TODO Auto-generated method stub
		map.removeTower(this);
		this.life = 0;
	}

	@Override
	public boolean isDestructed() {
		// TODO Auto-generated method stub
		return (this.getLife() <= 0);
	}
	
	@Override
	public void setFrozen(boolean frozen) {
		this.frozen = frozen;
	}

	@Override
	public boolean isFrozen() {
		return frozen;
	}

	@Override
	public int getTotalFrozenTime() {
		return frozentime;
	}
	
	@Override
	public void setTotalFrozenTime(int frozentime) {
		this.frozentime = frozentime;
	}
	
	/* ----- FROM ATTACKABLEOBJECT INTERFACE ----- */

	@Override
	public void beAttacked(AttackingObject object) {
		// TODO Auto-generated method stub
		if (object instanceof Agent)
			return;
	}
	
	@Override
	public Player getOwner() {
		if (this.zone != null && this.zone.getOwner() != null)
		{
			return this.zone.getOwner();
		}
		return null;
	}
	
	@Override
	public boolean isInHitBox(Point point) {
		if (this.hitbox != null && this.hitbox.contains(point))
			return true;
		return false;
	}
	
	@Override
	public void setHitBox() {
		if (this.hitbox == null)
		{
			this.hitbox = new Rectangle2D.Double();
		}
		this.hitbox.setRect(coordInTiles.getX()*Tile.getWidth(), coordInTiles.getY()*Tile.getHeight(), getObjectWidth()*Tile.getWidth(), getObjectHeight()*Tile.getHeight());
	}
	
	@Override
	public Rectangle2D.Double getHitBox() {
		return hitbox;
	}
	
	/* ----- METHODES ----- */

	public void calculateBestTarget(Mapping map) {
		// TODO Auto-generated method stub
		if (!map.getAgents().isEmpty())
		{
			this.target = map.getAgents().get(0);
		}
	}
}
