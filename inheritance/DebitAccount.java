package inheritance;

public class DebitAccount extends AbstractAccount{

	@Override
	protected void internalWithdraw(double beløp) {
		if (beløp > getBalance()) { //Konto må alltid være >= 0
			throw new IllegalStateException("Du har ikke nok penger på kontoen.");
		}			
		super.balance -= beløp;
	}

}
