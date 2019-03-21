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
    
    private int swordDmg, mpMax, hpMax;
    
    /**
     *
     * @param _hp
     * @param _name
     */
    public Warrior(int _hp, String _name){
        super(_hp,  _name);
        //setHp(300);
        hpMax = getHp();
        mpMax = 0;
        setCoins(0);
        setMp(mpMax);
        swordDmg = 40;
    }
       
    
    public void heal(){
        setHp(hpMax);
        setMp(mpMax);
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
