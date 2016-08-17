package tilegame.entities;

import java.awt.Graphics;
import java.awt.Rectangle;

import tilegame.Handler;

// CLasse abstraites dont vont hérité toutes les entités du jeu (créature, ennemis, pnj...)
public abstract class Entity {

	protected Handler handler;
	protected float x, y;
	protected int width, height;
	
	// Cette variable rectangle sert à déclarer la collisionBox de l'entité (qui ne sera pas tjr représentative de sa forme
	protected Rectangle bounds;
	
	//==========Constructeur ============
	
	public Entity(Handler handler, float x, float y, int width, int height) {
		this.handler = handler;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		
		bounds = new Rectangle(0, 0, width, height);
	}
	
	// Fonction maj et rendu
	
	public abstract void tick();
	
	public abstract void render(Graphics g);
	
	// ==========Accesseurs============
	
	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

}
