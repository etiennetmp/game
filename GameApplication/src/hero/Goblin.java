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
public class Goblin extends Entity {
    
    private int myDmg = 5;
    private int myHp = 20;
    /**
     *
     * @param _hp
     */
    public Goblin(int _hp){
        super(_hp);
        setDmg(myDmg);
    }
    
    public Goblin(){
        setHp(myHp);
        setDmg(myDmg);
    }
    
    public Goblin(int _hp, int _dmg){
        super(_hp, _dmg);
    }
    
    /**
     *
     * @return
     */
    public String getType(){
        return "Goblin";
    }
}
