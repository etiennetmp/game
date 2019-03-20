package hero;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author 20693
 */
public class Hero extends Human {
    
    private boolean bow;
    private int numArrows, key, spellDmg, spellCost;
    private String[] attacks;
    
    /**
     *
     * @param _hp
     * @param _name
     */
    public Hero(int _hp, String _name){
        super(_hp, _name);
        //setHp(200);
        setCoins(2);
        setMp(100);
        bow = false;
        numArrows = 0;
        key = 0;
        attacks = new String[] {"sword Dmg: 30", "Not unlocked yet", 
            "Not unlocked yet"};
        spellDmg = 0;
        spellCost = 200;
    }
    
    /**
     *
     * @return
     */
    public String[] getAttacks(){
        return attacks;
    }
    
    /**
     *
     * @param i
     * @return
     */
    public int att(int i){
        if(i == 0)
            return 30;
        else if(i == 1 && getMp() >= spellCost)
        {            
            setMp(getMp() - spellCost);
            return spellDmg;
        }
                
        return 0;
    }
    
    /**
     *
     * @param spellName
     */
    public void setSpell(int spellName){
        if(spellName == 0)
        {
            attacks[2] = "fire Dmg: 75   Mana Cost: 50";
            spellDmg = 75;
            spellCost = 50;
        }
        else
        {
            attacks[2] = "ice Dmg: 40   Mana Cost: 25";
            spellDmg = 40;
            spellCost = 25;
        }
    }
    
    /**
     *
     * @return
     */
    public boolean hasBow(){
        return bow;
    }
    
    /**
     *
     */
    public void obtainBow(){
        bow = true;
    }
    
    /**
     *
     * @param arrows
     */
    public void setNumArrows(int arrows){
        numArrows = arrows;
    }
    
    /**
     *
     * @return
     */
    public int getNumArrows(){
        return numArrows;
    }
    
    /**
     *
     * @return
     */
    public boolean hasKey(){
        return key != 0;
    }
    
    /**
     *
     * @param k
     */
    public void setKey(int k){
        key = k;
    }
    
    /**
     *
     * @return
     */
    public int getSpellDmg(){
        return spellDmg;
    }
    
    /**
     *
     * @return
     */
    public int getSpellCost(){
        return spellCost;
    }
}
