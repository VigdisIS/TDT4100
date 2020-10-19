package interfaces;


public class Person1 implements Named {
	String givenName;
	String familyName;

	public Person1(String givenName, String familyName) {
		this.givenName = givenName;
		this.familyName = familyName;
		
	}
	
	//Setter fornavn
		public void setGivenName(String givenName) {
			this.givenName = givenName;
		}
		
		//Henter fornavn
		public String getGivenName() {
			return givenName;
		}
		
		//Setter etternavn
		public void setFamilyName(String familyName) {
			this.familyName = familyName;
			
		}
		
		//Henter etternavn
		public String getFamilyName() {
			return this.familyName;
			
		}
		
		//Setter hele navnet
		public void setFullName(String fullName) {
		
		}
		
		//Henter hele navnet
		public String getFullName() {
			String fullName = this.getGivenName() + " " + this.getFamilyName();
			return fullName;
			
		}
		
		public static void main(String[] args) {
			
			Person1 pers1 = new Person1("Oleee", "Nordmann");
			
			System.out.println(pers1.getGivenName());
			System.out.println(pers1.getFamilyName());
			System.out.println(pers1.getFullName());
		}

		
		

}
