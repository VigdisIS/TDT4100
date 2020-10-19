package encapsulation;

public class Card {
	private int tallVerdi;
	private char kortFarge;

	public Card(char kortFarge, int tallVerdi) {
		
		if (tallVerdi > 13 || tallVerdi < 1 || kortFarge != 'S' && kortFarge != 'H' && kortFarge != 'D' && kortFarge != 'C'){
			throw new IllegalArgumentException("The card value or cardback value is invalid.");
		}
		this.kortFarge = kortFarge;
		this.tallVerdi = tallVerdi;
	}
	
	public char getSuit() {
		return kortFarge;
	}
	
	public int getFace() {
		return tallVerdi;
	}
	
	public String toString() {
		return kortFarge+String.valueOf(tallVerdi);
	}	
	
public static void main(String[] args) {
		Card kort = new Card('S',4);
		System.out.println(kort);

	}

}
