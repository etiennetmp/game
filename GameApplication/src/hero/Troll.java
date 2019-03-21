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
public class Troll extends Entity{
    
    private int myDmg = 5;
    private int myHp = 75;
    /**
     *
     * @param _hp
     */
    public Troll(int _hp){
        super(_hp);
        setDmg(myDmg);
    }
    
    public Troll(){
        setHp(myHp);
        setDmg(myDmg);
    }
    
    public Troll(int _hp, int _dmg){
        super(_hp, _dmg);
    }
    
    /**
     *
     * @return
     */
    public String getType(){
        return "Troll";
    }
}
