/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameapplication;
import room.*;
import fights.*;
import hero.*;
import java.util.Scanner;

import hero.*;
//import fights.*;

/**
 *
 * @author alex
 */
public class GameManager {
    
    private Map map;
    //private int playerPosition;
    private Room pos;
    
    private Team team;
    
    public GameManager() {
        map = new Map(20); //arg = nb of rooms
        //playerPosition = 0;
        pos = map.getMapList()[0];
        run();
    }
    
    public void run() {
        
        names();
        while (true) {
            //pos = map.getMapList()[playerPosition];
            pos.display();
            
            Scanner sc = new Scanner(System.in);
            String usrInput = sc.nextLine();
            int usrChoice = usrInput.charAt(0) - 48;
            playerMove(usrChoice);
        }
    }
    
    private void names() {
        System.out.println("Hello fellow adventurer, how may i call you?");
        
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        System.out.println("OK " + name + ", what will be your team name?");
        String teamName = sc.nextLine();
        team = new Team(name, teamName);
        fight ffight = new fight(new Entity[]{new Goblin(70)}, new int[]{1}, team);
    }
    
    private void playerMove(int x) {
        if (x == 0) {
            if (pos.getName() == "start")
                System.out.println("Input is too low");
            else {
                if (!pos.getLockR()) {
                    pos = pos.getPrec();
                    clearConsole();
                }
                else
                    System.out.println("Door is lock");
            }
        }
        else
            if (x > pos.getAdj().length)
                System.out.println("Input is too high");
            else {
                if (!pos.getLockF()) {
                    pos = pos.getAdj()[x-1];
                    clearConsole();
                }
                else
                    System.out.println("Door is lock");
            }
    }
    
    public Team getTeam(){ return team; }
    
    public final static void clearConsole() {
        System.out.print("\033[H\033[2J");
    }

}
