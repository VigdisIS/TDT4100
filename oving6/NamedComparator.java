package interfaces;

public class NamedComparator implements Comparable<NamedComparator>{

	/*public NamedComparator() {
		
	}*/

	public static int compare(Named named1, Named named2) {
		if(!named1.getFamilyName().equals(named2.getFamilyName())) {
			System.out.println(named1.getFamilyName());
			System.out.println(named2.getFamilyName());
			System.out.println("Etternavn er ulike.");
			int var1 = named1.getFamilyName().toLowerCase().compareTo(named2.getFamilyName().toLowerCase());
			if(var1 > 0) {
				// Hvis etternavnene er sortert
				return 1;
			} else {
				return -1;
			}
		} else {
			if(!named1.getGivenName().equals(named2.getGivenName())) {
				System.out.println("Fornavn er ulike.");
				int var2 = named1.getGivenName().toLowerCase().compareTo(named2.getGivenName().toLowerCase());
				if(var2 > 0) {
					// Hvis navene er sortert
					return 1;
				} else {
					return -1;
				}
			
			}else {
				System.out.println("Både fornavn og etternavn er like.");
				return 0;
			}
			}
		
		
	}

	@Override
	public int compareTo(NamedComparator o) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	public static void main(String[] args) {
		Person1 pers1 = new Person1("Ole", "Jordmann");
		Person2 pers2 = new Person2("Noen Noensen");
		Person2 pers3 = new Person2("Noen Noensen");
		
		System.out.print("skal være negativ: ");
		System.out.println(compare(pers1, pers2));
		
		System.out.print("skal være positiv: ");
		System.out.println(compare(pers2, pers1));
		
		System.out.print("skal være 0: ");
		System.out.println(compare(pers2, pers3));
	}
}
