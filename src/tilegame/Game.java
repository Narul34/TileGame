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

//Runnable est une interface que l'ont DOIT utilisé si les instance de la classe concerné seront géré par des threads
public class Game implements Runnable{ 

	private Display display;	
	
	// on conserve en mémoire la taille de l'écran et son nom (voir constructeur)
	private int width, height;
	public String title;
	
	// booléen de boucle infinie
	private boolean running = false;
	
	// un thread est une partie du code exécuté comme un élément "indépendant", afin d'alléger l'utilisation de la mémoire
	// ( un programme a rarement besoin d'éxécuter l'ensemble de son code simultanément pour fonctionner)
	private Thread thread;
	
	// represente la manière dont sont utilisé les buffer pour l'affichage, plus simplement le nombre de buffer utilisé,
	// il vaut null si aucun buffer n'y a été déclarer.
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
	
	// Fonction qui déclare la fenetre, elle est appelé en premier dans la fonction "run"
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
	
	
	// Egalement appelé  update() == Met à jours les variables, objet, paramètres...
	private void tick() {
		
		keyManager.tick();
		if (State.getCurrentState() != null)
		{
			State.getCurrentState().tick();
		}
	}
	
	// affiche les éléments en fonction des maj faite par tick()
	private void render() {
		bs = display.getCanvas().getBufferStrategy();
		if(bs == null) {
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();
		
		// Clear screen
		// "nettoie" (reinitialise) l'écran dans son ensemble
		
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
	
	// fonction qui fait tourner le programme après appel de start()
	public void run() {
	
		init();
		
		int fps = 70;
		double timePerTick = 1000000000 / fps; // en nanoseconde
		double delta = 0; // valeur utilisé pour le rendu, on met a jour et on reaffiche seulement lorsqu'elle vaut 1 ou plus
		long now; // temps actuel
		long lastTime = System.nanoTime(); // dernier temps relevé
		long timer = 0; // le temps qui s'est ecoulé entre maintenant et le dernier temps relevé
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

	// Fonction qui démarre le programme SI il n'a pas déjà démarrer
	public synchronized void start() {
		if (running)
			return;
		running = true; // on change la valeur du booléen pour que la boucle infinie se lance
		thread = new Thread(this);
		thread.start(); // cette ligne appel la fonction run()
	}
	
	// Fonction qui arrete le programme si il est démarrer
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
