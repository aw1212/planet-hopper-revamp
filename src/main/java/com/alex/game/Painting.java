package com.alex.game;

import javax.swing.*; 
import java.awt.event.*;
import java.awt.*;

/**              
* This class is the Painting class of the 'Planet Hopper' 
* This class designs the panels that
* get placed into the center of the GUI
* 
* @author Alex Williams-Bellotti
* @version 2013.01.07
* 
*/

public class Painting extends JPanel{

	int x = 0;

	private JPanel subpanel;
	private JPanel sub2;
	private JButton west;
	private JButton east;
	private JButton south;
	private JButton north;
	private JButton down;
	private JButton up;
	private JButton wormhole;
	private JButton look;
	private JButton examine;
	private Game game;
	private JTextArea text;

	public Painting(Game game) {
		
		this.game = game;

		setLayout(new BorderLayout(1,1));
		setBackground(Color.BLUE);
		event e = new event();
		addMouseListener(e);
				
		subpanel = new JPanel();
		sub2 = new JPanel();
		
		west = new JButton("WEST");
		east = new JButton("EAST");
		north = new JButton("NORTH");
		south = new JButton("SOUTH");
		down = new JButton("DOWN");
		up = new JButton("UP");
		wormhole = new JButton("WORMHOLE");
		look = new JButton("LOOK");
		examine = new JButton("EXAMINE");
		
		text = new JTextArea(game.currentRoom.getLongDescription());
		text.setEditable(false);
		text.setFont(new Font("Verdana", Font.BOLD, 12));
		add(text, BorderLayout.NORTH);
				
		subpanel.add(west);
		subpanel.add(east);
		subpanel.add(north);
		subpanel.add(south);
		subpanel.add(down);
		subpanel.add(up);
		subpanel.add(wormhole);
		
		sub2.add(look);
		sub2.add(examine);
		
		add(subpanel, BorderLayout.SOUTH);
		add(sub2, BorderLayout.EAST);
			
		thehandler handler = new thehandler(game);
		south.addActionListener(handler);
		north.addActionListener(handler);
		east.addActionListener(handler);
		west.addActionListener(handler);
		down.addActionListener(handler);
		up.addActionListener(handler);
		wormhole.addActionListener(handler);
		look.addActionListener(handler);
		examine.addActionListener(handler);
	
	}
	
	public void paintComponent(Graphics g) 
	{
		super.paintComponent(g);
		
		Polygon p = new Polygon();
		p.addPoint(80,500);
		p.addPoint(110,520);
		p.addPoint(110,480);
		
		Polygon v = new Polygon();
		v.addPoint(200, 480);
		v.addPoint(215, 520);
		v.addPoint(230, 480);
		
		Polygon z = new Polygon();
		z.addPoint(290, 520);
		z.addPoint(305, 480);
		z.addPoint(320, 520);
		
		Polygon q = new Polygon();
		q.addPoint(410, 520);
		q.addPoint(410, 480);
		q.addPoint(440, 500);
		
		g.setColor(Color.GREEN);
		g.fillOval(220, 100, 80, 140);
				
		g.setColor(Color.BLACK);
		g.fillOval(220, 120, 30, 70);
		g.fillOval(270, 120, 30, 70);
		
		g.setColor(Color.MAGENTA);
		g.drawString("PLANET HOPPER", 220, 80);
			
		g.setColor(Color.LIGHT_GRAY);
		g.fillPolygon(p);
		g.fillPolygon(z);

		g.setColor(Color.DARK_GRAY);
		g.fillPolygon(v);
		g.fillPolygon(q);
			
		if (game.currentRoom == game.near_venus) {
			setBackground(Color.BLACK);
			g.setColor(Color.BLACK);
			g.fillOval(220, 100, 80, 140);
			g.setColor(Color.ORANGE);
			g.fillOval(50, 50, 100, 100);
			south.setEnabled(false);
			west.setEnabled(true);
			east.setEnabled(true);
			down.setEnabled(true);
			north.setEnabled(true);
			up.setEnabled(false);
			wormhole.setEnabled(false);
			look.setVisible(false);
			examine.setVisible(false);
		}
		else if (game.currentRoom == game.venus) {
			setBackground(Color.ORANGE);
			g.setColor(Color.ORANGE);
			g.fillOval(220, 100, 80, 140);
			g.fillOval(50, 50, 100, 100);
			g.fillOval(220, 120, 30, 70);
			g.fillOval(270, 120, 30, 70);
			g.setColor(Color.WHITE);
			g.fillRect(30, 100, 200, 300);
			g.setColor(Color.BLACK);
			g.drawString("LETTER", 40, 110);
			g.drawString("????", 50, 140);
			south.setEnabled(false);
			west.setEnabled(false);
			east.setEnabled(false);
			down.setEnabled(false);
			north.setEnabled(false);
			up.setEnabled(true);
			wormhole.setEnabled(false);
			look.setVisible(true);
			examine.setVisible(true);
		}
		else if (game.currentRoom == game.sun) {
			setBackground(Color.YELLOW);
			g.setColor(Color.YELLOW);
			g.fillOval(220, 100, 80, 140);
			g.fillOval(50, 50, 100, 100);
			g.fillOval(220, 120, 30, 70);
			g.fillOval(270, 120, 30, 70);
			south.setEnabled(false);
			west.setEnabled(false);
			east.setEnabled(true);
			down.setEnabled(false);
			north.setEnabled(false);
			up.setEnabled(false);
			wormhole.setEnabled(true);
			look.setVisible(false);
			examine.setVisible(false);
		}
		else if (game.currentRoom == game.near_mercury) {
			setBackground(Color.BLACK);
			g.setColor(Color.BLACK);
			g.fillOval(220, 100, 80, 140);
			g.fillOval(220, 120, 30, 70);
			g.fillOval(270, 120, 30, 70);
			g.setColor(Color.PINK);
			g.fillOval(50, 50, 100, 100);
			south.setEnabled(false);
			west.setEnabled(true);
			east.setEnabled(true);
			down.setEnabled(true);
			north.setEnabled(false);
			up.setEnabled(false);
			wormhole.setEnabled(false);
			look.setVisible(false);
			examine.setVisible(false);
		}
		else if (game.currentRoom == game.mercury) {
			setBackground(Color.PINK);
			g.setColor(Color.PINK);
			g.fillOval(220, 100, 80, 140);
			g.fillOval(220, 120, 30, 70);
			g.fillOval(270, 120, 30, 70);
			g.fillOval(50, 50, 100, 100);
			south.setEnabled(false);
			west.setEnabled(false);
			east.setEnabled(false);
			down.setEnabled(false);
			north.setEnabled(false);
			up.setEnabled(true);
			wormhole.setEnabled(false);
			look.setVisible(false);
			examine.setVisible(false);
		}
		else if (game.currentRoom == game.near_earth) {
			setBackground(Color.BLACK);
			g.setColor(Color.BLACK);
			g.fillOval(220, 100, 80, 140);
			g.fillOval(220, 120, 30, 70);
			g.fillOval(270, 120, 30, 70);
			g.setColor(Color.BLUE);
			g.fillOval(50, 50, 100, 100);
			south.setEnabled(false);
			west.setEnabled(true);
			east.setEnabled(true);
			down.setEnabled(true);
			north.setEnabled(true);
			up.setEnabled(false);
			wormhole.setEnabled(false);
			look.setVisible(false);
			examine.setVisible(false);
		}
		else if (game.currentRoom == game.earth) {
			setBackground(Color.BLUE);
			g.setColor(Color.BLUE);
			g.fillOval(220, 100, 80, 140);
			g.fillOval(50, 50, 100, 100);
			g.fillOval(220, 120, 30, 70);
			g.fillOval(270, 120, 30, 70);
			south.setEnabled(false);
			west.setEnabled(false);
			east.setEnabled(false);
			down.setEnabled(false);
			north.setEnabled(false);
			up.setEnabled(true);		
			wormhole.setEnabled(false);
			look.setVisible(false);
			examine.setVisible(false);
		}
		else if (game.currentRoom == game.moon) {
			setBackground(Color.GRAY);
			g.setColor(Color.GRAY);
			g.fillOval(220, 100, 80, 140);
			g.fillOval(50, 50, 100, 100);
			g.fillOval(220, 120, 30, 70);
			g.fillOval(270, 120, 30, 70);
			south.setEnabled(true);
			west.setEnabled(false);
			east.setEnabled(false);
			down.setEnabled(false);
			north.setEnabled(false);
			up.setEnabled(false);		
			wormhole.setEnabled(false);
			look.setVisible(false);
			examine.setVisible(false);
		}
		else if (game.currentRoom == game.near_mars) {
			setBackground(Color.BLACK);
			g.setColor(Color.BLACK);
			g.fillOval(220, 100, 80, 140);
			g.fillOval(220, 120, 30, 70);
			g.fillOval(270, 120, 30, 70);
			g.setColor(Color.RED);
			g.fillOval(50, 50, 100, 100);
			south.setEnabled(false);
			west.setEnabled(true);
			east.setEnabled(true);
			down.setEnabled(true);
			north.setEnabled(false);
			up.setEnabled(false);
			wormhole.setEnabled(false);
			look.setVisible(false);
			examine.setVisible(false);
		}
		else if (game.currentRoom == game.mars) {
			setBackground(Color.RED);
			g.setColor(Color.RED);
			g.fillOval(220, 100, 80, 140);
			g.fillOval(50, 50, 100, 100);
			g.fillOval(220, 120, 30, 70);
			g.fillOval(270, 120, 30, 70);
			g.setColor(Color.LIGHT_GRAY);
			g.fillRect(30, 100, 200, 200);
			g.setColor(Color.BLACK);
			g.drawString("TRATSER DNA ENIMAXE", 50, 140);
			south.setEnabled(false);
			west.setEnabled(false);
			east.setEnabled(false);
			down.setEnabled(false);
			north.setEnabled(false);
			up.setEnabled(true);	
			wormhole.setEnabled(false);
			look.setVisible(true);
			examine.setVisible(true);
		}		
		else if (game.currentRoom == game.near_jupiter) {
			setBackground(Color.BLACK);
			g.setColor(Color.BLACK);
			g.fillOval(220, 100, 80, 140);
			g.fillOval(220, 120, 30, 70);
			g.fillOval(270, 120, 30, 70);
			g.setColor(Color.GREEN);
			g.fillOval(50, 50, 100, 100);
			south.setEnabled(false);
			west.setEnabled(true);
			east.setEnabled(true);
			down.setEnabled(true);
			north.setEnabled(false);
			up.setEnabled(false);
			wormhole.setEnabled(false);
			look.setVisible(false);
			examine.setVisible(false);
		}
		else if (game.currentRoom == game.jupiter) {
			setBackground(Color.GREEN);
			g.setColor(Color.GREEN);
			g.fillOval(220, 100, 80, 140);
			g.fillOval(50, 50, 100, 100);
			g.fillOval(220, 120, 30, 70);
			g.fillOval(270, 120, 30, 70);
			g.setColor(Color.DARK_GRAY);
			g.fillRect(30, 100, 200, 200);
			g.setColor(Color.RED);
			g.drawString("TOP SECRET!!!", 50, 140);
			south.setEnabled(false);
			west.setEnabled(false);
			east.setEnabled(false);
			down.setEnabled(false);
			north.setEnabled(false);
			up.setEnabled(true);		
			wormhole.setEnabled(false);
			look.setVisible(true);
			examine.setVisible(true);
		}		
		else if (game.currentRoom == game.home) {
			setBackground(Color.WHITE);
			g.setColor(Color.RED);
			g.drawString("YOU FOUND THE AMULET YOU WON!!!!", 160, 400);
			south.setEnabled(false);
			west.setEnabled(false);
			east.setEnabled(false);
			down.setEnabled(false);
			north.setEnabled(true);
			up.setEnabled(false);		
			wormhole.setEnabled(false);
			look.setVisible(false);
			examine.setVisible(false);
		}		
		else if (game.currentRoom == game.near_saturn) {
			setBackground(Color.BLACK);
			g.setColor(Color.BLACK);
			g.fillOval(220, 100, 80, 140);
			g.fillOval(220, 120, 30, 70);
			g.fillOval(250, 120, 30, 70);
			g.setColor(Color.DARK_GRAY);
			g.fillOval(50, 50, 100, 100);
			south.setEnabled(false);
			west.setEnabled(true);
			east.setEnabled(true);
			down.setEnabled(true);
			north.setEnabled(false);
			up.setEnabled(false);
			wormhole.setEnabled(false);
			look.setVisible(false);
			examine.setVisible(false);
		}
		else if (game.currentRoom == game.rings) {
			setBackground(Color.DARK_GRAY);
			g.setColor(Color.DARK_GRAY);
			g.fillOval(220, 100, 80, 140);
			g.fillOval(50, 50, 100, 100);
			g.fillOval(220, 120, 30, 70);
			g.fillOval(270, 120, 30, 70);
			south.setEnabled(true);
			west.setEnabled(true);
			east.setEnabled(true);
			down.setEnabled(false);
			north.setEnabled(true);
			up.setEnabled(false);	
			wormhole.setEnabled(false);
			look.setVisible(false);
			examine.setVisible(false);
		}		
		else if (game.currentRoom == game.near_uranus) {
			setBackground(Color.BLACK);
			g.setColor(Color.BLACK);
			g.fillOval(220, 100, 80, 140);
			g.fillOval(220, 120, 30, 70);
			g.fillOval(270, 120, 30, 70);
			g.setColor(Color.CYAN);
			g.fillOval(50, 50, 100, 100);
			south.setEnabled(false);
			west.setEnabled(true);
			east.setEnabled(true);
			down.setEnabled(false);
			north.setEnabled(false);
			up.setEnabled(false);
			wormhole.setEnabled(false);
			look.setVisible(false);
			examine.setVisible(false);
		}
		else if (game.currentRoom == game.near_neptune) {
			setBackground(Color.BLACK);
			g.setColor(Color.BLACK);
			g.fillOval(220, 100, 80, 140);
			g.fillOval(220, 120, 30, 70);
			g.fillOval(270, 120, 30, 70);
			g.setColor(Color.LIGHT_GRAY);
			g.fillOval(50, 50, 100, 100);
			south.setEnabled(false);
			west.setEnabled(true);
			east.setEnabled(true);
			down.setEnabled(true);
			north.setEnabled(false);
			up.setEnabled(false);
			wormhole.setEnabled(false);
			look.setVisible(false);
			examine.setVisible(false);
		}
		else if (game.currentRoom == game.neptune) {
			setBackground(Color.LIGHT_GRAY);
			g.setColor(Color.LIGHT_GRAY);
			g.fillOval(220, 100, 80, 140);
			g.fillOval(50, 50, 100, 100);
			g.fillOval(220, 120, 30, 70);
			g.fillOval(270, 120, 30, 70);
			g.setColor(Color.PINK);
			g.fillRect(30, 100, 200, 200);
			g.setColor(Color.BLACK);
			g.drawString("OPEN", 50, 140);
			south.setEnabled(false);
			west.setEnabled(false);
			east.setEnabled(false);
			down.setEnabled(false);
			north.setEnabled(false);
			up.setEnabled(true);	
			wormhole.setEnabled(false);
			look.setVisible(true);
			examine.setVisible(true);
		}
		else if (game.currentRoom == game.abyss) {
			setBackground(Color.BLACK);
			g.setColor(Color.BLACK);
			g.fillOval(220, 100, 80, 140);
			g.fillOval(50, 50, 100, 100);
			g.fillOval(220, 120, 30, 70);
			g.fillOval(270, 120, 30, 70);
			south.setEnabled(false);
			west.setEnabled(false);
			east.setEnabled(false);
			down.setEnabled(true);
			north.setEnabled(false);
			up.setEnabled(false);		
			wormhole.setEnabled(false);
			look.setVisible(false);
			examine.setVisible(false);
		}		
		else if (game.currentRoom == game.near_pluto) {
			setBackground(Color.BLACK);
			g.setColor(Color.BLACK);
			g.fillOval(220, 100, 80, 140);
			g.fillOval(220, 120, 30, 70);
			g.fillOval(270, 120, 30, 70);
			g.setColor(Color.MAGENTA);
			g.fillOval(50, 50, 100, 100);
			south.setEnabled(false);
			west.setEnabled(true);
			east.setEnabled(false);
			down.setEnabled(true);
			north.setEnabled(false);
			up.setEnabled(false);
			wormhole.setEnabled(false);
			look.setVisible(false);
			examine.setVisible(false);
		}
		else if (game.currentRoom == game.pluto) {
			setBackground(Color.MAGENTA);
			g.setColor(Color.MAGENTA);
			g.fillOval(220, 100, 80, 140);
			g.fillOval(50, 50, 100, 100);
			g.fillOval(220, 120, 30, 70);
			g.fillOval(270, 120, 30, 70);
			south.setEnabled(false);
			west.setEnabled(false);
			east.setEnabled(false);
			down.setEnabled(false);
			north.setEnabled(false);
			up.setEnabled(true);		
			wormhole.setEnabled(true);
			look.setVisible(false);
			examine.setVisible(false);
		}
		else if (game.currentRoom == game.outerspace) {
			setBackground(Color.BLUE);
			south.setEnabled(true);
			west.setEnabled(false);
			east.setEnabled(false);
			down.setEnabled(false);
			north.setEnabled(false);
			up.setEnabled(false);	
			wormhole.setEnabled(false);
			look.setVisible(false);
			examine.setVisible(false);
		}
	}
	//the following MouseListener part is from an earlier version of the GUI, and is no longer used.
	public class event implements MouseListener 
	{

		public void mouseClicked(MouseEvent e) {
			if(x == 0) {
				setBackground(Color.PINK);
				x = 1;
			} else if(x == 1) {
				setBackground(Color.BLUE);
				x = 0;
			}
		}
		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub			
		}
		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub			
		}
		@Override
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub			
		}
		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
		}
	}
	
	private class thehandler implements ActionListener
	{
		
		private Game game;

		
		public thehandler(Game game)
		{
			this.game=game;
		}
		
		public void actionPerformed(ActionEvent event) 
		{
			

			if (event.getSource() == south)
			{
				game.processCommand(new Command("go", "south"));
				update(getGraphics());
				text.setText(game.currentRoom.getLongDescription());
				add(text, BorderLayout.NORTH);
				
			}
			else if (event.getSource() == north)
			{
				game.processCommand(new Command("go", "north"));
				update(getGraphics());
				text.setText(game.currentRoom.getLongDescription()); 
				add(text, BorderLayout.NORTH);
			}
			else if (event.getSource() == west)
			{
				game.processCommand(new Command("go", "west"));
				update(getGraphics());
				text.setText(game.currentRoom.getLongDescription());
				add(text, BorderLayout.NORTH);
			}
			else if (event.getSource() == east)
			{
				game.processCommand(new Command("go", "east"));
				update(getGraphics());
				text.setText(game.currentRoom.getLongDescription());
				add(text, BorderLayout.NORTH);
			}
			else if (event.getSource() == down)
			{
				game.processCommand(new Command("go", "down"));
				update(getGraphics());
				text.setText(game.currentRoom.getLongDescription());
				add(text, BorderLayout.NORTH);
			}
			else if (event.getSource() == up)
			{
				game.processCommand(new Command("go", "up"));
				update(getGraphics());
				text.setText(game.currentRoom.getLongDescription());
				add(text, BorderLayout.NORTH);
			}
			else if (event.getSource() == wormhole)
			{
				game.processCommand(new Command("wormhole", null));
				update(getGraphics());
				text.setText(game.currentRoom.getLongDescription());
				add(text, BorderLayout.NORTH);
			}
			else if (event.getSource() == look)
			{
				game.processCommand(new Command("look", null));
				update(getGraphics());
				text.setText(game.currentRoom.getRoomItemDescription());
				add(text, BorderLayout.NORTH);
			}
			else if (event.getSource() == examine)
			{
				game.processCommand(new Command("examine", null));
				update(getGraphics());
				text.setText(game.currentRoom.getRoomItemDetails());
				add(text, BorderLayout.NORTH);
			}
		}
	}
}
