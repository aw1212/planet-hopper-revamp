package com.alex.game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener; 

/**              
* This class is the Visual Interface class of the 'Planet Hopper' 
* This class incorporates a GUI into the game, making the game-play
* it more fun and enjoyable!
* 
* @author Alex Williams-Bellotti
* @version 2013.01.07
* 
*/
public class VisualInterface extends JFrame{
	
	private JLabel titleBar;
	private JButton newGame;
	private JButton about;
	private JButton rules;
	private Game game;
	
	public VisualInterface(Game game) {
		
		super("PLANET HOPPER");
		
		this.game=game;

		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(700, 700);
		setLayout(new BorderLayout());
		setResizable(false);

		JPanel p = new JPanel(new BorderLayout());
			
		Painting panel = new Painting(game);
		
		titleBar = new JLabel("Planet Hopper Adventure Game!");
		titleBar.setToolTipText("By Alex Williams-Bellotti, 2012");
		titleBar.setHorizontalAlignment(SwingConstants.CENTER);
		titleBar.setBackground(Color.PINK);
		p.add(titleBar, BorderLayout.NORTH);
		
		p.add(panel, BorderLayout.CENTER);
		
		newGame = new JButton("NEW GAME");
		p.add(newGame, BorderLayout.SOUTH);
		
		about = new JButton("ABOUT");
		p.add(about, BorderLayout.WEST);
		
		rules = new JButton("RULES");
		p.add(rules, BorderLayout.EAST);
		
		add(p);

		thehandler handler = new thehandler(game);

		about.addActionListener(handler);
		rules.addActionListener(handler);
		newGame.addActionListener(handler);
	} 
	
	private class thehandler implements ActionListener{
		
		private Game game;
		
		public thehandler(Game game)
		{
			this.game=game;
			
		}
		
		public void actionPerformed(ActionEvent event) {
			
			String string = "";			
			
			if(event.getSource() == about)
			{
				string = String.format("About: %s", "Alex the awesomeness made this game in 2012-2013. " +
						"It is based on a text-version she wrote in 2012.");
				JOptionPane.showMessageDialog(null, string);
			}
			else if (event.getSource() == rules)
			{
				string = String.format("How to Play: %s", "You are searching the Universe for an amulet. Your home planet " +
						"\n is in grave danger without it. \n Press the button that refers to the direction you would like to go in" +
						"\n or the action you would like to take. Good luck!" );
				JOptionPane.showMessageDialog(null, string);
			}
			else if (event.getSource() == newGame)
			{
				string = String.format("To start the game: %s", "Start by pressing the direction button to move the ship");
				JOptionPane.showMessageDialog(null,string);
			}
		}
	}
}
