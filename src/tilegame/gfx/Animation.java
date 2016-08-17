package tilegame.gfx;

import java.awt.image.BufferedImage;

// Classe qui permet d'enchainer les image pour cr�� une animation
public class Animation {

	/*
	 * Variables speed : vitesse d'affichage, index : parcours le tableau de
	 * personnage par exemple, lastTime: le dernier temps relev�, mis � jour �
	 * chaque affichage comme temps de r�f�rence timer : mesure du temps depuis
	 * le dernier temps mesur�(lastTime) frames[] : les images � afficher
	 */
	private int speed, index;
	private long lastTime, timer;
	private BufferedImage[] frames;

	// ============= Constructeur ============

	public Animation(int speed, BufferedImage[] frames) {
		this.speed = speed;
		this.frames = frames;
		index = 0;
		timer = 0;
		lastTime = System.currentTimeMillis();
	}

	// ==========Accesseur ===========

	public BufferedImage getCurrentFrame() {
		return frames[index];
	}

	// Fonction MAJ

	public void tick() {
		timer += System.currentTimeMillis() - lastTime;
		lastTime = System.currentTimeMillis();

		if (timer > speed) {
			index++;
			timer = 0;
			if (index >= frames.length) {
				index = 0;
			}
		}
	}
}
