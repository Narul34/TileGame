package tilegame.state;

import java.awt.Graphics;

import tilegame.Handler;
import tilegame.entities.creatures.Player;
import tilegame.worlds.World;

//Etat "Jeu" du programme

public class GameState extends State {

	// =========Variables==========

	private Player player;
	private World world;

	// =========Constructeur=========

	public GameState(Handler handler) {
		super(handler);
		world = new World(handler, "ressource/world/world1.txt");
		handler.setWorld(world);
		player = new Player(handler, 50, 50);
	}

	/* Fonctions maj des variables (tick) et reaffiche, ou rendu (render),
	 * surcharger de l'interface "State"
	 */
	
	@Override
	public void tick() {
		world.tick();
		player.tick();
	}

	@Override
	public void render(Graphics g) {
		world.render(g);
		player.render(g);
	}

}
