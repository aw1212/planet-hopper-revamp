package com.alex.game;

/**
 * This is the Items class that creates an abstract object of an Item
 * and defines how items are set up.
 * 
 * @author Alex Williams-Bellotti
 * @version 2013.01.07
 */
public class Item
{
    private String description;
    private String details;

    /**
     * Constructor for objects of class Item
     */
    public Item(String d, String det)
    {
        description = d;
        details = det;
    }

    /**
     * get description accessor method
     */
    public String getDescription()
    {
        return description;
    }
    
    public String getDetails()
    {
        return details;
    }
}
