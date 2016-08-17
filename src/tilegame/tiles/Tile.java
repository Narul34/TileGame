package tilegame.tiles;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

// Classe qui d�finit les carr� comme on l'a imagin� dans dans notre programme
public class Tile {
	
	// Tableau pouvant contenir jusqu'a 256 tiles diff�rentes
	
	public static Tile[] tiles = new Tile[256];
	
	// Les tiles
	
	public static Tile videTile = new VideTile(0);
	public static Tile murTile = new MurTile(1);
	public static Tile limiteTile = new LimiteTile(2);
	public static Tile trapTile = new TrapTile(3);
	
	// Constantes d�finissant la taille d'une Tile

	public static final int TILEWIDTH = 30, TILEHEIGHT = 30;
	
	/* L'image utilis� et sont identifiant qu'on d�finira dans le constructeur des tiles filles pour les sotcker dans le tableau
	 * ainsi -- public static Tile videTile = new VideTile(0); -- fait que l'indice 0 du tableau tiles[] contiendra un Tile videTile
	 * (voir autre Tiles �galement)
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
	
	// Bool�en qui sert � d�finir si on veut que le joueur puisse passer/ traverser cette tile ou non
	public boolean isSolid(){
		return false;
	}
	
	
}
