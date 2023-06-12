package application;
	
import java.io.IOException;

import Controlador.VistaPrincipalController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) throws IOException {
		FXMLLoader loader = new FXMLLoader (getClass().getResource("/Vista/VistaPrincipal.fxml"));
		Parent root = loader.load();
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		VistaPrincipalController controller = loader.getController();
		controller.setStage(primaryStage);
		primaryStage.show();
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}