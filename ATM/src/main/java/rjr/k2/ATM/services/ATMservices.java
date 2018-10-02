package rjr.k2.ATM.services;

import java.math.BigDecimal;

public interface ATMservices {
	
	public Boolean autenticate(String iban);
	
	public void withdraw(BigDecimal ammount);
	
	public void deposit(BigDecimal ammount);
	
	public BigDecimal balance();
	

}
