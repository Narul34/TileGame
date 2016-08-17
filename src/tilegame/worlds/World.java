package tilegame.worlds;

import java.awt.Graphics;

import tilegame.Handler;
import tilegame.tiles.Tile;
import tilegame.utils.Utils;

public class World {

	// Variable handler qui contien un Game et un World
	private Handler handler;

	// Variable largeur et hauteur de carte, la position de depart du personnage
	private int width, height;
	private int spawnX, spawnY;

	// index a envoyer pour recuper une "tile"
	private int[][] index;

	// ======== CONSTRUCTEUR ===========

	public World(Handler handler, String path) {
		this.handler = handler;
		loadWorld(path);
	}

	// Fonction de maj et de rendu

	public void tick() {

	}
	
	// C'est ici quese fait le plsu gros du rendu
	public void render(Graphics g) {
		int xStart = (int) Math.max(0, handler.getGameCamera().getxOffset() / Tile.TILEWIDTH);
		int xEnd = (int) Math.min(width,
				(handler.getGameCamera().getxOffset() + handler.getWidth()) / Tile.TILEWIDTH + 1);
		int yStart = (int) Math.max(0, handler.getGameCamera().getyOffset() / Tile.TILEHEIGHT);
		int yEnd = (int) Math.min(height,
				(handler.getGameCamera().getyOffset() + handler.getHeight()) / Tile.TILEHEIGHT + 1);

		for (int j = yStart; j < yEnd; j++) {
			for (int i = xStart; i < xEnd; i++) {
				getTile(i, j).render(g, (int) (i * Tile.TILEWIDTH - handler.getGameCamera().getxOffset()),
						(int) (j * Tile.TILEHEIGHT - handler.getGameCamera().getyOffset()));
			}
		}
	}

	// Fonction qui renvoi la tile indiquer en paramètre

	public Tile getTile(int x, int y) {
		if (x < 0 || y < 0 || x >= width || y >= height) {
			return Tile.videTile;
		}

		Tile t = Tile.tiles[index[x][y]];
		if (t == null)
			return Tile.videTile;
		return t;
	}

	// fonction de chargement de la carte
	
	private void loadWorld(String path) {
		String file = Utils.loadFileAsString(path);
		String[] tokens = file.split("\\s+"); // découpe le fichier texte pour garder le caractère entre chaque espace
		width = Utils.parseInt(tokens[0]);
		height = Utils.parseInt(tokens[1]);
		spawnX = Utils.parseInt(tokens[2]);
		spawnY = Utils.parseInt(tokens[3]);

		index = new int[width][height];

		for (int j = 0; j < height; j++) { // y
			for (int i = 0; i < width; i++) { // x
				index[i][j] = Utils.parseInt(tokens[(i + j * width) + 4]);
			}
		}
	}
	
	// ============ Accesserus ==========
	public int getWidth(){
		return width;
	}
	
	public int getHeight() {
		return height;
	}
}
