package rjr.k2.ATM.entities;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class BankAccount {
	
	private Long id;
	
	private String iban;
	
	private BigDecimal balance;
	
	private List<Movement> movements;

	public BankAccount() {
	}
	
	public BankAccount(String iban) {
		super();
		this.iban = iban;
		this.balance = BigDecimal.ZERO;
		this.movements = new ArrayList<Movement>();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIban() {
		return iban;
	}

	public void setIban(String iban) {
		this.iban = iban;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public List<Movement> getMovements() {
		return movements;
	}

	public void setMovements(List<Movement> movements) {
		this.movements = movements;
	}
	
	public void addMovements(Movement movement) {
		this.movements.add(movement);
	}
	
	
}
