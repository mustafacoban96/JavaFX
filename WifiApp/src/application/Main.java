package application;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	
	private static Scene scene;
	
	@Override
	public void start(Stage primaryStage) throws IOException {
		scene  = new Scene(loadFXML("Sample"));
		primaryStage.setScene(scene);
		primaryStage.setTitle("Wifi-App");
		primaryStage.setMaxHeight(500);
		primaryStage.setMaxWidth(600);
		primaryStage.setResizable(false);
		primaryStage.show();
	}
	
	
	public static Parent loadFXML(String fxml) throws IOException{
		FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/view/" + fxml + ".fxml"));
		Parent parent = fxmlLoader.load();
		return parent;
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
