package router;

import java.io.IOException;

import application.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Routing {
	
	


	public static void redirectPage(String title,String location,String cssLocation,StageStyle style,boolean resziable) throws IOException{
		Stage primaryStage = new Stage();
		Scene scene = new Scene(loadFXML(location));
		
		if(cssLocation != null) {
			scene.getStylesheets().add(Main.class.getResource(cssLocation).toExternalForm());
		}
		if(style != null) {
			primaryStage.initStyle(style);
		}
		else {
			primaryStage.initStyle(StageStyle.DECORATED);
		}
		primaryStage.setTitle(title);
		primaryStage.setResizable(resziable);
		primaryStage.show();
	}
	
	
	private static Parent loadFXML(String fxml) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/views/" + fxml + ".fxml"));
		Parent parent = fxmlLoader.load();
		return parent;
	}

}
