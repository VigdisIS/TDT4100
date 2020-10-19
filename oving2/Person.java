package encapsulation;

import java.util.Arrays;
import java.util.Date;

public class Person {
	private String name;
	private String email;
	private Date birthday;
	private char gender;

	public Person(String name, String email, Date birthday, char gender) {
		this.name = name;
		this.email = email;
		this.birthday = birthday;
		this.gender = gender;
	}
	
	public Person(){
		
	}

	public void setName(String nyttNavn) {
		if(!nyttNavn.contains(" ")) {
			throw new IllegalArgumentException("You must write two names.");
		}
		String[] name_lname = nyttNavn.split(" ");
		int firstname_length = name_lname[0].length();
		int lastname_length = name_lname[1].length();
		
		for (int i = 0; i < nyttNavn.length(); i++) {
	        char c = nyttNavn.charAt(i);
	        if (! (Character.isLetter(c) || c == ' ' || c == '-')) {
	        	throw new IllegalArgumentException("The name cannot contain special characters.");
	        }
	    }

		if(name_lname.length > 2 || firstname_length < 2 || lastname_length < 2) {
			throw new IllegalArgumentException("You can only write your first and last name, separated by space. The names must be longer than two characters.");
		} this.name = nyttNavn;
		System.out.println("Nytt navn er "+nyttNavn);
	} 
	
	public String getName() {
		return name;
	}
	
	public void setEmail(String nyEmail) {
		String navn = this.getName();
		String lowercasenavn = navn.toLowerCase();
		
		
		if(nyEmail.contains("(at)")) {
			throw new IllegalArgumentException("Invalid email.");
		}
		
		String navnMPunkt = lowercasenavn.replace(" ", ".");

		String[] email_end = nyEmail.split("@");

		String etter_at = email_end[1];
		
		if(!etter_at.contains(".")) {
			throw new IllegalArgumentException("Invalid email.");
		}
		
	
		String[] splittet_igjen = etter_at.split("\\.");
		
		String landskode = splittet_igjen[1];
		
		String[] ISO = {"ad", "ae", "af", "ag", "ai", "al", "am", "ao", "aq", "ar", "as", "at", "au", "aw", "ax", "az", "ba", "bb", "bd", "be", "bf", "bg", "bh", "bi", "bj", "bl", "bm", "bn", "bo", "bq", "br", "bs", "bt", "bv", "bw", "by", "bz", "ca", "cc", "cd", "cf", "cg", "ch", "ci", "ck", "cl", "cm", "cn", "co", "cr", "cu", "cv", "cw", "cx", "cy", "cz", "de", "dj", "dk", "dm", "do", "dz", "ec", "ee", "eg", "eh", "er", "es", "et", "fi", "fj", "fk", "fm", "fo", "fr", "ga", "gb", "gd", "ge", "gf", "gg", "gh", "gi", "gl", "gm", "gn", "gp", "gq", "gr", "gs", "gt", "gu", "gw", "gy", "hk", "hm", "hn", "hr", "ht", "hu", "id", "ie", "il", "im", "in", "io", "iq", "ir", "is", "it", "je", "jm", "jo", "jp", "ke", "kg", "kh", "ki", "km", "kn", "kp", "kr", "kw", "ky", "kz", "la", "lb", "lc", "li", "lk", "lr", "ls", "lt", "lu", "lv", "ly", "ma", "mc", "md", "me", "mf", "mg", "mh", "mk", "ml", "mm", "mn", "mo", "mp", "mq", "mr", "ms", "mt", "mu", "mv", "mw", "mx", "my", "mz", "na", "nc", "ne", "nf", "ng", "ni", "nl", "no", "np", "nr", "nu", "nz", "om", "pa", "pe", "pf", "pg", "ph", "pk", "pl", "pm", "pn", "pr", "ps", "pt", "pw", "py", "qa", "re", "ro", "rs", "ru", "rw", "sa", "sb", "sc", "sd", "se", "sg", "sh", "si", "sj", "sk", "sl", "sm", "sn", "so", "sr", "ss", "st", "sv", "sx", "sy", "sz", "tc", "td", "tf", "tg", "th", "tj", "tk", "tl", "tm", "tn", "to", "tr", "tt", "tv", "tw", "tz", "ua", "ug", "um", "us", "uy", "uz", "va", "vc", "ve", "vg", "vi", "vn", "vu", "wf", "ws", "ye", "yt", "za", "zm", "zw"};
		boolean contains = Arrays.stream(ISO).anyMatch(landskode::equals);
		
		String korrekt_email = (navnMPunkt + "@" + splittet_igjen[0] + "."+splittet_igjen[1]);
		
		//if (!(nyEmail == null)) {
			if ((!nyEmail.contains(korrekt_email)) || contains == false){
				throw new IllegalArgumentException("The email is invalid.");
			} this.email = nyEmail;
			System.out.println("Ny email er "+nyEmail);
		}
		//}

	public String getEmail() {
		return email;
	}
	
	public void setBirthday(Date nyBursdag) {
		long dateOne = new Date().getTime();
		
		long birthday = nyBursdag.getTime();
		
		if(dateOne - birthday < 0) {
			throw new IllegalArgumentException("The date of birth cannot be in the future.");
		} this.birthday = nyBursdag;
		System.out.println("Ny fødselsdato er "+nyBursdag);
        
	}
	public Date getBirthday() {
		return birthday;
	}
	
	public void setGender(char nyttKjonn) {
		if(nyttKjonn == 'M' || nyttKjonn == 'F' || nyttKjonn == '\0') {
			this.gender = nyttKjonn;
			System.out.println("Nytt kjønn er "+nyttKjonn);
		} else if (nyttKjonn != 'M' || nyttKjonn != 'F' || nyttKjonn != '\0') {
			throw new IllegalArgumentException("The gender must be either female, male or other");
		}
	}
	
	public char getGender(){
		return gender;
	}
	
	public static void main(String[] args) {
		Person pers = new Person("Vigdis Steinsund", "vigdisssteinsund@hotmail.com", new Date(200000), 'F');
		pers.setName("ola nordmann");
		pers.setEmail("ola.nordmann(at)ntnu.no");
		pers.setBirthday(new Date(1000000));
		pers.setGender('M');
		

	}

}
