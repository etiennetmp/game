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
public class Golem extends Entity{
    
    private int myDmg = 6;
    private int myHp = 170;
    /**
     *
     * @param _hp
     */
    public Golem(int _hp){
        super(_hp);
        setDmg(myDmg);
    }
    
    public Golem(){
        setHp(myHp);
        setDmg(myDmg);
    }
    
    public Golem(int _hp, int _dmg){
        super(_hp, _dmg);
    }
    
    /**
     *
     * @return
     */
    public String getType(){
        return "Golem";
    }
}
