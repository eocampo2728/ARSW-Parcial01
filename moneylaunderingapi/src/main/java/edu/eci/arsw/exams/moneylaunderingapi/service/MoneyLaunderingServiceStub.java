package edu.eci.arsw.exams.moneylaunderingapi.service;

import edu.eci.arsw.exams.moneylaunderingapi.model.SuspectAccount;
import java.util.ArrayList;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MoneyLaunderingServiceStub implements MoneyLaunderingService {
    
    List<SuspectAccount> accounts = new ArrayList<>();
    
    @Override
    public void updateAccountStatus(SuspectAccount suspectAccount) {
        SuspectAccount selected = null;
        for (SuspectAccount sa: accounts){
            if (sa.getAccountId().equals(suspectAccount.getAccountId())){
                selected = sa;
            }
        }
        if (selected == null){
            accounts.add(suspectAccount);
        }else{
            selected.updateState(suspectAccount.getAmountOfSmallTransactions());
        }
    }

    @Override
    public SuspectAccount getAccountStatus(String accountId) {
        SuspectAccount answer = null;
        for (SuspectAccount sa: accounts){
            if (sa.getAccountId().equals(accountId)){
                answer = sa;
            }
        }
        return answer;
    }

    @Override
    public List<SuspectAccount> getSuspectAccounts() {
        return accounts;
    }
}
