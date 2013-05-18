package basis;

import java.util.Vector;

public class Base {

	protected int id = 0;
	protected int time = 0; // temps d'attente entre chaque cr�ation d'agent en secondes
	protected int nbCreatableAgents = 0; // nb d�agents que la base peut cr�er (par intervalle r�gulier)
	protected int nbHostedAgents = 0; // nb d�agents que la base h�berge
	protected Vector<Object> position2d = new Vector<Object> (); // Position 2D sur la map
	protected Base target = new Base();
	// private Player ownerPlayer; // Joueur propri�taire
	
	/*
	 * Getter - setter
	 */
	public int getId() {
		return id;
	}
	
	public int getTime() {
		return time;
	}
	
	public void setTime(int time) {
		this.time = time;
	}
	
	public int getNbCreatableAgents() {
		return nbCreatableAgents;
	}
	
	public void setNbCreatableAgents(int nbCreatableAgents) {
		this.nbCreatableAgents = nbCreatableAgents;
	}
	
	public int getNbHostedAgents() {
		return nbHostedAgents;
	}
	
	public void setNbHostedAgents(int nbHostedAgents) {
		this.nbHostedAgents = nbHostedAgents;
	}
	
	public Vector<Object> getPosition2d() {
		return position2d;
	}

	public void setPosition2d(Vector<Object> position2d) {
		this.position2d = position2d;
	}
	
	/*
	 * Constructor
	 */
	
	public Base(int time, int nbCreatableAgents, int nbHostedAgents, Vector<Object> position2d) {
		this.time = time;
		this.nbCreatableAgents = nbCreatableAgents;
		this.nbHostedAgents = nbHostedAgents;
		this.position2d = position2d;
		this.id = this.id + 1;
	}
	
	public Base() {
		super();
	}
	
	/*
	 * Methodes
	 */
	
	public Base ChooseTarget(Base base) { //choisir une cible
		
		return base;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}