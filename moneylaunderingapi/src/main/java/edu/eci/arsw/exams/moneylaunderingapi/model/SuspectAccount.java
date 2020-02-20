package edu.eci.arsw.exams.moneylaunderingapi.model;

public class SuspectAccount {
    public String accountId;
    public int amountOfSmallTransactions;
    
    public String getAccountId(){
        return accountId;
    }
    
    public void updateState(int amountOfSmallTransactions){
        this.amountOfSmallTransactions = amountOfSmallTransactions;
    }
    
    public int getAmountOfSmallTransactions(){
        return amountOfSmallTransactions;
    }
}
