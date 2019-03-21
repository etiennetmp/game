/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hero;

import java.util.Scanner;

/**
 *
 * @author 20693
 */
public class Team {
    
    private Human[] teamMembers;
    private String teamName;
    private int teamLength;
    
    /**
     *
     * @param heroName
     * @param _teamName
     */
    public Team(String heroName, String _teamName){
        
        teamLength = 0;
        teamMembers = new Human[3];
        addMember("Hero", heroName);
        teamName = _teamName;
    }
    
    /**
     *
     * @param style
     * @param memberName
     */
    public void addMember(String style, String memberName){
        
        if(style == "Hero")
            teamMembers[teamLength++] = new Hero(200, memberName);
        
        else if(style == "Wizard")
            teamMembers[teamLength++] = new Wizard(100, memberName);
        
        else if(style == "Warrior")
            teamMembers[teamLength++] = new Warrior(300, memberName);
        
        else
            System.out.println("unknown member class");
    }
    
    
    
    public void teachSpell()
    {
        int si;
        Scanner sc = new Scanner(System.in);
                
        do{
            System.out.println(teamMembers[1].getName() + ": I can teach you a spell, what do you want?");
            System.out.println("1: Fire Dmg: 75  Mana cost: 50");
            System.out.println("2: Ice Dmg: 40  Mana cost: 25");
            System.out.println("3: I hate studies, i'll keep going as a swordman!");

            String s = sc.nextLine();

            si = (int)s.charAt(0) - 49;
            
            if(si < 0 || si > 2)
                System.out.println("Hey i don't have that choice");

        }while(si < 0 || si > 2);

        if(si != 2)
            teamMembers[0].setSpell(si);
    }
    
    
    public void addWarrior(){
        System.out.println("\nA Warrior just appeared, what will be his name?");
        Scanner sc = new Scanner(System.in); 
        String name = sc.nextLine();
        addMember("Warrior", name);
    }
    
    public void addWizard(){
        System.out.println("A Wizard just appeared, what will be his name?");
        Scanner sc = new Scanner(System.in); 
        String name = sc.nextLine();
        addMember("Wizard", name);
    }
    /**
     *
     * @return
     */
    public int getTeamCoins(){
        int c = 0;
        
        for(int i = 0; i < teamLength; ++i){
            c += teamMembers[i].getCoins();
        }
        
        return c;
    }
    
    /**
     *
     * @return
     */
    public String getTeamName(){
        return teamName;
    }
    
    /**
     *
     * @return
     */
    public Human[] getTeamMembers(){
        return teamMembers;
    }
    
    /**
     *
     * @return
     */
    public int getTeamLength(){
        return teamLength;
    }
}
