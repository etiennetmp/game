/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hero;

/**
 *
 * @author atomesz
 */
public class Drake extends Entity {
    
    private int dmg;
    
    /**
     *
     * @param _hp
     */
    public Drake(int _hp){
        super(_hp);
        dmg = 30;
    }
    
    /**
     *
     * @return
     */
    public String getType(){
        return "Drake";
    }
    
    /**
     *
     * @return
     */
    public int getDmg(){
        return dmg;
    }
}
