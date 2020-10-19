package app2;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;

public class AppController{
	private CareCenter careCenter = new CareCenter();
	private PetNumber petNumH = new PetNumber();
	private PetNumber petNumP = new PetNumber();
	private PetNumber petNumD = new PetNumber();
	private PetNumber overallProgVal = new PetNumber();
	private LoadSavedValues progress = new LoadSavedValues();
	private Timer deplete = new Timer();
	
	@FXML
	private ProgressBar overallProg;
	
	@FXML
	private TextArea statusText;
	
	@FXML
	private Button feedBtn;
	@FXML
	private Button playBtn;
	@FXML
	private Button disciplineBtn;
	
	@FXML
	private Button saveBtn;
	
	@FXML
	private Pane petPane;
	
	@FXML
	private Pane bgpane;
	
	@FXML
	private ProgressBar hPBStatus;
	@FXML
	private ProgressBar pPBStatus;
	@FXML
	private ProgressBar dPBStatus;
	
	
	public class Deplete extends TimerTask{
		@Override
		public void run() {
			deplete();
		     }
		}

	public void initialize(){
		String[] data_split = progress.readFromFile("appProgress.txt", petNumH).split("\n");
		String petH = data_split[0];
		String petP = data_split[1];
		String petD = data_split[2];

		petNumH.setNumber(Double.valueOf(petH));
		petNumP.setNumber(Double.valueOf(petP));
		petNumD.setNumber(Double.valueOf(petD));
		statusText.setText("Loaded data from last save successfully.");
		overallBar();
		
		hPBStatus.progressProperty().bind(petNumH.numberProperty());
		pPBStatus.progressProperty().bind(petNumP.numberProperty());
		dPBStatus.progressProperty().bind(petNumD.numberProperty());
		
		overallProg.progressProperty().bind(overallProgVal.numberProperty());
		
		//Timer deplete = new Timer();
		deplete.schedule(new Deplete(), 0, 4000);		
	}
	
	public void feedBtn(ActionEvent event) {
		if (careCenter.calcMischief(petNumD.getNumber())){
			if(petNumH.getNumber() < 0.9) {
				statusText.setText(careCenter.feed());
				petNumH.setNumber(petNumH.getNumber() + 0.1);
			} else {
				statusText.setText("Pet does not need to be fed right now.");
			}
		} else{
			statusText.setText("Pet does not want to be fed right now.");
		}
		overallBar();
	}
	
	public void playBtn(ActionEvent event) {
		if (careCenter.calcMischief(petNumD.getNumber())){
			if(petNumP.getNumber() <0.9) {
				statusText.setText(careCenter.play());
				petNumP.setNumber(petNumP.getNumber() + 0.1);
			} else {
				statusText.setText("Pet does not need to be played with right now.");
			}
			
		} else {
			statusText.setText("Pet does not want to play with you right now.");
		}
		overallBar();
	}
	
	public void disciplineBtn(ActionEvent event) {
		if(petNumD.getNumber() < 0.9) {
			statusText.setText(careCenter.discipline());
			petNumD.setNumber(petNumD.getNumber() + 0.1);
		} else {
			statusText.setText("Pet does not need to be disciplined right now.");
		}
		}
	
	public boolean checkHealth() {
		if(petNumH.getNumber() < 0.1 || petNumP.getNumber() < 0.1) {
			death();
			return false;
		} else {
			return true;
		}
	}
	
	
	public void deplete() {
		petNumH.setNumber(petNumH.getNumber() - 0.1);
		petNumP.setNumber(petNumP.getNumber() - 0.1);
		petNumD.setNumber(petNumD.getNumber() - 0.1);
		overallBar();
		checkHealth();
	}
	
	public void overallBar() {
		overallProgVal.setNumber(((petNumH.getNumber() + petNumP.getNumber())/2));
	}
	
	public void death() {
		feedBtn.setDisable(true);
		playBtn.setDisable(true);
		disciplineBtn.setDisable(true);
		
		hPBStatus.setDisable(true);
		pPBStatus.setDisable(true);
		dPBStatus.setDisable(true);
		
		deplete.cancel();
		deplete.purge();
		
		statusText.setText("Your pet has died.");
	}
	
	public void saveProgress() throws FileNotFoundException, IOException {
		new FileOutputStream("appProgress.txt").close(); //Fjerner content i txt-filen
		progress.writeToFile("appProgress.txt", petNumH);
		progress.writeToFile("appProgress.txt", petNumP);
		progress.writeToFile("appProgress.txt", petNumD);
		System.out.println("Lagring ferdig.");
		statusText.setText("Your progress was saved successfully.");
		
	}



	
	
	
}