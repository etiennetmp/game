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
        map = new Map(11); //arg = nb of rooms
        //playerPosition = 0;
        pos = map.getMapList()[0];
        run();
    }
    
    /**
     *
     */
    public void run() {
        
        names();
        while (team.isGameOn()) {
            
            /*if (pos == map.getMapList()[2])
                initialTeam();
            
            pos.runCbt(team);*/
            if(!team.isGameOn())
                break;
            pos.display(team);
            
            win();
            
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
        
        team.addWizard();
    }
    
    
    private void initialTeam() {
        team.teachSpell();
        team.addWarrior();
        new fight(new Entity[]{new Hydra(), new Troll()},
                new int[]{1, 1}, team);
    }
    
    private void win() {
        if (pos == map.getMapList()[0] && team.getTeamMembers()[0].getKey() > 0)
            team.gameWon();
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
        else if (x <= pos.getAdj().length)
            if (!pos.getAdj()[x-1].getLockF()) {
                pos = pos.getAdj()[x-1];
                clearConsole();
            }
            else
                System.out.println("Door is lock");
        else {
            if (pos == map.getMapList()[10] && x == 1) {
                team.getTeamMembers()[0].obtainBow();
                team.getTeamMembers()[0].setNumArrows(5);
            }
            if (pos == map.getMapList()[5] && x == 1) {
                team.getTeamMembers()[0].setKey(
                        team.getTeamMembers()[0].getKey() + 1);
                map.getMapList()[8].unlockF();
            }
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
