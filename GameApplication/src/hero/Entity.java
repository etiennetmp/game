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
    
    public Entity(int _hp){
        hp = _hp;
    }
    
    
    public void setHp(int newHp){
        hp = newHp;
    }
    
    public int getHp(){
        return hp;
    }
    
    public String getType(){
        return "None";
    }
    
    public int getDmg(){
        return 0;
    }
}
