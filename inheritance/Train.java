package inheritance;

import java.util.ArrayList;
import java.util.Collection;

public class Train {

	private Collection<TrainCar> togVogner;

	public Train(){
		togVogner = new ArrayList<TrainCar>();
	}

	@Override
	public String toString(){
		String output = "";
		for (TrainCar vogn : togVogner) {
			output += vogn.toString() + "\n";
		}
		return output;
	}

	public boolean contains(TrainCar tc) {
		return togVogner.contains(tc);
	}

	public void addTrainCar(TrainCar car){
		togVogner.add(car);
	}

	public int getTotalWeight() {
		int totalWeight = 0;
		for (TrainCar tc : togVogner) {
			totalWeight += tc.getTotalWeight();
		}
		return totalWeight;
	}

	public int getPassengerCount() {
		int passengerCount = 0;
		for (TrainCar tc : togVogner) {
			if( tc instanceof PassengerCar)
				passengerCount += ((PassengerCar) tc).getPassengerCount();
		}
		return passengerCount;
	}

	public int getCargoWeight(){
		int cargoWeight = 0;
		for (TrainCar tc : togVogner) {
			if(tc instanceof CargoCar)
				cargoWeight += ((CargoCar) tc).getCargoWeight();
		}
		return cargoWeight;
	}
}