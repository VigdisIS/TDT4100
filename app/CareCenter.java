package app2;

import java.util.Random;

public class CareCenter {
	
	public String feed() {
		return "Pet was fed.";
	}
	
	public String play() {
		return "Pet enjoyed playing with you.";
	}
	
	public String discipline() {
		return "Pet was disciplined.";
	}
	
	public boolean calcMischief(double disciplineVal) {
		Random rand = new Random();
		if (rand.nextDouble() < disciplineVal) {
			return true;
		}return false;
	}
}
