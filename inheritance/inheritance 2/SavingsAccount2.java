package inheritance;

public class SavingsAccount2 extends AbstractAccount{

	private int uttak;
	private final double avgift;

	public SavingsAccount2(int uttak, double avgift) {
		super();
		this.uttak = uttak;
		this.avgift = avgift;
	}

	@Override
	protected void internalWithdraw(double beløp) {
		if (beløp > balance) {
			throw new IllegalStateException("Du har ikke nok penger på konto.");
		}
		if (uttak > 0) { //SavingsAcc må alltid være positiv, ellers vil det bli gebyr
			balance -= beløp;
			uttak -= 1;
		} else if (balance >= beløp + avgift) {
			balance -= (beløp + avgift);
		} else {
			throw new IllegalStateException("Kan ikke ta ut mer.");
		}
	}
}
