package Controlador;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class VistaBienvenidaController {
	private VistaRegistroController reController;
	private Stage Bienve;
    @FXML
    private Label nombreBienvenido;

	public void init(String text, Stage stage2, VistaRegistroController vistaRegistroController) {

		nombreBienvenido.setText(text);
		this.Bienve = stage2;
		this.reController = vistaRegistroController;
	}







}
