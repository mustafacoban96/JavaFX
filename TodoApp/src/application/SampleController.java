package application;

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
	private ListView<String> eventListView;
	
}
