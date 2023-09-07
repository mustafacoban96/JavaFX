package controllers;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

public class SampleController {
	
	@FXML
	private Button showBtn;
	
	@FXML
	private ListView<String> myListView;
	
	
	
	@FXML
	private void ShowBtn() throws IOException {
		ProcessController.mkDirectory();
	}
	
	
}
