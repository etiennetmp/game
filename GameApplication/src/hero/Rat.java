/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hero;

/**
 *
 * @author atomesz
 */
public class Rat extends Entity{
    
    private int myDmg = 3;
    private int myHp = 5;
    /**
     *
     * @param _hp
     */
    public Rat(int _hp){
        super(_hp);
        setDmg(myDmg);
    }
    
    public Rat(){
        setHp(myHp);
        setDmg(myDmg);
    }
    
    public Rat(int _hp, int _dmg){
        super(_hp, _dmg);
    }
    
    /**
     *
     * @return
     */
    public String getType(){
        return "Rat";
    }
    
}
