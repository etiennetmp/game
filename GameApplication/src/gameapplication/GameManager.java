/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameapplication;
import room.*;
import java.util.Scanner;

import hero.*;
//import fights.*;

/**
 *
 * @author alex
 */
public class GameManager {
    
    private Map map;
    private int playerPosition;
    private Room pos;
    
    
    private Team team;
    
    public GameManager() {
        
        System.out.println("Hello fellow adventurer, how may i call you?");
        
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        System.out.println("OK " + name + ", what will be your team name?");
        String teamName = sc.nextLine();
        team = new Team(name, teamName);
        
        
        map = new Map(4);
        //playerPosition = map.GetMapList()[0];
        playerPosition = 0;
        run();
    }
    
    public void run() {
        
        while (true) {
            pos = map.GetMapList()[playerPosition];
            System.out.println(map.GetMapList()[playerPosition].getDesc());
            Scanner sc = new Scanner(System.in);
            String usrInput = sc.nextLine();
            int usrChoice = usrInput.charAt(0) - 48;
            playerMove(usrChoice);
        }
    }
    
    private void playerMove(int x) {
        playerPosition += x;
        
    }
    
    public Team getTeam(){
        return team;
    }
}
