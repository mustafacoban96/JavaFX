module WifiApp {
	requires javafx.controls;
	requires javafx.fxml;
	requires com.jfoenix;
	opens controllers to javafx.graphics, javafx.fxml;
	opens application to javafx.graphics, javafx.fxml;
}
