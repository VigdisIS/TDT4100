package interfaces;

public interface Named {
	//public static final String givenName = "";
	//public static final String familyName = "";
	//public static final String fullName = "";
	
	//Setter fornavn
	public void setGivenName(String givenName);
	
	//Henter fornavn
	public String getGivenName();
	
	//Setter etternavn
	public void setFamilyName(String familyName);
	
	//Henter etternavn
	public String getFamilyName();
	
	//Setter hele navnet
	public void setFullName(String fullName);
	
	
	//Henter hele navnet
	public String getFullName();
}
