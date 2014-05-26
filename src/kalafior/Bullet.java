package kalafior;

import java.awt.Graphics;
import java.awt.Image;


public class Bullet extends GameObject {
	
	public int deltaX;

	public Bullet(int x, int y, int width, int height, Image img) {
		super(x, y, width, height, img);
		
	}

	@Override
	public void update() {
		
		x += deltaX;
		rect.x += deltaX;
		
		if(Schooter.getInstance().getPlayer1().rect.contains(this.rect)){
			//PlayerSh1
			Schooter.getInstance().getPlayer1().health--;
			
			removeBullet();
		}else if (Schooter.getInstance().getPlayer2().rect.contains(this.rect)){
			//PlayerSh2
			Schooter.getInstance().getPlayer2().health--;
			
			removeBullet();
		}
		
		if(deltaX > 0) { //gracz1 strzela
			if(x > Schooter.getInstance().getWidth() + 50){
				
				removeBullet();
			}
			
			
		}
		else if(deltaX < 0) { //gracz2 strzela
			if(x < -50){
				
				removeBullet();
			}
			
			
		}
	}

	@Override
	public void draw(Graphics g) {
		g.drawImage(img, x, y, width, height, null);
		
	}
	private void removeBullet(){
		Schooter.getInstance().getBullets().remove(this);
	}
	
	

}
