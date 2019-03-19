/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fights;
import hero.*;
import gameapplication.*;
import java.util.Scanner;

/**
 *
 * @author 20693
 */
public class fight {
    
    private int opponentNumber;
    private Entity[] ennemies;
    private int[] numbers;
    private Team team;
    //private Human[] teamMembers;
    
    
    public fight(Entity[] _ennemies, int[] _numbers, Team _team){
        ennemies = _ennemies;
        numbers = _numbers;
        team = _team;
        //teamMembers = team.getTeamMembers();
        
        System.out.print(team.getTeamMembers()[0].getName());
        
        for(int i = 1; i < team.getTeamLength() - 1; ++i){
            System.out.print(", " + team.getTeamMembers()[i].getName());
        }
        
        if(team.getTeamLength() > 1)
            System.out.println(" and " + 
                    team.getTeamMembers()[team.getTeamLength() - 1].getName() + 
                    " are entering a fight! How will they handle it?");
        else
            System.out.println(" is entering a fight! How will he handle it?");
        
        
        do {
            updateFight(ennemies, numbers);
            
            System.out.println("Who do you want to attack?");
            
            Scanner sc = new Scanner(System.in);
            String e = sc.nextLine();
            
            for(int i = 0; i < ennemies.length; ++i)
            {
                System.out.println((i+1) + ": " + ennemies[i].getType());
            }
            

            
            attack((int)e.charAt(0) - 49);
            takeDmg();
        }
        while(opponentNumber != 0);
        
    }
    
    private void attack(int ennemi){
        
        System.out.println("Who will attack?");
        
        for(int i = 0; i < team.getTeamLength(); ++i)
        {
            System.out.println((i+1) + ": " 
                    + team.getTeamMembers()[i].getName());
        }
        
        int at;
        
        do{
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        Human attacker = team.getTeamMembers()[(int)a.charAt(0) - 49];
        
        String[] attacks = attacker.getAttacks();
        for(int i = 0; i < attacks.length; ++i)
        {
            System.out.println((i+1) + ": " + attacks[i]);
        }
        
        a = sc.nextLine();
        at = attacker.att((int)a.charAt(0) - 49);
        }while(at != 0);
        
        ennemies[ennemi].setHp(ennemies[ennemi].getHp() - at/numbers[ennemi]);
        
    }
    
    private void takeDmg(){
        int dmg = 0;
        int tl = team.getTeamLength();
        
        for(int i = 0; i < ennemies.length; ++i){
            dmg += ennemies[i].getDmg() * i;
        }
        
        for(int i = 0; i < tl; ++i){            
            team.getTeamMembers()[i].setHp(team.getTeamMembers()[i].getHp() 
                    - dmg/tl);
        }
        
    }
    
    
    private void updateFight(Entity[] ennemies, int[] numbers){
        
        System.out.print("You are facing ");
        opponentNumber = 0;
        
        for(int i = 0; i < ennemies.length; ++i){
            System.out.println("a level " + numbers[i] + " " 
                    + ennemies[i].getType() + ". HP: " 
                    + (ennemies[i].getHp()*numbers[i]) + ". Dmg: "
                    + (ennemies[i].getDmg()*numbers[i]));
                        
            opponentNumber += numbers[i];
        }
        
        System.out.print("This is like a total of " + opponentNumber 
                + " level 1");
        
        if(opponentNumber > 1)
            System.out.println(" ennemies, good luck handling them!");
        
        else if(opponentNumber == 1)
            System.out.println(" ennemy, come on he is alone just rekt him!");
        
        else
            System.out.println(" ennemy, you did it! Good Job!");
    }
    
   
}
