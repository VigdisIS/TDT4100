package inheritance;

public abstract class AbstractAccount {

	protected double balance;

	public AbstractAccount() {
		balance = 0;
	}

	public void deposit(double beløp) {
		if (beløp >= 0) {
			balance += beløp;
		} else {
			throw new IllegalArgumentException("Beløpet må være positivt.");
		}
	}

	public void withdraw(double beløp) {
		if (beløp >= 0) {
			internalWithdraw(beløp);
		} else {
			throw new IllegalArgumentException("Beløpet må være positivt.");
		}
	}

	protected abstract void internalWithdraw(double beløp);

    public double getBalance() {
    	return balance;
    }
}
