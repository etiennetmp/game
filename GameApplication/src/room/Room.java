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
    Room[] adj;
    Room prec;
    String desc, name;
    int[] itemList; //change type
    int[] enttList; //change type
    boolean lockFront, lockRear, cbt;
    
    /**
     *
     * @param _name
     * @param size
     * @param _lockF
     * @param _lockR
     * @param _desc
     */
    public Room(String _name, int size, boolean _lockF, boolean _lockR, String _desc) {
        name = _name;
        adj = new Room[size];
        lockFront = _lockF;
        lockRear = _lockR;
        desc = _desc;
    }
    
    /**
     * Display descriptions of current map and names of next maps
     */
    public void display() {
        System.out.println(desc+"\n=============================================");
        if (name != "start")
            System.out.println("0 : go back");
        for (int i = 0; i < adj.length; i++) {
            System.out.println((i+1)+" : "+adj[i].name);
        }
    }
    
    /**
     *
     * @return
     */
    public Room[] getAdj() { return adj; }

    /**
     *
     * @return
     */
    public String getName() { return name; }

    /**
     *
     * @return
     */
    public Room getPrec() { return prec; }

    /**
     *
     * @return
     */
    public boolean getLockR() { return lockRear; }

    /**
     *
     * @return
     */
    public boolean getLockF() { return lockFront; }
    
    /**
     *
     */
    public void printDirections() {
        System.out.print("["+adj[0].name);
        for (int i = 1; i < adj.length; i++)
            System.out.print(", "+adj[i].name);
        System.out.println("]");
    }
}
