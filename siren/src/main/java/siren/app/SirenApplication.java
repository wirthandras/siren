package siren.app;

import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class SirenApplication extends Application {
	
	private static final String FXML_DESCRIPTOR = "siren.fxml.descriptor";

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		String formPath = System.getProperty(FXML_DESCRIPTOR);
		FXMLLoader loader = new FXMLLoader(getClass().getResource(formPath));
		ResourceBundle texts = ResourceBundle.getBundle("texts");
		loader.setResources(texts);
		AnchorPane pane = loader.load();
		Scene scene = new Scene(pane);
		primaryStage.setTitle(texts.getString(TextIds.APP_TITLE));
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}
