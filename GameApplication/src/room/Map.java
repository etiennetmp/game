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
        mapList[0] = new Intro("Welcome! There is a farm in front of you.", 1);
        mapList[1] = new Intro("Here is a farm!", 1);
        mapList[2] = new Intro("There is a clear land in front of you. Or maybe would you like to attempt the dungeon...", 1);
        mapList[3] = new Nature("Here is the open world!", 1);
        
        linkAll();
    }
    
    
    private void linkAll() {
        /*  has to be done manualy :'(  */
        linkRooms(0, 1);
        linkRooms(1, 2);
    }
    
    
    private void linkRooms(int src, int dst) {
        
        for (int i = 0; i < mapList[src].directions.length; i++) {
            
            if (mapList[src].directions == null) {
                mapList[src].directions[i] = mapList[dst];
                mapList[src].nbLinks++;
            }
        }
    }
    
    
    public void display() {
        
        for (int i = 0; i < nbRooms; i++) {
            System.out.print(i+" : ");
            System.out.println(mapList[i].desc);
        }
    }
    
    
    public Room[] GetMapList() { return mapList; }
}
