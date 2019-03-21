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
public class Zombie extends Entity{

    private int myDmg = 8;
    private int myHp = 40;
    /**
     *
     * @param _hp
     */
    public Zombie(int _hp){
        super(_hp);
        setDmg(myDmg);
    }
    
    public Zombie(){
        setHp(myHp);
        setDmg(myDmg);
    }
    
    public Zombie(int _hp, int _dmg){
        super(_hp, _dmg);
    }
    
    /**
     *
     * @return
     */
    public String getType(){
        return "Zombie";
    }
    
}
