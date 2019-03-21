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
    
    /**
     *
     */
    public GameManager() {
        map = new Map(20); //arg = nb of rooms
        //playerPosition = 0;
        pos = map.getMapList()[0];
        run();
    }
    
    /**
     *
     */
    public void run() {
        
        names();
        while (true) {
            if (pos.isCbt())
            {
                Scanner sc = new Scanner(System.in);
                new fight(new Entity[]{new Goblin(), new Zombie()}, 
                        new int[]{1, 2}, team);
                
                int si;
                
                do{
                    System.out.println(team.getTeamMembers()[1].getName() + ": I can teach you a spell, what do you want?");
                    System.out.println("1: Fire Dmg: 75  Mana cost: 50");
                    System.out.println("2: Ice Dmg: 40  Mana cost: 25");
                    System.out.println("3: I hate studies, i'll keep going as a swordman!");

                    String s = sc.nextLine();

                    si = (int)s.charAt(0) - 49;
                    if(si < 0 || si > 2)
                        System.out.println("Hey i don't have that choice");
                    
                }while(si < 0 || si > 2);
                
                if(si != 2)
                    team.getTeamMembers()[0].setSpell(si);
                
                System.out.println("\nA Warrior just appeared, what will be his name?");
                
                String name = sc.nextLine();
                team.addMember("Warrior", name);
                
                
                new fight(new Entity[]{new Hydra(), new Troll()}, 
                        new int[]{1, 1}, team);
            }
            
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
        
        System.out.println("A Wizard just appeared, what will be his name?");
        name = sc.nextLine();
        team.addMember("Wizard", name);
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
    
    /**
     *
     * @return
     */
    public Team getTeam(){ return team; }
    
    /**
     *
     */
    public final static void clearConsole() {
        System.out.print("\033[H\033[2J");
    }

}
