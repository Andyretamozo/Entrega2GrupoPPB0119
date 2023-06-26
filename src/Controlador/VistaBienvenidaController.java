package Controlador;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class VistaBienvenidaController {
	private VistaRegistroController reController;
	private Stage Bienve;
	//private Stage Nivel1;
    @FXML
    private Label nombreBienvenido;
    
    
    @FXML
    void btoIniciarJuego(ActionEvent event) throws IOException {
    	
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vista/VistaNivel1.fxml"));
    	Parent root = loader.load();
    	Scene scene = new Scene(root);
    	Bienve.setScene(scene);
      	VistaNivel1Controller controller = loader.getController();
		controller.setStage(Bienve);
    	//controller.init(txtNombre.getText(), stage2, this);
    	Bienve.show();
    }
        

	public void init(String text, Stage stage2, VistaRegistroController vistaRegistroController) {

		nombreBienvenido.setText(text);
		this.Bienve = stage2;
		this.reController = vistaRegistroController;
	}







}
