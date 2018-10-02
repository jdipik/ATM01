package rjr.k2.ATM;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import rjr.k2.ATM.entities.BankAccount;
import rjr.k2.ATM.services.ATMservices;
import rjr.k2.ATM.services.ATMservicesImpl;
import rjr.k2.ATM.services.BankAccountService;
import rjr.k2.ATM.services.BankAccountServiceImpl;

public class App {

	static HashMap<String, BankAccount> accounts = new HashMap<String, BankAccount>();
	static BankAccount bankAccount = new BankAccount();
	static BankAccountService bankAccountService = new BankAccountServiceImpl();
	static ATMservices atmServices = new ATMservicesImpl();
	

	public static void main( String[] args ) {
		Scanner input = new Scanner(System.in);
		int choiceMenu;
		
		System.out.println( "Hello ATM!" );

		bankAccount = new BankAccount("11111");
		accounts.put(bankAccount.getIban(), bankAccount);

		bankAccount = new BankAccount("22222");
		accounts.put(bankAccount.getIban(), bankAccount);

		bankAccount = new BankAccount("33333");
		accounts.put(bankAccount.getIban(), bankAccount);

		bankAccount = new BankAccount("44444");
		accounts.put(bankAccount.getIban(), bankAccount);

		bankAccount = new BankAccount("55555");
		accounts.put(bankAccount.getIban(), bankAccount);

		bankAccount = new BankAccount("66666");
		accounts.put(bankAccount.getIban(), bankAccount);

		do {
			System.out.println("0) Esci");
			System.out.println("1) Elenco conti");
			System.out.println("2) Saldo e operazioni su conto");
			choiceMenu = input.nextInt();

			switch (choiceMenu) {
			case 0:
				System.out.println("Ciao!");
				break;
			case 1:
				for (Map.Entry<String, BankAccount> entry : accounts.entrySet()) {
					System.out.println(entry.getValue().getIban());
				};
				break;
			case 2:
				System.out.print("Inserisci iban: ");
				String iban = input.next();
				if (atmServices.autenticate(iban)) {
					System.out.println("Il saldo del conto "+iban+" è: "+atmServices.balance());
					int choiceOperation;
					do {
						BigDecimal ammount = null;
						System.out.println("0) Esci");
						System.out.println("1) Prelievo");
						System.out.println("2) Deposito");
						choiceOperation = input.nextInt();
						
						switch (choiceOperation) {
						case 0:
							break;
						case 1:
							System.out.print("Inserisci importo da prelevare: ");
							ammount = input.nextBigDecimal();
							int check = ammount.compareTo(atmServices.balance());
							if (check == 1) {
								System.out.println("Credito insufficente!");
								System.out.println("Il saldo del conto "+iban+" è: "+atmServices.balance());
							} else {
								atmServices.withdraw(ammount);
								System.out.println("Il nuovo saldo del conto "+iban+" è: "+atmServices.balance());
								choiceOperation = 0;
							}
							break;
						case 2:
							System.out.print("Inserisci importo da depositare: ");
							ammount = input.nextBigDecimal();
							atmServices.deposit(ammount);
							System.out.println("Il nuovo saldo del conto "+iban+" è: "+atmServices.balance());
							choiceOperation = 0;
							break;
						default:
							System.out.println("Scelta errata!");
							break;
						}
					} while (choiceOperation != 0);
					
				} else {
					System.out.println("Errore nell'inserimento del numero di conto");
				}
				break;
			default:
				System.out.println("inserimento errato");
				break;
			}
		} while (choiceMenu != 0);

		input.close();
	}
}
