package com.alex.game;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * This class is based on the Parser class from "World of Zuul": 
 * by Michael Kolling and David J. Barnes
 * version 2008.03.30
 *
 * When player enters a string, the parser reads it from the terminal
 * and tries to interpret as a two string command that gets returned
 * as an object of class Command.
 *
 * The parser takes set of command words from the arrays validCommands or otherCommands
 * from CommandWords class. These words are compared to the player's string(s) and
 * returns it as a Command object or an unknown Command object (when player's input is unknown).
 * 
 * @author Alex Williams-Bellotti
 * @version 2013.01.07
 */

public class Parser 
{

    private CommandWords commands;  
    // holds all legitimate command words from 
    //validCommands and otherCommands lists

    public Parser() 
    {
        commands = new CommandWords();
    }

    public Command getCommand() 
    {
        String inputLine = "";   // takes input
        String word1;
        String word2;

        System.out.print("> ");     // print prompt

        BufferedReader reader = 
            new BufferedReader(new InputStreamReader(System.in));
        try {
            inputLine = reader.readLine();
        }
        catch(java.io.IOException exc) {
            System.out.println ("There was an error during reading: "
                                + exc.getMessage());
        }

        StringTokenizer tokenizer = new StringTokenizer(inputLine);

        if(tokenizer.hasMoreTokens())
            word1 = tokenizer.nextToken();      // get first word
        else
            word1 = null;
        if(tokenizer.hasMoreTokens())
            word2 = tokenizer.nextToken();      // get second word
        else
            word2 = null;

        // valid input is can only be one or two strings, anything else gets ignored

        // Create a command with known words. Null command for unknown words.

        if(commands.isCommand(word1))
            return new Command(word1, word2);
        else if(commands.isOther(word1))
            return new Command(word1, word2);
        else
            return new Command(null, word2);
    }

    /**
     * Print out a list of command words that are not 'hidden' to player at start of game.
     */
    public void showCommands()
    {
        //will return all words in validCommands list but not otherCommands list 
        commands.showAll();
    }
}
