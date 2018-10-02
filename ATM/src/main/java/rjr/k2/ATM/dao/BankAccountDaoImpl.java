package rjr.k2.ATM.dao;

import java.util.HashMap;

import rjr.k2.ATM.entities.BankAccount;
import rjr.k2.ATM.entities.Movement;

public class BankAccountDaoImpl implements BankAccountDao {
	
	private static HashMap<String, BankAccount> accounts = new HashMap<String, BankAccount>();

	@Override
	public BankAccount find(String iban) {
		if (iban != null) {
			BankAccount account = accounts.get(iban);
			if (account == null) {
				account = new BankAccount(iban);
				accounts.put(iban, account);
			}
			return account;
		}
		return null;
	}

	@Override
	public void save(BankAccount account) {
		accounts.put(account.getIban(), account);
	}

	@Override
	public void save(Movement movement) {
		accounts.get(movement.getIban()).addMovements(movement);
	}

}
