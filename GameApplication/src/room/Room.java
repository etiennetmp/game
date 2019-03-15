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
public class Room {
    Room[] directions;
    int nbLinks;
    String desc;
    int[] itemList; //change type
    int[] enttList; //change type
    
    public Room(String _desc, int _nblinks) {
        directions = new Room[_nblinks];
        nbLinks = _nblinks;
        desc = _desc;
    }
    
    public String getDesc() { return desc; }
}
