/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package room;

import fights.fight;
import hero.*;

/**
 *
 * @author alex
 */
public class Room {
    Room[] adj;
    Room prec;
    String desc, name;
    String[] itemList; //change type
    int[] enttList; //change type
    boolean lockFront, lockRear;
    int cbt;
    
    /**
     *
     * @param _name
     * @param size
     * @param _lockF
     * @param _lockR
     * @param _desc
     */
    public Room(String _name, int size, boolean _lockF, 
            boolean _lockR, int _cbt, String _desc) {
        
        name = _name;
        adj = new Room[size];
        lockFront = _lockF;
        lockRear = _lockR;
        cbt = _cbt;
        desc = _desc;
        itemList = new String[0];
        enttList = new int[0];
    }
    
    public void addItem(String s) {
        itemList = new String[1];
        itemList[0] = s;
    }
    
    
    /**
     * Display descriptions of current map and names of next maps
     */
    public void display(Team team) {
        
        System.out.println(desc+"\n========================"
                + "                 =====================");
        
        if (name != "start")
            System.out.println("0 : go back");
        
        for (int i = 0; i < adj.length; i++)
            System.out.println((i+1)+" : "+adj[i].name);
        
        if (enttList.length > 0)
            for (int i = 0; i < enttList.length; i++)
                System.out.println((i+enttList.length+1)+" : "+enttList[i]);
        
        if (itemList.length > 0 && !team.getTeamMembers()[0].hasBow())
            for (int i = 0; i < itemList.length; i++)
                System.out.println((i+adj.length+enttList.length+1)
                        +" : "+itemList[i]);
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
    public void unlockF() {lockFront = false; }
    
    /**
     *
     */
    public void printDirections() {
        System.out.print("["+adj[0].name);
        for (int i = 1; i < adj.length; i++)
            System.out.print(", "+adj[i].name);
        System.out.println("]");
    }
    
    
    public void addBow() {
        addItem("bow");
    }
    
    public void addKey() {
        addItem("key");
    }
    
    
    public void runCbt(Team team) {
        if (cbt == 1)
            new fight(new Entity[]{new Goblin(), new Zombie()},
                    new int[]{1, 2}, team);
        if (cbt == 2)
            new fight(new Entity[]{new Hydra(), new Troll()},
                    new int[]{1, 1}, team);
        if (cbt == 4)
            new fight(new Entity[]{new Golem(),
                new Zombie()}, new int[]{2, 2}, team);
        if (cbt == 8) {
            team.regen();
            new fight(new Entity[]{new Drake()}, new int[]{3}, team);
        }
    }
}
