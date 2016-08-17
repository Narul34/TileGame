package tilegame.gfx;

import java.awt.image.BufferedImage;

// Classe qui permet d'enchainer les image pour créé une animation
public class Animation {

	/*
	 * Variables speed : vitesse d'affichage, index : parcours le tableau de
	 * personnage par exemple, lastTime: le dernier temps relevé, mis à jour à
	 * chaque affichage comme temps de référence timer : mesure du temps depuis
	 * le dernier temps mesuré(lastTime) frames[] : les images à afficher
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
