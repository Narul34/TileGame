package tilegame.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

// Gestionnaire d'évènement clavier(ou Listener)

public class KeyManager implements KeyListener{

	// Tableau de booléen pour les touches claviers
	
	private boolean[] keys;
	
	// Tableau de booléen pour les directions du personnages
	public boolean up, down, left, right;
	
	/*========== Constructeur ===============
	 *
	 *On y declare 256 booleens pour pouvoir gérer toutes les valeurs de la table Ascii ( en théories)
	 */
	public KeyManager() {
		keys = new boolean [256];
	}
	
	
	/* MAJ valeur du booleen de chaque direction, 
	 * les KeyEvent.VK_"X" correspondent à la touche testée, cela sert d'indice également. 
	 * Si elle est enfoncé, le booléen du tableau keys[KeyEvent.VK_"X"] passe vrai,
	 * et donc le booléen associé(up, down...) passe à vrai 
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

	
	// Non utilisé
	@Override
	public void keyTyped(KeyEvent e) {
		
	}

}
