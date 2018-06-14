package siren.app.gui;

import java.io.IOException;
import java.util.ResourceBundle;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.TreeItem;
import javafx.scene.layout.AnchorPane;

public class SirenTreeItem extends TreeItem<String> {

	private AnchorPane pane;

	public SirenTreeItem(String title, String formPath) {
		super(title);
		FXMLLoader loader = new FXMLLoader(getClass().getResource(formPath));
		ResourceBundle texts = ResourceBundle.getBundle("texts");
		loader.setResources(texts);
		try {
			pane = loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public AnchorPane getPane() {
		return pane;
	}

}
