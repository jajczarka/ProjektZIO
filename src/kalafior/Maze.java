package kalafior;

import javax.swing.*;

public class Maze {

	public Maze(){
	JFrame f = new JFrame();
	f.setTitle("Maze Game");
	f.add(new Board());
	f.setSize(464,485);
	f.setLocationRelativeTo(null);
	f.setVisible(true);
	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
