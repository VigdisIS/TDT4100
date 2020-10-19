package patterns.delegation.office;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Printer {
	//Lager en ordered dictionary med printhistory tilhørende employee
	private HashMap<Employee, Collection<String>> printHistory;
	
	public Printer() {
		this.printHistory = new HashMap<Employee, Collection<String>>();
	}
	
	public void printDocument(String document, Employee employee) {
		//Sjekker om employee har en printhistory, lager en hvis ikke
		if (! printHistory.containsKey(employee)){
			printHistory.put(employee, new ArrayList<String>());
		}
		this.printHistory.get(employee).add(document);
		
		
	}
	
	public List<String> getPrintHistory(Employee employee){
		//Sjekker om employee har printhistory, returnerer en tom liste hvis ikke
		if (! printHistory.containsKey(employee)){
			return Collections.emptyList();
		}
		return new ArrayList<String>(printHistory.get(employee));
		
	}

}
