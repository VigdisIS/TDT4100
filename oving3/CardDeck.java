package encapsulation;

import java.util.ArrayList;
import java.util.Arrays;

public class CardDeck {
	ArrayList<Card> cardDeck = new ArrayList<Card>();
	private char kortFarge;	

	public CardDeck(int n) {
		System.out.println(n);
		
		if (n > 13 || n < 1) {
			throw new IllegalArgumentException("Card value out of bounds");
		}
		
		
		for(int x = 1; x <= 4 ; x++) {
			if (x == 1) {
				System.out.println(x);
				this.kortFarge = 'S';
			} else if (x == 2) {
				this.kortFarge = 'H';
			} else if (x == 3) {
				this.kortFarge = 'D';
			} else {
				this.kortFarge = 'C';
			}
			System.out.println(this.kortFarge);
			
			for(int i=1 ; i<=n ; i++) {
				Card nyttKort = new Card(this.kortFarge,i);
				System.out.println(nyttKort);
				cardDeck.add(nyttKort);
				System.out.println(cardDeck);
			}
		}
	}

	public int getCardCount() {
		int cardCount = cardDeck.size();
		return cardCount;
	}

	public Card getCard(int n) {
		Card kort = cardDeck.get(n);
		return kort;
		
	}
	
	public void shufflePerfectly() {
		int size = getCardCount();
		int x = 1;
		for (int i = size/2; i < size; i++) {
			cardDeck.add(x, cardDeck.get(i));
			cardDeck.remove(i+1);
			x += 2;
		}

	}
	
	static boolean sortertKortstokk(Object[] kortstokk_for, Object[] kortstokk) {
			if (!Arrays.equals(kortstokk_for, kortstokk)) {
				return false;
			}return true;
		} 
		

	public static void main(String[] args) {
		CardDeck kortstokk = new CardDeck(4);
		System.out.println(kortstokk.getCardCount());
		System.out.println(kortstokk.getCard(1));
		kortstokk.shufflePerfectly();
	}

}






