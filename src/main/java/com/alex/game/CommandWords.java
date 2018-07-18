package com.alex.game;

/**
 * This class is based on the CommandWords class from "World of Zuul": 
 * by Michael Kolling and David J. Barnes
 * version 2008.03.30
 * 
 * CommandWords class holds all possible command words in the game.
 * When a command is typed in, it needs to be one of the commands
 * listed here, otherwise it is a false command. 
 * The wormhole command is listed separately as it is not known
 * to the player at the start of game.
 */

class CommandWords
{
    private static final String validCommands[] = {
        "go", "quit", "help", "look", "examine"
    };
    
    // this array holds only one command at the moment but can be updated to hold more 'hidden' commands
    private static final String otherCommands[] = {
        "wormhole" 
    };

    public CommandWords()
    {
        // empty
    }

    /**
     * If the player types a command, make sure
     * that it is one of the valid commands
     * Return true if the command is in the validCommands list,
     * false if it isn't.
     */
    public boolean isCommand(String aString)
    {
        for(int i = 0; i < validCommands.length; i++) {
            if(validCommands[i].equals(aString))
                return true;
        }
        // if we get here, the string was not found in the validCommands array
        return false;
    }

    /*
     * Print all commands from validCommands list 
     */
    public void showAll() 
    {
        for(int i = 0; i < validCommands.length; i++) {
            System.out.print(validCommands[i] + "  ");
        }
        System.out.println();
    }
   
    // If player types a command check to see if it is in otherCommands list.
    // Return true if it is, false if it isn't.
    public boolean isOther(String aString)
    {
        for(int i = 0; i < otherCommands.length; i++) {
            if(otherCommands[i].equals(aString))
                return true;
        }
        return false;
    }      
}
