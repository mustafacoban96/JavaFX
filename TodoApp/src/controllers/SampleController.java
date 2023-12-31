package controllers;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import Model.Model;
import application.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import missionSerializer.MissionSerializer;
import router.Routing;

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
	private void buttonWorkingCode() {
		
		var newMission = new Model(datePicker.getValue(), missionDescription.getText());
		myData.add(newMission);
		eventListView.setItems(myData);
		missionDescription.clear();
	}
	
	@FXML
	private void deleteMission(ActionEvent e) {
		myData.remove(eventListView.getSelectionModel().getSelectedIndex());
		
		
	}
	
	@FXML
	private void textFieldEnter(KeyEvent e) {
		if(e.getCode() == KeyCode.ENTER) {
			buttonWorkingCode();
		}
	}
	
	
	public Object[] getMissions() {
		
		return eventListView.getItems().toArray();
	}
 	
	@FXML
	private void loginBtn() throws IOException {
		/*Stage primaryStage = new Stage();
		Scene primaryScene = new Scene(Main.loadFXML("GirisPaneli"));
		primaryStage.setScene(primaryScene);
		primaryStage.show();*/
		
		Routing.redirectPage("Giris Paneli", "GirisPaneli", null, StageStyle.DECORATED, true);
	}
	
	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		datePicker.setValue(LocalDate.now());
		
		try {
			var missions = MissionSerializer.deserializer();
			eventListView.getItems().addAll(missions);
		}catch (Exception e) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("TodoApp Hatası");
			alert.setHeaderText("Görevler Yüklenmedi dosya sistemini kontrol ediniz.");
		}
	}
	
}
