/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankapplication;

import loanprocessing.*;
import savingaccounts.*;
import insuranceprocessing.*;


/**
 *
 * @author 20693
 */
public class BankProducts {
    
    public BankProducts(){
        TrackerMortgage tracker = new TrackerMortgage(4, 22);
        FixedRateCarLoan car = new FixedRateCarLoan(12, 1.4f);
        TermDeposit term = new TermDeposit(1.5f, 0.25f);
        FixedDeposit fixed = new FixedDeposit(3, 0.65f);
        InvestmentAccount acc = new InvestmentAccount(3);
        HomeInsurance home = new HomeInsurance(4.25f);
        LifeAssurance life = new LifeAssurance(6);
        System.out.println("Products created.");
    }

}