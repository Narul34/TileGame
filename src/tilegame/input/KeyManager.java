package tilegame.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

// Gestionnaire d'�v�nement clavier(ou Listener)

public class KeyManager implements KeyListener{

	// Tableau de bool�en pour les touches claviers
	
	private boolean[] keys;
	
	// Tableau de bool�en pour les directions du personnages
	public boolean up, down, left, right;
	
	/*========== Constructeur ===============
	 *
	 *On y declare 256 booleens pour pouvoir g�rer toutes les valeurs de la table Ascii ( en th�ories)
	 */
	public KeyManager() {
		keys = new boolean [256];
	}
	
	
	/* MAJ valeur du booleen de chaque direction, 
	 * les KeyEvent.VK_"X" correspondent � la touche test�e, cela sert d'indice �galement. 
	 * Si elle est enfonc�, le bool�en du tableau keys[KeyEvent.VK_"X"] passe vrai,
	 * et donc le bool�en associ�(up, down...) passe � vrai 
	 * 
	 */
	public void tick() {
		up = keys[KeyEvent.VK_Z];	
		down = keys[KeyEvent.VK_S];	
		left = keys[KeyEvent.VK_Q];	
		right = keys[KeyEvent.VK_D];	
	}
	
	// C'est grace aux deux fonction suivantes qu'on va changer les valeurs du tableau keys.
	@Override
	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
	}

	
	// Non utilis�
	@Override
	public void keyTyped(KeyEvent e) {
		
	}

}
