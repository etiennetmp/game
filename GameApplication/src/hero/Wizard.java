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
public class Wizard extends Human {
    
    private String[] attacks;
    private int fireDmg;
    private int iceDmg;
    
    public Wizard(int _hp, String _name){
        super(_hp, _name);
        //setHp(100);
        setCoins(10);
        setMp(300);
        attacks = new String[] {"fire Dmg: 120   Mana Cost: 100", 
            "ice Dmg: 65   Mana Cost: 60"};
        fireDmg = 120;
        iceDmg = 65;
    }
    
    public String[] getAttacks(){
        return attacks;
    }
    
    public int getFireDmg(){
        return fireDmg;
    }
    
    public int getIceDmg(){
        return iceDmg;
    }
    
    public int att(int i){
        if(i == 0 && getMp() >= 100)
        {
            setMp(getMp() - 100);
            return fireDmg;
        }
        
        else if(getMp() >= 60)
        {
            setMp(getMp() - 60);
            return iceDmg;
        }
                
        return 0;
    }
}
