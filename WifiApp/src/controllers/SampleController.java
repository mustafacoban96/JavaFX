package controllers;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

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
		try {
			ProcessController.mkDirectory();
		} catch (IOException | ParserConfigurationException | SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
