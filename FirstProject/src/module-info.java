module FirstProject {
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.swing;
	
	opens application to javafx.graphics, javafx.fxml;
}
