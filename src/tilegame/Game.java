package tilegame;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import tilegame.display.Display;
import tilegame.gfx.Assets;
import tilegame.gfx.GameCamera;
import tilegame.input.KeyManager;
import tilegame.state.GameState;
import tilegame.state.MenuState;
import tilegame.state.State;

//Runnable est une interface que l'ont DOIT utilis� si les instance de la classe concern� seront g�r� par des threads
public class Game implements Runnable{ 

	private Display display;	
	
	// on conserve en m�moire la taille de l'�cran et son nom (voir constructeur)
	private int width, height;
	public String title;
	
	// bool�en de boucle infinie
	private boolean running = false;
	
	// un thread est une partie du code ex�cut� comme un �l�ment "ind�pendant", afin d'all�ger l'utilisation de la m�moire
	// ( un programme a rarement besoin d'�x�cuter l'ensemble de son code simultan�ment pour fonctionner)
	private Thread thread;
	
	// represente la mani�re dont sont utilis� les buffer pour l'affichage, plus simplement le nombre de buffer utilis�,
	// il vaut null si aucun buffer n'y a �t� d�clarer.
	private BufferStrategy bs;
	private Graphics g;
	
	//States
	private State gameState;
	private State menuState;
	
	// input
	
	private KeyManager keyManager;
	
	// Camera
	private GameCamera gameCamera;
	
	//Handler
	private Handler handler;
	
	//=========CONSTRUCTOR============
	public Game(String title, int width, int height) {
		
		this.width = width;
		this.height = height;
		this.title = title;
		keyManager = new KeyManager();
	}
	
	// Fonction qui d�clare la fenetre, elle est appel� en premier dans la fonction "run"
	private void init() {
		display = new Display(title, width, height);
		display.getFrame().addKeyListener(keyManager);
		Assets.init();
		
		handler = new Handler(this);
		gameCamera = new GameCamera(handler, 0, 0);
		
		
		gameState = new GameState(handler);
		menuState = new MenuState(handler);
		State.setCurrentState(gameState);
	}
	
	
	// Egalement appel�  update() == Met � jours les variables, objet, param�tres...
	private void tick() {
		
		keyManager.tick();
		if (State.getCurrentState() != null)
		{
			State.getCurrentState().tick();
		}
	}
	
	// affiche les �l�ments en fonction des maj faite par tick()
	private void render() {
		bs = display.getCanvas().getBufferStrategy();
		if(bs == null) {
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();
		
		// Clear screen
		// "nettoie" (reinitialise) l'�cran dans son ensemble
		
		g.clearRect(0, 0, width, height); 
		
		//Draw
		// on dessine
		if (State.getCurrentState() != null)
		{
			State.getCurrentState().render(g);
		}		
		// End draw
		// fin du dessin
		
		// on montre les buffer
		bs.show();
		g.dispose();
	}
	
	// fonction qui fait tourner le programme apr�s appel de start()
	public void run() {
	
		init();
		
		int fps = 70;
		double timePerTick = 1000000000 / fps; // en nanoseconde
		double delta = 0; // valeur utilis� pour le rendu, on met a jour et on reaffiche seulement lorsqu'elle vaut 1 ou plus
		long now; // temps actuel
		long lastTime = System.nanoTime(); // dernier temps relev�
		long timer = 0; // le temps qui s'est ecoul� entre maintenant et le dernier temps relev�
		//int ticks = 0;
		
		while(running) {
			now = System.nanoTime();
			delta += (now - lastTime) / timePerTick;
			timer += now - lastTime;
			lastTime = now;
			
			if(delta >= 1) {
				tick();
				render();
				//ticks++;
				delta--;
			}
			if (timer >= 1000000000){
				//System.out.println("Ticks and Frames: " + ticks);
				//ticks = 0;
				timer = 0;
			}
			
		}
		
		stop();
	}
	
	
	//======= Accesseurs =========
	
	public KeyManager getKeyManager() {
		return keyManager;		
	}
	
	public GameCamera getGameCamera() {
		return gameCamera;
		
	}
	
	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	// Fonction qui d�marre le programme SI il n'a pas d�j� d�marrer
	public synchronized void start() {
		if (running)
			return;
		running = true; // on change la valeur du bool�en pour que la boucle infinie se lance
		thread = new Thread(this);
		thread.start(); // cette ligne appel la fonction run()
	}
	
	// Fonction qui arrete le programme si il est d�marrer
	public synchronized void stop() {
		if (!running)
			return;
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
}
