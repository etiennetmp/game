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
public class Warrior extends Human {
    
    
    public Warrior(int _hp, String _name){
        super(_hp,  _name);
        //setHp(300);
        setCoins(0);
        setMp(0);
    }
}
