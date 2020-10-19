package encapsulation;

public class Account {
	private double balance;
	private double interestRate;
	
	public Account(double balance, double interestRate) {
		if(balance < 0 || interestRate < 0) {
			throw new IllegalArgumentException("Invalid.");
		} else {
			this.balance = balance;
			this.interestRate = interestRate;
		}
	}
	
	
	public void deposit(double depositPeng) {
		if(depositPeng < 0) {
			throw new IllegalArgumentException("Deposit cannot be negative.");
		} this.balance += depositPeng;
	}
	
	public void withdraw(double withdrawPeng) {
		if(withdrawPeng > 0) {
			if((this.balance - withdrawPeng) < 0) {
				throw new IllegalArgumentException("Balance cannot be negative after withdrawing.");
			} this.balance -= withdrawPeng;	
		} else {
			throw new IllegalArgumentException("Money to be withdrawn must be positive.");
		}
	}
	
	public void addInterest() {
		this.balance += ((this.interestRate/100)*this.balance);
	}
	
	public double getBalance() {
		return balance;
	}
	
	public double getInterestRate() {
		return interestRate;
	}
	
	public void setInterestRate(double nyRente) {
		if(nyRente < 0) {
			throw new IllegalArgumentException("Interestrate must be positive");
		} else {
			this.interestRate = nyRente;
		}
		
	}
	
	public String toString() {
		return "Account balance: " + String.valueOf(balance) + "\nInterest rate: " + String.valueOf(interestRate);
	}
	
	
	public static void main(String[] args) {/*
		Account acc = new Account(35000, (20/100));
		
		acc.deposit(15000.25);
		acc.addInterest();
		acc.getBalance();
		acc.setInterestRate(3.1);
		acc.getInterestRate();
		
		System.out.println(acc);*/
		Account acc = new Account(100,5);
		System.out.println(acc.getBalance());
	}
}
