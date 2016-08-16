package tilegame.state;

import java.awt.Graphics;

import tilegame.Game;
import tilegame.entities.creatures.Player;
import tilegame.tiles.Tile;
import tilegame.worlds.World;

//Etat "Jeu" du programme

public class GameState extends State {

	private Player player;
	private World world;
	
	//=======Constructeur=========
	
	public GameState(Game game) {
		super(game);
		player = new Player(game, 0,0);
		world = new World(game, "ressource/world/world1.txt");
		
	}
	
	// Fonctions maj des variables (tick) et reaffiche, rendu (render), surcharger de l'interface "State"
	
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
