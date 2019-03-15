/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hero;

/**
 *
 * @author 20693
 */
public class Team {
    
    private Human[] teamMembers;
    private String teamName;
    private int teamLength;
    
    public Team(String heroName, String _teamName){
        
        teamLength = 0;
        teamMembers = new Human[3];
        addMember("Hero", heroName);
        teamName = _teamName;
    }
    
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
    
    public int getTeamCoins(){
        int c = 0;
        
        for(int i = 0; i < teamLength; ++i){
            c += teamMembers[i].getCoins();
        }
        
        return c;
    }
    
    
    public String getTeamName(){
        return teamName;
    }
    
    
    public Human[] getTeamMembers(){
        return teamMembers;
    }
}
