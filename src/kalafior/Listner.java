package kalafior;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;


public class Listner implements ActionListener {
public int check(){
	int tmp=1;
	int a = 0,b=0;
	for(int i=0;i<20;i++){
		for(int j=0;j<20;j++){
			tmp=tmp*Program.board[i][j];
			if(Program.board[i][j] == 1) a++;
			else if(Program.board[i][j] == 2) b++;
		}
	}
if(tmp==0) return 0;
else{
	if(a>b) return 1;
	else return 2;
}
}

	public void actionPerformed(ActionEvent e) {
		JButton field = (JButton)e.getSource();
		int name = Integer.parseInt(field.getName());

		int x = name/20;
		int y = name%20;
		if(name != 100){
		if(Program.player == 1){
			
		if(Program.board[x][y-1] == 1 || Program.board[x][y+1] == 1 || Program.board[x+1][y] == 1 || Program.board[x-1][y] == 1){
		Program.fields[x][y].setBackground(Color.RED);
		Program.fields[x][y].setEnabled(false);
		Program.board[x][y] = 1;
		Program.player = 2;}
		else{
			JOptionPane.showMessageDialog(null, "WRONG MOVE !!!");
		}
		}
		else{
			if(Program.board[x][y-1] == 2 || Program.board[x][y+1] == 2 || Program.board[x+1][y] == 2 || Program.board[x-1][y] == 2){
			Program.fields[x][y].setBackground(Color.GREEN);
			Program.fields[x][y].setEnabled(false);
			Program.board[x][y] = 2;
			if(check() == 0) Program.player = 1;
			else {
			if(check()==1) JOptionPane.showMessageDialog(null, "RED WINS !!!");	
			else  JOptionPane.showMessageDialog(null, "GREEN WINS !!!");
			}
			}
			else{
				JOptionPane.showMessageDialog(null, "WRONG MOVE !!!");
			}
		}
		}
		else{
			if(Program.player == 1) Program.player = 2;
			else Program.player = 1;
		}

	}

}
