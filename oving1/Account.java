package stateandbehavior;

public class Account {
	private double balance;
	private double interestRate;
	
	public Account() {
		this.balance = 0;
		this.interestRate = 0;
	}
	
	
	public void deposit(double depositPeng) {
		if(depositPeng > 0) {
			this.balance += depositPeng;
		} else {
			System.out.println("Du må skrive inn et positivt tall.");
		}
		
	}
	
	public void addInterest() {
		this.balance += ((this.interestRate/100)*this.balance);
	}
	
	public double getBalance() {
		return this.balance;
	}
	
	public double getInterestRate() {
		return this.interestRate;
	}
	
	public void setInterestRate(double nyRente) {
		this.interestRate = nyRente;
	}
	
	public String toString() {
		return "Account balance: " + String.valueOf(balance) + "\nInterest rate: " + String.valueOf(interestRate);
	}
	
	
	public static void main(String[] args) {
		Account acc = new Account();
		
		acc.deposit(15000.25);
		acc.addInterest();
		acc.getBalance();
		acc.setInterestRate(3.1);
		acc.getInterestRate();
		
		System.out.println(acc);
	}
}
