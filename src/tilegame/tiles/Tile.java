package tilegame.tiles;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Tile {
	
	// STATIC STUFF
	
	public static Tile[] tiles = new Tile[256];
	public static Tile videTile = new VideTile(0);
	public static Tile murTile = new MurTile(1);
	public static Tile limiteTile = new LimiteTile(2);
	public static Tile trapTile = new TrapTile(3);
	
	// CLASS

	public static final int TILEWIDTH = 30, TILEHEIGHT = 30;
	
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
	
	public boolean isSolid(){
		return false;
	}
	
	
}
