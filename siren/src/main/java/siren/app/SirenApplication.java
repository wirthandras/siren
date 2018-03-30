package siren.app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class SirenApplication extends Application {

	private final String title = "siren application";

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		AnchorPane pane = FXMLLoader.load(getClass().getResource(Descpritors.CAR_PATH));
		Scene scene = new Scene(pane);
		primaryStage.setTitle(title);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}
