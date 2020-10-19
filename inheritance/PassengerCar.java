package inheritance;

public class PassengerCar extends TrainCar{
	private static final int passasjererVekt = 80;

	private int passasjerer;

	public PassengerCar(int vekt, int passasjerer) {
		super(vekt);
		this.passasjerer = passasjerer;
	}

	protected String getTrainCarType() {
		return "passenger car";
	}

	public int getPassengerCount(){
		return passasjerer;
	}

	public void setPassengerCount(int passasjerer){
		this.passasjerer = passasjerer;
	}

	public int getTotalWeight(){
		return super.getTotalWeight() + (passasjerer*passasjererVekt);
	}

}
