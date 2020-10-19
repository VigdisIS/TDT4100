package stateandbehavior;

public class UpOrDownCounter {
	private int counter;
    private int end;

	public UpOrDownCounter(int start, int end) {
		this.counter = start;
        this.end = end;
        if (this.counter == this.end) {
        	throw new IllegalArgumentException("Start-verdien kan ikke være lik slutt-verdien.");
        }
	}
	
	public int getCounter() {
		return this.counter;
	}
	
	public boolean count() {
		System.out.println(this.counter);
		if (this.counter > this.end) {
			this.counter -= 1;
			System.out.println("Telleren har tellt ned én.");
			System.out.println("Telleren er nå på " + this.counter);
			return true;
		} else if (this.counter < this.end) {
			this.counter += 1;
			System.out.println("Telleren har tellt opp én.");
			System.out.println("Telleren er nå på " + this.counter);
			return true;
		} else {
			return false;
		}
	}
	
	public String toString() {
		return "Telleren er på " + String.valueOf(this.counter);
	}


	public static void main(String[] args) {
		UpOrDownCounter teller = new UpOrDownCounter(7,1);
		
		if (teller.counter > teller.end) {
			for(int i=0;i==(teller.counter - teller.end);i++) {
				teller.count();
				System.out.println(teller);
			}

		} else if (teller.counter < teller.end) {
			for(int i=0;i==(teller.end - teller.counter);i++) {
				teller.count();
				System.out.println(teller);
			}
		}
		

	} 
	
}
