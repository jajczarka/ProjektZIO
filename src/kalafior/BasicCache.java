package kalafior;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class BasicCache {
	
    private static final String IMAGE_DIR ="images/";
	public static Image player1;
	public static Image player2;
	public static Image bullet;
	
	public BasicCache(){
		load();
	}
	
	public void load(){
		player1 = loadImage("player1.png");
		player2 = loadImage("player2.png");
		bullet = loadImage("bullet.png");
		
	}
	
	private Image loadImage(String img){
		
		try {
			return ImageIO.read(new File(IMAGE_DIR + img));
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return null;
		
	}
}

