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
        mapList[0] = new Room("start", 1, false, false, "Welcome! There is a farm in front of you.");
        mapList[1] = new Room("farm", 1, false, false, "Here is a farm!");
        mapList[2] = new Room("village exit", 2, false, false, "There is a clear land in front of you. Or maybe would you like to attempt the dungeon...");
        mapList[3] = new Room("dungeon entry", 1, false, true, "You are in the dungeon.. Can't go back ! There is an old man in the ground and a door in front of you.");
        mapList[4] = new Room("first room", 1, false, false, "There is a very dark hole.. seems very deep.. Shall you continue or explore ?");
        mapList[5] = new Room("dark room", 1, false, false, "It's very dark in here.. You are in a coal reserve.. You feel something with your feet..");
        //mapList[6] = new Room("statue room", 2, )
        mapList[19] = new Room("fields", 1, false, false, "Here is the open world!");
        
        linkAll();
    }
    
    
    private void linkAll() {
        /*  has to be done manualy :'(  */
        backLinkRoom(0, 0);
        linkRoom(0, 1);
        backLinkRoom(1, 0);
        linkRoom(1, 2);
        backLinkRoom(2, 1);
        linkRooms(2, 3, 19);
        backLinkRoom(3, 2);
        backLinkRoom(19, 2);
        linkRoom(3, 3);
        linkRoom(19, 19);
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
    
    
    private void backLinkRoom(int src, int dst) {
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
