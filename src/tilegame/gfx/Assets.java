package tilegame.gfx;

import java.awt.image.BufferedImage;

//Cette classe à pour but de charger une seule fois tous les fichiers utilisé dans le jeu pour ne pas saturer la mémoire en opérations couteuse.

public class Assets {

	private static final int width = 30, height = 30;
	private static int indiceX = 0;

	private static int nbElement = 4;

	public static BufferedImage[] boule = new BufferedImage[6];
	public static BufferedImage vide;
	public static BufferedImage mur;
	public static BufferedImage limite;
	public static BufferedImage piege;

	public static void init() {
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/boule_mobile.jpg"));

		for (int i = 0; i < boule.length - 1; i++) {
			boule[i] = sheet.crop(indiceX, 0, width, height);
			indiceX += width;
		}
		indiceX = 0;

		for (int i = 0; i < nbElement; i++) {
			switch (i) {
			case 0:
				limite = sheet.crop(indiceX, 150, width, height);
				break;
			case 1:
				mur = sheet.crop(indiceX, 150, width, height);
				break;
			case 2:
				piege = sheet.crop(indiceX, 150, width, height);
				break;
			case 3:
				vide = sheet.crop(indiceX, 150, width, height);
				break;
			default:
				;
			}
			indiceX += width;
		}

	}
}
