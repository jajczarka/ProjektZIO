package kalafior;

import java.awt.*;
import java.io.*;
import java.util.*;

import javax.swing.ImageIcon;

public class Map {
	
	private Scanner m;
	private String Map[]=new String[14];
	
	private Image grass, wall,finish;
	
	public Map(){
		
		ImageIcon img = new ImageIcon("tutorial//grass.png");
		grass = img.getImage();
		img = new ImageIcon("tutorial//wall.png");
		wall = img.getImage();
		img = new ImageIcon("tutorial//finish.png");
		finish = img.getImage();
		
		openFile();
		readFile();
		closeFile();
		
	}
	
	public Image getGrass(){
		return grass;
	}
	
	public Image getWall(){
		return wall;
	}
	
	public Image getFinish(){
		return finish;
	}
	
	public String getMap(int x, int y){
		String index = Map[y].substring(x, x+1);
		return index;
	}
	
	public void openFile(){
		
		try{
		m = new Scanner(new File("tutorial//Map.txt"));
		}catch(Exception e){
			System.out.println("error loading map");
		}
	}
	
	public void readFile(){
		
		while(m.hasNext()){
			for(int i= 0; i<14;i++){
				Map[i] = m.next();
			}
		}
		
	}

	public void closeFile(){
		
		m.close();
		
	}
	
}
