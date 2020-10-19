package interfaces;


public class Person2 implements Named {
	//String givenName;
	//String familyName;
	String fullName;

	public Person2(String fullName) {
		this.fullName = fullName;
		
	}
	
	//Setter fornavn
		public void setGivenName(String givenName) {
			String[] splittet_navn = this.getFullName().split(" ");
			splittet_navn[0] = givenName;
			this.setFullName(splittet_navn[0] + " " + splittet_navn[1]);
		}
		
		//Henter fornavn
		public String getGivenName() {
			String[] splittet_navn = this.getFullName().split(" ");
			return splittet_navn[0];
		}
		
		//Setter etternavn
		public void setFamilyName(String familyName) {
			String[] splittet_navn = this.getFullName().split(" ");
			splittet_navn[1] = familyName;
			this.setFullName(splittet_navn[0] + " " + splittet_navn[1]);
			
		}
		
		//Henter etternavn
		public String getFamilyName() {
			String[] splittet_navn = this.getFullName().split(" ");
			return splittet_navn[1];
		}
		
		//Setter hele navnet
		public void setFullName(String fullName) {
			this.fullName = fullName;
		}
		
		//Henter hele navnet
		public String getFullName() {
			return fullName;
			
		}
		
		public static void main(String[] args) {
			
			Person2 pers2 = new Person2("Oleee Nordmann");
			
			System.out.println(pers2.getGivenName());
			System.out.println(pers2.getFamilyName());
			System.out.println(pers2.getFullName());
			
			pers2.setGivenName("Jens");
			System.out.println(pers2.getGivenName());
			System.out.println(pers2.getFullName());
			pers2.setFamilyName("Stoltenberg");
			System.out.println(pers2.getFullName());
		}

		
		

}
