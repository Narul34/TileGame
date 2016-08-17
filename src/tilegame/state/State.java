package tilegame.state;

import java.awt.Graphics;

import tilegame.Handler;

// classe abstraite qui permet d'indiquer l'etat géré par le programme (GameState, menuState...) qui seront ses enfants

public abstract class State {

	private static State CurrentState = null;	
	protected Handler handler;
	
	// ========== Constructeur ==========
	
	public State(Handler handler) {
		this.handler = handler;
	}
	
	// ========= Accesseur ==========
	
	public static State getCurrentState() {
		return CurrentState;
	}

	public static void setCurrentState(State currentState) {
		CurrentState = currentState;
	}
	
	// Fonctions maj des variables (tick) et reaffiche, rendu (render), inutilisé jusqu'ici, puisque un seul etat pour l'instant
	
	public abstract void tick();
	
	public abstract void render(Graphics g);

	
}
