package application;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import Model.Model;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class SampleController implements Initializable{
	@FXML
	private Button addMissionBtn;
	@FXML
	private TextField missionDescription;
	@FXML
	private DatePicker datePicker;
	@FXML
	private ListView<Model> eventListView;
	
	@FXML
	private Button deleteMissionBtn;
	
	ObservableList<Model> myData = FXCollections.observableArrayList();
	
	@FXML
	private void buttonWorkingCode(ActionEvent e) {
		
		var newMission = new Model(datePicker.getValue(), missionDescription.getText());
		myData.add(newMission);
		eventListView.setItems(myData);
		missionDescription.clear();
	}
	
	@FXML
	private void deleteMission(ActionEvent e) {
		myData.remove(eventListView.getSelectionModel().getSelectedIndex());
		
		
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		datePicker.setValue(LocalDate.now());
	}
	
}
