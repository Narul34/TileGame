package tilegame.entities.creatures;

import tilegame.Handler;
import tilegame.entities.Entity;
import tilegame.tiles.Tile;


// Classe abstraite qui hérite de Entity, comprendra les ennemies et le joueur par exemple
public abstract class Creature extends Entity {

	// Constantes  : Santé, vitesse, largeur et hauteur par defaut
	public static final int DEFAULT_HEALTH = 10;
	public static final float DEFAULT_SPEED = 3.0f;
	public static final int DEFAULT_CREATURE_WIDHT = 30, DEFAULT_CREATURE_HEIGHT = 30;

	//Variables santé, vitesse, et valeurs à ajouter à x et y pour le déplacement
	protected int health;
	protected float speed;
	protected float xMove, yMove;

	//========Constructeur==============
	
	public Creature(Handler handler, float x, float y, int width, int height) {
		super(handler, x, y, width, height);
		health = DEFAULT_HEALTH;
		speed = DEFAULT_SPEED;
		xMove = 0;
		yMove = 0;
	}

	// Fonction de mouvement d'une creature
	public void move() {
		moveX();
		moveY();
	}

	// Fonction de variation de la position x avec gestion des collisions
	public void moveX() {

		if (xMove > 0) {

			int fuX = (int) (x + xMove + bounds.x + bounds.width) / Tile.TILEWIDTH;
			if (!collisionWithTile(fuX, (int) (y + bounds.y) / Tile.TILEHEIGHT)
					&& !collisionWithTile(fuX, (int) (y + bounds.y + bounds.height) / Tile.TILEHEIGHT)) {
				x += xMove;
			} else {
				x = fuX * Tile.TILEWIDTH - bounds.x - bounds.width - 1;
			}
		} else if (xMove < 0) {
			int fuX = (int) (x + xMove + bounds.x) / Tile.TILEWIDTH;
			if (!collisionWithTile(fuX, (int) (y + bounds.y) / Tile.TILEHEIGHT)
					&& !collisionWithTile(fuX, (int) (y + bounds.y + bounds.height) / Tile.TILEHEIGHT)) {
				x += xMove;
			} else {
				x = fuX * Tile.TILEWIDTH + Tile.TILEWIDTH - bounds.x;
			}
		}
	}

	// Fonction de variation de la position y avec gestion des collisions
	public void moveY() {
		if (yMove < 0) {
			int fuY = (int) (y + yMove + bounds.y) / Tile.TILEHEIGHT;
			if (!collisionWithTile((int) (x + bounds.x) / Tile.TILEWIDTH, fuY)
					&& !collisionWithTile((int) (x + bounds.x + bounds.width) / Tile.TILEWIDTH, fuY)) {
				y += yMove;
			} else {
				y = fuY * Tile.TILEHEIGHT + Tile.TILEHEIGHT - bounds.y;
			}

		} else if (yMove > 0) {
			int fuY = (int) (y + yMove + bounds.y + bounds.height) / Tile.TILEHEIGHT;
			if (!collisionWithTile((int) (x + bounds.x) / Tile.TILEWIDTH, fuY)
					&& !collisionWithTile((int) (x + bounds.x + bounds.width) / Tile.TILEWIDTH, fuY)) {
				y += yMove;
			} else {
				y = fuY * Tile.TILEHEIGHT - bounds.y - bounds.height -1;
			}
		}
	}

	// Fonction de collision, on test la valeur de la fonction isSolid qui renvoi un boolean.(voir Tile)
	protected boolean collisionWithTile(int x, int y) {
		return handler.getWorld().getTile(x, y).isSolid();
	}

	//==========ACCESSEURS============

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}

	public float getxMove() {
		return xMove;
	}

	public void setxMove(float xMove) {
		this.xMove = xMove;
	}

	public float getyMove() {
		return yMove;
	}

	public void setyMove(float yMove) {
		this.yMove = yMove;
	}

}
