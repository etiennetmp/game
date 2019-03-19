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
    
    public Room(String _name, int size, String _desc) {
        name = _name;
        adj = new Room[size];
        desc = _desc;
    }
    
    public void display() {
        System.out.println(desc+"\n=============================================");
        if (name != "start")
            System.out.println("0 : go back");
        for (int i = 0; i < adj.length; i++) {
            System.out.println((i+1)+" : "+adj[i].name);
        }
    }
    
    public Room[] getAdj() { return adj; }
    public String getName() { return name; }
    public Room getPrec() { return prec; }
    
    public void printDirections() {
        System.out.print("["+adj[0].name);
        for (int i = 1; i < adj.length; i++)
            System.out.print(", "+adj[i].name);
        System.out.println("]");
    }
}
