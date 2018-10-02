package rjr.k2.ATM.entities;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

public class Movement {
	
	private Long id;
	
	private String iban;
	
	private BigDecimal ammount;
	
	private Date date;
	
	public Movement() {
		
	}

	public Movement(String iban, BigDecimal ammount) {
		super();
		this.iban = iban;
		this.ammount = ammount;
		this.date = Calendar.getInstance().getTime();
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

	public BigDecimal getAmmount() {
		return ammount;
	}

	public void setAmmount(BigDecimal ammount) {
		this.ammount = ammount;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
}
