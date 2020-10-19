package interfaces;

import java.util.Arrays;
import java.util.function.BinaryOperator;
import java.util.Iterator;

public class BinaryComputingIterator implements Iterator<Double> {
	private Iterator<Double> it1;
	private Iterator<Double> it2;
	private BinaryOperator<Double> op;
	private Double default1;
	private Double default2;

	BinaryComputingIterator(Iterator<Double> iterator1, Iterator<Double> iterator2, BinaryOperator<Double> operator){
		this.it1 = iterator1;
		this.it2 = iterator2;
		this.op = operator;
	}
	
	BinaryComputingIterator(Iterator<Double> iterator1, Iterator<Double> iterator2, Double default1, Double default2, BinaryOperator<Double> operator){
		this.it1 = iterator1;
		this.it2 = iterator2;
		this.op = operator;
		this.default1 = default1;
		this.default2 = default2;
		
	}
	
	public boolean hasNext() {
		return (it1.hasNext() || default1 != null) && (it2.hasNext() || default2 != null) && (it1.hasNext() || it2.hasNext());
	}
	
	public Double next() {
		final Double next1 = (it1.hasNext() ? it1.next() : default1);
		final Double next2 = (it2.hasNext() ? it2.next() : default2);
		return op.apply(next1, next2);
	}
		
	public static void main(String[] args) {
		Iterator<Double> iterator1 = (Iterator<Double>) Arrays.asList(2.0, 3.0).iterator();
		Iterator<Double> iterator2 = (Iterator<Double>) Arrays.asList(5.0).iterator();

		BinaryOperator<Double> addition = (a, b) -> a + b;

		// Opprett en ny BinaryComputingIterator som tar inn iterator1 og iterator2 og utfører addisjon på verdiene.
		BinaryComputingIterator binaryIterator = new BinaryComputingIterator(iterator1, iterator2, null, 10.0, addition);

		binaryIterator.next();   // 7.0
		binaryIterator.hasNext(); // true
		binaryIterator.next();    // 13.0
		binaryIterator.hasNext(); // false

	}
}
