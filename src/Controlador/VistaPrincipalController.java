package Controlador;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class VistaPrincipalController {

	private Stage stage;
    @FXML
    private Button bttonRegistro1;
    
    @FXML
    private Text txtName;

    @FXML
    private Button bttonsalir;

    @FXML
    void salirJuego(ActionEvent event) {
    	this.stage.close();
    }

    @FXML
    void showVistaRegistro(ActionEvent event) throws IOException {
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vista/VistaRegistro.fxml"));
    	Parent root = loader.load();
    	VistaRegistroController controller = loader.getController();
    	Scene scene = new Scene(root);
    	Stage stage = new Stage();
		stage.setTitle("Matemax: calcula y combina");
    	stage.setScene(scene);
		controller.setStage(stage);
		this.stage.close();
    	stage.show();
    	
    }

	public void setStage(Stage primaryStage) {
		stage = primaryStage;
		
	}

}
