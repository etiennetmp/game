/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package room;

/**
 *
 * @author alex
 */
public class Map {
    
    private Room[] mapList;
    private int nbRooms;
    
    public Map(int _nbRooms) {
        nbRooms = _nbRooms;
        mapList = new Room[nbRooms];
        init();
    }
    
    
    private void init() {
        mapList[0] = new Room("start", 1, "Welcome! There is a farm in front of you.");
        mapList[1] = new Room("farm", 1, "Here is a farm!");
        mapList[2] = new Room("village exit", 2, "There is a clear land in front of you. Or maybe would you like to attempt the dungeon...");
        mapList[19] = new Room("fields", 1, "Here is the open world!");
        mapList[3] = new Room("dungeon entry", 1, "You are in the dungeon.. Can't go back !");
        
        linkAll();
    }
    
    
    private void linkAll() {
        /*  has to be done manualy :'(  */
        backLinkRooms(0, 0);
        linkRoom(0, 1);
        backLinkRooms(1, 0);
        linkRoom(1, 2);
        backLinkRooms(2, 1);
        linkRooms(2, 3, 4);
        backLinkRooms(3, 2);
    }
    
    
    private void linkRoom(int src, int dst) {
        
        for (int i = 0; i < mapList[src].adj.length; i++) {

            if (mapList[src].adj[i] == null) {
                mapList[src].adj[i] = mapList[dst];
                break;
            }
        }
    }
    
    private void linkRooms(int src, int dst1, int dst2) {
        
        for (int i = 0; i < mapList[src].adj.length; i++) {

            if (mapList[src].adj[i] == null) {
                mapList[src].adj[i] = mapList[dst1];
                mapList[src].adj[i+1] = mapList[dst2];
                break;
            }
        }
    }
    
    
    private void backLinkRooms(int src, int dst) {
        mapList[src].prec = mapList[dst];
    }
    
    
    public void display() {
        
        for (int i = 0; i < nbRooms; i++) {
            System.out.print(i+" : ");
            mapList[i].printDirections();
            System.out.println(mapList[i].prec.name);
        }
    }
    
    
    public Room[] getMapList() { return mapList; }
}
