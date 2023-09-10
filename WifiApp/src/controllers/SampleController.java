package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import model.WifiProfile;

public class SampleController{
	
	@FXML
	private Button showBtn;
	
	@FXML
	private ListView<String> myListView;
	
	@FXML
	private void showBtn() throws IOException {
		try {
			 ArrayList<WifiProfile> myList = null;
			 for (WifiProfile wifiProfile :ProcessController.mkDirectory()) {
				System.out.println(wifiProfile.getName() + " " + wifiProfile.getPassword());;
			}
			 
			 
			 
		} catch (IOException | ParserConfigurationException | SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	
	
	
}
