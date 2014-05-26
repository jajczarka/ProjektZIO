package kalafior;
import java.applet.Applet;
import java.awt.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class MainFrame  extends JFrame implements ActionListener{
	JButton ttt;
	JButton maze;
	JButton shooter;
	JButton guess;
	JButton tetris;
	JButton colour;
	
	public MainFrame() {
        super( "Wybierz gre" );
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 250);
        setLocation(50,50);
        setLayout(new GridLayout(2, 3));
//przyciski
        
        ttt = new JButton();
        ttt.addActionListener(this);
        ttt.setIcon(new ImageIcon("ttt.png"));
        add(ttt);
        
        maze = new JButton("Maze");
        maze.addActionListener(this);
        add(maze);
        
        shooter = new JButton("schotter");
        shooter.addActionListener(this);
        
        add(shooter);
        
        guess = new JButton("Gues");
        guess.addActionListener(this);
        add(guess);
        
        tetris = new JButton("Tetris");
        tetris.addActionListener(this);
        add(tetris);
        
        colour = new JButton("colour");
        colour.addActionListener(this);
        add(colour);
        
        
        setVisible(true);
        
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == ttt)
		{
			new Gra();
		}
		
		if(e.getSource() == guess)
		{
			new Guess();
		}
		
		if(e.getSource() == maze)
		{
		 new Maze();
		}
		
		if(e.getSource() == shooter)
		{
			new Schooter();
		}
		if(e.getSource() == tetris)
		{
			JOptionPane.showMessageDialog(null, "tetris", "tetris", JOptionPane.WARNING_MESSAGE);
			
		}
		if(e.getSource() == colour)
		{
			new Program();
		}
		
		
		
		}
		
		
		
	}
       
        
      
        

	

