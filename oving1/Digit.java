package stateandbehavior;

public class Digit {
	private int tallsystem;
	private int siffer_verdi;

	public Digit() {
		this.tallsystem = 10;
		this.siffer_verdi = 0;
	}

	public int getValue() {
		return this.siffer_verdi;
	}
	
	public boolean increment() {
		if(this.siffer_verdi == this.tallsystem) {
			this.siffer_verdi = 0;
			return true;
		} else {
			return false;
		}
	}
	
	public int getBase() {
		return this.tallsystem;
	}
	
	
	public static void main(String[] args) {
		Digit digit = new Digit();
		digit.increment();
		

	}

}
