package com.alex.game;


/**              
* This class is the main class of the 'Planet Hopper' 
* based on the Game class from "World-of-Zuul" by Michael Kolling and David J. Barnes
* version 2008.03.30
* Planet Hopper is a space adventure game. To play the game, create an instance of 
* this class and call the 'play' method.
* 
* @author Alex Williams-Bellotti
* @version 2013.01.07
* 
*/

class Game   
{      
   private Parser parser;
   public Room currentRoom; 
   public Room outerspace, sun, near_mercury, mercury, near_venus, venus, near_earth, earth, moon, near_mars, mars, near_jupiter, jupiter, home, near_saturn, rings, near_uranus, near_neptune, neptune, abyss, near_pluto, pluto;
   /**
    * Create the game and initialize the map of planetary bodies.
    */
   public Game() 
   {
       createRooms(); 
       parser = new Parser();
   }        
   /**
    * Create all the different rooms (planets) that the player can get to. 
    * Link their exits together.
    */
   private void createRooms()    
   {
       
       // create the rooms
       outerspace = new Room("wandering in OUTERSPACE in the milky way galaxy");
       sun = new Room("reaching the SUN. It's way too hot!"); 
       near_mercury = new Room("NEAR_MERCURY");
       mercury = new Room("on planet MERCURY. Nothing to do here...");
       near_venus = new Room("NEAR_VENUS");
       venus = new Room("on planet VENUS.");
       near_earth = new Room("NEAR_EARTH");
       earth = new Room("on planet EARTH...a crazy creature yells 'if you use wormhole" + "\n from a certain place, you can jump to the other part of space!'"); 
       moon = new Room("on earth's MOON. Nice view. But nothing more.");
       near_mars = new Room("NEAR_MARS");
       mars = new Room("on planet MARS.");
       near_jupiter = new Room("NEAR_JUPITER");
       jupiter = new Room("on planet JUPITER.");
       home = new Room("back on your home planet. Everyone is saved!");
       near_saturn = new Room("NEAR_SATURN");
       rings = new Room("stuck in the orbit of saturn's RINGS!");
       near_uranus = new Room("NEAR_URANUS...there's probably nothing here...let's move on");
       near_neptune = new Room("NEAR_NEPTUNE");
       neptune = new Room("on planet NEPTUNE"); 
       abyss = new Room("wandering in an infinite void. Might as well quit"); 
       near_pluto = new Room("NEAR_PLUTO");
       pluto = new Room("on PLUTO. It yells: I USED TO BE A PLANET TOO YOU KNOW?!");
       
       venus.addItem(new Item("letter", "The letter says: avoid Saturn's rings!!"));
       mars.addItem(new Item("heavy box", "You opened the box....uh oh...looks like a vortex...."));
       jupiter.addItem(new Item("glowing box", "You found the amulet!! You won!"));
       neptune.addItem(new Item("floating box", "You open the box. Black hole."));
      
       currentRoom = outerspace;       // begin game in outerspace

       // initialize room exits   

       outerspace.setExit("south", near_venus);

       sun.setExit("east", near_mercury);
       
       near_mercury.setExit("west", sun);
       near_mercury.setExit("east", near_venus);
       near_mercury.setExit("down", mercury);
       
       mercury.setExit("up", near_mercury);

       near_venus.setExit("north", outerspace);
       near_venus.setExit("west", near_mercury);      
       near_venus.setExit("east", near_earth);
       near_venus.setExit("down", venus);
       
       venus.setExit("up", near_venus);
       
       near_earth.setExit("north", moon);
       near_earth.setExit("west", near_venus);
       near_earth.setExit("east", near_mars);
       near_earth.setExit("down", earth);
     
       earth.setExit("up", near_earth);

       moon.setExit("south", near_earth);

       near_mars.setExit("west", near_earth);
       near_mars.setExit("east", near_jupiter);
       near_mars.setExit("down", mars);

       mars.setExit("up", near_mars);

       near_jupiter.setExit("west", near_mars);
       near_jupiter.setExit("east", near_saturn);
       near_jupiter.setExit("down", jupiter);

       jupiter.setExit("up", near_jupiter);

       home.setExit("north", outerspace);

       near_saturn.setExit("west", near_jupiter); 
       near_saturn.setExit("east", near_uranus);
       near_saturn.setExit("down", rings);

       rings.setExit("north", rings);
       rings.setExit("south", rings);
       rings.setExit("west", rings);
       rings.setExit("east", rings);

       near_uranus.setExit("west", near_saturn);
       near_uranus.setExit("east", near_neptune);

       near_neptune.setExit("west", near_uranus);
       near_neptune.setExit("east", near_pluto);
       near_neptune.setExit("down", neptune);

       neptune.setExit("up", near_neptune);

       abyss.setExit("down", abyss);

       near_pluto.setExit("west", near_neptune);
       near_pluto.setExit("down", pluto);

       pluto.setExit("up", near_pluto);
       
       // initialize wormhole moves 
       
       sun.setWormhole(sun, pluto);
       
       pluto.setWormhole(pluto, sun);
       
       mars.setNextPlaces(mars, outerspace);
       
       jupiter.setNextPlaces(jupiter, home);
       
       neptune.setNextPlaces(neptune, abyss);
   }
   
   /**
    *  Main play loops.  Keeps going until player quits.
    */
   public void play() 
   {            
       printWelcome(); 

       // Main command loop begins.
       // Keep reading commands and executing 
       // until end of game.
           
       boolean finished = false;

       while (! finished) { // keep reading commands as long as game is not over
           Command command = parser.getCommand();
           finished = processCommand(command);
       }
       System.out.println("Thank you for exploring the galaxy.  You are always welcome here."); // when player quits, print this line
   }
    
   /**
    * Print out the opening message for the player.
    */
   private void printWelcome()
   {
       System.out.println();
       System.out.println("Welcome to Planet Hopper!!");
       System.out.println("Planet Hopper is filled with cosmic fun!");
       System.out.println("Type 'help' if you need help getting started.");
       System.out.println();
       System.out.println(currentRoom.getLongDescription());
   } 

   /**
    * When a command is given, process and execute it.
    * If the command ends the game, then return true.
    * Otherwise return false.
    */
      
   public boolean processCommand(Command command) 
    {
       boolean wantToQuit = false;  
       if(command.isUnknown()) {
           System.out.println("I don't know what you mean...");
           return false;
       }
       // Given one of these commands, do the following
       String commandWord = command.getCommandWord();
       if (commandWord.equals("help")) {
           printHelp();
       }
       else if (commandWord.equals("wormhole")) {
           getWormhole();
       }            
       else if (commandWord.equals("go")) {
           goRoom(command);
       }
       else if (commandWord.equals("look")) {
           System.out.println(currentRoom.getRoomItemDescription());
       }
       else if (commandWord.equals("examine")) {
           System.out.println(currentRoom.getRoomItemDetails());
           getNextPlace();
       }         
       else if (commandWord.equals("quit")) {
           wantToQuit = quit(command);
       }
       // else command not recognized.
       return wantToQuit;
   }
   
   /** 
    * If command is help, execute printHelp
    * which explains the main setting/purpose of 
    * the game.
    */
   private void printHelp() 
    {
       System.out.println("You are searching the Universe for an amulet. Your home planet");
       System.out.println("is in grave danger without it.");
       System.out.println();
       System.out.println("Your ship's command words are:");
       parser.showCommands();
   }
    
   private void getNextPlace()
   {
       Room nextPlace = currentRoom.getNextPlace(currentRoom);
       if (nextPlace == null) {
           currentRoom = currentRoom;
       }
       else {
           currentRoom = nextPlace;
           System.out.println(currentRoom.getLongDescription());
       } 
   }
   
   private void getWormhole()
   {
       // if player uses wormhole command, execute getWormhole
       Room nextRoom = currentRoom.getWormhole(currentRoom);
       if (nextRoom == null) { // if player tries to use wormhole in wrong place
           System.out.println("Can't use that here");
       }              
       else {
           currentRoom = nextRoom; // from one end of space, jump to other end
           System.out.println(currentRoom.getLongDescription());
       } 
   }     
                
   /**    
    * If player uses go command without specifying a direction
    * we don't know where to go
    * If the player specifies a direction and there is an exit, 
    * enter the new room. 
    */
   public void goRoom(Command command) 
   {
       if(!command.hasSecondWord()) {
           System.out.println("Go where?");
           return;
       }

       String direction = command.getSecondWord();

       Room nextRoom = currentRoom.getExit(direction);

       if (nextRoom == null) { // if player tries to go in a direction without an exit, print message:
           System.out.println("That leads to a dead end!");
       }
       else {  
           currentRoom = nextRoom;  
           System.out.println(currentRoom.getLongDescription());
       }         
   }               
  
   /**    
    * If quit command was used, make sure
    * that there is no second word. If there isn't
    * then quit the game. Otherwise print message.
    */
   private boolean quit(Command command) 
   {        
       if(command.hasSecondWord()) { 
           System.out.println("Quit what?");
           return false;
        } 
       else { 
           return true;    
       }
   }
   
	public static void main(String args[]) 
	{
		Game game=new Game();
		VisualInterface vf = new VisualInterface(game);
		vf.setVisible(true);
		game.play();
	} 
}

