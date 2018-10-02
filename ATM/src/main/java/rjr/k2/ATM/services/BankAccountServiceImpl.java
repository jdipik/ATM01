package rjr.k2.ATM.services;

import java.math.BigDecimal;

import rjr.k2.ATM.dao.BankAccountDao;
import rjr.k2.ATM.dao.BankAccountDaoImpl;
import rjr.k2.ATM.entities.BankAccount;
import rjr.k2.ATM.entities.Movement;

public class BankAccountServiceImpl implements BankAccountService {
	
	private BankAccountDao bankAccountDao = new BankAccountDaoImpl();

	@Override
	public BankAccount find(String iban) {
		return bankAccountDao.find(iban);
	}

	@Override
	public BankAccount withdraw(BankAccount account, BigDecimal ammount) {
		Movement movement = new Movement(account.getIban(), ammount.negate());
		account.addMovements(movement);
		account.setBalance(account.getBalance().subtract(ammount));
		bankAccountDao.save(account);
		return account;
	}

	@Override
	public BankAccount deposit(BankAccount account, BigDecimal ammount) {
		Movement movement = new Movement(account.getIban(), ammount);
		account.addMovements(movement);
		account.setBalance(account.getBalance().add(ammount));
		bankAccountDao.save(account);
		return account;
	}

}
