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
public class Drake extends Entity {
    
    private int myDmg = 30;
    private int myHp = 200;
    /**
     *
     * @param _hp
     */
    public Drake(int _hp){
        super(_hp);
        setDmg(myDmg);
    }
    
    public Drake(){
        setHp(myHp);
        setDmg(myDmg);
    }
    
    public Drake(int _hp, int _dmg){
        super(_hp, _dmg);
    }
    
    /**
     *
     * @return
     */
    public String getType(){
        return "Drake";
    }
}
