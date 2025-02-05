package app2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application{

	@Override
	public void start(final Stage primaryStage) throws Exception {
		primaryStage.setTitle("My Application");
		primaryStage.setScene(new Scene(FXMLLoader.load(App.class.getResource("App.fxml"))));
		String css = this.getClass().getResource("style.css").toExternalForm();
		primaryStage.getScene().getStylesheets().clear();
		primaryStage.getScene().getStylesheets().add(css);
		primaryStage.show();
	}

	public static void main(final String[] args) {
		App.launch(args);
	}
}

