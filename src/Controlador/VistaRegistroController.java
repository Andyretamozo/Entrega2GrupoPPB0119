package Controlador;

import java.io.IOException;

import application.alertaGeneral;
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

        if (txtNombre.getText().isEmpty() || txtEdad.getText().isEmpty()) {

            alertaGeneral.showAlert("Comprobar campos", "Complete los campos nombre y edad");
            return;
        }
        try {
	        String edad2 = txtEdad.getText();
	        int edad = Integer.parseInt(edad2);
	        if (edad <1 || edad >99){
	        	alertaGeneral.showAlert("Error", "Edad debe ser un entero menor a 99");
	        	return;
        }
        
	    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vista/VistaBienvenida.fxml"));
	    	Parent root = loader.load();
	    	Scene scene = new Scene(root);
	    	stage2.setScene(scene);
	      	VistaBienvenidaController controller = loader.getController();
	    	controller.init(txtNombre.getText(), txtEdad.getText(), stage2, this);
	    	stage2.show();
	        
  
        }catch (NumberFormatException e) {
	    	alertaGeneral.showAlert ("Error", "Edad no debe contener caracteres");
	    	return;
        }
    }

		public void setStage(Stage stage) throws IOException {

		this.stage2= stage;
	}

}
