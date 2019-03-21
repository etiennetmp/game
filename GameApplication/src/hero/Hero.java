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
    
    private boolean bow, spell;
    private int numArrows, key, spellDmg, spellCost, arrowDmg, swordDmg;
    private String spellName;
    
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
        spellDmg = 0;
        spellCost = 200;
        spellName = "None";
        arrowDmg = 35;
        swordDmg = 30;
        spell = false;
    }
    
    /**
     *
     * @return
     */
    public String[] getAttacks(){
        return new String[]{"sword Dmg: " + swordDmg,
                spell ? spellName + "Dmg: " + spellDmg + " Mana cost: " 
                + spellCost : "Not unlocked yet",
                bow ? "Bow    Arrows left: " + numArrows + " Dmg: " + arrowDmg 
                : "Not unlocked yet"};
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
        
        else if(i == 2 && bow && numArrows != 0)
        {
            --numArrows;
            return arrowDmg;
        }
        
        return 0;
    }
    
    /**
     *
     * @param spellName
     */
    public void setSpell(int sName){
        if(sName == 0)
        {
            spellName = "Fire";
            spellDmg = 75;
            spellCost = 50;
        }
        else if(sName == 1)
        {
            spellName = "Ice";
            spellDmg = 40;
            spellCost = 25;
        }
        else
            return;
        
        System.out.println("Congrats! You just learned how to use " + spellName);
        spell = true;
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
    public int getKey(){
        return key;
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
