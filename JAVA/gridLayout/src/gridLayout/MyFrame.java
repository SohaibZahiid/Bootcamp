package gridLayout;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MyFrame extends JFrame implements ActionListener {

	JButton bContacts, bMessages, bCallLog, bGames, bSettings, bApplications, bMusic, bGallery, bOrganiser;
	
	MyFrame() {
	
		bContacts = new JButton("Contacts");
		bContacts.addActionListener(this);
		
		bMessages = new JButton("Messages");
		bMessages.addActionListener(this);
		
		bCallLog = new JButton("Call Log");
		bCallLog.addActionListener(this);
		
		bGames = new JButton("Games");
		bGames.addActionListener(this);
		
		bSettings = new JButton("Settings");
		bSettings.addActionListener(this);
		
		bApplications = new JButton("Applications");
		bApplications.addActionListener(this);
		
		bMusic = new JButton("Music");
		bMusic.addActionListener(this);
		
		bGallery = new JButton("Gallery");
		bGallery.addActionListener(this);
		
		bOrganiser = new JButton("Organiser");
		bOrganiser.addActionListener(this);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500, 500);
		this.setVisible(true);

		this.setLayout(new GridLayout(3, 3));
		
		this.add(bContacts);
		this.add(bMessages);
		this.add(bCallLog);
		this.add(bGames);
		this.add(bSettings);
		this.add(bApplications);
		this.add(bMusic);
		this.add(bGallery);
		this.add(bOrganiser);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == bContacts) {
			System.out.println("Contacts");
		} 
		
		if(e.getSource() == bMessages) {
			System.out.println("Messages");
		} 
		
		if(e.getSource() == bCallLog) {
			System.out.println("Call Log");
		} 
		
		if(e.getSource() == bGames) {
			System.out.println("Games");
		} 
		
		if(e.getSource() == bSettings) {
			System.out.println("Settings");
		} 
		
		if(e.getSource() == bApplications) {
			System.out.println("Applications");
		} 
		
		if(e.getSource() == bMusic) {
			System.out.println("Music");
		} 
		
		if(e.getSource() == bMessages) {
			System.out.println("Messages");
		} 
		
		if(e.getSource() == bGallery) {
			System.out.println("Gallery");
		} 
		
		if(e.getSource() == bOrganiser) {
			System.out.println("Organiser");
		} 
	}

}
