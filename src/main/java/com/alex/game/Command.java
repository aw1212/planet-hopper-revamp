package com.alex.game;

/**
 * This class is based on Command class of the "World of Zuul" application:
 * by Michael Kolling and David J. Barnes
 * version 2008.03.30
 * 
 * Words that have been through CommandWords class
 * and are not known commands are null. Otherwise, they are
 * defined as two strings (first word and second word).
 * If there is no second word, then second string is null.
 * 
 * The first word is either invalid (not known to game) or 
 * is one of the commands defined in CommandWords. The second word
 * is either null, or is needed to specify direction.
 * 
 * @author Alex Williams-Bellotti
 * @version 2013.01.07
 * 
 */

class Command
{
    private String commandWord;
    private String secondWord;

    /**
     * Create a command object with first and second 
     * words (even if they are null)
     */
    public Command(String firstWord, String secondWord)
    {
        commandWord = firstWord;
        this.secondWord = secondWord;
    }

    /**
     * Return the first word of two word command. Return is null if
     * command is unknown. 
     */
    public String getCommandWord()
    {
        return commandWord;
    }

    /**
     * Return the second word of two word command. 
     * Return is null if there is no second word.
     */
    public String getSecondWord()
    {
        return secondWord;
    }

    /**
     * Return true if command is unknown.
     */
    public boolean isUnknown()
    {
        return (commandWord == null);
    }

    /**
     * Return true if there is a second word in the command.
     */
    public boolean hasSecondWord()
    {
        return (secondWord != null);
    }
}

