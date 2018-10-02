package rjr.k2.ATM.services;

import java.math.BigDecimal;

import rjr.k2.ATM.entities.BankAccount;

public interface BankAccountService {
	
	public BankAccount find(String iban);
	public BankAccount withdraw(BankAccount account, BigDecimal ammount);
	public BankAccount deposit(BankAccount account, BigDecimal ammount);

}
