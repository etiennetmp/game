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
public class Goblin extends Entity {
    
    private int dmg;
    
    public Goblin(int _hp){
        super(_hp);
        dmg = 7;
    }
    
    public String getType(){
        return "Goblin";
    }
    
    public int getDmg(){
        return dmg;
    }
}
