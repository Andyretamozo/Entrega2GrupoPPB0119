package Controlador;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class VistaRegistroController {


	private Stage stage2;
    @FXML
    private TextField txtEdad;
    

    @FXML
    private Button bttonRegistrarse;

    @FXML
    private TextField txtNombre;

    @FXML
    void showVistaBienvenida(ActionEvent event) throws IOException {
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vista/VistaBienvenida.fxml"));
    	Parent root = loader.load();
    	Scene scene = new Scene(root);
    	stage2.setScene(scene);
      	VistaBienvenidaController controller = loader.getController();
		//controller.setStage(stage2);
    	controller.init(txtNombre.getText(), stage2, this);
    	stage2.show();
  
    }



		public void setStage(Stage stage) throws IOException {

		this.stage2= stage;
	}







}
