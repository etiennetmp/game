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
public class Entity {
    
    private int hp;
    
    /**
     *
     * @param _hp
     */
    public Entity(int _hp){
        hp = _hp;
    }
    
    /**
     *
     * @param newHp
     */
    public void setHp(int newHp){
        hp = newHp;
    }
    
    /**
     *
     * @return
     */
    public int getHp(){
        return hp;
    }
    
    /**
     *
     * @return
     */
    public String getType(){
        return "None";
    }
    
    /**
     *
     * @return
     */
    public int getDmg(){
        return 0;
    }
}
