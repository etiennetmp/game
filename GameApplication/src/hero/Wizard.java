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
    
    private int fireDmg, iceDmg, fireCost, iceCost, mpMax, hpMax;
    
    /**
     *
     * @param _hp
     * @param _name
     */
    public Wizard(int _hp, String _name){
        super(_hp, _name);
        //setHp(100);
        setCoins(10);
        mpMax = 300;
        hpMax = getHp();
        setMp(mpMax);
        fireDmg = 120;
        fireCost = 100;
        iceCost = 60;
        iceDmg = 65;
    }
    
    /**
     *
     * @return
     */
    public String[] getAttacks(){
        return new String[]{"Fire Dmg: " + fireDmg + " Mana cost: " + fireCost,
                            "Ice Dmg: " + iceDmg + " Mana cost: " + iceCost};
    }
     
    
    public void heal(){
        setHp(hpMax);
        setMp(mpMax);
    }
    
    /**
     *
     * @return
     */
    public int getFireDmg(){
        return fireDmg;
    }
    
    /**
     *
     * @return
     */
    public int getIceDmg(){
        return iceDmg;
    }
    
    /**
     *
     * @param i
     * @return
     */
    public int att(int i){
        if(i == 0 && getMp() >= fireCost)
        {
            setMp(getMp() - fireCost);
            return fireDmg;
        }
        
        else if(getMp() >= iceCost)
        {
            setMp(getMp() - iceCost);
            return iceDmg;
        }
                
        return 0;
    }
}
