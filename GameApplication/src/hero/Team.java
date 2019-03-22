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
    private boolean wiz, gameOn;
    
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
        wiz = false;
        gameOn = true;
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
            System.out.println("Unknown member class");
    }
    
    
    
    public void teachSpell()
    {
        if(wiz)
        {
            int si;
            Scanner sc = new Scanner(System.in);

            do{
                System.out.println(teamMembers[1].getName() 
                        + ": I can teach you a spell, what do you want?");
                System.out.println("1: Fire Dmg: 75  Mana cost: 50");
                System.out.println("2: Ice Dmg: 40  Mana cost: 25");
                System.out.println("3: I hate studies, "
                        + "i'll keep going as a swordman!");

                String s = sc.nextLine();

                si = (int)s.charAt(0) - 49;

                if(si < 0 || si > 2)
                    System.out.println("Hey i don't have that choice");

            }while(si < 0 || si > 2);

            if(si != 2)
                teamMembers[0].setSpell(si);
        }
    }
    
    
    public void addWarrior(){
        System.out.println("A Warrior just appeared, can he join your team?");
        int si;
        Scanner sc = new Scanner(System.in); 
        
        do{
            System.out.println("1: Heck yes!");
            System.out.println("2: Hell no!");
            String s = sc.nextLine();

            si = (int)s.charAt(0) - 49;
            
            if(si != 0 && si != 1)
                System.out.println("Come on, there is no maybe, just decide!");
            
        }while(si != 0 && si != 1);
        
        
        if(si == 0)
        {
            System.out.println("What will be the name of the Warrior?");
            String name = sc.nextLine();
            addMember("Warrior", name);
            System.out.println(name + " successfully joined " + teamName);
        }
        System.out.println("");
    }
    
    public void addWizard(){
        System.out.println("A Wizard just appeared, can he join your team?");
        int si;
        Scanner sc = new Scanner(System.in); 
        
        do{
            System.out.println("1: Heck yes!");
            System.out.println("2: Hell no!");
            String s = sc.nextLine();

            si = (int)s.charAt(0) - 49;
            
            if(si != 0 && si != 1)
                System.out.println("Come on, there is no maybe, just decide!");
            
        }while(si != 0 && si != 1);
        
        
        if(si == 0)
        {
            System.out.println("What will be the name of the Wizard?");
            String name = sc.nextLine();
            addMember("Wizard", name);
            System.out.println(name + " successfully joined " + teamName);
            wiz = true;
        }
        System.out.println("");
    }
    
    
    public void regen(){
        for(int i = 0; i < teamLength; ++i)
        {
            System.out.println("\nAll the members of " + teamName 
                    + " got back their Hp and Mana to max!\n" 
                    + "Maybe a hard fight is coming up..");
            teamMembers[i].heal();
        }
    }
    
    public void gameOver(){
        System.out.println("All the members of " + teamName + " are dead!");
        
        System.out.println("\n┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼\n" +
                            "███▀▀▀██┼███▀▀▀███┼███▀█▄█▀███┼██▀▀▀\n" +
                            "██┼┼┼┼██┼██┼┼┼┼┼██┼██┼┼┼█┼┼┼██┼██┼┼┼\n" +
                            "██┼┼┼▄▄▄┼██▄▄▄▄▄██┼██┼┼┼▀┼┼┼██┼██▀▀▀\n" +
                            "██┼┼┼┼██┼██┼┼┼┼┼██┼██┼┼┼┼┼┼┼██┼██┼┼┼\n" +
                            "███▄▄▄██┼██┼┼┼┼┼██┼██┼┼┼┼┼┼┼██┼██▄▄▄\n" +
                            "┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼\n" +
                            "███▀▀▀███┼▀███┼┼██▀┼██▀▀▀┼██▀▀▀▀██▄┼\n" +
                            "██┼┼┼┼┼██┼┼┼██┼┼██┼┼██┼┼┼┼██┼┼┼┼┼██┼\n" +
                            "██┼┼┼┼┼██┼┼┼██┼┼██┼┼██▀▀▀┼██▄▄▄▄▄▀▀┼\n" +
                            "██┼┼┼┼┼██┼┼┼██┼┼█▀┼┼██┼┼┼┼██┼┼┼┼┼██┼\n" +
                            "███▄▄▄███┼┼┼─▀█▀┼┼─┼██▄▄▄┼██┼┼┼┼┼██▄\n" +
                            "┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼\n" +
                            "┼┼┼┼┼┼┼┼██┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼██┼┼┼┼┼┼┼┼┼\n" +
                            "┼┼┼┼┼┼████▄┼┼┼▄▄▄▄▄▄▄┼┼┼▄████┼┼┼┼┼┼┼\n" +
                            "┼┼┼┼┼┼┼┼┼▀▀█▄█████████▄█▀▀┼┼┼┼┼┼┼┼┼┼\n" +
                            "┼┼┼┼┼┼┼┼┼┼┼█████████████┼┼┼┼┼┼┼┼┼┼┼┼\n" +
                            "┼┼┼┼┼┼┼┼┼┼┼██▀▀▀███▀▀▀██┼┼┼┼┼┼┼┼┼┼┼┼\n" +
                            "┼┼┼┼┼┼┼┼┼┼┼██┼┼┼███┼┼┼██┼┼┼┼┼┼┼┼┼┼┼┼\n" +
                            "┼┼┼┼┼┼┼┼┼┼┼█████▀▄▀█████┼┼┼┼┼┼┼┼┼┼┼┼\n" +
                            "┼┼┼┼┼┼┼┼┼┼┼┼███████████┼┼┼┼┼┼┼┼┼┼┼┼┼\n" +
                            "┼┼┼┼┼┼┼┼▄▄▄██┼┼█▀█▀█┼┼██▄▄▄┼┼┼┼┼┼┼┼┼\n" +
                            "┼┼┼┼┼┼┼┼▀▀██┼┼┼┼┼┼┼┼┼┼┼██▀▀┼┼┼┼┼┼┼┼┼\n" +
                            "┼┼┼┼┼┼┼┼┼┼▀▀┼┼┼┼┼┼┼┼┼┼┼▀▀┼┼┼┼┼┼┼┼┼┼┼\n" +
                            "┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼");
        
        gameOn = false;
    }
    
    
    public void gameWon(){
        System.out.println("All the members of " + teamName 
                + " made it to defeat the demon, you've won!");
        
        System.out.println("  ________  ________ \n" +
                            " /  _____/ /  _____/ \n" +
                            "/   \\  ___/   \\  ___ \n" +
                            "\\    \\_\\  \\    \\_\\  \\\n" +
                            " \\______  /\\______  /\n" +
                            "        \\/        \\/");
        
        gameOn = false;
    }
    
    public boolean isGameOn(){
        return gameOn;
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
