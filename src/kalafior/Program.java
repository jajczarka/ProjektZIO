package kalafior;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class Program {
public static int[][] board;
public static JButton[][] fields;
public static int player = 1;

public Program() {
	board = new int[20][20];
	fields = new JButton[20][20];
	JFrame myFrame = new JFrame("COLORS");
	myFrame.setSize(700, 800);
	myFrame.setLayout(new FlowLayout());
	myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	JPanel p1 = new JPanel();
	p1.setLayout(new GridLayout(20,20));
	p1.setSize(700, 700);
	JPanel p2 = new JPanel();
	
	for(int i = 0;i<20;i++){
        
		for(int j=0;j<20;j++){
        JButton field = new JButton();
        field.setName("" + (i*20+j));
        fields[i][j] = field;
        field.addActionListener(new Listner());
        p1.add(field);
        }
       }
	myFrame.add(p1);
	JButton field = new JButton();
	field.addActionListener(new Listner());
	field.setText("Pass");
	field.setName("" + 100);
	p2.add(field);
	initialization();
	myFrame.add(p2);
	myFrame.setVisible(true);
	
	
	 

}
private static void initialization(){
	Random rnd = new Random();
	int x,y;
	x=rnd.nextInt(20);
	y=rnd.nextInt(20);
	Program.fields[x][y].setBackground(Color.RED);
	Program.fields[x][y].setEnabled(false);
	Program.board[x][y] = 1;
	
	x=rnd.nextInt(20);
	y=rnd.nextInt(20);
	Program.fields[x][y].setBackground(Color.GREEN);
	Program.fields[x][y].setEnabled(false);
	Program.board[x][y] = 2;
}
	

	

}
