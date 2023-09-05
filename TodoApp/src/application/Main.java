package application;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.stage.Stage;
import missionSerializer.MissionSerializer;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	
	private static SampleController appController;
	private static Scene scene;
	
	@Override
	public void start(Stage primaryStage) throws IOException {
		scene = new Scene(loadFXML("Sample"));
		primaryStage.setScene(scene);
		primaryStage.setTitle("TODO APP");
		primaryStage.show();
	}
	
	@Override
	public void stop() throws IOException{
		MissionSerializer.serialize(appController.getMissions());
	}
	
	private static Parent loadFXML(String fxml) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/application/" + fxml + ".fxml"));
		Parent parent = fxmlLoader.load();
		appController = fxmlLoader.getController();
		return parent;
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
