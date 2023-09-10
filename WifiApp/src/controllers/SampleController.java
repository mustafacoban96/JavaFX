package controllers;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;

import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import model.WifiProfile;

public class SampleController{
	
	@FXML
	private Button showBtn;
	
	@FXML
	private ListView<WifiProfile> myListView;
	
	ObservableList<WifiProfile> myData = FXCollections.observableArrayList();
	
	
	public static void deleteDirectory(Path directory) throws IOException {
        Files.walk(directory)
                .sorted(Comparator.reverseOrder())
                .map(Path::toFile)
                .forEach(File::delete);
    }
	
	@FXML
	private void showBtn() throws IOException {
		
		try {
			 ArrayList<WifiProfile> myList = new ArrayList<WifiProfile>();
			 for (WifiProfile wifiProfile :ProcessController.mkDirectory()) {
				if(wifiProfile != null) {
					myData.add(wifiProfile);
				}
			}
			
			 myListView.setItems(myData);
			 Path mypath = Path.of(ProcessController.MY_PATH);
			 deleteDirectory(mypath);
			 showBtn.setDisable(true);
			 
			 
		} catch (IOException | ParserConfigurationException | SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	


	
	
	
}
