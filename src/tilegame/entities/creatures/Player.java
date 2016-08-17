package tilegame.entities.creatures;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import tilegame.Handler;
import tilegame.gfx.Animation;
import tilegame.gfx.Assets;

// Classe qui créé une entité "Joueur" ou personnage

public class Player extends Creature {

	// Objet de type Animation du déplacement vers le bas
	private Animation animDown;

	//=======Constructeur========
	public Player(Handler handler, float x, float y) {
		super(handler, x, y, Creature.DEFAULT_CREATURE_WIDHT, Creature.DEFAULT_CREATURE_HEIGHT);

		bounds.x = 5;
		bounds.y = 10;
		bounds.width = 20;
		bounds.height = 20;

		animDown = new Animation(50, Assets.boule);
	}
	
	// Fonction Maj  et rendu

	@Override
	public void tick() {
		animDown.tick();
		getInput();
		move();
		handler.getGameCamera().centerOnEntity(this);
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(getCurrentAnimationFrame(), (int) (x - handler.getGameCamera().getxOffset()),
				(int) (y - handler.getGameCamera().getyOffset()), width, height, null);
	}
	
	/* Fonction qui récupère la valeur des booléens généré par les entrées claviers et
	*modifit la variable speed dont la valeur est donnée au xMove et yMove
	*/
	private void getInput() {
		xMove = 0;
		yMove = 0;
		if (handler.getKeyManager().up)
			yMove = -speed;
		if (handler.getKeyManager().down)
			yMove = speed;
		if (handler.getKeyManager().left)
			xMove = -speed;
		if (handler.getKeyManager().right)
			xMove = speed;
	}

	//Fonction qui permet d'alterner entre les différents type d'animations possibles

	private BufferedImage getCurrentAnimationFrame() {
		// if(yMove > 0){
		return animDown.getCurrentFrame();
		/*
		 * }if (yMove< 0){ return animUp.getCurrentFrame();
		 *  .
		 *  . 
		 *  ect.....
		 */
	}

}
