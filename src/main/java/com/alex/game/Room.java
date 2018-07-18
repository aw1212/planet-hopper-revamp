package com.alex.game;


import java.util.Set;
import java.util.HashMap;
import java.util.Iterator;
import java.util.ArrayList;

/**
 * This class is based on the Room class from the game
 * "World-of-Zuul" by  Michael Kolling and David J. Barnes
 * version 2008.03.30
 *
 * The 'rooms' in Planet Hopper are all the locations in the game that a player
 * can explore. The player can get to different locations based on where they are
 * and what (if anything) lies in another direction.
 * The valid directions that one can go to 
 * from a certain location are listed as exits for that location.
 * The rooms are stored with what neighbors they have in each direction.
 * If wormhole is used on either end of the map, the player jumps to
 * the opposite end of the map.
 * 
 * @author Alex Williams-Bellotti
 * @version 2013.01.07
 * 
 */

class Room 
{
    private String description; 
    private HashMap<String, Room> exits; // stores room exits
    private HashMap<Room, Room> wormholes;// stores wormhole jumps  
    private HashMap<Room, Room> places;
    private ArrayList<Item> items;

    /**
     * An initial room is created that is a "description" without exits.
     * Exits and wormhole jumps are then set and stored.
     */
    public Room(String description) 
    {
        this.description = description;
        exits = new HashMap<String, Room>();
        wormholes = new HashMap<Room, Room>();
        places = new HashMap<Room, Room>();
        items = new ArrayList<Item>(); 
    }
    
    /**
     * Define what a valid exit is which gets described in Game class.
     */
    public void setExit(String direction, Room neighbor) 
    {
        exits.put(direction, neighbor);
    }
    
    // Define what valid wormhole jump is which is described in Game class.
    public void setWormhole(Room currentRoom, Room nextRoom)
    {
        wormholes.put(currentRoom, nextRoom);
    }
    
    public void setNextPlaces (Room currentRoom, Room nextPlace)
    {
        places.put(currentRoom, nextPlace);
    }

    /**
     * Return the description of the room which was
     * defined in the Game class. 
     */
    public String getShortDescription()
    {
        return description;
    }

    /**
     * Return a long description of the room, in the form:
     *     You are NEAR-VENUS.
     *     Exits: down north west east
     */
    public String getLongDescription()
    {
        return "You are " + description + ".\n" + getExitString();
    }
    
    public String getRoomItemDescription()
    {
        String itemRoomDesc = "Nothing here.";
        if (items.size() > 0) {
            itemRoomDesc = "\n You found the following item: \n";
            for (Item item : items) {
                itemRoomDesc += "\t" + item.getDescription() + "\n";
            }
        }
        return itemRoomDesc;
    }
    
        public String getRoomItemDetails()
    {
        String itemRoomDet = null;
        if (items.size() > 0) {
            itemRoomDet = "\n You inspect the item: \n";
            for (Item item : items) {
                itemRoomDet += "\t" + item.getDetails() + "\n";
            }
        }
        return itemRoomDet;
    }

    /**
     * Return a string that gives the room's exits.
     */
    private String getExitString()
    {
        String returnString = "Exits:";
        Set keys = exits.keySet();
        for(Iterator iter = keys.iterator(); iter.hasNext(); )
            returnString += " " + iter.next();
        return returnString;
    }
    
    /**
     * From the current room, when given a 
     * direction (north, south, east, west, up, down)
     * return the room that we get to from the specified direction.
     * If it is a dead end, return null.
     */
    public Room getExit(String direction) 
    {
        return (Room)exits.get(direction);
    }
    
    /**
     * From current room, when given wormhole command,
     * return the room that the player will jump to.
     * If there is no room (command used at wrong place)
     * return null.
     */
    public Room getWormhole(Room currentRoom)
    {
        return (Room)wormholes.get(currentRoom);
    }
    
    public Room getNextPlace(Room currentRoom)
    {
        return (Room)places.get(currentRoom);
    }
    
    public void addItem(Item i) {
        items.add(i);
    }
}
