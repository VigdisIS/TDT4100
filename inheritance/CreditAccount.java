package inheritance;

public class CreditAccount extends AbstractAccount {

	private double kredittGrense;

	public CreditAccount(double kredittGrense) {
		super();
		this.kredittGrense = kredittGrense;
	}

	@Override
	protected void internalWithdraw(double beløp) {
		if (balance - beløp >= - kredittGrense) { //Konto kan overtrekkes innenfor kredittgrensen
			balance -= beløp;
		} else {
			throw new IllegalStateException("Du har ikke nok penger på kontoen.");
		}
	}

	public double getCreditLine() {
		return kredittGrense;
	}

	public void setCreditLine(double kredittGrense) {
		if (kredittGrense < 0) {
			throw new IllegalArgumentException("Kredittgrensen kan ikke være negativ.");
		}
		if (balance < 0 && balance <= -kredittGrense) {
			throw new IllegalStateException("Kredittgrensen dekker ikke din eksisterende balanse.");
		}
		this.kredittGrense = kredittGrense;							
	}
}
