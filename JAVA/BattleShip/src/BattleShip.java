import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class BattleShip implements ActionListener {

	JFrame frame;
	JPanel panel, leftPanel, bottomPanel;
	JLabel title, labels[], winOrLose;
	JButton buttons[][];
	ImageIcon icon;

	final String[] POSSIBLE = { "bomb", "water", "water", "water" };

	Random r = new Random();

	int totalBombs = 0, bombsFound = 0, totalShips = 0, shipsFound = 0;
	
	

	BattleShip() {

		frame = new JFrame("Battle Ship");

		panel = new JPanel();
		leftPanel = new JPanel();
		bottomPanel = new JPanel();

		title = new JLabel("Enemy Zone");
		title.setBounds(170, 30, 700, 20);

		labels = new JLabel[5];
		for (int i = 0; i < labels.length; i++) {
			labels[i] = new JLabel(String.valueOf(i + 1));
//			labels[i].setBounds(150, 70, 700, 20);
			leftPanel.add(labels[i]);
		}

		for (int i = 0; i < labels.length; i++) {
			labels[i] = new JLabel(String.valueOf(i + 1));
//			labels[i].setBounds(150, 70, 700, 20);
			bottomPanel.add(labels[i]);
		}
		
		winOrLose = new JLabel("", SwingConstants.CENTER);
		winOrLose.setBounds(0, 450, 700, 100);
		winOrLose.setFont(new Font("Ink Free", Font.BOLD, 74));
		winOrLose.setForeground(Color.GREEN);


		panel.setBounds(200, 60, 300, 300);
		panel.setLayout(new GridLayout(5, 5, 10, 10));

		leftPanel.setBounds(180, 60, 10, 300);
		leftPanel.setLayout(new GridLayout(5, 1, 10, 10));

		bottomPanel.setBounds(220, 370, 300, 10);
		bottomPanel.setLayout(new GridLayout(1, 5, 10, 10));

		buttons = new JButton[5][5];
		for (int i = 0; i < buttons.length; i++) {
			for (int j = 0; j < buttons[i].length; j++) {
				buttons[i][j] = new JButton();
				buttons[i][j].addActionListener(this);
				buttons[i][j].setName(POSSIBLE[r.nextInt(POSSIBLE.length)]);
				if (buttons[i][j].getName().equals("bomb")) {
					totalBombs++;
				} else {
					totalShips++;
				}
				panel.add(buttons[i][j]);

			}
		}

		frame.add(title);
		frame.add(panel);
		frame.add(leftPanel);
		frame.add(bottomPanel);
		frame.add(winOrLose);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(700, 800);
		frame.setLayout(null);
		frame.setVisible(true);

	}

	public static void main(String[] args) {
		new BattleShip();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	    for (int i = 0; i < buttons.length; i++) {
	        for (int j = 0; j < buttons[i].length; j++) {
	            if (e.getSource() == buttons[i][j]) {
	                if (bombsFound < totalBombs && shipsFound < totalShips) {
	                    System.out.println((i + 1) + ", " + (j + 1) + ": " + buttons[i][j].getName());
	                    buttons[i][j].setEnabled(false);
	                    if (buttons[i][j].getName().equals("bomb")) {
	                        bombsFound++;
	                        icon = new ImageIcon("bomb.png");
	                        Image resizedBomb = icon.getImage().getScaledInstance(buttons[i][j].getWidth(),
	                                buttons[i][j].getHeight(), 0);
	                        buttons[i][j].setIcon(new ImageIcon(resizedBomb));
	                    } else {
	                    	shipsFound++;
	                        icon = new ImageIcon("wave.png");
	                        Image resizedBomb = icon.getImage().getScaledInstance(buttons[i][j].getWidth(),
	                                buttons[i][j].getHeight(), 0);
	                        buttons[i][j].setIcon(new ImageIcon(resizedBomb));
	                    }
	                }
	                
	                if(bombsFound >= totalBombs) {
	                	System.out.println("Ship Sunken!!!");	
	                	winOrLose.setText("Ship Sunken!!!");
	                	winOrLose.setForeground(Color.RED);
	                }
	                
	                if (bombsFound < totalBombs && shipsFound == totalShips) {
	                    System.out.println("You Win!!!");
	                    winOrLose.setText("You Win!!!");
	                }
	            }
	        }
	    }
	}


}
