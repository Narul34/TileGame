package tilegame.gfx;

import java.awt.image.BufferedImage;

/* Cette classe permet de prendre une image et d'y appliquer une methode pour n'afficher que la partie voulue de cette image.
 * On a besoin d'une image et d'une fonction permettant de la découpé.
 */

public class SpriteSheet {
	
	private BufferedImage sheet;
	
	// ======= Constructeur ========
	
	public SpriteSheet(BufferedImage sheet) {
		this.sheet = sheet;
	}
	
	// Fonction qui permet de subdiviser une image en plusieurs plus petites
	
	public BufferedImage crop(int x, int y, int width, int height) {
		return sheet.getSubimage(x, y, width, height);	
	}

}
