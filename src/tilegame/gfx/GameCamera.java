package tilegame.gfx;

import tilegame.Handler;
import tilegame.entities.Entity;
import tilegame.tiles.Tile;

// Classe qui gere l'affichage d'une portion de du monde du jeu, autrement dit une camera.

public class GameCamera {

	
	private Handler handler;
	
	// Ces deux variables servent à déterminer quelle partie on souhaite afficher
	
	private float xOffset, yOffset;
	
	
	//=========Constructeur=========
	
	public GameCamera (Handler handler,float xOffset, float yOffset){
		this.handler = handler;
		this.xOffset = xOffset;
		this.yOffset = yOffset;
	}
	
	/*Cette fonction vérifit si une des cases(ou Tiles) est vide(blanche), et empeche le déplacement
	 * de la caméra pour ne pas les afficher
	 */
	
	public void checkBlankSpace() {
		// si le x de la caméra est inférieur à 0 (on sort de la carte par la gauche), on la remet à 0
		if (xOffset < 0) {
			xOffset = 0;
			
		//si la camera sort de la carte du jeu( par la droite), on la remet à sa coordonnées maximum voulu
		}else if(xOffset > handler.getWorld().getWidth() * Tile.TILEWIDTH - handler.getWidth()){
			xOffset = handler.getWorld().getWidth() * Tile.TILEWIDTH - handler.getWidth();
		}
		
		// idem que précédemment mais pour le haut et le bas
		if (yOffset < 0) {
			yOffset = 0;
		}else if (yOffset > handler.getWorld().getHeight() * Tile.TILEHEIGHT - handler.getHeight()){
			yOffset = handler.getWorld().getHeight() * Tile.TILEHEIGHT - handler.getHeight();
			
		}
	}

	// ========Accesseurs=========
	
	public float getxOffset() {
		return xOffset;
	}

	public void setxOffset(float xOffset) {
		this.xOffset = xOffset;
	}

	public float getyOffset() {
		return yOffset;
	}

	public void setyOffset(float yOffset) {
		this.yOffset = yOffset;
	}
	
	//Fonction qui permet de centrer la caméra sur le joueur (hormis dans les cas de la fonction checkblankSpace)
	
	public void centerOnEntity (Entity e) {
		xOffset = e.getX() - handler.getWidth() / 2 + e.getWidth()/2; // coordonnees du personnage - largeur carte / 2 + largeur perso / 2
		yOffset = e.getY() - handler.getHeight() / 2 + e.getHeight()/2;
		checkBlankSpace();
	}
	
	// mouvement de la caméra
	public void move(float xAmt, float yAmt) {
		xOffset += xAmt;
		yOffset += yAmt;
		checkBlankSpace();
	}
}
