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
    
    private String spell;
    private boolean bow;
    private int numArrows, key;
    private String[] attacks;
    
    public Hero(int _hp, String _name){
        super(_hp, _name);
        //setHp(200);
        setCoins(2);
        setMp(100);
        spell = "None";
        bow = false;
        numArrows = 0;
        key = 0;
        attacks = new String[] {"sword", "None"};
    }
    
    
    public String[] getAttacks(){
        return attacks;
    }
    
    
    public void setSpell(String spellName){
        spell = spellName;
    }
    
    public String getSpell(){
        return spell;
    }
    
    
    public boolean hasBow(){
        return bow;
    }
    
    public void obtainBow(){
        bow = true;
    }
    
    
    public void setNumArrows(int arrows){
        numArrows = arrows;
    }
    
    public int getNumArrows(){
        return numArrows;
    }
    
    
    public boolean hasKey(){
        return key != 0;
    }
    
    public void setKey(int k){
        key = k;
    }
}
