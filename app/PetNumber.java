package app2;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class PetNumber {
	private DoubleProperty number;
	
	public double getNumber() {
		if (number!= null) {
			return number.get();
		}return 0;
	}	
	
	public final void setNumber(double number) {
		this.numberProperty().set(number);
	}

	public final DoubleProperty numberProperty() {
		if(number == null) {
			number = new SimpleDoubleProperty(0);
		}
		return number;
	}
}
