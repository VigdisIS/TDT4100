package inheritance;

public class CargoCar extends TrainCar{
	private int lastVekt;
	
	public CargoCar(int vekt, int lastVekt) {
		super(vekt);
		this.lastVekt = lastVekt;
	}

	public int getCargoWeight() {
		return lastVekt;
	}

	public void setCargoWeight(int lastVekt) {
		this.lastVekt = lastVekt;
	}

	public int getTotalWeight(){
		return super.getTotalWeight() + lastVekt;
	}

}
