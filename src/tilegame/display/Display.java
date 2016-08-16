package tilegame.display;

import java.awt.Canvas;
import java.awt.Dimension;
import javax.swing.JFrame;


// Classe de creation de fenetre
public class Display {

	private JFrame frame;
	
	// créer un composant personalisé, ici des notions de taille de fenetre.
	private Canvas canvas;
	
	private String title;
	private int width, height; // largeur et hauteur
	
	// =====CONSTRUCTOR============
	public Display(String title, int width, int height) {
		this.title = title;
		this.width = width;
		this.height = height;
		
		createDisplay();
	}
	
	//Createur de fenetre
	private void createDisplay() {
		frame = new JFrame(title); //paramètre le titre envoyer dans le constructeur
		frame.setSize(width,height);// pareil pour la largeur et la hauteur
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// fonction de fermeture prorpre OBLIGATOIRE
		frame.setResizable(false); // interdiction de redimensionnement de la fenetre
		frame.setLocationRelativeTo(null); // centrage de la fenetre sur l'écran
		frame.setVisible(true);// rendre la fenetre visible
		
		canvas = new Canvas();// nouveau canevas declaré : trois type de format de la fenetre
		canvas.setPreferredSize(new Dimension(width, height)); 
		canvas.setMaximumSize(new Dimension(width, height));
		canvas.setMinimumSize(new Dimension(width, height));
		canvas.setFocusable(false)
;		
		// On l'ajoute au frame
		frame.add(canvas);
		frame.pack();
	}

	public Canvas getCanvas() {
		return canvas;
	}
	
	public JFrame getFrame() {
		return frame;
		
	}
}
