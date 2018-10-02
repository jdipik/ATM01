package rjr.k2.ATM.services;

import java.math.BigDecimal;

import rjr.k2.ATM.entities.BankAccount;

public class ATMservicesImpl implements ATMservices {
	
	private BankAccountService bankAccountService = new BankAccountServiceImpl();
	
	private BankAccount account;

	@Override
	public Boolean autenticate(String iban) {
		account = bankAccountService.find(iban);
		return account != null;
	}

	@Override
	public void withdraw(BigDecimal ammount) {
		bankAccountService.withdraw(account, ammount);
	}

	@Override
	public void deposit(BigDecimal ammount) {
		bankAccountService.deposit(account, ammount);
	}

	@Override
	public BigDecimal balance() {
		return account.getBalance();
	}

}
