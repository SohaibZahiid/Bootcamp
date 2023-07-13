import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
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
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;

public class BattleShip implements ActionListener {

	JFrame frame;
	JPanel panel, leftPanel, bottomPanel;
	JLabel title, labels[], winOrLose;
	JButton buttons[][];
	ImageIcon icon, background;
	static JProgressBar bar;

	final String[] POSSIBLE = { "bomb", "water", "water", "water" };

	int totalBombs = 0, bombsFound = 0, totalShips = 0, shipsFound = 0;
	int health = 100;

	Random r = new Random();

	BattleShip() {

		frame = new JFrame("Battle Ship");
		
		JPanel backgroundPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Load the background image
                ImageIcon backgroundImage = new ImageIcon("background.jpg");
                Image image = backgroundImage.getImage();

                // Draw the image as the background
                g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
            }
        };
        
        backgroundPanel.setLayout(null);

		panel = new JPanel();
		leftPanel = new JPanel();
		bottomPanel = new JPanel();

		bar = new JProgressBar(0);
		bar.setValue(health);
		bar.setBounds(280, 10, 150, 20);
		bar.setStringPainted(true);

		title = new JLabel("Enemy Zone");
		title.setBounds(170, 50, 700, 20);
		title.setForeground(Color.WHITE);
		title.setFont(new Font(null, Font.BOLD, 14));

		labels = new JLabel[5];
		for (int i = 0; i < labels.length; i++) {
			labels[i] = new JLabel(String.valueOf(i + 1));
//			labels[i].setBounds(150, 70, 700, 20);
			labels[i].setForeground(Color.WHITE);
			labels[i].setFont(new Font(null, Font.BOLD, 14));
			leftPanel.add(labels[i]);
		}

		for (int i = 0; i < labels.length; i++) {
			labels[i] = new JLabel(String.valueOf(i + 1));
//			labels[i].setBounds(150, 70, 700, 20);
			labels[i].setForeground(Color.WHITE);
			labels[i].setFont(new Font(null, Font.BOLD, 14));
			bottomPanel.add(labels[i]);
		}

		winOrLose = new JLabel("", SwingConstants.CENTER);
		winOrLose.setBounds(0, 450, 700, 100);
		winOrLose.setFont(new Font("Ink Free", Font.BOLD, 74));
		winOrLose.setForeground(Color.GREEN);

		panel.setBounds(200, 80, 300, 300);
		panel.setLayout(new GridLayout(5, 5, 10, 10));
		panel.setOpaque(false);

		leftPanel.setBounds(180, 80, 10, 300);
		leftPanel.setLayout(new GridLayout(5, 1, 10, 10));
		leftPanel.setOpaque(false);

		bottomPanel.setBounds(220, 390, 300, 10);
		bottomPanel.setLayout(new GridLayout(1, 5, 10, 10));
		bottomPanel.setOpaque(false);

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
		
		backgroundPanel.add(bar);
        backgroundPanel.add(title);
        backgroundPanel.add(panel);
        backgroundPanel.add(leftPanel);
        backgroundPanel.add(bottomPanel);
        backgroundPanel.add(winOrLose);

        // Set the background panel as the content pane of the frame
        frame.setContentPane(backgroundPanel);

		frame.add(bar);
		frame.add(title);
		frame.add(panel);
		frame.add(leftPanel);
		frame.add(bottomPanel);
		frame.add(winOrLose);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(700, 700);
		frame.setResizable(false);
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
					if (health >= 0 && bombsFound < totalBombs && shipsFound < totalShips) {
						System.out.println((i + 1) + ", " + (j + 1) + ": " + buttons[i][j].getName());
//		                    buttons[i][j].setEnabled(false);
						buttons[i][j].removeActionListener(this);
						if (buttons[i][j].getName().equals("bomb")) {
							bombsFound++;
							int bombDecrement = 100 / totalBombs;
	                        health = 100 - (bombsFound * bombDecrement);
							bar.setValue(health);
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

					if (bombsFound >= totalBombs) {
						System.out.println("Ship Sunken!!!");
						winOrLose.setText("Ship Sunken!!!");
						winOrLose.setForeground(Color.RED);
						bar.setValue(0);
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
