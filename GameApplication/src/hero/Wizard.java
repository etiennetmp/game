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
public class Wizard extends Human {
    
    public Wizard(int _hp, String _name){
        super(_hp, _name);
        //setHp(100);
        setCoins(10);
        setMp(300);
    }
}
