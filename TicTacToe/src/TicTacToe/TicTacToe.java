package TicTacToe;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;


public class TicTacToe implements ActionListener{

	Random random = new Random();
	JFrame frame = new JFrame();
	JPanel title_panel = new JPanel();
	JPanel button_panel = new JPanel();

	JLabel textfield = new JLabel();
	JButton[] buttons = new JButton[9];
	boolean player1_turn;

	TicTacToe() {
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400,400);
		frame.getContentPane().setBackground(new Color(50,50,50));
		frame.setLayout(new BorderLayout());
		frame.setVisible(true);
		
		textfield.setBackground(new Color(38,38,38));
		textfield.setForeground(Color.WHITE);
		textfield.setFont(new Font("sans-serif",Font.BOLD,55));
		textfield.setHorizontalAlignment(JLabel.CENTER);
		textfield.setText("Tic-Tac-Toe");
		textfield.setOpaque(true);
		
		title_panel.setLayout(new BorderLayout());
		title_panel.setBounds(0,0,800,100);
		
		button_panel.setLayout(new GridLayout(4,3));
		button_panel.setBackground(new Color(150,150,150));
		
		
		for(int i=0;i<9;i++) {
			buttons[i] = new JButton();
			buttons[i].setBackground(new Color(38,38,38));
			button_panel.add(buttons[i]);
			buttons[i].setFont(new Font("sans-serif",Font.BOLD,60));
			buttons[i].setFocusable(false);
			buttons[i].addActionListener(this);
		}
		JButton reset = new JButton("Reset");
		JButton exit = new JButton("Exit");
		
		reset.setForeground(new Color(158,0,0));
		reset.setBackground(Color.BLACK);
		reset.setFont(new Font("sans-serif",Font.BOLD,30));
	
		
		exit.setForeground(new Color(158,0,0));
		exit.setBackground(Color.BLACK);
		exit.setFont(new Font("sans-serif",Font.BOLD,30));
		
		button_panel.add(reset);
		button_panel.add(exit);
		
		reset.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){  
		       for(int i=0; i<9; i++) {
		    	   buttons[i].setText("");
		    	   buttons[i].setEnabled(true);
		    	   buttons[i].setBackground(new Color(38,38,38));
		    	  }
		       firstTurn();
			}  
			});  
		
		exit.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){  
				System.exit(0);
			}  
			}); 
		
		title_panel.add(textfield);
		frame.add(title_panel,BorderLayout.NORTH);
		frame.add(button_panel);
		
		firstTurn();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		for(int i=0;i<9;i++) {
			if(e.getSource()==buttons[i]) {
				if(player1_turn) {
					if(buttons[i].getText()=="") {
						buttons[i].setForeground(Color.WHITE);
						buttons[i].setText("X");
						player1_turn=false;
						textfield.setText("O turn");
						check();
					}
				}
				else {
					if(buttons[i].getText()=="") {
						buttons[i].setForeground(Color.WHITE);
						buttons[i].setText("O");
						player1_turn=true;
						textfield.setText("X turn");
						check();
					}
				}
			}			
		}

	}
	
	public void firstTurn() {
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(random.nextInt(2)==0) {
			player1_turn=true;
			textfield.setText("X turn");
		}
		else {
			player1_turn=false;
			textfield.setText("O turn");
		}
	}
	
	public void check() {
		//check X win conditions
		if(
				(buttons[0].getText()=="X") &&
				(buttons[1].getText()=="X") &&
				(buttons[2].getText()=="X")
				) {
			xWins(0,1,2);
		}
		if(
				(buttons[3].getText()=="X") &&
				(buttons[4].getText()=="X") &&
				(buttons[5].getText()=="X")
				) {
			xWins(3,4,5);
		}
		if(
				(buttons[6].getText()=="X") &&
				(buttons[7].getText()=="X") &&
				(buttons[8].getText()=="X")
				) {
			xWins(6,7,8);
		}
		if(
				(buttons[0].getText()=="X") &&
				(buttons[3].getText()=="X") &&
				(buttons[6].getText()=="X")
				) {
			xWins(0,3,6);
		}
		if(
				(buttons[1].getText()=="X") &&
				(buttons[4].getText()=="X") &&
				(buttons[7].getText()=="X")
				) {
			xWins(1,4,7);
		}
		if(
				(buttons[2].getText()=="X") &&
				(buttons[5].getText()=="X") &&
				(buttons[8].getText()=="X")
				) {
			xWins(2,5,8);
		}
		if(
				(buttons[0].getText()=="X") &&
				(buttons[4].getText()=="X") &&
				(buttons[8].getText()=="X")
				) {
			xWins(0,4,8);
		}
		if(
				(buttons[2].getText()=="X") &&
				(buttons[4].getText()=="X") &&
				(buttons[6].getText()=="X")
				) {
			xWins(2,4,6);
		}
		//check O win conditions
		if(
				(buttons[0].getText()=="O") &&
				(buttons[1].getText()=="O") &&
				(buttons[2].getText()=="O")
				) {
			oWins(0,1,2);
		}
		if(
				(buttons[3].getText()=="O") &&
				(buttons[4].getText()=="O") &&
				(buttons[5].getText()=="O")
				) {
			oWins(3,4,5);
		}
		if(
				(buttons[6].getText()=="O") &&
				(buttons[7].getText()=="O") &&
				(buttons[8].getText()=="O")
				) {
			oWins(6,7,8);
		}
		if(
				(buttons[0].getText()=="O") &&
				(buttons[3].getText()=="O") &&
				(buttons[6].getText()=="O")
				) {
			oWins(0,3,6);
		}
		if(
				(buttons[1].getText()=="O") &&
				(buttons[4].getText()=="O") &&
				(buttons[7].getText()=="O")
				) {
			oWins(1,4,7);
		}
		if(
				(buttons[2].getText()=="O") &&
				(buttons[5].getText()=="O") &&
				(buttons[8].getText()=="O")
				) {
			oWins(2,5,8);
		}
		if(
				(buttons[0].getText()=="O") &&
				(buttons[4].getText()=="O") &&
				(buttons[8].getText()=="O")
				) {
			oWins(0,4,8);
		}
		if(
				(buttons[2].getText()=="O") &&
				(buttons[4].getText()=="O") &&
				(buttons[6].getText()=="O")
				) {
			oWins(2,4,6);
		}
		 else {
			   
			   int checkTie = 0;
			   for(JButton i : buttons) {
			    if(i.getText()=="O" || i.getText()=="X") {
			     checkTie++; 
			    }
			    if(checkTie==9) {
			     tie();
			     System.out.println("tie");
			    }
			   }
			  }

			 }
			 public void tie() {
			  textfield.setText("It's a tie");
			 }
	
	
	public void xWins(int a,int b,int c) {
		buttons[a].setBackground(Color.GREEN);
		buttons[b].setBackground(Color.GREEN);
		buttons[c].setBackground(Color.GREEN);
		
		for(int i=0;i<9;i++) {
			buttons[i].setEnabled(false);
		}
		textfield.setText("X wins");
	}
	public void oWins(int a,int b,int c) {
		buttons[a].setBackground(Color.GREEN);
		buttons[b].setBackground(Color.GREEN);
		buttons[c].setBackground(Color.GREEN);
		
		for(int i=0;i<9;i++) {
			buttons[i].setEnabled(false);
		}
		textfield.setText("O wins");
	}
}