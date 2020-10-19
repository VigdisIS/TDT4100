package patterns.delegation.office;

import java.util.function.BinaryOperator;

//import javafx.print.Printer;

public class Clerk implements Employee {
	private Printer printer;
	private int timesCalculated = 0;

	public Clerk(Printer printer){
		this.printer = printer;
	}

	@Override
	public double doCalculations(BinaryOperator<Double> operation, double value1, double value2) {
		double result = operation.apply(value1,value2);
		timesCalculated++;
		return result;
	}

	@Override
	public void printDocument(String document) {
		printer.printDocument(document, this);
		
	}

	@Override
	public int getTaskCount() {
		return printer.getPrintHistory(this).size() + timesCalculated;
	}

	@Override
	public int getResourceCount() {
		return 1;
	}

}
