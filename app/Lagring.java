package app2;

public interface Lagring {
	//Skriver til fil
	public void writeToFile(String filNavn, PetNumber progBarVerdi);
	
	//Leser fra fil
	public String readFromFile(String filNavn, PetNumber progBarVerdi);
}
