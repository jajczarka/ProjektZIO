import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.swing.JFrame;


public class Schooter extends Canvas implements Runnable, KeyListener {
    
	
	private static Schooter INSTANCE;
	private static final long serialVersionUID = 1L;
	private static final int WIDTH = 600;
	private static final int HEIGHT = 600;
	
	private Thread thread;
	private BufferStrategy bs = null;
	private Graphics graphics = null;

	private boolean running = false;
	
	private Player player1;
	private Player player2;
	private boolean gameOver = false;
	private int winner;
	
	
	private List<Bullet> bullets = new CopyOnWriteArrayList<Bullet>();
	
	public Schooter() {
		JFrame frame = new JFrame("Schooter");
		frame.setSize(WIDTH,HEIGHT);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setResizable(false);
	    
	    
	    //ustawienia
	    
	    new BasicCache();
	    
	    player1 = new Player(10, 150, 20, 90, BasicCache.player1);
	    player2 = new Player(570, 150, 20, 90, BasicCache.player2);
	    frame.add(this);
	    
	    thread = new Thread(this);
	    
	    
	    
	    frame.setVisible(true);
	    frame.addKeyListener(this);
        frame.requestFocus();
       
	}
	
	public void paint(Graphics g){
		
		if(bs == null){
			
			createBufferStrategy(2);
			bs = getBufferStrategy();
			graphics = bs.getDrawGraphics();
			
			thread.start();
			running =true;
		}
		
	}
	
	public void update(){
		if(!gameOver){
		player1.update();
		player2.update();
		for(Bullet bullet : bullets){
			bullet.update();
		}
		}
		if(player1.health <= 0){
			//gracz2 wygral
			winner =2;
			gameOver = true;
		}
		if(player2.health <= 0){
			//gracz1 wygral
			winner =1;
			gameOver = true;
		}
		
		
	}
	
	public void render(){
		graphics.clearRect(0, 0, WIDTH, HEIGHT);
		
		graphics.setColor(Color.black);
		graphics.fillRect(0, 0, WIDTH, HEIGHT);
		
	
		graphics.setColor(Color.red);
		graphics.drawString("Zdrowie: " +player1.health, 50, 50);
		graphics.drawString("Zdrowie: " +player2.health, 520, 50);
		
		graphics.drawString("Strzaly: " +bullets.size(), 300, 30);
		
		if(gameOver){
			graphics.drawString("Koniec Gry ", 250, 60);
			graphics.drawString("Gracz " +winner+ "wygral", 250, 75);
			
			graphics.drawString("Wcisnij Escape aby zresetowac gre", 250, 100);
		}
		
	
		
		player1.draw(graphics);
		player2.draw(graphics);
		
		for(Bullet bullet : bullets){
			bullet.draw(graphics);
		}
		
	}
	@Override
	public void run() {
		//Petla gry
		while(running){
			update();
			render();
			
			bs.show();
			
			Thread.currentThread();
			try {
				Thread.sleep(10);
				
			}catch(InterruptedException e){
				
			}
		}
		
	}
	
	public static void main(String[] args){
		INSTANCE = new Schooter();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(!gameOver){
			
			if(e.getKeyCode() == KeyEvent.VK_W){
				player1.up =true;
				
			}else if (e.getKeyCode() == KeyEvent.VK_S){
				player1.down =true;
				
			}
			
			if(e.getKeyCode()==KeyEvent.VK_UP){
				player2.up =true;
				
			}else if (e.getKeyCode() == KeyEvent.VK_DOWN){
				player2.down =true;
				
			}
		}else {
			//resetuj gre
			if(e.getKeyCode() == KeyEvent.VK_ESCAPE){
				resetGame();
				
			}
		}
		
		
		
		
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
		if(e.getKeyCode() == KeyEvent.VK_W){
			player1.up =false;
			
		}else if (e.getKeyCode() == KeyEvent.VK_S){
			player1.down =false;
			
		}
		
		if(e.getKeyCode()==KeyEvent.VK_UP){
			player2.up =false;
			
		}else if (e.getKeyCode() == KeyEvent.VK_DOWN){
			player2.down =false;
			
		}
		if(!gameOver){
		// lewy gracz
		if(e.getKeyCode()==KeyEvent.VK_SPACE){
			Bullet bullet = new Bullet(player1.x+player1.width, player1.y+player1.height/2, 4, 4,BasicCache.bullet);
			
			bullet.deltaX = 4;
			
			
			bullets.add(bullet);
		}
		
		// prawy gracz
				if(e.getKeyCode()==KeyEvent.VK_ENTER){
					Bullet bullet = new Bullet(player2.x-4, player2.y+player2.height/2, 4, 4,BasicCache.bullet);
					bullet.deltaX = -4;
					
					bullets.add(bullet);
				}
		}
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
		
	}
	private void resetGame(){
		player1.reset();
		player2.reset();
		
		bullets.clear();
		
		gameOver = false;
		
	}
	
	public Player getPlayer1(){
		
		return player1;
	}
	public Player getPlayer2(){
		return player2;
	}
	public List<Bullet> getBullets(){
		
		return bullets;
	}
public static Schooter getInstance(){
	return INSTANCE;
}
	
	
}
