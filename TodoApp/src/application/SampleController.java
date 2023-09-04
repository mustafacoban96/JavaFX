package application;

import Model.Model;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class SampleController {
	@FXML
	private Button addMissionBtn;
	@FXML
	private TextField missionDescription;
	@FXML
	private DatePicker datePicker;
	@FXML
	private ListView<Model> eventListView;
	
	ObservableList<Model> myData = FXCollections.observableArrayList();
	
	@FXML
	private void buttonWorkingCode(ActionEvent e) {
		
		var newMission = new Model(datePicker.getValue(), missionDescription.getText());
		myData.add(newMission);
		eventListView.setItems(myData);
	}
	
}
