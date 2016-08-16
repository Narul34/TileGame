package tilegame;

//=================Main du projet - Créé une instance et le Jeu===============

public class Launcher {

	public static void main (String[] args) {
		
		Game game = new Game("Tile game!", 600, 600);
		
		game.start();
		}
}
