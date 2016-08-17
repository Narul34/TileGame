package tilegame.gfx;

import java.awt.image.BufferedImage;

//Cette classe à pour but de charger une seule fois tous les fichiers utilisé dans le jeu pour ne pas saturer la mémoire en opérations couteuse.

public class Assets {

	// On a besoin d'une largeur et d'une hauteur fixe
	private static final int width = 30, height = 30;

	// Indice pour parcourir l'image a decouper
	private static int indiceX = 0;

	// nombre d'élément à afficher excepté la boule
	private static int nbElement = 4;

	// Tableau d'image pour la boule (6 imagesp our l'instant)
	public static BufferedImage[] boule = new BufferedImage[6];

	// les images des "tiles"
	public static BufferedImage vide;
	public static BufferedImage mur;
	public static BufferedImage limite;
	public static BufferedImage piege;

	
	public static void init() {
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/boule_mobile.jpg")); // on charge l'image dans un ojbet SpriteSheet

		// on découpe l'image pour la boule (premiere image a x=0 et y = 0
		for (int i = 0; i < boule.length; i++) {
			boule[i] = sheet.crop(indiceX, 0, width, height);
			indiceX += width;
		}
		indiceX = 0; // indice remis à 0 car les images des "tiles" commence en x =0 et y = 150

		// on decoupe l'image pour récupéré les "tiles" ou éléments
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
