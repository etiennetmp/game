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
    
    /**
     *
     * @param _hp
     */
    public Goblin(int _hp){
        super(_hp);
        dmg = 7;
    }
    
    /**
     *
     * @return
     */
    public String getType(){
        return "Goblin";
    }
    
    /**
     *
     * @return
     */
    public int getDmg(){
        return dmg;
    }
}
