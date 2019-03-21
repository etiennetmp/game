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
    
    private int hp = 0;
    private int dmg = 0;
    
    /**
     *
     * @param _hp
     */
    public Entity(int _hp){
        hp = _hp;
    }
    
    
    public Entity(){
        
    }
    
    public Entity(int _hp, int _dmg){
        hp = _hp;
        dmg = _dmg;
    }
    
    /**
     *
     * @param newHp
     */
    public void setHp(int newHp){
        hp = newHp;
    }
    
    
    public void setDmg(int newDmg){
        dmg = newDmg;
    }
    
    
    public int getDmg(){
        return dmg;
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
    
}
