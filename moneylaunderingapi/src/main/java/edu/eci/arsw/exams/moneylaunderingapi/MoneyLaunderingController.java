package edu.eci.arsw.exams.moneylaunderingapi;


import edu.eci.arsw.exams.moneylaunderingapi.model.SuspectAccount;
import edu.eci.arsw.exams.moneylaunderingapi.service.MoneyLaunderingService;
import java.util.ArrayList;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
public class MoneyLaunderingController{
    
    @Autowired
    MoneyLaunderingService moneyLaunderingService;

    @RequestMapping( value = "/fraud-bank-accounts")
    public List<SuspectAccount> offendingAccounts() {
        return moneyLaunderingService.getSuspectAccounts();
    }

    @RequestMapping(method = RequestMethod.GET)

    public ResponseEntity<List<SuspectAccount>> getSuspectAccounts() {

        try {
            //obtener datos que se enviarán a través del API
            return new ResponseEntity<List<SuspectAccount>>(moneyLaunderingService.getSuspectAccounts(), HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            Logger.getLogger(Exception.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<List<SuspectAccount>>(new ArrayList<>(),HttpStatus.NOT_FOUND);
        }
    }
    
    @RequestMapping(method = RequestMethod.GET, path = "{accountId}")

    public ResponseEntity<SuspectAccount> getAccountStatus(@PathVariable String accountId) {

        try {
            //obtener datos que se enviarán a través del API
            return new ResponseEntity<SuspectAccount>(moneyLaunderingService.getAccountStatus(accountId), HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            Logger.getLogger(Exception.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<SuspectAccount>(new SuspectAccount(),HttpStatus.NOT_FOUND);
        }
    }
    
    @RequestMapping(method = RequestMethod.POST, path = "/createSuspectAccount")
    public ResponseEntity<?> addSuspectAccount(@PathVariable SuspectAccount account) {

        try {
            //obtener datos que se enviarán a través del API
            moneyLaunderingService.updateAccountStatus(account);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception ex) {
            Logger.getLogger(Exception.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(new SuspectAccount(),HttpStatus.NOT_FOUND);
        }
    }
    
    @RequestMapping(method = RequestMethod.PUT, path = "/updateSuspectAccount")

    public ResponseEntity<?> updateAccountStatus(@PathVariable SuspectAccount account) {

        try {
            //obtener datos que se enviarán a través del API
            moneyLaunderingService.updateAccountStatus(account);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception ex) {
            Logger.getLogger(Exception.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(new SuspectAccount(),HttpStatus.NOT_FOUND);
        }
    }
}
