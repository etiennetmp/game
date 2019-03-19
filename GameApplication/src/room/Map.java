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
        //System.out.println(mapList[0].adj[0].name);
        mapList[2] = new Room("village exit", 2, "There is a clear land in front of you. Or maybe would you like to attempt the dungeon...");
        mapList[3] = new Room("fields", 1, "Here is the open world!");
        mapList[4] = new Room("dungeon entry", 1, "you are in the dungeon");
        
        linkAll();
    }
    
    
    private void linkAll() {
        /*  has to be done manualy :'(  */
        linkRooms(0, 1);
        linkRooms(1, 0);
        linkRooms(1, 2);
        linkRooms(2, 1);
        linkRooms(2, 3);
        linkRooms(2, 4);
    }
    
    
    private void linkRooms(int src, int dst) {
        
        for (int i = 0; i < mapList[src].adj.length; i++) {

            if (mapList[src].adj[i] == null) {
                mapList[src].adj[i] = mapList[dst];
                break;
            }
        }
    }
    
    
    public void display() {
        
        for (int i = 0; i < nbRooms; i++) {
            System.out.print(i+" : ");
            System.out.println(mapList[i].desc);
        }
    }
    
    
    public Room[] getMapList() { return mapList; }
}
