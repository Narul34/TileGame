package tilegame.worlds;

import java.awt.Graphics;

import tilegame.Game;
import tilegame.tiles.Tile;
import tilegame.utils.Utils;

public class World {

	private Game game;
	
	// Variable largeur et hauteur de carte, la position de depart du personnage
	private int width, height;
	private int spawnX, spawnY;
	
	//index a envoyer pour recuper une "tile"
	private int[][] index;
	
	
	//======== CONSTRUCTEUR ===========
	
	public World(Game game, String path) {
		this.game = game;
		loadWorld(path);
	}
	
	// Fonction de maj et de rendu
	
	public void tick() {
		
	}
	
	public void render(Graphics g) {
		for (int j = 0; j < height; j++){
			for (int i =0; i < width; i++){
				getTile(i, j).render(g, (int)(i * Tile.TILEWIDTH - game.getGameCamera().getxOffset()),
						(int)(j * Tile.TILEHEIGHT - game.getGameCamera().getyOffset()));
			}
		}
	}
	
	// Fonction qui renvoi la tile indiquer en paramètre
	
	public Tile getTile(int x, int y){
		Tile t = Tile.tiles[index[x][y]];
		if(t == null)
			return Tile.videTile;
		return t;
	}
	
	private void loadWorld(String path){
		String file = Utils.loadFileAsString(path);
		String[] tokens = file.split("\\s+");
		width = Utils.parseInt(tokens[0]);
		height = Utils.parseInt(tokens[1]);
		spawnX = Utils.parseInt(tokens[2]);
		spawnY = Utils.parseInt(tokens[3]);
		
		index = new int[width][height];
		
		for(int j = 0; j < height; j++ ){
			for(int i = 0; i < width; i++ ){
				index[i][j] = Utils.parseInt(tokens[(i + j * width) + 4]);
			}
		}
		}
	}

