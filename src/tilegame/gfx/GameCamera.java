package tilegame.gfx;

import tilegame.Handler;
import tilegame.entities.Entity;
import tilegame.tiles.Tile;

// Classe qui gere l'affichage d'une portion de du monde du jeu, autrement dit une camera.

public class GameCamera {

	
	private Handler handler;
	
	// Ces deux variables servent � d�terminer quelle partie on souhaite afficher
	
	private float xOffset, yOffset;
	
	
	//=========Constructeur=========
	
	public GameCamera (Handler handler,float xOffset, float yOffset){
		this.handler = handler;
		this.xOffset = xOffset;
		this.yOffset = yOffset;
	}
	
	/*Cette fonction v�rifit si une des cases(ou Tiles) est vide(blanche), et empeche le d�placement
	 * de la cam�ra pour ne pas les afficher
	 */
	
	public void checkBlankSpace() {
		// si le x de la cam�ra est inf�rieur � 0 (on sort de la carte par la gauche), on la remet � 0
		if (xOffset < 0) {
			xOffset = 0;
			
		//si la camera sort de la carte du jeu( par la droite), on la remet � sa coordonn�es maximum voulu
		}else if(xOffset > handler.getWorld().getWidth() * Tile.TILEWIDTH - handler.getWidth()){
			xOffset = handler.getWorld().getWidth() * Tile.TILEWIDTH - handler.getWidth();
		}
		
		// idem que pr�c�demment mais pour le haut et le bas
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
	
	//Fonction qui permet de centrer la cam�ra sur le joueur (hormis dans les cas de la fonction checkblankSpace)
	
	public void centerOnEntity (Entity e) {
		xOffset = e.getX() - handler.getWidth() / 2 + e.getWidth()/2; // coordonnees du personnage - largeur carte / 2 + largeur perso / 2
		yOffset = e.getY() - handler.getHeight() / 2 + e.getHeight()/2;
		checkBlankSpace();
	}
	
	// mouvement de la cam�ra
	public void move(float xAmt, float yAmt) {
		xOffset += xAmt;
		yOffset += yAmt;
		checkBlankSpace();
	}
}
