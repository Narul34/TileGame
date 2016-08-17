package tilegame.tiles;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

// Classe qui définit les carré comme on l'a imaginé dans dans notre programme
public class Tile {
	
	// Tableau pouvant contenir jusqu'a 256 tiles différentes
	
	public static Tile[] tiles = new Tile[256];
	
	// Les tiles
	
	public static Tile videTile = new VideTile(0);
	public static Tile murTile = new MurTile(1);
	public static Tile limiteTile = new LimiteTile(2);
	public static Tile trapTile = new TrapTile(3);
	
	// Constantes définissant la taille d'une Tile

	public static final int TILEWIDTH = 30, TILEHEIGHT = 30;
	
	/* L'image utilisé et sont identifiant qu'on définira dans le constructeur des tiles filles pour les sotcker dans le tableau
	 * ainsi -- public static Tile videTile = new VideTile(0); -- fait que l'indice 0 du tableau tiles[] contiendra un Tile videTile
	 * (voir autre Tiles également)
	 */
	
	protected BufferedImage texture;
	protected final int id;
	
	// ======= Constructeur =======
	
	public Tile(BufferedImage texture, int id) {
		this.texture = texture;
		this.id = id;
		
		tiles[id] = this;
	}
	
	// =========  Accesseur ==========
	
	public int getId() {
		return id;
	}
	
	// Fonctions maj des variables (tick) et reaffiche, rendu (render) + un boolean qui servira aux collision dans le futur
	
	public void tick() {
		
	}
	
	public void render(Graphics g, int x, int y) {
		g.drawImage(texture, x, y, TILEWIDTH, TILEHEIGHT, null);	
	}
	
	// Booléen qui sert à définir si on veut que le joueur puisse passer/ traverser cette tile ou non
	public boolean isSolid(){
		return false;
	}
	
	
}
