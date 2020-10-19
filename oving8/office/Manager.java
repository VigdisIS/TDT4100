package patterns.delegation.office;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.BinaryOperator;

public class Manager implements Employee{
	private List<Employee> employees;
	private List<Employee> copyOfEmployees;
	private int taskCount = 0;

	public Manager(List<Employee> employeeList) {
		if(employeeList.isEmpty()) {
			throw new IllegalArgumentException("This manager does not have any employees.");
		}
		this.employees = employeeList;
		this.copyOfEmployees = employees;
	}
	
	public Employee getEmployee() {
	    Random rand = new Random();
	    Employee randomEmployee = employees.get(rand.nextInt(employees.size()));
		
		return randomEmployee;
	}

	@Override
	public double doCalculations(BinaryOperator<Double> operation, double value1, double value2) {
		taskCount++;
		return getEmployee().doCalculations(operation, value1, value2);
	}

	@Override
	public void printDocument(String document) {
		taskCount++;
		getEmployee().printDocument(document);
	}

	@Override
	public int getTaskCount() {
		int task = 0; 
		 for(Employee e: employees) {
		 	task += e.getTaskCount(); 
		 }
		 return task; 

	}

	@Override
	public int getResourceCount() {
		int totalResources = 1;
		for (Employee employee : employees) {
			totalResources += employee.getResourceCount();
		}
		return totalResources;
        
	}
	
	public static void main(String[] args) {
		BinaryOperator<Double> add = (n1, n2) -> n1 + n2;
		BinaryOperator<Double> subtract = (n1, n2) -> n1 - n2;
		BinaryOperator<Double> multiply = (n1, n2) -> n1 * n2;
		BinaryOperator<Double> divide = (n1, n2) -> n1 / n2;
		
		
		Printer printer = new Printer();
		Clerk clerk1 = new Clerk(printer);
		Clerk clerk2 = new Clerk(printer);
		Clerk clerk3 = new Clerk(printer);
		
		List<Employee> employeeList = new ArrayList<Employee>();
		
		employeeList.add(clerk1);
		employeeList.add(clerk2);
		employeeList.add(clerk3);
		
		Manager manager1 = new Manager(employeeList);
		Manager manager2 = new Manager(employeeList);
		
		System.out.println(manager1.getResourceCount());
		System.out.println(manager1.getTaskCount());
		
		List<Employee> managerList = new ArrayList<Employee>();
		
		managerList.add(manager1);
		managerList.add(manager2);
		
		Manager supremeManager = new Manager(managerList);
		
		System.out.println(supremeManager.getResourceCount());
		System.out.println(supremeManager.getTaskCount());
		
		
		
		
		
		
        
        
	}

}
