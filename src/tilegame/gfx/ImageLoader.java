package tilegame.gfx;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

// Classe qui charge une image à partir de son adresse envoyer sous la forme d'un String

public class ImageLoader {

	public static BufferedImage loadImage(String path) {
		try {
			return ImageIO.read(ImageLoader.class.getResource(path));
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1); // si échec de chargement de l'image, on quitte le programme
		}
		return null;
	}
}
