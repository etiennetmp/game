/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fights;
import hero.*;
import gameapplication.*;

/**
 *
 * @author 20693
 */
public class fight {
    
    private int opponentNumber;
    private Entity[] ennemies;
    private int[] numbers;
    private Team team;
    private Human[] teamMembers;
    
    
    public fight(Entity[] _ennemies, int[] _numbers, Team _team){
        ennemies = _ennemies;
        numbers = _numbers;
        team = _team;
        teamMembers = team.getTeamMembers();
        
        do {
            updateFight(ennemies, numbers);
            
            attack(ennemies[0]); //TODO
            takeDmg();
        }
        while(opponentNumber != 0);
        
    }
    
    private void attack(Entity ennemy){
        
    }
    
    private void takeDmg(){
        int dmg = 0;
        for(int i = 0; i < ennemies.length; ++i){
            
            dmg += ennemies[i].getDmg() * i;
            
        }
    }
    
    
    
    private void updateFight(Entity[] ennemies, int[] numbers){
        
        System.out.print("You are facing ");
        opponentNumber = 0;
        
        for(int i = 0; i < ennemies.length; ++i){
            System.out.print(numbers[i] + " " + ennemies[i].getType());
            
            if(numbers[i] > 1)
                System.out.println("s,");
            
            else
                System.out.println(",");
            
            opponentNumber += numbers[i];
        }
        
        System.out.print("This is a total of " + opponentNumber);
        
        if(opponentNumber > 1)
            System.out.println(" ennemies, good luck handling them!");
        
        else if(opponentNumber == 1)
            System.out.println(" ennemy, come on he is alone just rekt him!");
        
        else
            System.out.println(" ennemy, you did it! Good Job!");
    }
    
   
}
