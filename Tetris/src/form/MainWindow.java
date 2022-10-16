package form;

import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

/*
 * This window handles clicks, mouse events, timers and other window configuration
 */
public class MainWindow extends JFrame implements Runnable, KeyListener {

	private static final long serialVersionUID = 1L;
	private GameManager game;
	private boolean decorate = true;

	/* To learn about Delta Time
	    - https://dev.to/dsaghliani/understanding-delta-time-in-games-3olf
	    - https://gafferongames.com/post/fix_your_timestep/
	    - https://stackoverflow.com/questions/26838286/delta-time-getting-60-updates-a-second-in-java
	 */

	private final double FPS = 21D;
	private final double UPS = 60D;

	// nanoseconds
	private final double timeFps = 1000000000 / FPS;
	private final double timeUps = 1000000000 / UPS;
	
	private double deltaFps = 0, deltaUps = 0;
	private long initialTime = System.nanoTime();
	private boolean typeRight = false, typeLeft = false;

    public MainWindow() {
    	// #1: create instance of the game
    	this.game = new GameManager();

    	// #2: Define window
        this.setUndecorated(decorate);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);

        this.pack();
        this.setSize(Toolkit.getDefaultToolkit().getScreenSize());
        this.getContentPane().add(game);

        // #3: Add listeners
        this.addKeyListener(this);
        
        new Thread(this).start();
    }

	// Delta time: Tick
	@Override
	public void run() {
		while(true) {

			long currentTime = System.nanoTime();

	        this.deltaFps += (currentTime - this.initialTime) / this.timeFps;
	        this.deltaUps += (currentTime - this.initialTime) / this.timeUps;

	        this.initialTime = currentTime;

	        // Updates per second
		    if(this.deltaUps >= 1){
		    	if(typeLeft) {
		    		game.moveLeft();
		    	} 
		    	
		    	if(typeRight) {
		    		game.moveRight();
		    	}

		    	this.game.tick();
                this.deltaUps = 0;
		    }

		    // Frames per second
		    if(this.deltaFps >= 1){
		    	this.game.repaintGame();
		    	

		    	this.deltaFps = 0;
		    }
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_A){
			typeLeft = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_D) {
			typeRight = true;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_A){
			typeLeft = false;
			
		}
		if(e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_D) {
			typeRight = false;	
		}
		if(e.getKeyCode() == KeyEvent.VK_SPACE) {
			this.game.rotate();
		}
		if(e.getKeyCode() == KeyEvent.VK_P) {
			this.game.pauseOrResumeGame();
		}
		if(e.getKeyCode() == KeyEvent.VK_R) {
			this.game.resetGame();
		}
	}
}
