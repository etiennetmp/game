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
public class Warrior extends Human {
    
    private int swordDmg;
    
    /**
     *
     * @param _hp
     * @param _name
     */
    public Warrior(int _hp, String _name){
        super(_hp,  _name);
        //setHp(300);
        setCoins(0);
        setMp(0);
        swordDmg = 40;
    }
    
    /**
     *
     * @return
     */
    public String[] getAttacks(){
        return new String[] {"Sword Dmg: " + swordDmg};
    }
    
    /**
     *
     * @param i
     * @return
     */
    public int att(int i){
        if(i == 0)
            return swordDmg;
                
        return 0;
    }
}
