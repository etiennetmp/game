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
    
    /**
     *
     * @param _ennemies
     * @param _numbers
     * @param _team
     */
    public fight(Entity[] _ennemies, int[] _numbers, Team _team){
        ennemies = _ennemies;
        numbers = _numbers;
        team = _team;

        Scanner sc = new Scanner(System.in);
        
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
        
        updateFight(ennemies, numbers);
        
        int ei;
        int totalAttacker = 0;
        for(int i = 0; i < team.getTeamLength(); ++i)
        {
            if(team.getTeamMembers()[i].getHp() != 0)
                ++totalAttacker;
        }
        
        do {
            
            boolean unattackable;
            do{
                do{

                    System.out.println("Who do you want to attack?");

                    for(int i = 0; i < ennemies.length; ++i)
                    {
                        System.out.println((i+1) + ": " + ennemies[i].getType());
                    }



                    String e = sc.nextLine();
                    ei = (int)e.charAt(0) - 49;
                    if(ei < 0 || ei >= ennemies.length || ennemies[ei].getHp() == 0)
                    {
                        if(!(ei < 0 || ei >= ennemies.length))
                        {
                            System.out.print("This " + ennemies[ei].getType() 
                                    + " is already dead, stop bullying him! ");
                        }

                        else
                            System.out.print("There is no such opponent. ");

                        unattackable = true;
                    }
                    else
                        unattackable = false;

                }while(unattackable);
                attack(ei);
                --totalAttacker;
                updateFight(ennemies, numbers);
            }while(totalAttacker > 0);
            
            if(opponentNumber != 0)
                takeDmg();
            
            //updateFight(ennemies, numbers);
        }
        while(opponentNumber != 0);
        
    }
    
    private void attack(int ennemi){
        
        int at;
        Scanner sc = new Scanner(System.in);
        
        
        do{
            int atta;
            boolean cantAttack;
            
            do{
                
                System.out.println("Who will attack?");

                for(int i = 0; i < team.getTeamLength(); ++i)
                {
                    System.out.println((i+1) + ": " 
                            + team.getTeamMembers()[i].getName());
                }


                
                String a = sc.nextLine();
                atta = (int)a.charAt(0) - 49;

                if(atta < 0 || atta >= team.getTeamLength()
                            || team.getTeamMembers()[atta].getHp() == 0)
                {
                    if(!(atta < 0 || atta > team.getTeamLength() - 1))
                    {
                        System.out.println(team.getTeamMembers()[atta].getName()
                                    + " is dead he will not help you there..");
                    }
                    
                    cantAttack = true;
                    System.out.print("Choose someone else. ");
                    
                }
                else
                {
                    cantAttack = false;
                }
                
            }while(cantAttack);
            
            Human attacker = team.getTeamMembers()[atta];

            String[] attacks = attacker.getAttacks();
            
            for(int i = 0; i < attacks.length; ++i)
            {
                System.out.println((i+1) + ": " + attacks[i]);
            }

            String b = sc.nextLine();
            at = attacker.att((int)b.charAt(0) - 49);
            
            if(at == 0)
                System.out.println("You can not attack with that, "
                        + "try something else");
            
        }while(at == 0);
        
        if(numbers[ennemi] != 0 && 
                ennemies[ennemi].getHp() - at/numbers[ennemi] > 0)
            
            ennemies[ennemi].setHp(ennemies[ennemi].getHp() 
                    - at/numbers[ennemi]);
        else
        {
            ennemies[ennemi].setHp(0);
            numbers[ennemi] = 0;
        }
        
    
        
    }
    
    private void takeDmg(){
        int dmg = 0;
        int tl = team.getTeamLength();
        
        for(int i = 0; i < ennemies.length; ++i){
            dmg += ennemies[i].getDmg() * numbers[i];
        }
        
        for(int i = 0; i < tl; ++i){            
            if(team.getTeamMembers()[i].getHp() - dmg/tl > 0)
            {
                team.getTeamMembers()[i].setHp(team.getTeamMembers()[i].getHp() 
                    - dmg/tl);
                
                System.out.println(team.getTeamMembers()[i].getName() + " has "
                        + team.getTeamMembers()[i].getHp() + " HP and " 
                        + team.getTeamMembers()[i].getMp() + " MP.");
            }
            else
            {
                team.getTeamMembers()[i].setHp(0);
                System.out.println(team.getTeamMembers()[i].getName() 
                        + " IS DEAD WHAT HAVE YOU DONE ??!");
            }            
        }        
    }
    
    
    private void updateFight(Entity[] ennemies, int[] numbers){
        
        System.out.print("\nYou are facing ");
        opponentNumber = 0;
        
        for(int i = 0; i < ennemies.length; ++i){
            System.out.println((i == 0 ? "a" : "A") +" level " + numbers[i] + " " 
                    + ennemies[i].getType() + ". HP: " 
                    + (ennemies[i].getHp()*numbers[i]) + ". Dmg: "
                    + (ennemies[i].getDmg()*numbers[i]));
                        
            opponentNumber += numbers[i];
        }
        
        System.out.print("\nThis is like a total of " + opponentNumber 
                + " level 1");
        
        if(opponentNumber > 1)
            System.out.println(" ennemies, good luck handling them!");
        
        else if(opponentNumber == 1)
            System.out.println(" ennemy, come on he is alone just rekt him!");
        
        else
            System.out.println(" ennemy, you did it! Good Job!\n");
    }
}
