package Controlador;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class VistaNivel1Controller {
 
	Stage nivelActual1;
    
	 @FXML
	    private Button avanzar;

	    @FXML
	    private ImageView ptoFil1Carta1;

	    @FXML
	    private ImageView ptoFil1Carta2;

	    @FXML
	    private ImageView ptoFil1Carta3;

	    @FXML
	    private ImageView ptoFil1Carta4;

	    @FXML
	    private ImageView ptoFil2Carta1;

	    @FXML
	    private ImageView ptoFil2Carta2;

	    @FXML
	    private ImageView ptoFil2Carta3;

	    @FXML
	    private ImageView ptoFil2Carta4;

	    @FXML
	    private Label puntosNivel1;

	    @FXML
	    private Label totAcumulado;

	    @FXML
	    void btnAvanzar2(ActionEvent event) {

	    }
	
	
	public void setStage(Stage bienve) {
		this.nivelActual1 = bienve;
		
	}



}
