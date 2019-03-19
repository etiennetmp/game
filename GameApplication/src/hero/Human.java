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
public class Human extends Entity {
    
    private int mp, coins;
    private String name;
    
    
    public Human(int _hp, String _name){
        super(_hp);
        name = _name;
    }
    
    /*
    public Human(int _mp, String _name, String _type) {
        super( _type);
        name = _name;
        mp = _mp;
    }
    
    
    public void castSpell(){
        System.out.println("You can not cast this spell");
    }
    */
    
    
    public void setMp(int newMp){
        mp = newMp;
    }
    
    public int getMp(){
        return mp;
    }
    
        
    public void setCoins(int newCoins){
        coins = newCoins;
    }
    
    public int getCoins(){
        return coins;
    }
    
    
    public String getName(){
        return name;
    }
    
    public int att(int i){
        return 0;
    }
    
    public String[] getAttacks(){
        return new String[] {};
    }
    
}
