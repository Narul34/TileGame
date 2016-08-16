package tilegame.state;

import java.awt.Graphics;

import tilegame.Game;

// Interface qui permet d'indiquer l'etat géré par le programme (Jeu, menu...)

public abstract class State {

	private static State CurrentState = null;	
	protected Game game;
	
	// ========== Constructeur ==========
	
	public State(Game game) {
		this.game = game;
	}
	
	// ========= Accesseur ==========
	
	public static State getCurrentState() {
		return CurrentState;
	}

	public static void setCurrentState(State currentState) {
		CurrentState = currentState;
	}
	
	// Fonctions maj des variables (tick) et reaffiche, rendu (render)
	
	public abstract void tick();
	
	public abstract void render(Graphics g);

	
}
