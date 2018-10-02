package rjr.k2.ATM.dao;

import rjr.k2.ATM.entities.BankAccount;
import rjr.k2.ATM.entities.Movement;

public interface BankAccountDao {
	
	public BankAccount find(String iban);
	public void save(BankAccount account);
	public void save(Movement movement);

}
